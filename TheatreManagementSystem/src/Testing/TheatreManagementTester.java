package Testing;

import Entity.*;
import Exception.*;
import Service.TheatreManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class TheatreManagementTester {
    public static void main(String[] args) {
        TheatreManagementSystem managementSystem = new TheatreManagementSystem();

        //Movie Creation
        Movie m1 = new Feature(101, "Theri", "Tamil", "Atlee", 180.5, "Action");
        Movie m2 = new Documentry(102, "Sarkar", "Tamil", "ARM", 167.5, "Politic");
        Movie m3 = new Feature(103, "Ghilli", "Tamil", "Dell", 184.5, "Sports");
        Movie m4 = new Documentry(104, "Avengers", "English", "Lenovo", 137.5, "Action");
        Movie m5 = new Feature(105, "Master", "Tamil", "Hp", 181.5, "Action");
        Movie m6 = new Documentry(106, "Titanic", "English", "Acer", 162.5, "Romance");

        //Screen Creation
        Screen s1 = new Screen(201, "Shanthi", 100, 50, 5, 4, m1);
        Screen s2 = new Screen(202, "Sivaji", 100, 50, 6, 4, m2);
        Screen s3 = new Screen(203, "Kamala", 100, 50, 0, 5, null);
        Screen s4 = new Screen(204, "Gee Vee", 100, 50, 15, 3, m4);
        Screen s5 = new Screen(205, "Vijaya", 100, 50, 20, 4, m3);
        Screen s6 = new Screen(206, "Jupiter", 100, 50, 10, 5, m4);

        //Screen List for Shanthi kamala
        List<Screen> screenList_Shanthi = new ArrayList<>();
        screenList_Shanthi.add(s1);
        screenList_Shanthi.add(s2);
        screenList_Shanthi.add(s3);
        screenList_Shanthi.add(s4);

        //Screen List for otherTheatre
        List<Screen> screenList_Other = new ArrayList<>();
        screenList_Other.add(s5);
        screenList_Other.add(s6);

        //Theatre Creation
        Theatre shanthiKamala = new Theatre(301, "ShanthiKamala", "Thanjavur", 4, screenList_Shanthi);
        Theatre jupiter_Vijaya = new Theatre(302, "Jupiter_Vijaya", "TNJ", 2, screenList_Other);

        //Theatre List Creation
        List<Theatre> theatreList = new ArrayList<>();
        theatreList.add(shanthiKamala);
        theatreList.add(jupiter_Vijaya);



        System.out.println("Added Theatre with screen ? "+
                managementSystem.addTheatreWithScreen(301, "ShanthiKamala", "Thanjavur", 4, screenList_Shanthi) );
        System.out.println("Added Theatre with screen ? "+
                managementSystem.addTheatreWithScreen(302, "Jupiter_Vijaya", "TNJ", 2, screenList_Other) );

        try{
            System.out.println("Added Movie to Theatre ? "+
                    managementSystem.addMovieToTheatre(301, m5, 6));
        }catch (ScreenNotAvailable e){
            System.out.println("Added Movie to Theatre ? "+e);
        }
        try{
            System.out.println("Added Movie to Theatre2 ? "+
                    managementSystem.addMovieToTheatre(301, m5, 6));
        }catch (ScreenNotAvailable e){
            System.out.println("Added Movie to Theatre2 ? "+e);
        }

        try{
            System.out.println("Drop Movie in Theatre ? "+
                    managementSystem.dropMovieFromTheatre(301, m6 ));
        }catch (MovieNotExist e){
            System.out.println("Drop Movie in Theatre ? "+e);
        }
        try{
            System.out.println("Drop Movie in Theatre2 ? "+
                    managementSystem.dropMovieFromTheatre(301, m5 ));
        }catch (MovieNotExist e){
            System.out.println("Drop Movie in Theatre2 ? "+e);
        }


        System.out.println("List Movie Available in Theatre : \n"+managementSystem.listMoviesAvailableInTheatre());

        System.out.println("List Movie Completed N days : \n"+managementSystem.listMoviesCompletedNDays(10));


    }
}
