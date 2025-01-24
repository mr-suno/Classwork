import java.util.HashMap;
import java.util.Scanner;
import Classes.Classroom;
import Classes.Student;

public class Main {
    public static boolean Closed = false;

    public static void print(String[] Messages, boolean NewLine) {
        StringBuilder Output = new StringBuilder();

        for (String Message : Messages) {
            if (Message != null) {
                Output.append(Message).append(" ");
            } else {
                Output.append("null ");
            }
        }

        if (NewLine) {
            System.out.println(Output.toString().trim());
        } else {
            System.out.print(Output.toString().trim());
        }
    }

    public static void ShowInterface() {
        print(new String[]{}, true);
        print(new String[]{"#  OPTIONS"}, true);
        print(new String[]{"#"}, true);
        print(new String[]{"#  ⋅ [A] Add Student -n <String name> -i <int ID> -g <double[] grades>"}, true);
        print(new String[]{"#  ⋅ [R] Remove Student by ID -i <int ID>"}, true);
        print(new String[]{"#  ⋅ [S] Show All Students"}, true);
        print(new String[]{"#  ⋅ [F] Find Student by ID -i <int ID>"}, true);
        print(new String[]{"#  ⋅ [E] Exit"}, true);
        print(new String[]{"#"}, true);
        print(new String[]{"#  SELECTION: "}, false);
    }

    public static HashMap<String, String> ParseParams(String Input) {
        HashMap<String, String> Mapped = new HashMap<>();
        String[] Parts = Input.split("(?<!\\[)\\s+");

        for (int Index = 0; Index < Parts.length; Index++) {
            if (Parts[Index].startsWith("-")) {
                String Key = Parts[Index];

                if (Index + 1 < Parts.length && !Parts[Index + 1].startsWith("-")) {
                    Mapped.put(Key, Parts[Index + 1]);
                    Index++;
                } else {
                    Mapped.put(Key, null);
                }
            }
        }

        return Mapped;
    }

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        while (!Closed) {
            ShowInterface();

            String Option = Input.nextLine().trim();
            String[] Parts = Option.split(" ", 2);

            print(new String[]{"#"}, true);
            print(new String[]{}, true);

            switch (Parts[0]) {
                case "A":
                    String AMessage = " ⋅ Adding a New Student requires 3* parameters: -n <String name> -i <int ID> -g <double[] grades>";

                    if (Parts.length > 1) {
                        HashMap<String, String> Params = ParseParams(Parts[1]);

                        String Name = Params.get("-n");
                        String ID = Params.get("-i");
                        String Grades = Params.get("-g");

                        if (Name != null && ID != null && Grades != null) {
                            Grades = Grades.replaceAll("[\\[\\]\"]", "");

                            int NewID = Integer.parseInt(ID);
                            String[] NewGrades = Grades.split(",");
                            double[] GradesList = new double[NewGrades.length];

                            for (int Current = 0; Current < NewGrades.length; Current++) {
                                GradesList[Current] = Double.parseDouble(NewGrades[Current].trim());
                            }

                            Student Child = new Student();
                            Child.SetName(Name);
                            Child.SetID(NewID);
                            Child.SetGrades(GradesList);

                            Classroom.AddStudent(Child);

                            print(new String[]{" ⋅ SUCCESS: Added Student to Classroom"}, true);
                        } else {
                            print(new String[]{AMessage}, true);
                        }
                    } else {
                        print(new String[]{AMessage}, true);
                    }

                    break;
                case "R":
                    String RMessage = " ⋅ Removing a Student requires 1* parameter: -i <int ID>";

                    if (Parts.length > 1) {
                        HashMap<String, String> Params = ParseParams(Parts[1]);

                        String ID = Params.get("-i");

                        if (ID != null) {
                            try {
                                int NewID = Integer.parseInt(ID);

                                if (Classroom.StudentExists(NewID)) {
                                    Classroom.RemoveStudent(Integer.parseInt(ID));
                                    
                                    print(new String[]{" ⋅ Removed Student from Classroom"}, true);
                                } else {
                                    print(new String[]{" ⋅ Unknown Student ID, Add a Student Using the \"A\" Parameter!"}, true);
                                }
                            } catch (NumberFormatException _) {
                                print(new String[]{" ⋅ Invalid ID format, requires type: <int ID>"}, true);
                            }
                        } else {
                            print(new String[]{RMessage}, true);
                        }
                    } else {
                        print(new String[]{RMessage}, true);
                    }

                    break;
                case "S":
                    String Children = String.valueOf(Classroom.DisplayAllStudents());

                    if (Classroom.GetStudentCount() > 0) {
                        print(new String[]{" ⋅ List of Students in Classroom:"}, true);
                        print(new String[]{" ⋅ " + Children}, true);
                    } else {
                        print(new String[]{" ⋅ No Students in Current Classroom!"}, true);
                        print(new String[]{" ⋅ Use \"A -n <String name> -i <int ID> -g <double[] grades>\" to add a child"}, true);
                    }

                    break;
                case "F":
                    String FMessage = " ⋅ Finding a Student requires 1* parameter: -i <int ID>";

                    if (Parts.length > 1) {
                        HashMap<String, String> Params = ParseParams(Parts[1]);

                        String ID = Params.get("-i");

                        if (ID != null) {
                            int NewID = Integer.parseInt(ID);

                            if (Classroom.StudentExists(NewID)) {
                                print(new String[]{" ⋅ " + Classroom.FindStudent(NewID)}, true);
                            } else {
                                print(new String[]{" ⋅ Unknown Student ID, Add a Student Using the \"A\" Parameter!"}, true);
                            }
                        } else {
                            print(new String[]{FMessage}, true);
                        }
                    } else {
                        print(new String[]{FMessage}, true);
                    }

                    break;
                case "E":
                    print(new String[]{" ⋅ Stopping Student Management Terminal ..."}, true);

                    Closed = true;

                    break;
                default:
                    System.out.println(" ⋅ Invalid option. Please try again.");

                    break;
            }
        }
        
        Input.close();
    }
}
