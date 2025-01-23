package Classes;
import java.util.ArrayList;

public class Classroom {
    public static final ArrayList<Student> Students = new ArrayList<>();

    public static void AddStudent(Student Child) {
        Students.add(Child);
    }

    public static void RemoveStudent(int ID) {
        for (Student Child : Students) {
            if (Child.GetID() == ID) {
                Students.remove(Child);

                return;
            }
        }
    }

    public static boolean StudentExists(int ID) {
        for (Student Child : Students) {
            if (Child.GetID() == ID) {
                return true;
            }
        }

        return false;
    }

    public static int GetStudentCount() {
        return Students.size();
    }

    public static StringBuilder DisplayAllStudents() {
        StringBuilder StudentsList = new StringBuilder();

        for (Student Child : Students) {
            if (Child != null) {
                StudentsList.append(Child.GetName()).append(" | ID: ").append(Child.GetID()).append("\n");
            }
        }

        return StudentsList;
    }

    public static StringBuilder FindStudent(int ID) {
        StringBuilder StudentsList = new StringBuilder();

        for (Student Child : Students) {
            if (Child != null && Child.GetID() == ID) {
                StudentsList.append(Child.GetName()).append(" | ID: ").append(Child.GetID()).append("\n");
            }
        }

        return StudentsList;
    }
}
