package JAVA.JDBC.Bus_MAnagament_System;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Class.forName;
import static java.lang.System.out;

public class MAIN {
    private static final String url = "jdbc:mysql://localhost:3306/Bus_Management";
    public static final String username = "root";
    public static final String password = "root";


    public int BusID(Scanner scanner){
        int busID;
        while (true) {
            try {
                out.println("Bus ID number: ");
                busID = scanner.nextInt();
                break; // Exit the loop if input is valid
            } catch (InputMismatchException e) {
                out.println("Invalid Input. Try Again.");
                scanner.next();
                // Clear the scanner buffer
            }
        }
        return busID;
    }
    String BusName(Scanner scanner){
        String bus_name;
        while (true){
            try {
                out.println("Bus Name : ");
                bus_name= scanner.next();
                break;
            }catch (InputMismatchException e){
                out.println("Invalid Input. Try Again.");
                scanner.next();
            }
        }
        return bus_name;
    }

    LocalDate RegisterDATE(Scanner scanner){
        LocalDate Register_DATE;
        while (true) {
            try {
                out.println("Enter Bus Registering Date (yyyy-MM-dd) : ");
                String registering = scanner.next();
                Register_DATE =LocalDate.parse(registering);
                break;
            } catch (DateTimeParseException e){
                out.println("Invalid Input. Try Again.");
                scanner.next();
            }
        }
            return Register_DATE;
    }
    int Capacity(Scanner scanner){
        int bus_Seat;
        while(true){
            try{
                out.println("Total Seats Bus : ");
                bus_Seat = scanner.nextInt();
                break;
            }catch (InputMismatchException e){
                out.println("Invalid Input. Try Again.");
                scanner.nextInt();
            }
        }
        return bus_Seat;
    }
    int AmountPerSeat(Scanner scanner){
        int AmountPerSeat;
        while (true){
            try{
                out.println("Amount Per Seat : ");
                AmountPerSeat= scanner.nextInt();
                break;
            }catch (InputMismatchException e){
                out.println("Invalid Input. Try Again.");
                scanner.nextInt();
            }
        }
        return AmountPerSeat;
    }
    String ActiveStatus(Scanner scanner){
        String Active_Status;
        while (true){
            try{
                out.println("Active Status(Y/N) : ");
                Active_Status = String.valueOf(scanner.next().charAt(0));
                break;
            }catch(InputMismatchException e){
                out.println("Invalid Input. Try Again.");
                scanner.next();
            }
        }
        return Active_Status;
    }
    String Start(Scanner scanner){
        String Start;
        while (true){
            try{
                out.println("Starting Point : ");
                Start = scanner.next();
                break;
            }catch(InputMismatchException e){
                out.println("Invalid Input. Try Again.");
                scanner.next();
            }
        }
        return Start;
    }
    String End(Scanner scanner){
        String End;
        while(true){
            try {
                out.println("Ending point : ");
                End = scanner.next();
                break;
            }catch (InputMismatchException e){
                out.println("Invalid Input. Try Again.");
                scanner.next();
            }
        }
        return End;
    }
    
    int PassNo(Scanner scanner){
        int PassNo ;
        while (true){
            try{
                out.println("Passenger Number : ");
                PassNo = scanner.nextInt();
                break;
            }catch (InputMismatchException e){
                out.println("Invalid Input. Try Again.");
                scanner.nextInt();
            }
        }
        return PassNo;
    }
    
    int PassID(Scanner scanner){
        int PassID;
        while(true){
            try {
                out.println("Passenger ID : ");
                PassID =scanner.nextInt();
                break;
            }catch (InputMismatchException e){
                out.println("Invalid Input. Try Again.");
                scanner.nextInt();
            }
        }
        return PassID;
    }
    String PassName(Scanner scanner){
        String PassName;
        while (true ){
            try{
                out.println("Passenger Name : ");
                PassName= scanner.next();
                break;
            }catch(InputMismatchException e){
                out.println("Invalid Input. Try Again.");
                scanner.nextInt();
            }
        }
        return PassName;
    }
    int Age(Scanner scanner){
        int Age;
        while (true){
            try{
                out.println("Passenger Age : ");
                Age = scanner.nextInt();
                break;
            }catch ( InputMismatchException e){
                out.println("Invalid Input. Try Again.");
                scanner.nextInt();
            }
        }
        return Age;
    }

