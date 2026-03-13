import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Vehicle Rental Management System
 * 
 * This system demonstrates Object-Oriented Programming principles including:
 * - Interface-based design for defining contracts
 * - Inheritance through interface implementation
 * - Polymorphism through method overriding
 * - Encapsulation of vehicle-specific attributes
 * 
 * @author Muhammad Ahmad
 * @version 1.0
 * @since 2026-03-13
 */

// ==================== INTERFACES ====================

/**
 * Core Vehicle interface defining the contract for all vehicle types.
 * Provides methods for retrieving basic vehicle information.
 */
interface Vehicle {
    /**
     * Retrieves the manufacturer of the vehicle.
     * @return String representing the vehicle make
     */
    String getMake();
    
    /**
     * Retrieves the model name of the vehicle.
     * @return String representing the vehicle model
     */
    String getModel();
    
    /**
     * Retrieves the year of manufacture.
     * @return int representing the manufacturing year
     */
    int getYearOfManufacture();
    
    /**
     * Displays detailed information about the vehicle.
     */
    void displayVehicleDetails();
}

/**
 * CarVehicle interface extends the behavior for Car-specific attributes.
 * Includes methods for managing door count and fuel type.
 */
interface CarVehicle {
    /**
     * Sets the number of doors for the car.
     * @param doors Number of doors (typically 2, 4, or 5)
     */
    void setNumberOfDoors(int doors);
    
    /**
     * Retrieves the number of doors.
     * @return int representing number of doors
     */
    int getNumberOfDoors();
    
    /**
     * Sets the fuel type for the car.
     * @param fuelType Type of fuel (Petrol, Diesel, or Electric)
     */
    void setFuelType(String fuelType);
    
    /**
     * Retrieves the fuel type.
     * @return String representing fuel type
     */
    String getFuelType();
}

/**
 * MotorVehicle interface defines motorcycle-specific behaviors.
 * Manages wheel configuration and motorcycle classification.
 */
interface MotorVehicle {
    /**
     * Sets the number of wheels on the motorcycle.
     * @param wheels Number of wheels (typically 2 or 3 for trikes)
     */
    void setNumberOfWheels(int wheels);
    
    /**
     * Retrieves the number of wheels.
     * @return int representing wheel count
     */
    int getNumberOfWheels();
    
    /**
     * Sets the motorcycle type/category.
     * @param type Category: Sport, Cruiser, or Off-Road
     */
    void setMotorcycleType(String type);
    
    /**
     * Retrieves the motorcycle type.
     * @return String representing motorcycle category
     */
    String getMotorcycleType();
}

/**
 * TruckVehicle interface specifies commercial truck attributes.
 * Handles cargo capacity and transmission specifications.
 */
interface TruckVehicle {
    /**
     * Sets the cargo capacity in tons.
     * @param capacity Cargo capacity in metric tons
     */
    void setCargoCapacity(double capacity);
    
    /**
     * Retrieves the cargo capacity.
     * @return double representing capacity in tons
     */
    double getCargoCapacity();
    
    /**
     * Sets the transmission type.
     * @param transmission Either "Manual" or "Automatic"
     */
    void setTransmissionType(String transmission);
    
    /**
     * Retrieves the transmission type.
     * @return String representing transmission type
     */
    String getTransmissionType();
}

// ==================== CONCRETE CLASSES ====================

/**
 * Car class represents a passenger vehicle.
 * Implements both Vehicle and CarVehicle interfaces.
 */
class Car implements Vehicle, CarVehicle {
    // Core vehicle attributes
    private String make;
    private String model;
    private int yearOfManufacture;
    
    // Car-specific attributes
    private int numberOfDoors;
    private String fuelType;
    
    /**
     * Constructs a Car with basic vehicle information.
     */
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = year;
    }
    
    @Override
    public String getMake() {
        return make;
    }
    
    @Override
    public String getModel() {
        return model;
    }
    
    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    
    @Override
    public void setNumberOfDoors(int doors) {
        if (doors < 1 || doors > 5) {
            throw new IllegalArgumentException("Number of doors must be between 1 and 5");
        }
        this.numberOfDoors = doors;
    }
    
    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    
    @Override
    public void setFuelType(String fuelType) {
        String normalized = fuelType.trim().toLowerCase();
        if (!normalized.equals("petrol") && !normalized.equals("diesel") && !normalized.equals("electric")) {
            throw new IllegalArgumentException("Fuel type must be Petrol, Diesel, or Electric");
        }
        this.fuelType = normalized.substring(0, 1).toUpperCase() + normalized.substring(1);
    }
    
    @Override
    public String getFuelType() {
        return fuelType;
    }
    
    @Override
    public void displayVehicleDetails() {
        System.out.println("\n+======================================+");
        System.out.println("|          CAR DETAILS                 |");
        System.out.println("+======================================+");
        System.out.printf("| Make:              %-17s |%n", make);
        System.out.printf("| Model:             %-17s |%n", model);
        System.out.printf("| Year:              %-17d |%n", yearOfManufacture);
        System.out.printf("| Doors:             %-17d |%n", numberOfDoors);
        System.out.printf("| Fuel Type:         %-17s |%n", fuelType);
        System.out.println("+======================================+");
    }
}

