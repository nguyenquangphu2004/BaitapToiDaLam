package Bai3;

import Bai2.InvalidAmoutException;

public class Teacher {
    private String idTeacher;
    private String fullName;
    private String major;
    private int salary;
    private String expYear;

    public Teacher(String idTeacher, String fullName, String major,
                   String salary, String expYear) throws InvalidAmoutException {
        this.idTeacher = idTeacher;
        this.fullName = fullName;
        this.major = major;
        setSalary(salary);
        this.expYear = expYear;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(String salary) throws InvalidAmoutException {
        var words = salary.split("k");
        int amount = Integer.parseInt(words[0]);
        if(amount >= 0 && amount <= 50000) {
            this.salary = amount;
        } else {
            this.salary = 0;
            String msg = "So tien khong hop le";
            throw new InvalidAmoutException(msg, 0);
        }
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "idTeacher='" + idTeacher + '\'' +
                ", fullName='" + fullName + '\'' + "\n" +
                ", major='" + major + '\'' +
                ", salary=" + salary + "k" +
                ", expYear='" + expYear + '\'' +
                '}';
    }
}
