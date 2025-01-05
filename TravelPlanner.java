import java.util.*;
// Class to represent a travel itinerary
class TravelItinerary {
    private String destination;
    private String startDate;
    private String endDate;
    private double budget;

    // Constructor to initialize the itinerary details
    public TravelItinerary(String destination, String startDate, String endDate, double budget) {
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    // Getter for destination
    public String getDestination() {
        return destination;
    }

    // Getter for start date
    public String getStartDate() {
        return startDate;
    }

    // Getter for end date
    public String getEndDate() {
        return endDate;
    }

    // Getter for budget
    public double getBudget() {
        return budget;
    }

    // Override toString to provide a readable representation of the itinerary
    @Override
    public String toString() {
        return "Destination: " + destination + 
               "\nStart Date: " + startDate + 
               "\nEnd Date: " + endDate + 
               "\nBudget: $" + budget + "\n";
    }
}

// Main class to handle travel planning
public class TravelPlanner {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<TravelItinerary> itineraries = new ArrayList<>(); // List to store itineraries

    // Main method to run the application
    public static void main(String[] args) {
        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (true) {
            // Display menu options
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
                    addItinerary(); // Call method to add an itinerary
                    break;
                case 2:
                    viewItineraries(); // Call method to view all itineraries
                    break;
                case 3:
                    calculateTotalBudget(); // Call method to calculate total budget
                    break;
                case 4:
                    System.out.println("Thank you for using the Travel Itinerary Planner. Goodbye!");
                    System.exit(0); // Exit the application
                    break;
                default:
                    System.out.println("Invalid choice! Please try again."); // Handle invalid input
            }
        }
    }

    // Method to add a new itinerary
    private static void addItinerary() {
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();

        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();

        System.out.print("Enter budget: ");
        double budget = scanner.nextDouble();

        // Create a new itinerary and add it to the list
        itineraries.add(new TravelItinerary(destination, startDate, endDate, budget));
        System.out.println("Itinerary added successfully!");
    }

    // Method to view all saved itineraries
    private static void viewItineraries() {
        if (itineraries.isEmpty()) {
            System.out.println("No itineraries found."); // Handle case with no itineraries
            return;
        }

        System.out.println("\nYour Itineraries:");
        for (TravelItinerary itinerary : itineraries) {
            System.out.println(itinerary); // Print each itinerary
        }
    }

    // Method to calculate the total budget for all itineraries
    private static void calculateTotalBudget() {
        if (itineraries.isEmpty()) {
            System.out.println("No itineraries found."); // Handle case with no itineraries
            return;
        }

        double totalBudget = 0;
        for (TravelItinerary itinerary : itineraries) {
            totalBudget += itinerary.getBudget(); // Sum up the budget of each itinerary
        }

        System.out.println("Total Budget for All Itineraries: $" + totalBudget);
    }
}
