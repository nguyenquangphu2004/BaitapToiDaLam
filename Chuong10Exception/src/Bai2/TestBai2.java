package Bai2;

public class TestBai2 {
    public static void main(String[] args) throws InvalidAmoutException {

        AccountBank accountBank1 = new AccountBank(
                "9294124142", "8999005022004",
                "NGUYEN QUANG PHU",1700000);
        AccountBank accountBank2 = new AccountBank(
                "05491242142","0377018551",
                "TRAN THI TOAN",5000000);
//Thực hiện chuyển tiền không hợp lệ;
        System.out.println("Thông tin tài khoản trước khi chuyển: ");
        System.out.println(accountBank1);
        System.out.println("------------------------------------------------");
        System.out.println(accountBank2);
        System.out.println("================================================");
        System.out.println("\n");
        try {
            accountBank1.pay(150000, "Ăn cơm trưa");
            accountBank1.withDraw(1500000);
            accountBank1.transfer(accountBank2, 50000);
            System.out.println();
            System.out.println(accountBank1);
            System.out.println();
            accountBank1.withDraw(0);
            accountBank1.transfer(accountBank2,0);
        } catch (InvalidAmoutException e) {
            e.printStackTrace();
        }

        System.out.println("\n");
        System.out.println("Thông tin tài khoản sau khi chuyển: ");
        System.out.println(accountBank1);
        System.out.println("------------------------------------------------");
        System.out.println(accountBank2);


    }
}
