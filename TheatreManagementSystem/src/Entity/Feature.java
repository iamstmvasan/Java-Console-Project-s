package Entity;

public class Feature extends Movie {
    private String type;

    public Feature(int movieId, String movieName, String movieLanguage, String movieDirector, double movieDuration, String type) {
        super(movieId, movieName, movieLanguage, movieDirector, movieDuration);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString()+"Feature{" +
                "type='" + type + '\'' +
                '}';
    }
}
