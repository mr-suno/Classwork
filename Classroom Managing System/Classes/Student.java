package Classes;

public class Student {
    private String Name;
    private int ID;
    private double[] Grades = new double[5];

//    Name

    public String GetName() {
        return Name;
    }

    public void SetName(String Name) {
        this.Name = Name;
    }

//    ID

    public int GetID() {
        return ID;
    }

    public void SetID(int ID) {
        this.ID = ID;
    }

//    Grades

    public void SetGrades(double[] Grades) {
        this.Grades = Grades;
    }

//    Other Stuff

    public double CalculateAverage() {
        double Sum = 0.0;

        for (double Grade : Grades) {
            Sum += Grade;
        }

        return Sum / Grades.length;
    }

    public String GetLetterGrade() {
        double Average = CalculateAverage();

        if (Average >= 90) {
            return "A";
        } else if (Average >= 80) {
            return "B";
        } else if (Average >= 70) {
            return "C";
        } else if (Average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