    LocalDate DateBooking(Scanner scanner){
        LocalDate DateBooking;
        while (true) {
            try {
                out.println("Enter Bus Registering Date (yyyy-MM-dd) : ");
                String registering = scanner.next();
                DateBooking =LocalDate.parse(registering);
                break;
            } catch (DateTimeParseException e){
                out.println("Invalid Input. Try Again.");
                scanner.next();
            }
        }
        return DateBooking;
    }
    void createBus(Connection connect, Scanner scanner, MAIN method) {
        String insertQuery = "INSERT INTO Bus (BusID, Bus_name, Register_Date, Capacity, Fees_InRupees, Available, Starting_Point, End_Point) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement add = connect.prepareStatement(insertQuery)) {
            while (true) {
                add.setInt(1, method.BusID(scanner));
                add.setString(2, method.BusName(scanner));
                add.setDate(3, java.sql.Date.valueOf(method.RegisterDATE(scanner)));
                add.setInt(4, method.Capacity(scanner));
                add.setInt(5, method.AmountPerSeat(scanner));
                add.setString(6, method.ActiveStatus(scanner));
                add.setString(7, method.Start(scanner));
                add.setString(8, method.End(scanner));

                add.addBatch();

                System.out.println("Want to add More Data? (Y/N) : ");
                String choice = scanner.next();
                if (choice.equalsIgnoreCase("N")) break;
            }
            add.executeBatch();
            System.out.println("Data added successfully.");
        } catch (SQLException e) {
            System.out.println("Error occurred while adding data: " + e.getMessage());
        }
    }
    int Amount(Scanner scanner){
        int Amount;
        while (true){
            try {
                out.println("Budget/person  : ");
                Amount = scanner.nextInt();
                break;
            }catch( InputMismatchException e){
                out.println("Invalid Input. Try Again.");
                scanner.nextInt();
            }
        }
        return Amount;
    }
    void createPassenger(Connection connect, Scanner scanner, MAIN method){
        String insertQuery = "INSERT INTO Passenger (Pass_No, PassID, Pass_name, Age, DATEBooking, Amount) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement add = connect.prepareStatement(insertQuery)) {
            while (true) {
                add.setInt(1, method.PassNo(scanner));
                add.setInt(2, method.PassID(scanner));
                add.setString(3, method.PassName(scanner));
                add.setInt(4, method.Age(scanner));
                add.setDate(5, java.sql.Date.valueOf(method.DateBooking(scanner)));
                add.setInt(6, method.Amount(scanner));

                add.addBatch();

                System.out.println("Want to add More Data? (Y/N) : ");
                String choice = scanner.next();
                if (choice.equalsIgnoreCase("N")) break;
            }
            add.executeBatch();
            System.out.println("Data added successfully.");
        } catch (SQLException e) {
            System.out.println("Error occurred while adding data: " + e.getMessage());
        }
    }

    void printPassenger(Connection connect) {
        try (PreparedStatement printStatement = connect.prepareStatement("SELECT * FROM Passenger");
             ResultSet resultSet = printStatement.executeQuery()) {
            if (!resultSet.next()) out.println("Empty Data...");
            else {
                do{
                    int passNo = resultSet.getInt("Pass_No");
                    int passID = resultSet.getInt("PassID");
                    String passName = resultSet.getString("Pass_name");
                    int age = resultSet.getInt("Age");
                    java.sql.Date dateBooking = resultSet.getDate("DATEBooking");
                    int amount = resultSet.getInt("Amount");

                    System.out.println("Passenger Number: " + passNo);
                    System.out.println("Passenger ID: " + passID);
                    System.out.println("Passenger Name: " + passName);
                    System.out.println("Age: " + age);
                    System.out.println("Date Booking: " + dateBooking);
                    System.out.println("Amount: " + amount);
                    System.out.println("\n");
                }while (resultSet.next());
            }
        }catch (SQLException e) {
            out.println(e.getMessage());
        }
    }
    void printBus(Connection connect ) {
        try (PreparedStatement Print = connect.prepareStatement("SELECT * FROM bus");) {
            ResultSet printset = Print.executeQuery();
            if (!printset.next()) System.out.println("Empty Data...");
            else {
                do {
                    int busNo = printset.getInt("Bus_No");
                    int busID = printset.getInt("BusID");
                    String BusName = printset.getString("Bus_name");
                    Date register = printset.getDate("Register_Date");
                    int capacity = printset.getInt("Capacity");
                    int Fees = printset.getInt("Fees_InRupees");
                    String status = printset.getString("Available");
                    String Start = printset.getString("Starting_Point");
                    String End = printset.getString("End_Point");

                    System.out.println("Bus No. : " + busNo);
                    System.out.println("Bus ID : " + busID);
                    System.out.println("Bus Name : " + BusName);
                    System.out.println("Total Seat No : " + capacity);
                    System.out.println("Registered DATE : " + register);
                    System.out.println("Fees per Person : " + Fees);
                    System.out.println("Availability : " + status);
                    System.out.println("Starting point : " + Start);
                    System.out.println("Reaching point : " + End);
                    System.out.println();
                } while (printset.next());
            }
        } catch (SQLException e) {
            // Print the error message
            out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws SQLException {
        try {forName("com.mysql.cj.jdbc.Driver");}
        catch (ClassNotFoundException e) {out.println(e.getMessage());}

        Connection connect = DriverManager.getConnection(url, username, password);
        MAIN Method = new MAIN();
        Scanner in = new Scanner(System.in);
        String choice;
        do {
            out.println(" 🔰Add Buses Data                 (1) 🔰 ");
            out.println(" 🔰Add Passengers Data            (2) 🔰 ");
            out.println(" 🔰To get All Data from Bus       (3) 🔰 ");
            out.println(" 🔰To get All Data from Passenger (4) 🔰 ");
            out.print("Choice : ");
            int ch = in.nextInt();

            if (ch==1) Method.createBus(connect,in,Method);
            if (ch==2) Method.createPassenger(connect,in,Method);
            if (ch==3) Method.printBus(connect);
            if (ch==4) Method.printPassenger(connect);

            out.println("\n \t Perform Any other operation (y/n) : ");
            choice = String.valueOf(in.next().charAt(0));
        }while (choice.equalsIgnoreCase("y"));
    }
}
