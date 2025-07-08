package Com.Cars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Collection<Cars> cars = new ArrayList<>();

        int menuOption;

        do {
            System.out.println("\nGood day, Welcome to our app.");
            System.out.println("(1) Capture vehicle details");
            System.out.println("(2) View vehicle report");
            System.out.println("(3) Exit app");
            System.out.print("Choose an option: ");

            menuOption = input.nextInt();
            input.nextLine(); // consume newline

            switch (menuOption) {
                case 1:
                    System.out.print("Enter Make: ");
                    String make = input.nextLine();

                    System.out.print("Enter Model: ");
                    String model = input.nextLine();

                    System.out.print("Enter Plate Number (e.g. AA11BB GP): ");
                    String plateNum = input.nextLine();

                    System.out.print("Enter VIN Number (17 characters): ");
                    String vin = input.nextLine();
                    while (vin.length() != 17) {
                        System.out.print("Invalid VIN. Please re-enter (17 characters): ");
                        vin = input.nextLine();
                    }

                    System.out.print("Enter Year: ");
                    int year = input.nextInt();

                    System.out.print("Enter Mileage: ");
                    int mileage = input.nextInt();
                    input.nextLine(); // consume newline

                    Cars carObj = new Cars();
                    carObj.setMake(capitalize(make));
                    carObj.setModel(capitalize(model));
                    carObj.setPlateNumber(plateNum.toUpperCase());
                    carObj.setVin(vin.toUpperCase());
                    carObj.setYear(year);
                    carObj.setMileage(mileage);

                    cars.add(carObj);
                    System.out.println("Vehicle registered successfully!");
                    break;

                case 2:
                    if (cars.isEmpty()) {
                        System.out.println("No vehicles registered yet.");
                    } else {
                        System.out.println("\n----- Vehicle Report -----");
                        for (Cars car : cars) {
                            System.out.println(
                                    "MAKE: " + car.getMake() +
                                            "\nMODEL: " + car.getModel() +
                                            "\nPLATE NUMBER: " + car.getPlateNumber() +
                                            "\nVIN: " + car.getVin() +
                                            "\nYEAR: " + car.getYear() +
                                            "\nMILEAGE: " + car.getMileage() +
                                            "\n--------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println(" Invalid option. Please try again.");
            }

        } while (menuOption != 3);

        input.close();
    }

    public static String capitalize(String text) {
        if (text == null || text.isEmpty()) return text;
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
}
