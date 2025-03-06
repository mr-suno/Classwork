import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
    public static int sortReversed(ArrayList<String> list) { // Returns the provided ArrayList in the opposite order of the original state (Use twice to cancel out)
        if (list.isEmpty()) return 1;

        try {
            list.sort(Collections.reverseOrder());

            return 0;
        } catch (Exception ignored) {}

        return 1;
    }

    public static int sortAlphabetically(ArrayList<String> list) { // Sorts the given ArrayList in alphabetical order
        if (list.isEmpty()) return 1;

        try {
            Collections.sort(list);

            return 0;
        } catch (Exception ignored) {}

        return 1;
    }
}
