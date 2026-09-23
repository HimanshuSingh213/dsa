class Vehicle{
    protected String name;
    protected String model;
    protected int noOfTyres;

    public void start_engine(){
        System.out.println(name + " " + model + " Engine Started!!");
    }

    public void stop_engine(){
        System.out.println(name + " " + model + " Engine Stopped!!");
    }

}

class Car extends Vehicle{
    private int noOfDoors;
    private String transmissionType;

    public Car(String name, String model, int noOfTyres, int noOfDoors, String transmissionType){
        this.name = name;
        this.model = model;
        this.noOfTyres = noOfTyres;
        this.noOfDoors = noOfDoors;
        this.transmissionType = transmissionType;
    }
    public void startAC(){
        System.out.println(name + " " + model + " AC Started!!");
    }
    
    public void stopAC(){
        System.out.println(name + " " + model + " AC Stopped!!");
    }
    
    public void displayCarDetails(){
        System.out.println("Car Name: " + name);
        System.out.println("Car Model: " + model);
        System.out.println("No of Tyres: " + noOfTyres);
        System.out.println("No of Doors: " + noOfDoors);
        System.out.println("Transmission Type: " + transmissionType);
    }
    
}

class Bike extends Vehicle{
    private int noOfGears;
    private String fuelType;

    public Bike(String name, String model, int noOfTyres, int noOfGears, String fuelType){
        this.name = name;
        this.model = model;
        this.noOfTyres = noOfTyres;
        this.noOfGears = noOfGears;
        this.fuelType = fuelType;
    }

    public void wheelie(){
        System.out.println(name + " " + model + " Wheelie!!");
    }

    public void displayBikeDetails(){
        System.out.println("Bike Name: " + name);
        System.out.println("Bike Model: " + model);
        System.out.println("No of Tyres: " + noOfTyres);
        System.out.println("No of Gears: " + noOfGears);
        System.out.println("Fuel Type: " + fuelType);
    }
}

public class single_inheritance {
    public static void main(String[] args) {
    
        Car car = new Car("Toyota", "Corolla", 4, 4, "Automatic");
        car.displayCarDetails();
        car.startAC();
        car.stopAC();
        car.start_engine();
        car.stop_engine();

        Bike bike = new Bike("Honda", "CBR", 2, 6, "Petrol");
        bike.displayBikeDetails();
        bike.wheelie();
        bike.start_engine();
        bike.stop_engine();
    }
}
