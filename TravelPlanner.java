import java.util.ArrayList;
import java.util.Scanner;

class TravelItinerary {
    private String destination;
    private String startDate;
    private String endDate;
    private double budget;

    public TravelItinerary(String destination, String startDate, String endDate, double budget) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public String getDestination() {
        return destination;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Destination: " + destination + 
               "\nStart Date: " + startDate + 
               "\nEnd Date: " + endDate + 
               "\nBudget: $" + budget + "\n";
    }
}

public class TravelPlanner {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<TravelItinerary> itineraries = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Itinerary");
            System.out.println("2. View Itineraries");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItinerary();
                    break;
                case 2:
                    viewItineraries();
                    break;
                case 3:
                    calculateTotalBudget();
                    break;
                case 4:
                    System.out.println("Thank you for using the Travel Itinerary Planner. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void addItinerary() {
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();

        System.out.print("Enter budget: ");
        double budget = scanner.nextDouble();

        itineraries.add(new TravelItinerary(destination, startDate, endDate, budget));
        System.out.println("Itinerary added successfully!");
    }

    private static void viewItineraries() {
        if (itineraries.isEmpty()) {
            System.out.println("No itineraries found.");
            return;
        }

        System.out.println("\nYour Itineraries:");
        for (TravelItinerary itinerary : itineraries) {
            System.out.println(itinerary);
        }
    }

    private static void calculateTotalBudget() {
        if (itineraries.isEmpty()) {
            System.out.println("No itineraries found.");
            return;
        }

        double totalBudget = 0;
        for (TravelItinerary itinerary : itineraries) {
            totalBudget += itinerary.getBudget();
        }

        System.out.println("Total Budget for All Itineraries: $" + totalBudget);
    }
}
