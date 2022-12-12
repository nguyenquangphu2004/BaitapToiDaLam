package Bai3;

import Bai2.InvalidAmoutException;

public class Check {
    public static void main(String[] args) {
        String salary = "500k";
        var words = salary.split("k");
        int amount = Integer.parseInt(words[0]);
        System.out.println(amount);

    }
}
