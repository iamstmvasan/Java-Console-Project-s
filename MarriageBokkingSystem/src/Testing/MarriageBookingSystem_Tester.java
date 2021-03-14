package Testing;

import Entity.Applicant;
import Entity.Person;
import Exceptional.ApplicantNotFound;
import Service.MarriageBookingSystem;

public class MarriageBookingSystem_Tester {
    public static void main(String[] args) {

        MarriageBookingSystem marriageBookingSystem = new MarriageBookingSystem();

        Applicant person1 = new Applicant(10, "Thiru", 20, "Male", 100);
        Applicant person2 = new Applicant(11, "Malai", 22, "Male", 101);
        Applicant person3 = new Applicant(12, "Vasan", 20, "Male", 102);
        Applicant person4 = new Applicant(13, "Manjima", 21, "Female", 103);
        Applicant person5 = new Applicant(14, "Priyanka", 21, "Female", 104);

        System.out.println("Person Added ? " + marriageBookingSystem.addApplicant( person1 ) );
        System.out.println("Person Added ? " + marriageBookingSystem.addApplicant( person2 ) );
        System.out.println("Person Added ? " + marriageBookingSystem.addApplicant( person3 ) );
        System.out.println("Person Added ? " + marriageBookingSystem.addApplicant( person4 ) );
        System.out.println("Person Added ? " + marriageBookingSystem.addApplicant( person5 ) );

        try {
            System.out.println("Matched Applicant's -> " + marriageBookingSystem.findMatch(person5));
        }catch (ApplicantNotFound e){
            System.out.println("Matched Applicant's -> " + e);
        }

        System.out.println("Applicant Assigned ? " + marriageBookingSystem.assignApplicant(101, person5) );
        System.out.println("Applicant Assigned ? " + marriageBookingSystem.assignApplicant(102, person4) );
        System.out.println("Applicant Assigned ? " + marriageBookingSystem.assignApplicant(100, person5) );

        System.out.println("Applicant Dropped ? " + marriageBookingSystem.dropProposal(101) );

        System.out.println("Applicant Summary -> "+marriageBookingSystem.findApplicantSummary() );



    }
}
