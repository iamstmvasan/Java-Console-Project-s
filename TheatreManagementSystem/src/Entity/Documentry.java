package Entity;

public class Documentry extends Movie {
    private String topic;

    public Documentry(int movieId, String movieName, String movieLanguage, String movieDirector, double movieDuration, String topic) {
        super(movieId, movieName, movieLanguage, movieDirector, movieDuration);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return super.toString()+ "Documentry{" +
                "topic='" + topic + '\'' +
                '}';
    }
}
