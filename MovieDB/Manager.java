import java.util.ArrayList;

public final class Manager {
    private static final ArrayList<String> movies = new ArrayList<>();

    public static ArrayList<String> getMovies() { // Returns our MovieDB ArrayList
        return movies;
    }

    public static int clearMovies(ArrayList<String> list) { // Instantly clears every single movie
        if (list.isEmpty()) return 1;

        try {
            list.clear();

            return 0;
        } catch (Exception ignored) {}

        return 1;
    }

    public static int addMovie(String title) { // Adds a new title to MovieDB
        if (title == null) return 1;
        if (movies.contains(title)) return 1;

        movies.add(title); // Insert the Movie to the "movies" ArrayList

        return 0; // Success, useful for debug messages
    }

    public static int removeMovie(String title) { // Removes a movie from our DB
        if (title == null) return 1;

        if (movies.contains(title)) {
            movies.remove(title);

            return 0;
        }

        return 1; // Default to a failure response if such movie is non-existent
    }

    public static String findMovie(String title) { // Finds and returns a movie in MovieDB
        if (title == null) return "1";

        StringBuilder output = new StringBuilder();

        if (movies.contains(title)) {
            return output.append("Displaying Movie: ").append(title).append("\n").toString();
        }

        return "1"; // String type because I'm really lazy
    }
}
