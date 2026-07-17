import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private String Names;
    private String Subjects;
    private int TotalMarks;

    public String getNames() {
        return Names;
    }

    public String getSubjects() {
        return Subjects;
    }

    public int getTotalMarks() {
        return TotalMarks;
    }

    public Student(String names, String subjects, int marks) {
        this.Names = names;
        this.Subjects = subjects;
        this.TotalMarks = marks;
    }

    @Override
    public String toString() {
        return "Name: " + Names + " | Subject: " + Subjects + " | Marks: " + TotalMarks;
    }

}

class Methodology {
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String names, String subjects, int marks) {
        students.add(new Student(names, subjects, marks));
        System.out.println("Done");
    }

    public void Displayall() {
        students.forEach(System.out::println);
    }

    public void SortedDisplay() {
        students.stream().sorted(Comparator.comparingInt(Student::getTotalMarks).reversed())
                .forEach(System.out::println);
    }

    public void above60() {
        students.stream().filter(s -> s.getTotalMarks() > 60).forEach(System.out::println);
    }

    public void Avg() {
        double avg = students.stream().mapToInt(Student::getTotalMarks).average().orElse(0.0);
        System.out.println("the avg is : " + avg);
    }

}

public class ecer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Methodology methodology = new Methodology();
        System.out.println("-------hello there-------");
        System.out.println("1. add student\n" + "2. display all students\n" + " 3. Sorted display of all students\n"
                + " 4. above 60 marks students\n" + "5. net average of all marks of students\n" + "6. Exit");
        while (true) {
            int teraflow = sc.nextInt();
            switch (teraflow) {
                case 1:
                    sc.nextLine(); // consume newline after switch's nextInt
                    System.out.println("enter name");
                    String dew = sc.nextLine();
                    System.out.println("enter subject");
                    String gew = sc.nextLine();
                    System.out.println("enter marks");
                    int fero = sc.nextInt();
                    methodology.addStudent(dew, gew, fero);
                    break;
                case 2:
                    methodology.Displayall();
                    break;
                case 3:
                    methodology.SortedDisplay();
                    break;
                case 4:
                    methodology.above60();
                    break;
                case 5:
                    methodology.Avg();
                    break;
                case 6:
                    sc.close();
                    System.exit(0);

            }
        }
    }
}
