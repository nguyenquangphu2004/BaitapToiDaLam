package Bai4;

import java.util.Arrays;

public class SmartPhone implements  Comparable<SmartPhone>{
    public static int index = 0;
    private String deviceCode; // ma thiet bij
    private String genuineName; // ten hang
    private String deviceName; // ten thiet bi
    private String sellingPriceOriginal; // gia ban goc
    private String yearOfManufacture; // nam san xuat
    private String screenSize; // kich co


    public SmartPhone(String deviceCode, String genuineName,
                      String deviceName, String sellingPriceOriginal,
                      String yearOfManufacture, String screenSize) throws InvalidNameSmartPhoneException {
        this.deviceCode = deviceCode;
        setGenuineName
                (genuineName);
        this.deviceName = deviceName;
        this.sellingPriceOriginal = sellingPriceOriginal;
        this.yearOfManufacture = yearOfManufacture;
        this.screenSize = screenSize;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getGenuineName() {
        return genuineName;
    }

    public void setGenuineName(String genuineName) throws InvalidNameSmartPhoneException {
        String[] genuineNames = {"Apple","Samsung","Huawei","Xiaomi","Oppo","Vsmart"};
        int check = 0;
        for(int i = 0; i < genuineNames.length; i++) {
            if(genuineName.compareToIgnoreCase(genuineNames[i]) == 0) {
                this.genuineName = genuineNames[i];
                check = 1;
                break;
            }
        }
        if(check == 0) {
            this.genuineName = "";
            String msg = "Không có hãng vừa nhập";
            throw new InvalidNameSmartPhoneException(msg);
        }


    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getSellingPriceOriginal() {
        return sellingPriceOriginal;
    }

    public void setSellingPriceOriginal(String sellingPriceOriginal) {
        this.sellingPriceOriginal = sellingPriceOriginal;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }


    @Override
    public int compareTo(SmartPhone o) {
        if(index == 2) {
            return genuineName.compareTo(o.getGenuineName());
        } else if( index == 3) {
            int salary1 = Integer.parseInt(sellingPriceOriginal);
            int salary2 = Integer.parseInt(o.getSellingPriceOriginal());
            if(salary1 < salary2) {
                return 1;
            }
        } else if(index == 4) {
            int year1 = Integer.parseInt(yearOfManufacture);
            int year2 = Integer.parseInt(o.getYearOfManufacture());
            if(year1 < year2) {
                return 1;
            }

        }
        return -1;
    }
}
