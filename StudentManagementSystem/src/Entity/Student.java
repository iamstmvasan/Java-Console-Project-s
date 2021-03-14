package Entity;

import java.util.List;

public class Student {
    private long rollNo;
    private String name, address, subject;
    private List<Integer> markList;

    public Student(long rollNo, String name, String address, String subject, List<Integer> markList) {
        this.rollNo = rollNo;
        this.name = name;
        this.address = address;
        this.subject = subject;
        this.markList = markList;
    }

    public long getRollNo() {
        return rollNo;
    }

    public void setRollNo(long rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Integer> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Integer> markList) {
        this.markList = markList;
    }

    public int sumList(){

        return markList.stream().reduce(0,Integer::sum);

    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", subject='" + subject + '\'' +
                ", markList=" + markList +
                '}';
    }
}
