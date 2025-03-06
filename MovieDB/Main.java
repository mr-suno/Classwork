import java.util.ArrayList;
import java.util.Scanner;

// Writing this makes me realize how lazy I truly am...
// I will never change

public class Main {
    public static boolean running = true;

    public static void print(String message) { // Prints a message with a newline to the terminal
        System.out.println(message);
    }

    public static void printf(String message) { // Prints a message to the terminal, no newline
        System.out.print(message);
    }

    private static void displayBeginningMessage() { // Displays the starting message when used
        print("Welcome, user, to MovieDB \n");
        print("• Various choices for DB Searching • \n");

//      <-- Regular Choices -->

        print("1. Add Movie");
        print("2. Remove Movie");
        print("3. Search for a Movie \n");

//      <-- Displaying Choices -->

        print("• Your choices for Displaying Movies • \n");

        print("4. Display in Original Places");
        print("5. Display in Alphabetical Order");
        print("6. Display in Reversed Order \n");

//      <-- Miscellaneous Choices -->

        print("7. Clear MovieDB Catalog");
        print("8. Close \n");
    }

    public static void main(String[] args) {
        displayBeginningMessage();

        while (running) {
            printf("Select an option: ");

            Scanner input = new Scanner(System.in);
            String command = input.nextLine();

            if (command.equals("8") || command.equalsIgnoreCase("close")) { // Stops the program
                running = false;

//              If "8" or "Close" is returned, immediately stop the program
            }

            if (command.equals("1") || command.equalsIgnoreCase("add")) { // Introduces a new movie to MovieDB
                printf("Provide the Movie's name: ");

                Scanner nextInput = new Scanner(System.in);
                String title = nextInput.nextLine();

                print("");

                int result = Manager.addMovie(title);
                if (result == 1) {
                    print("• MovieDB Already has this, Use \"2\" to Remove It • \n");
                } else {
                    print("• Added \"" + title + "\" to MovieDB, Thank You • \n");
                }
            } else if (command.equals("2") || command.equalsIgnoreCase("remove")) { // Removes a movie from MovieDB
                printf("Provide the Movie's name: ");

                Scanner nextInput = new Scanner(System.in);
                String title = nextInput.nextLine();

                print("");

                int result = Manager.removeMovie(title);
                if (result == 1) {
                    print("• Movie Isn't in MovieDB, Use \"1\" to Add It • \n");
                } else {
                    print("• Removed \"" + title + "\" from MovieDB, Thank You • \n");
                }
            } else if (command.equals("3") || command.equalsIgnoreCase("search")) { // Returns a movie's title (if it exists)
                printf("Provide the Movie's name: ");

                Scanner nextInput = new Scanner(System.in);
                String title = nextInput.nextLine();

                print("");

                String result = Manager.findMovie(title);
                if (result.equals("1")) {
                    print("• Movie Isn't in MovieDB, Use \"1\" to Add It • \n");
                } else {
                    print("• " + result);
                }
            }

            if (command.equals("4") || command.equalsIgnoreCase("original")) { // Lists every movie in the order of when it was added
                int movieCount = Manager.getMovies().size();

                if (movieCount > 0) {
                    print("\n• Here's a List of All Movies • \n");

                    for (int index = 0; index < movieCount; index++) {
                        print(String.format("%d. %s", index + 1, Manager.getMovies().get(index)));
                    }
                } else {
                    print("\n• Currently, There are no More Than 0 Movies •");
                }

                print("");
            } else if (command.equals("5") || command.equalsIgnoreCase("alphabetic")) { // Lists every movie in MovieDB via alphabetical
                ArrayList<String> movies = Manager.getMovies();
                ArrayList<String> localMovies = new ArrayList<>(movies);

                int movieCount = localMovies.size();
                if (movieCount > 0) {
                    int result = Sorting.sortAlphabetically(localMovies); // Uhh... I think I'll add a converter like: "1" to "one"
                    if (result == 0) {
                        print("\n• Here's Every Movie Displayed Alphabetically • \n");

                        for (int index = 0; index < movieCount; index++) {
                            print(String.format("%d. %s", index + 1, localMovies.get(index))); // Format our string to make things easier to read! (%d = int, %s = String)
                        }
                    }
                } else {
                    print("\n• Currently, There are no More Than 0 Movies •");
                }

                print("");
            } else if (command.equals("6") || command.equalsIgnoreCase("reverse")) { // Sorts and displays all movies opposite of the original order
                ArrayList<String> movies = Manager.getMovies();
                ArrayList<String> localMovies = new ArrayList<>(movies);

                int movieCount = localMovies.size();
                if (movieCount > 0) {
                    int result = Sorting.sortReversed(localMovies); // Reverse the local ArrayList YEEEAAAAAAAAAHHHHHHHH
                    if (result == 0) {
                        print("\n• Here's Every Movie in Reverse Order • \n");

                        for (int index = 0; index < movieCount; index++) {
                            print(String.format("%d. %s", index + 1, localMovies.get(index))); // Yes, sure, this is just a clone of #5, do I care? No.
                        }
                    }
                } else {
                    print("\n• Currently, There are no More Than 0 Movies •");
                }

                print("");
            }

            if (command.equals("7") || command.equalsIgnoreCase("clear")) { // Removes all titles from MovieDB
                ArrayList<String> movies = Manager.getMovies();

                int result = Manager.clearMovies(movies);
                if (result == 1) {
                    print("\n• Add Movies to the DB Before Clearing • \n");
                } else {
                    print("\n• Cleared MovieDB Successfully • \n");
                }
            }
        }
    }
}
