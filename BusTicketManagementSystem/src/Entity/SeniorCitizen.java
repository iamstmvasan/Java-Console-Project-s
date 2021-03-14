package Entity;

public class SeniorCitizen extends Passenger {
    private int age;

    public SeniorCitizen(String name, String gender, String source, String destination, int age) {
        super(name, gender, source, destination);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString()+"SeniorCitizen{" +
                "age=" + age +
                '}';
    }
}
