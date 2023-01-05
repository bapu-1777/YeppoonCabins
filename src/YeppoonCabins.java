import java.util.Scanner;

// #1 class name "YeppoonCabins"
public class YeppoonCabins {

//    #2 all variables
    public static final double CLEANING_FEE = 20.00;
    public static final double NIGHTS_COST = 89.95;
    public static final int DISCOUNT_LEVEL_7 = 7;
    public static final int DISCOUNT_LEVEL_14 = 14;
    public static final double DISCOUNT_10 = 0.10;
    public static final double DISCOUNT_15 = 0.15;
    public static void main(String[] args) {

        System.out.println("Welcome to the Yeppoon Cabins Management System");

        // #3 to take input
        Scanner textScanner = new Scanner(System.in);
        Scanner numberScanner = new Scanner(System.in);

        // #4 highest digit in student ID
        int N = 3;
        double minBooking = Integer.MAX_VALUE;
        double maxBooking = Integer.MIN_VALUE;
        double totalCost = 0.0;
        double totalNights = 0.0;

        for (int i = 1; i <= N; i++) {
            System.out.println("Enter booking name " + i + ": ");
            String bookingName = textScanner.nextLine();

            while (bookingName == null || bookingName.isEmpty()) {
                System.out.println("Booking name can not be blank. Please enter the booking name again: ");
                bookingName = textScanner.nextLine();
            }

            System.out.println("Enter number of nights for booking " + i + ": ");
            int numberOfNights = numberScanner.nextInt();

            while (numberOfNights < 1) {
                System.out.println("Number of nights must be greater than or equal to 1. Please enter the number of nights again: ");
                numberOfNights = numberScanner.nextInt();
            }

            // calculate the cost
            double cost = 0.0;
            if (numberOfNights > DISCOUNT_LEVEL_14) {
                cost = (numberOfNights * NIGHTS_COST) * (1 - DISCOUNT_15);
            } else if (numberOfNights > DISCOUNT_LEVEL_7) {
                cost = (numberOfNights * NIGHTS_COST) * (1 - DISCOUNT_10);
            } else {
                cost = numberOfNights * NIGHTS_COST;
            }
            cost += CLEANING_FEE;

            // format the cost
            System.out.printf("Booking %d: %s, %d night(s) - charge $%.2f\n", i, bookingName, numberOfNights, cost);

            totalCost += cost;
            totalNights += numberOfNights;

            // check for min and max bookings
            if (numberOfNights < minBooking) {
                minBooking = numberOfNights;
            }
            if (numberOfNights > maxBooking) {
                maxBooking = numberOfNights;
            }
        }

        // calculate the average nights
        double averageNights = totalNights / N;

        System.out.println("Statistical information for Yeppoon Cabins");
        System.out.printf("Minimum number of nights booked: %.0f\n", minBooking);
        System.out.printf("Maximum number of nights booked: %.0f\n", maxBooking);
        System.out.printf("Average number of nights per booking: %.2f\n", averageNights);
        System.out.printf("Total charges collected: $%.2f\n", totalCost);
        System.out.println("Thank you for using the Yeppoon Cabins Management System");
        System.out.println("Program written by [your name/STUDENT ID]");
    }
}