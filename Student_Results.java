import java.util.Scanner;

public class Student_Results {

    private int regNo;
    private String name;
    private String branch;
    private double cgpa;

    public Student_Results() {
    }

    public Student_Results(int regNo, String name, String branch, double cgpa) {
        this.regNo = regNo;
        this.name = name;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getCGPA() {
        return cgpa;
    }

    public void setCGPA(double CGPA) {
        this.cgpa = cgpa;
    }

    public void display() {
        System.out.println("Reg.No: " + regNo);
        System.out.println("Name: " + name);
        System.out.println("Branch: " + branch);
        System.out.println("CGPA: " + cgpa);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of students: ");
        int n = sc.nextInt();

        Student_Results[] students = new Student_Results[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the details of student " + (i + 1) + ": ");

            System.out.println("Enter the reg. no.: ");
            int regNo = sc.nextInt();

            System.out.println("Enter the name: ");
            String name = sc.next();

            System.out.println("Enter the branch: ");
            String branch = sc.next();

            System.out.println("Enter the CGPA: ");
            double cgpa = sc.nextDouble();

            students[i] = new Student_Results(regNo, name, branch, cgpa);
        }

        // Find the top two toppers in each branch
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (students[i].getCGPA() < students[j].getCGPA()) {
                    Student_Results temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }

        // Display the shortlisted students' details
        System.out.println("The shortlisted students are: ");
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                students[i].display();
            }
        }
    } 
}
