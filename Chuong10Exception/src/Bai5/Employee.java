package Bai5;

import java.util.Date;

public class Employee extends Person{

    public static int next = 1001;

    private String idEmployee;
    private String position;
    private int salary;
    private double expYear;
    private int day;
    private int sumSalary;
    private int bonus;

    public Employee() {

    }


    public Employee(String idCard, String fullName, String address,
                    String birthday, String email, String phoneNumber,
                    String idEmployee, String position, int salary, double expYear,
                    int day, int sumSalary, int bonus)  {
        super(idCard, fullName, address, birthday, email, phoneNumber);
        this.idEmployee = idEmployee;
        this.position = position;
        this.salary = salary;
        this.expYear = expYear;
        try {
            setDay(day);
        } catch (InvalidDayException e) {
            System.out.println(e.getMessage());
        }
        this.sumSalary = sumSalary;
        this.bonus = bonus;
    }



    public Employee(Person person, Employee employee) {
        super(person.getIdCard(),person.getFullName(),person.getAddress(),
                person.getBirthday(),person.getEmail(),person.getPhoneNumber());
        this.idEmployee = employee.getIdEmployee();
        this.position = employee.getPosition();
        this.salary = employee.getSalary();
        this.expYear = employee.getExpYear();
        this.day = employee.getDay();
        this.sumSalary = employee.getSumSalary();
        this.bonus = employee.getBonus();
    }

    public void setNext(int next) {
        Employee.next = next;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee( ) {
        this.idEmployee = "EMP" + next;
        next ++;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getExpYear() {
        return expYear;
    }

    public void setExpYear(double expYear) {
        this.expYear = expYear;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) throws InvalidDayException {
        if(day >= 0 && day <= 30) {
            this.day = day;
        } else {
            this.day = 0;
            String msg = "====>Số làm việc ngày nhập không hợp lệ -> Tự động chuyển ngày thành<====:0";
            throw new InvalidDayException(msg, 0);
        }
    }

    public int getSumSalary() {
        return sumSalary;
    }

    public void setSumSalary(int sumSalary) {
        this.sumSalary = sumSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    protected void doWork() {

    }

    public int bonus() {
        if(day >= 22) {
            return (int)(0.5 * salary * (day - 22)) / 30;
        } else {
            return 0;
        }
    }

    public int realSalary() {
        return (int) ((salary * day) / 30);
    }

    public int sumSalary() {
        return  realSalary() + bonus();
    }

    @Override
    public String toString() {
        return super.toString() + ";" + idEmployee + ";" +
                position + ";" + salary + ";" + expYear + ";" +
                day + ";" + sumSalary + ";" + bonus;
    }
}