/**
 * Motorcycle class represents two-wheeled vehicles.
 * Implements Vehicle and MotorVehicle interfaces.
 */
class Motorcycle implements Vehicle, MotorVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfWheels;
    private String motorcycleType;
    
    public Motorcycle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = year;
    }
    
    @Override
    public String getMake() {
        return make;
    }
    
    @Override
    public String getModel() {
        return model;
    }
    
    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    
    @Override
    public void setNumberOfWheels(int wheels) {
        if (wheels < 2 || wheels > 3) {
            throw new IllegalArgumentException("Motorcycles typically have 2 or 3 wheels");
        }
        this.numberOfWheels = wheels;
    }
    
    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
    
    @Override
    public void setMotorcycleType(String type) {
        String normalized = type.trim().toLowerCase();
        if (!normalized.equals("sport") && !normalized.equals("cruiser") && !normalized.equals("off-road")) {
            throw new IllegalArgumentException("Type must be Sport, Cruiser, or Off-Road");
        }
        this.motorcycleType = normalized.substring(0, 1).toUpperCase() + normalized.substring(1);
    }
    
    @Override
    public String getMotorcycleType() {
        return motorcycleType;
    }
    
    @Override
    public void displayVehicleDetails() {
        System.out.println("\n+======================================+");
        System.out.println("|       MOTORCYCLE DETAILS             |");
        System.out.println("+======================================+");
        System.out.printf("| Make:              %-17s |%n", make);
        System.out.printf("| Model:             %-17s |%n", model);
        System.out.printf("| Year:              %-17d |%n", yearOfManufacture);
        System.out.printf("| Wheels:            %-17d |%n", numberOfWheels);
        System.out.printf("| Type:              %-17s |%n", motorcycleType);
        System.out.println("+======================================+");
    }
}

/**
 * Truck class represents commercial cargo vehicles.
 * Implements Vehicle and TruckVehicle interfaces.
 */
class Truck implements Vehicle, TruckVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private double cargoCapacity;
    private String transmissionType;
    
    public Truck(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.yearOfManufacture = year;
    }
    
    @Override
    public String getMake() {
        return make;
    }
    
    @Override
    public String getModel() {
        return model;
    }
    
    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    
    @Override
    public void setCargoCapacity(double capacity) {
        if (capacity <= 0 || capacity > 100) {
            throw new IllegalArgumentException("Cargo capacity must be between 0.1 and 100 tons");
        }
        this.cargoCapacity = capacity;
    }
    
    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }
    
    @Override
    public void setTransmissionType(String transmission) {
        String normalized = transmission.trim().toLowerCase();
        if (!normalized.equals("manual") && !normalized.equals("automatic")) {
            throw new IllegalArgumentException("Transmission must be Manual or Automatic");
        }
        this.transmissionType = normalized.substring(0, 1).toUpperCase() + normalized.substring(1);
    }
    
    @Override
    public String getTransmissionType() {
        return transmissionType;
    }
    
    @Override
    public void displayVehicleDetails() {
        System.out.println("\n+======================================+");
        System.out.println("|         TRUCK DETAILS                |");
        System.out.println("+======================================+");
        System.out.printf("| Make:              %-17s |%n", make);
        System.out.printf("| Model:             %-17s |%n", model);
        System.out.printf("| Year:              %-17d |%n", yearOfManufacture);
        System.out.printf("| Cargo Capacity:    %-16.1fT |%n", cargoCapacity);
        System.out.printf("| Transmission:      %-17s |%n", transmissionType);
        System.out.println("+======================================+");
    }
}

// ==================== MAIN PROGRAM ====================

/**
 * VehicleRentalSystem serves as the entry point and controller.
 * Provides interactive menu-driven interface for vehicle management.
 */
