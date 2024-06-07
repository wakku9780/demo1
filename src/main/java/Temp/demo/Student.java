package Temp.demo;

public class Student {
    public int rollNo;
    public String name;
    public String mobNo;
    public int age;

    public Student(int rollNo, String name, String mobNo, int age) {
        this.rollNo = rollNo;
        this.name = name;
        this.mobNo = mobNo;
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
