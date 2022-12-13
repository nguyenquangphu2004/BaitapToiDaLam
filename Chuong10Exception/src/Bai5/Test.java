package Bai5;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {
    private static String fileEmployee = "EMP.DAT";

    public static void main(String[] args) throws InvalidDayException {
        var input = new Scanner(System.in);
        ArrayList<Person> employees = new ArrayList<>(readFileEmployee());
        String choice = "";
        do {
            menu();
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("1.Thêm nhân viên.");
                    System.out.println("2.Thêm giám đốc.");
                    System.out.println("Mời bạn chọn: ");
                    String choice1 = input.nextLine();
                    if(choice1.equals("1")) {
                        employees.add(employee(input));
                    } else if(choice1.equals("2")) {
                        employees.add(manager(input));
                    }
                    saveFileEmployee(employees);
                    break;
                case "2":
                    showListEmployee(employees);
                    break;
                case "3":
                    searchEmployeeBySalary(employees,input);
                    break;
                case "4":
                    removeEmployeeById(employees, input);
                    saveFileEmployee(employees);
                    break;
                case "5":
                    calculatorSalaryToEmployee(employees);
                    saveFileEmployee(employees);
                    break;
                case "6":
                    showListTableSalary(employees);
                    break;

            }

        } while(true);





    }

    private static void menu() {
        System.out.println("1.Thêm mới nhân viên.");
        System.out.println("2.Hiển thị thông tin nhân viên.");
        System.out.println("3.Tìm nhân viên có mức lương >= x.");
        System.out.println("4.Xóa nhân viên theo mã.");
        System.out.println("5.Tính lương cho nhân viên.");
        System.out.println("6.Hiển thị bảng lương của nhân viên.");
        System.out.println("Mời bạn chọn: ");
    }

    private static void showListEmployee(ArrayList<Person> employees) {
        System.out.printf("%-15s%-25s%-15s%-15s%-15s\n",
                            "Mã nhân viên","Họ tên",
                            "Sinh nhật","Chức vụ","Mức lương");
        for (var item1 : employees) {
            if(item1 instanceof Employee) {
                var item = (Employee)item1;
                System.out.printf("%-15s%-25s%-15s%-15s%-15s\n",
                        item.getIdEmployee(), item.getFullName(),
                        item.getBirthday(), item.getPosition(), item.getSalary());
            }

        }
    }
    private static ArrayList<Employee> readFileEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        File file = new File(fileEmployee);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Scanner readFile = new Scanner(file);
            while(readFile.hasNextLine()) {
                var words = readFile.nextLine().split(";");
                String idCard = words[0];
                String fullName = words[1];
                String address = words[2];
                String birthDay = words[3];
                String email = words[4];
                String phoneNumber = words[5];
                String idEmployee = words[6];
                String position = words[7];
                int salary = Integer.parseInt(words[8]);
                double expYear = Double.parseDouble(words[9]);
                int day = Integer.parseInt(words[10]);
                int sumSalary = Integer.parseInt(words[11]);
                int bonus = Integer.parseInt(words[12]);
                if(words.length == 13) {
                    Employee employee = new Employee(idCard,fullName,address,birthDay,email,
                            phoneNumber,idEmployee,position,salary,expYear,day,sumSalary,
                            bonus);
                    employees.add(employee);
                }
                else {
                    String start = words[13];
                    String end = words[14];
                    Manager manager = new Manager(idCard, fullName, address, birthDay, email,
                            phoneNumber, idEmployee, position, salary, expYear, day, sumSalary,
                            bonus, start, end);
                    employees.add(manager);
                }
            }
        } catch (FileNotFoundException | IndexOutOfBoundsException e ) {
            System.out.println(e.getMessage());
        }
        return employees;

    }
    public static Person employee(Scanner input) {
        Employee employee = new Employee();
        System.out.println("Chứng minh thư:");
        String idCard = input.nextLine();
        System.out.println("Họ và tên: ");
        String fullName = input.nextLine();
        System.out.println("Địa chỉ:");
        String address = input.nextLine();
        System.out.println("Sinh nhật: ");
        String birthDay = input.nextLine();
        System.out.println("Email:");
        String email = input.nextLine();
        System.out.println("Số điện thoại:");
        String numberPhone = input.nextLine();
        System.out.println("Mã nhân viên:");
        employee.setIdEmployee();
        System.out.println(employee.getIdEmployee());
        System.out.println("Chức vụ: ");
        String position = input.nextLine();
        System.out.println("Mức lương: ");
        int salary = input.nextInt();
        System.out.println("Số năm kinh nghiêm: ");
        double expYear = input.nextDouble();
        System.out.println("Số ngày làm việc: ");
        int day = input.nextInt();
        return new Employee(idCard, fullName, address, birthDay, email,
                    numberPhone, employee.getIdEmployee(), position,
                    salary, expYear, day, 0, 0);

    }
    public static Person manager(Scanner input) {
        var employee = employee(input);
        System.out.println("Ngày bắt đầu nhiệm kì:");
        String start = input.nextLine();
        System.out.println("Ngày kết thúc nhiệm kì:");
        String end = input.nextLine();
        return new Manager((Employee) employee,start,end);
    }
    public static void saveFileEmployee(ArrayList<Person> employees) {
        try {
            FileWriter fileWriter = new FileWriter(fileEmployee);
            PrintWriter out = new PrintWriter(fileWriter);
             for(int i = 0; i < employees.size(); i++) {
                 if(employees.get(i) instanceof Employee) {
                     var item = (Employee)employees.get(i);
                     out.println(item);
                 } else if(employees.get(i) instanceof Manager) {
                     var item = (Manager)employees.get(i);
                     out.println(item);
                }
             }
             out.close();
             fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void searchEmployeeBySalary(ArrayList<Person> employees, Scanner input) {
        System.out.println("Nhập số tiền x: ");
        int x = Integer.parseInt(input.nextLine());
        System.out.printf("%-15s%-25s%-15s%-15s%-15s\n",
                "Mã nhân viên","Họ tên",
                "Sinh nhật","Chức vụ","Mức lương");
        for(int i = 0; i < employees.size(); i++) {
            var item = (Employee)employees.get(i);
            if(item.getSalary() >= x) {
                System.out.printf("%-15s%-25s%-15s%-15s%-15s\n",
                        item.getIdEmployee(), item.getFullName(),
                        item.getBirthday(), item.getPosition(), item.getSalary());
            }
        }
    }
    public static void removeEmployeeById(ArrayList<Person> employees, Scanner input) {
        System.out.println("Nhập mã nhân viên: ");
        String id = input.nextLine();
        for(int i = 0; i < employees.size(); i++) {
            var item = (Employee)employees.get(i);
            if(item.getIdEmployee().compareTo(id) == 0) {
                employees.remove(i);
                System.out.println("====>Xóa thành công<=====");
            }
        }
    }
    public static void calculatorSalaryToEmployee(ArrayList<Person> employees) {
        for(int i = 0; i < employees.size(); i++) {
            if(employees.get(i) instanceof Employee) {
                var item = (Employee)employees.get(i);
                item.setBonus(item.bonus());
                item.setSumSalary(item.sumSalary());
            } else if(employees.get(i) instanceof Manager){
                var item = (Manager)employees.get(i);
                item.setBonus(item.bonus());
                item.setSumSalary(item.sumSalary());
            }
        }
        System.out.println("===>Cập nhật thành công<=====");
    }
    public static void showListTableSalary(ArrayList<Person> employees) {
        System.out.printf("%-14s%-25s%-15s%-15s%-15s%-15s%-15s\n","Mã nhân viên","Họ tên",
                    "Chức vụ","Mức lương", "Số ngày","Thưởng","Tổng lương");
        for (var item1 : employees) {
            var item = (Employee)item1;
            System.out.printf("%-14s%-25s%-15s%-15s%-15s%-15s%-15s\n",
                        item.getIdEmployee(),item.getFullName(),item.getPosition(),
                        item.getSalary(),item.getDay(),item.getBonus(),item.getSumSalary());

        }
    }
}