public class VehicleRentalSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Vehicle> vehicleFleet = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   VEHICLE RENTAL MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("Initializing OOP Interface Demonstration\n");
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getMenuChoice();
            
            try {
                switch (choice) {
                    case 1 -> addCar();
                    case 2 -> addMotorcycle();
                    case 3 -> addTruck();
                    case 4 -> displayAllVehicles();
                    case 5 -> {
                        running = false;
                        System.out.println("\nThank you for using Vehicle Rental System!");
                    }
                    default -> System.out.println("Invalid option. Please select 1-5.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Clear buffer
            }
        }
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n+-------------------------------------+");
        System.out.println("|         MAIN MENU                   |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 1. Add New Car                      |");
        System.out.println("| 2. Add New Motorcycle               |");
        System.out.println("| 3. Add New Truck                    |");
        System.out.println("| 4. Display All Vehicles             |");
        System.out.println("| 5. Exit                             |");
        System.out.println("+-------------------------------------+");
        System.out.print("Enter your choice (1-5): ");
    }
    
    private static int getMenuChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }
    
    private static void addCar() {
        System.out.println("\n--- Adding New Car ---");
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter Make: ");
        String make = scanner.nextLine().trim();
        
        System.out.print("Enter Model: ");
        String model = scanner.nextLine().trim();
        
        int year = getValidYear();
        
        Car car = new Car(make, model, year);
        
        System.out.print("Enter Number of Doors (2-5): ");
        int doors = scanner.nextInt();
        car.setNumberOfDoors(doors);
        
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Fuel Type (Petrol/Diesel/Electric): ");
        String fuel = scanner.nextLine();
        car.setFuelType(fuel);
        
        vehicleFleet.add(car);
        System.out.println("[OK] Car added successfully!");
    }
    
    private static void addMotorcycle() {
        System.out.println("\n--- Adding New Motorcycle ---");
        scanner.nextLine();
        
        System.out.print("Enter Make: ");
        String make = scanner.nextLine().trim();
        
        System.out.print("Enter Model: ");
        String model = scanner.nextLine().trim();
        
        int year = getValidYear();
        
        Motorcycle motorcycle = new Motorcycle(make, model, year);
        
        System.out.print("Enter Number of Wheels (2-3): ");
        int wheels = scanner.nextInt();
        motorcycle.setNumberOfWheels(wheels);
        
        scanner.nextLine();
        System.out.print("Enter Motorcycle Type (Sport/Cruiser/Off-Road): ");
        String type = scanner.nextLine();
        motorcycle.setMotorcycleType(type);
        
        vehicleFleet.add(motorcycle);
        System.out.println("[OK] Motorcycle added successfully!");
    }
    
    private static void addTruck() {
        System.out.println("\n--- Adding New Truck ---");
        scanner.nextLine();
        
        System.out.print("Enter Make: ");
        String make = scanner.nextLine().trim();
        
        System.out.print("Enter Model: ");
        String model = scanner.nextLine().trim();
        
        int year = getValidYear();
        
        Truck truck = new Truck(make, model, year);
        
        System.out.print("Enter Cargo Capacity (tons): ");
        double capacity = scanner.nextDouble();
        truck.setCargoCapacity(capacity);
        
        scanner.nextLine();
        System.out.print("Enter Transmission Type (Manual/Automatic): ");
        String transmission = scanner.nextLine();
        truck.setTransmissionType(transmission);
        
        vehicleFleet.add(truck);
        System.out.println("[OK] Truck added successfully!");
    }
    
    private static int getValidYear() {
        int currentYear = java.time.Year.now().getValue();
        while (true) {
            try {
                System.out.print("Enter Year of Manufacture (1900-" + currentYear + "): ");
                int year = scanner.nextInt();
                if (year < 1900 || year > currentYear) {
                    System.out.println("Invalid year. Please enter between 1900 and " + currentYear);
                    continue;
                }
                return year;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.nextLine();
            }
        }
    }
    
    private static void displayAllVehicles() {
        if (vehicleFleet.isEmpty()) {
            System.out.println("\nNo vehicles in the system yet.");
            return;
        }
        
        System.out.println("\n########################################");
        System.out.println("#       COMPLETE VEHICLE FLEET         #");
        System.out.println("########################################");
        
        for (int i = 0; i < vehicleFleet.size(); i++) {
            System.out.println("\nVehicle #" + (i + 1));
            vehicleFleet.get(i).displayVehicleDetails();
        }
        
        System.out.println("\nTotal vehicles registered: " + vehicleFleet.size());
    }
}