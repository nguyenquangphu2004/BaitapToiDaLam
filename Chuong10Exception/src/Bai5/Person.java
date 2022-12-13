package Bai5;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person {
    private String idCard;
    private FullName fullName;
    private String address;
    private Date birthday;
    private String email;
    private String phoneNumber;


    public Person(String idCard, String fullName, String address,
                  String birthday, String email, String phoneNumber) {
        this.idCard = idCard;
        this.fullName = new FullName();
        setFullName(fullName);
       this.address = address;
        setBirthday(birthday);
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Person() {

    }


    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getFullName() {
        return fullName.last + " " + fullName.mid + fullName.first;
    }

    public void setFullName(String fullName) {
        var words = fullName.split(" ");
        this.fullName.last = words[0];
        this.fullName.first = words[words.length - 1];
        this.fullName.mid = "";
        for(int i = 1; i < words.length - 1; i++) {
            this.fullName.mid += words[i] + " ";
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(birthday);
    }

    public void setBirthday(String birthday) {
        var format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            this.birthday = dateFormat.parse(birthday);
        } catch (ParseException e) {
            this.birthday = new Date();
            System.out.println("====>Ngày sinh không hợp lệ -> Tự động ngày " +
                                "sinh chuyển thành ngày hiện tại<=====: " + dateFormat.format(this.birthday));
        }

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private class FullName {
        private String first;
        private String mid;
        private String last;

        public FullName() {

        }

        public FullName(String first, String mid, String last) {
            this.first = first;
            this.mid = mid;
            this.last = last;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }
    }
    protected abstract void doWork();

    @Override
    public String toString() {
        return idCard + ";" + getFullName() + ";" + address +
                ";" +getBirthday() + ";" + email + ";" + phoneNumber;

    }
}
