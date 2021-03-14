package Entity;

public class Applicant extends Person{

    private int applicantId;
    private Person person;

    public Applicant(int personId, String name, int age, String sex, int applicantId) {
        super(personId, name, age, sex);
        this.applicantId = applicantId;
        //this.person = person;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return super.toString()+"Applicant{" +
                "applicantId=" + applicantId +
                '}';
    }
}
