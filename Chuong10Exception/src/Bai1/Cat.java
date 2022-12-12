package Bai1;

public class Cat {
    private String featherColor;
    private int age;
    private String habitatEat;
    private String eyeColor;
    private String petName;

    public Cat() {

    }


    public Cat(String featherColor, int age, String habitatEat,
               String eyeColor, String petName) {
        this.featherColor = featherColor;
        this.age = age;
        this.habitatEat = habitatEat;
        this.eyeColor = eyeColor;
        this.petName = petName;
    }

    public Cat(String featherColor, String habitatEat, String eyeColor,
                String petName) {
        this.featherColor = featherColor;
        this.habitatEat = habitatEat;
        this.eyeColor = eyeColor;
        this.petName = petName;
    }

    public String getFeatherColor() {
        return featherColor;
    }

    public void setFeatherColor(String featherColor) {
        this.featherColor = featherColor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age >= 0  && age <= 50) {
            this.age = age;
        } else {
            this.age = 0;
            var msg = "Tuổi của mèo không hợp lệ";
            throw new InvalidAgeException(msg, age);
        }

    }

    public String getHabitatEat() {
        return habitatEat;
    }

    public void setHabitatEat(String habitatEat) {
        this.habitatEat = habitatEat;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "featherColor='" + featherColor + '\'' +
                ", age=" + age +
                ", habitatEat='" + habitatEat + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", petName='" + petName + '\'' +
                '}';
    }
}
