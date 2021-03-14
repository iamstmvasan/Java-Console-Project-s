package Service;

import Entity.Feature;
import Entity.Movie;
import Entity.Screen;
import Entity.Theatre;
import Exception.*;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TheatreManagementSystem {
    public List<Theatre> theatreList = new ArrayList<>();

    //add Theatre with screen
    public boolean addTheatreWithScreen(int theatreId, String name, String address, int noOfScreen, List<Screen> screenList){
        if( noOfScreen != screenList.size() )
            return false;
        Theatre theatre = new Theatre(theatreId, name, address, noOfScreen, screenList);
        theatreList.add(theatre);
        return true;
    }

    //add movie to theatre
    public boolean addMovieToTheatre(int theatreId, Movie m, int n)throws ScreenNotAvailable {
        /*Theatre theatre = null;
        for(Theatre i : theatreList)
            if(i.getTheatreId() == theatreId){
                theatre = i;
                break;
            }*/
        List<Theatre> theatreList1 = theatreList.stream().
                                    filter(i->i.getTheatreId() == theatreId).collect(Collectors.toList());
        if(theatreList1.isEmpty())
            return false;
        List<Screen> screenList = theatreList1.get(0).getScreenList().
                                    stream().filter(i->i.getNoOfDaysRunning() == 0).
                                    collect(Collectors.toList());
        if(screenList.isEmpty())
            throw new ScreenNotAvailable("There is no screen available to release the movie");
        screenList.get(0).setMovie(m);
        screenList.get(0).setNoOfDaysRunning(n);
        return true;

        /*if(theatre != null){
            boolean screenAvailable = false;
            for (Screen screen : theatre.getScreenList())
                if(screen.getNoOfDaysRunning() == 0){
                    screenAvailable = true;
                    screen.setMovie(m);
                    break;
                }
            if(!screenAvailable)
                throw new ScreenNotAvailable("There is no screen available to release the movie");

            return true;
        }
        else
            return false;*/

    }

    //drop movie from theatre
    public boolean dropMovieFromTheatre(int theatreId, Movie m) throws MovieNotExist {
        /*Theatre theatre = null;
        for(Theatre i : theatreList)
            if(i.getTheatreId() == theatreId){
                theatre = i;
                break;
            }*/
        List<Theatre> list = theatreList.stream().filter(i->i.getTheatreId() == theatreId).collect(Collectors.toList());
        if(list.isEmpty())
            return false;
        List<Screen> screenList = list.get(0).getScreenList().stream().filter(i->i.getMovie().getMovieId() == m.getMovieId()).collect(Collectors.toList());
        if(screenList.isEmpty())
            throw new MovieNotExist("Unable to locate the movie with specified name");
        screenList.get(0).setMovie(null);
        screenList.get(0).setNoOfDaysRunning(0);
        return true;
        /*if(theatre != null){
            boolean isMovieAvailable = false;
            for(Screen screen : theatre.getScreenList())
                if( screen.getMovie().getMovieId() == m.getMovieId() ){
                    screen.setMovie(null);
                    screen.setNoOfDaysRunning(0);
                    isMovieAvailable = true;
                    break;
                }
            if(!isMovieAvailable)
                throw new MovieNotExist("Unable to locate the movie with specified name");
            return true;
        }
        else
            return false;*/
    }

    public Map<String, Integer> listMoviesAvailableInTheatre(){
        Map<String , Integer> map = new HashMap<>();
        /*for ( Theatre theatre : theatreList ) {
            int count = 0;
            for (Screen screen : theatre.getScreenList())
                if (screen.getMovie() instanceof Feature)
                    count++;
            map.put(theatre.getTheatreName(), count);
        }
        return map;*/
        map = theatreList.stream().collect(Collectors.toMap(Theatre::getTheatreName,
                i->(int)(i.getScreenList().stream().filter(j->j.getMovie() instanceof Feature).count())));
        return map;
    }

    public List<Movie>listMoviesCompletedNDays(int numberOfDays){
        /*List<Movie> movies = new ArrayList<>();
        for ( Theatre theatre : theatreList )
            for ( Screen screen : theatre.getScreenList() )
                if( screen.getNoOfDaysRunning() > numberOfDays )
                    movies.add(screen.getMovie());

        return movies;*/
        return theatreList.stream().map(i->i.getScreenList()).
                flatMap(Collection::stream).filter(j->j.getNoOfDaysRunning() > numberOfDays).map(k->k.getMovie()).collect(Collectors.toList());
    }

}
