package DataStructure;
class Vehicle {
    protected float speed;

    public float getSpeed;
}

class Car {
    //thuoc tinh
    int year;
    String brand;
    String color;
    //phuong thuc
    // constructor = ham` tao.
    public Car(String color, String brand, int year) {
        this.color = color;
        this.brand = brand;
        this.year = year;
    }

    public void start() {

        System.out.println("The car is starting");
        
        }
        public void stop() {
        
        System.out.println("The car is stoping");
        
        }
        public void brake() {
        
        System.out.println("The car is braking");
        
        }
}


public class OOP {
    public static void main(String[] agrs) {
        // tao ra doi tuong
        //Car myCar = new Car();
        //myCar.year = 2024;
        //myCar.brand = "BMW";
        //myCar.color = "White";
        Car car2 = new Car("Black Blue", "Bugatti", 2020);
    }
}
