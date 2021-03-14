package Testing;

import Entity.Student;
import Exception.StudentDoesntExist;
import Service.StudentManagementSystem;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentDemo {
    public static void main(String[] args) {
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        System.out.println("Is Student added ? " +
                studentManagementSystem.addStudent(new Student(
                        101,
                        "Thiru",
                        "Thanjavur",
                        "Java",
                         new ArrayList<>(Arrays.asList(50, 60, 70, 80, 90, 100))
                )));
        System.out.println("Is Student added ? " +
                studentManagementSystem.addStudent(new Student(
                        102,
                        "Vijay",
                        "Pkt",
                        "C",
                        new ArrayList<>(Arrays.asList(54, 67, 80, 50, 40, 100))
                )));
        System.out.println("Is Student added ? " +
                studentManagementSystem.addStudent(new Student(
                        101,
                        "Ragav",
                        "Ampt",
                        "Java",
                        new ArrayList<>(Arrays.asList(100, 60, 70, 80, 90, 100))
                )));


        try{
            System.out.println("Is Student deleted ? " + studentManagementSystem.deleteStudent(105));
        }catch (StudentDoesntExist e){
            System.out.println("Is Student deleted ? " + e );
        }

        studentManagementSystem.listStudent();

        try{
            System.out.println("Is Student Updated ? "+ studentManagementSystem.updateStudent(102, new Student(
                    102,
                    "Vijay",
                    "Pkt",
                    "C, Java",
                    new ArrayList<>(Arrays.asList(100, 600, 70, 80, 90, 100)))));
        }catch (StudentDoesntExist doesntExist){
            System.out.println("Is Student Updated ? "+ doesntExist);
        }

        System.out.println("Topper ? "+studentManagementSystem.findTopper());
    }
}
