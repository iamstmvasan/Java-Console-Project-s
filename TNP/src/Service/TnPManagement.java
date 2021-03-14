package Service;

import Entity.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TnPManagement {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>(); // CREATE A STUDENT LIST

        // ADD STUDENT INTO LIST
        studentList.add( new Student(1001, "A", "EEE", 6.5f, false, null) );
        studentList.add( new Student(1002, "B", "ECE", 7.5f, false, null) );
        studentList.add( new Student(1003, "C", "EEE", 5.5f, false, null) );
        studentList.add( new Student(1004, "D", "CSE", 8.5f, false, null) );
        studentList.add( new Student(1005, "E", "ECE", 7.5f, false, null) );
        studentList.add( new Student(1006, "F", "EEE", 6.5f, false, null) );

        //Function's invoking
        System.out.println("Eligible Student's -> " + getEligibleStudents(studentList, "ECE", 6.5f) );
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Placement count -> " + getPlacedStudentsCount(studentList) );
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Student -> " + getStudent(studentList, 1001) );
        System.out.println("------------------------------------------------------------------------------------");

        studentList = updatePlacementStatusAndSort(studentList, 1001, "TCS");

        System.out.println("Update Placement Status -> " + studentList );
        System.out.println("------------------------------------------------------------------------------------");

        System.out.println("Placement count -> " + getPlacedStudentsCount(studentList) );


    }

    private static List<Student> updatePlacementStatusAndSort(List<Student> studentList, int regNo, String company) {

        /*boolean isStudentEdited = false;
        Iterator<Student> iterator = studentList.iterator();
        Student student = null;
        while(iterator.hasNext()){
            student = iterator.next();
            if(student.getRegNo() == regNo){
                iterator.remove();
                isStudentEdited = true;
                break;
            }
        }

        if(isStudentEdited){
            student.setPlacementStatus( true );
            student.setCompany( company );
            studentList.add( student );
            return studentList;
        }
        return null;*/
        List<Student> list = studentList.stream().filter(i -> i.getRegNo() == regNo).collect(Collectors.toList());
        if(list.isEmpty())
            return null;
        list.get(0).setCompany(company);
        list.get(0).setPlacementStatus(true);
        return studentList;
    }

    private static Student getStudent(List<Student> studentList, int regNo) {
        /*for( Student student : studentList )
            if(student.getRegNo() == regNo)
                return student;
        return null;*/
        return ( studentList.stream().filter(i -> i.getRegNo() == regNo).collect(Collectors.toList()) ).get(0);
    }

    private static int getPlacedStudentsCount(List<Student> studentList) {
        /*int count = 0;
        for(Student student : studentList)
            if( student.isPlacementStatus() )
                count++;
        return count;*/

        return (int)studentList.stream().filter(i -> i.isPlacementStatus()).count();
    }

    private static List<Student> getEligibleStudents(List<Student> studentList, String branch, float cgpa) {
        /*List<Student> list = new ArrayList<>();

        for( Student student : studentList )
            if( student.getBranch().equalsIgnoreCase(branch) && student.getCgpa() > cgpa && !student.isPlacementStatus() )
                list.add(student);

        if( list.isEmpty() )
            return null;
        return list;*/

        return studentList.stream().filter(i -> i.getBranch().equalsIgnoreCase(branch) && i.getCgpa() > cgpa).collect(Collectors.toList());
    }


}
