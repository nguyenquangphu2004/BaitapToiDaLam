package Bai4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        String choice = "";
        ArrayList<SmartPhone> smartPhones = new ArrayList<>();
        do {
            menu();
            System.out.println("Mời bạn lựa chọn: ");
            choice = input.nextLine();
            switch (choice) {
                case "1" :
                    try {
                        smartPhones.add(smartPhone(input));
                    } catch (InvalidNameSmartPhoneException e) {
                        e.printStackTrace();
                    }

                    System.out.println("===>Thêm thất bại<====");
                    break;
                case "2": case "3": case "4":
                    SmartPhone.index = Integer.parseInt(choice);
                    Collections.sort(smartPhones);
                    showDevice(smartPhones);
                    break;
                case "5":
                    showDevice(smartPhones);
                    break;
                default:
                    choice = "6";
            }


        } while(Integer.parseInt(choice) <=5 && Integer.parseInt(choice) >= 1);


    }

    private static void showDevice(ArrayList<SmartPhone> smartPhones) {
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n","Mã thiết bị","Tên hãng","Tên thiết bị",
                "Giá bán gốc","Năm sản xuất","Kích cỡ");
        for (var item :
                smartPhones) {
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n",
                    item.getDeviceCode(),item.getGenuineName(),item.getDeviceName(),
                    item.getSellingPriceOriginal(),item.getYearOfManufacture(),
                    item.getScreenSize());
        }
    }

    private static void menu() {
        System.out.println("1.Thêm mới 1 thiết bị vào danh sách.");
        System.out.println("2.Sắp xếp thiết bị theo tên hãng tăng dần");
        System.out.println("3.Sắp xếp thiết bị theo giá bán giảm dần.");
        System.out.println("4.Sắp xếp theo năm sản xuất từ mới nhất đến cũ nhất.");
        System.out.println("5.Hiển thị danh sách các thiết bị.");

    }

    public static SmartPhone smartPhone(Scanner input) throws InvalidNameSmartPhoneException {
        System.out.println("Mã thiết bị: ");
        String deviceCode = input.nextLine();
        System.out.println("Tên hãng: ");
        String genuineName = input.nextLine();
        System.out.println("Tên thiết bị: ");
        String deviceName = input.nextLine();
        System.out.println("Giá bán gốc: ");
        String sellingPriceOriginal  = input.nextLine();
        System.out.println("Năm sản xuất:");
        String yearOfManufacture = input.nextLine();
        System.out.println("Kích cỡ:");
        String screenSize = input.nextLine();
        return new SmartPhone(deviceCode,genuineName,deviceName,
                sellingPriceOriginal, yearOfManufacture,screenSize);
    }
}
