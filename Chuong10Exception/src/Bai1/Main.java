package Bai1;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Màu trắng", "Ăn cá",
                        "Màu đen","Tôm");

        try {
            cat.setAge(-5);

        } catch (InvalidAgeException e)
        { System.out.println("Đã gặp ngoại lệ: InvalidAgeException");
            e.printStackTrace();

        }
        System.out.println(cat);
    }
}