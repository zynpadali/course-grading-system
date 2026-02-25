import java.util.Scanner;

// Abstract class
abstract class Student {
    protected String name;
    protected double[][] grades;

    // Constructor
    public Student(String name) {
        this.name = name;
        this.grades = new double[3][2]; // 3 courses, 2 exams (midterm & final)
    }
	//calculate average grade
    public double calculateAverage() {
        double sum = 0;
        for (int a = 0; a < grades.length; a++) {
            sum += (grades[a][0] + grades[a][1]);// sum all exams grades
        }
        return sum / 6; // divide sum to 6 for average (total 6 exams)
    }

    // Abstract method
    public abstract String getGradeCategory();
    
	// print student info
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Average: " + calculateAverage());
        System.out.println("Grade Category: " + getGradeCategory());
    }
}
//child class 1
class UndergraduateStudent extends Student {
    public UndergraduateStudent(String name) {
        super(name);
    }

    @Override
    //categorize grades
    public String getGradeCategory() {
        double avrg = calculateAverage();
        if (avrg >= 85) {
            return "Excellent";
        } else if (avrg >= 70 && avrg < 85) {
            return "Good";
        } else if (avrg >= 50 && avrg < 70) {
            return "Average";
        } else {
            return "Fail";
        }
    }
}
//child class 2
class GraduateStudent extends Student {
    public GraduateStudent(String name) {
        super(name);
    }

    @Override
    public String getGradeCategory() {
        double avrg = calculateAverage();
        if (avrg >= 85) {
            return "Excellent";
        } else if (avrg >= 70 && avrg < 85) {
            return "Good";
        } else if (avrg >= 50 && avrg < 70) {
            return "Average";
        } else {
            return "Fail";
        }
    }
}
//child class 3
class InternationalStudent extends Student {
    public InternationalStudent(String name) {
        super(name);
    }

    @Override
    public String getGradeCategory() {
        double avrg = calculateAverage();
        if (avrg >= 85) {
            return "Excellent";
        } else if (avrg >= 70 && avrg < 85) {
            return "Good";
        } else if (avrg >= 50 && avrg < 70) {
            return "Average";
        } else {
            return "Fail";
        }
    }
}
// main class
public class CourseGradingSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of students: ");
        int nos = input.nextInt();
        input.nextLine();
  

        Student[] stdn = new Student[nos];

        for (int x = 0; x < nos; x++) {
            System.out.print("Enter student name: ");
            String name = input.nextLine();
            
           
            System.out.print("Student type (1) Undergraduate (2) Graduate (3) International ?: ");
            int type = input.nextInt();
           

            if (type == 1) {
                stdn[x] = new UndergraduateStudent(name);
            } else if (type == 2) {
                stdn[x] = new GraduateStudent(name);
            } else {
                stdn[x] = new InternationalStudent(name);
            }

            System.out.println("Enter grades for 3 courses (Midterm and Final): ");
            for (int y = 0; y < 3; y++) {
                System.out.print("Course " + (y + 1) + ": ");
                stdn[x].grades[y][0] = input.nextDouble(); // midterm grades
                stdn[x].grades[y][1] = input.nextDouble(); // final grades
                input.nextLine();
             
            }
        }
        
		System.out.println("\n--- Student Results ---");
        for (Student student : stdn) {
            student.displayInfo();
        }
        input.close();
    }
}
