package Service;

import Entity.Student;
import Exception.StudentDoesntExist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentManagementSystem {
    private List<Student> studentList = new ArrayList<>(10);

    public boolean addStudent( Student student ){
        /*boolean isStudentAdded = true;
        for( Student s : studentList )
            if( s.getRollNo() == student.getRollNo() ){
                isStudentAdded = false;
                break;
            }
        if(isStudentAdded && studentList.size() < 10){
            studentList.add(student);
            return true;
        }
        return false;*/
        if( studentList.size() >= 10 && studentList.stream().filter(i->i.getRollNo() == student.getRollNo()).count() > 0)
            return false;
        studentList.add(student);
        return true;
    }

    public boolean deleteStudent(long rollNo) throws StudentDoesntExist {
        /*boolean isStudentAvailable = false;
        Iterator<Student> iterator = studentList.iterator();
        while( iterator.hasNext() ){
            Student student = iterator.next();
            if(student.getRollNo() == rollNo ){
                isStudentAvailable = true;
                iterator.remove();
                return true;
            }
        }
        if(!isStudentAvailable)
            throw new StudentDoesntExist("Roll no is not found !");
        return false;*/
        List<Student> list = studentList.stream().filter(i->i.getRollNo() == rollNo).collect(Collectors.toList());
        if(list.isEmpty())
            throw new StudentDoesntExist("Roll no is not found !");
        studentList.remove(list.get(0));
        return true;
    }

    public void listStudent(){
        /*for(Student s : studentList){
            System.out.println(s);
            System.out.println("------------------------------------------------------------------");
        }*/
        studentList.stream().forEach(i -> System.out.println(i+"\n\n") );
    }

    public boolean updateStudent(long rollNo, Student student) throws StudentDoesntExist {
        /*boolean isStudentAvailable = false;
        Iterator<Student> iterator = studentList.iterator();
        while( iterator.hasNext() ){
            Student s = iterator.next();
            if(s.getRollNo() == rollNo ){
                isStudentAvailable = true;
                iterator.remove();
                studentList.add(student);
                return true;
            }
        }
        if(!isStudentAvailable)
            throw new StudentDoesntExist("Roll no is not found !");
        return false;*/

        List<Student> studentList1 = studentList.stream().filter(i->i.getRollNo() == rollNo).collect(Collectors.toList());
        if(studentList1.isEmpty())
            throw new StudentDoesntExist("Roll no is not found !");
        studentList.remove(studentList1.get(0));
        studentList.add(student);
        return true;


    }

    public Student findTopper(){
        /*Student student = null;
        int topperTotal = 0;
        for(Student s : studentList){
            List<Integer> markList= s.getMarkList();
            int sum = 0;
            for (Integer i : markList){
                sum += i;
            }
            if(sum > topperTotal){
                topperTotal = sum;
                student = s;
            }
        }
        return student;
         */
        List<Student> list = studentList.stream().sorted(
                (i,j)-> j.sumList() - i.sumList() ).
                collect(Collectors.toList());
        return list.get(0);
    }

}
