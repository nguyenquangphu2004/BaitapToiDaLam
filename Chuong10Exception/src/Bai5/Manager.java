package Bai5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Manager extends Employee{
    private Date start;
    private Date end;

    public Manager() {
        super();

    }

    public Manager(String idCard, String fullName, String address,
                   String birthday, String email, String phoneNumber,
                   String idEmployee, String position, int salary,
                   double expYear, int day, int sumSalary, int bonus,
                   String start, String end)  {
        super(idCard, fullName, address, birthday, email, phoneNumber, idEmployee, position, salary, expYear, day, sumSalary, bonus);
        setStart(start);
        setEnd(end);
    }


    public Manager(Employee employee, String start, String end) {
        super(employee.getIdCard(), employee.getFullName(),
                employee.getAddress(), employee.getBirthday(),
                employee.getEmail(), employee.getPhoneNumber(),
                employee.getIdEmployee(), employee.getPosition(),
                employee.getSalary(), employee.getExpYear(),
                employee.getDay(), employee.getSumSalary(),
                employee.getBonus());
        setStart(start);
        setEnd(end);
    }


    public Manager(String start, String end) {
        setEnd(end);
        setStart(start);
    }


    public String getStart() {
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(start);
    }

    public void setStart(String start) {
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            this.start = dateFormat.parse(start);
        } catch (ParseException e) {
            this.start = new Date();
            System.out.println("====>Ngày bắt đầu nhiệm kì không hợp lệ " +
                    "-> Chuyển thành ngày hiện tại<====: " + dateFormat.format(this.start));
        }

    }

    public String getEnd() {
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(end);
    }


    public void setEnd(String end) {
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            this.end = dateFormat.parse(end);
        } catch (ParseException e) {
            this.end = new Date();
            System.out.println("====>Ngày kết thúc nhiệm kì không hợp lệ " +
                    "-> Chuyển thành ngày hiện tại<====: " + dateFormat.format(this.end));
        }    }

    @Override
    public String toString() {
        return super.toString() + ";" + getStart() + ";" +getEnd();
    }

    @Override
    public int bonus() {
        if(getDay() >= 22) {
            setBonus((int)(0.25 * getSalary()));
            return getBonus();
        } else {
            return 0;
        }
    }

    @Override
    public int realSalary() {
        return super.realSalary();
    }

    @Override
    public int sumSalary() {
        return super.sumSalary();
    }
}
