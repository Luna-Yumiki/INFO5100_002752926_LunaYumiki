// Declare 10 classes based on objects around you
// Each class must have at least 8 properties & 3 methods (no logic inside methods is fine, i.e., empty methods or just a print statement)
class Desk {
    private String material;
    private int sizeInInches;
    private int numberOfDrawers;
    private boolean hasKeyboardTray;
    private String color;
    private boolean isAdjustableHeight;
    private boolean isFoldable;
    private boolean hasCableManagement;

    public void storeItems() {
        System.out.println("Storing items in the desk.");
    }

    public void organize() {
        System.out.println("Organizing items on the desk.");
    }

    public void adjustHeight(int heightInInches) { }

}
class Char {
    private String material;
    private String color;
    private int numberOfLegs;
    private boolean hasArmrests;
    private boolean isAdjustable;
    private boolean isReclining;
    private boolean hasCushion;
    private boolean isSwivel;

    public void sit() {
        System.out.println("Sitting on the chair.");
    }

    public void adjustHeight() {
    }

    public void recline() {
    }
}

class Light {
    private String type;
    private boolean isOn;
    private int brightnessLevel;
    private String color;
    private boolean hasDimmer;
    private boolean isMotionActivated;
    private boolean hasTimer;
    private boolean isSmartLight;

    public void turnOn() {
        isOn = true;
        System.out.println("Turning on the light.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("Turning off the light.");
    }

    public void setBrightness(int brightness) {
    }
}

class Carpet {
    private String material;
    private double lengthInFeet;
    private double widthInFeet;
    private String color;
    private boolean isStainResistant;
    private boolean isPadded;
    private double price;
    private String brand;

    public void calculateArea() {
    }

    public void clean() {
    }

    public void rollUp() {
        System.out.println("Rolling up the carpet for cleaning.");
    }

}

class TV {
    private String brand;
    private String model;
    private int screenSizeInInches;
    private String displayTechnology;
    private boolean isSmartTV;
    private boolean is4K;
    private int volume;
    private int channel;

    public void powerOn() {
        System.out.println("Turning on the TV.");
    }

    public void changeChannel(int newChannel) {
    }

    public void adjustVolume(int newVolume) {
    }
}

class Employee {
    private String employeeID;
    private String firstName;
    private String lastName;
    private String department;
    private double salary;
    private int yearsOfWork;
    private boolean isPartTime;
    private boolean isDisability;

    public void workStatus() {}

    public void promote() {}
    public void onLeave() {}


    class Building {
        private String name;
        private String address;
        private int numberOfFloors;
        private int numberOfRooms;
        private double totalSquareFeet;
        private boolean hasElevator;
        private boolean isResidential;
        private boolean isCommercial;

        public void open() {}
        public void close() {}
        public void calculateRevenue(){}
    }

    class Camera {
        private String brand;
        private String model;
        private double megapixels;
        private String sensorType;
        private boolean isDigital;
        private boolean hasZoom;
        private boolean isRecording;
        private boolean isFlashEnabled;

        public void turnOn(){};
        public void turnOff(){};
        public void changeLens(){};
    }

    class Husband {
        private String name;
        private int age;
        private int income;
        private String hobby;
        private boolean isRich;
        private String hometown;
        private String address;
        private boolean ownAHouse;

        public void increaseIncome(){};
        public void cleanHouse(){};
        public void spendMoneyOnWife(){};
    }

    class Baby {
        private String name;
        private int age;
        private double weightInKilograms;
        private double heightInCentimeters;
        private boolean isMale;
        private boolean isHungry;
        private boolean isCrying;
        private String favoriteToy;

        public void stopCrying(){};
        public void drinkMilk(){};
        public void playToy(){};

        //Include 2 nested classes for one of class
        public static class BabyToy {
            private String name;
            private String type;
        public BabyToy(String name, int age) {
            this.name = name;
            this.type = type;
        }
        public String getName(){
            return name;
        };
        public String getType(){
            return type;
        };

        public void play() {
            System.out.println("Baby is called" + name + "his age is " + name);
        }

    };

    //Print a statement in constructor to indicate creation of each instance, preferably identify each instance with unique id/name
    public class Cat{
        public static int instanceCount = 0;
        private int id;
        private String type;

        public Cat(String type) {
            instanceCount++;
            id = instanceCount;
            this.type = type;
            System.out.println("Created Cat instance " + id + " of type: " + type);
        }
    };

    //Create a Main method to instantiate at least 3 objects of each class
    public class myExample{
        public void main(String[] args) {
            Husband husband1 = new Husband();
            Husband husband2 = new Husband();
            Husband husband3 = new Husband();

            Baby baby1 = new Baby();
            Baby baby2 = new Baby();
            Baby baby3 = new Baby();

            Camera camera1 = new Camera();
            Camera camera2 = new Camera();
            Camera camera3 = new Camera();

            Building building1 = new Building();
            Building building2 = new Building();
            Building building3 = new Building();

            Employee employee1 = new Employee();
            Employee employee2 = new Employee();
            Employee employee3 = new Employee();

            TV tv1 = new TV();
            TV tv2 = new TV();
            TV tv3 = new TV();

            Carpet carpet1 = new Carpet();
            Carpet carpet2 = new Carpet();
            Carpet carpet3 = new Carpet();

            Light light1 = new Light();
            Light light2 = new Light();
            Light light3 = new Light();

            Char char1 = new Char();
            Char char2 = new Char();
            Char char3 = new Char();

            Desk desk1 = new  Desk();
            Desk desk2 = new  Desk();
            Desk desk3 = new  Desk();

        }
    }


    }
}