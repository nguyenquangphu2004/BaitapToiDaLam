package Bai3;

import Bai2.InvalidAmoutException;

public class Main {
    public static void main(String[] args)  {

        Teacher teacher = null;
        try {
                teacher =new Teacher("B22DCCN621",
                    "NGUYEN QUANG PHU", "CNTT", "1500", "5");
        } catch (InvalidAmoutException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Thong tin cua giao vien: ");
        System.out.println(teacher);
    }
}
