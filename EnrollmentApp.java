import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Student {
    void addStudent(String name, String id);
    void deleteStudent(String id);
    void searchStudent(String name);
}

interface Course {
    void addCourse(String name, String code);
    void deleteCourse(String code);
    void searchCourse(String name);
}

interface Instructor {
    void addInstructor(String name, String id);
    void deleteInstructor(String id);
    void searchInstructor(String name);
}

class StudentImpl implements Student {
    private List<String> studentNames;
    private List<String> studentIds;

    public StudentImpl() {
        studentNames = new ArrayList<>();
        studentIds = new ArrayList<>();
    }

    @Override
    public void addStudent(String name, String id) {
        if (studentIds.contains(id)) {
            System.out.println("Error: Student ID already exists.");
        } else {
            studentNames.add(name);
            studentIds.add(id);
            System.out.println("Student added successfully.");
        }
    }

    @Override
    public void deleteStudent(String id) {
        int index = studentIds.indexOf(id);
        if (index == -1) {
            System.out.println("Error: Student ID not found.");
        } else {
            studentNames.remove(index);
            studentIds.remove(index);
            System.out.println("Student deleted successfully.");
        }
    }

    @Override
    public void searchStudent(String name) {
        boolean found = false;
        for (int i = 0; i < studentNames.size(); i++) {
            if (studentNames.get(i).equalsIgnoreCase(name)) {
                System.out.println("Student Name: " + studentNames.get(i));
                System.out.println("Student ID: " + studentIds.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with the given name.");
        }
    }
}

class CourseImpl implements Course {
    private List<String> courseNames;
    private List<String> courseCodes;

    public CourseImpl() {
        courseNames = new ArrayList<>();
        courseCodes = new ArrayList<>();
    }

    @Override
    public void addCourse(String name, String code) {
        if (courseCodes.contains(code)) {
            System.out.println("Error: Course code already exists.");
        } else {
            courseNames.add(name);
            courseCodes.add(code);
            System.out.println("Course added successfully.");
        }
    }

    @Override
    public void deleteCourse(String code) {
        int index = courseCodes.indexOf(code);
        if (index == -1) {
            System.out.println("Error: Course code not found.");
        } else {
            courseNames.remove(index);
            courseCodes.remove(index);
            System.out.println("Course deleted successfully.");
        }
    }

    @Override
    public void searchCourse(String name) {
        boolean found = false;
        for (int i = 0; i < courseNames.size(); i++) {
            if (courseNames.get(i).equalsIgnoreCase(name)) {
                System.out.println("Course Name: " + courseNames.get(i));
                System.out.println("Course Code: " + courseCodes.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No course found with the given name.");
        }
    }
}

class InstructorImpl implements Instructor {
    private List<String> instructorNames;
    private List<String> instructorIds;

    public InstructorImpl() {
        instructorNames = new ArrayList<>();
        instructorIds = new ArrayList<>();
    }

    @Override
    public void addInstructor(String name, String id) {
        if (instructorIds.contains(id)) {
            System.out.println("Error: Instructor ID already exists.");
        } else {
            instructorNames.add(name);
            instructorIds.add(id);
            System.out.println("Instructor added successfully.");
        }
    }

@Override
    public void deleteInstructor(String id) {
        int index = instructorIds.indexOf(id);
        if (index == -1) {
            System.out.println("Error: Instructor ID not found.");
        } else {
            instructorNames.remove(index);
            instructorIds.remove(index);
            System.out.println("Instructor deleted successfully.");
        }
    }

    @Override
    public void searchInstructor(String name) {
        boolean found = false;
        for (int i = 0; i < instructorNames.size(); i++) {
            if (instructorNames.get(i).equalsIgnoreCase(name)) {
                System.out.println("Instructor Name: " + instructorNames.get(i));
                System.out.println("Instructor ID: " + instructorIds.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No instructor found with the given name.");
        }
    }
}

public class EnrollmentApp {
    public static void main(String[] args) {
        Student student = new StudentImpl();
        Course course = new CourseImpl();
        Instructor instructor = new InstructorImpl();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Add Course");
            System.out.println("5. Delete Course");
            System.out.println("6. Search Course");
            System.out.println("7. Add Instructor");
            System.out.println("8. Delete Instructor");
            System.out.println("9. Search Instructor");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    student.addStudent(studentName, studentId);
                    break;
                case 2:
                    System.out.print("Enter student ID to delete: ");
                    String studentIdToDelete = scanner.nextLine();
                    student.deleteStudent(studentIdToDelete);
                    break;
                case 3:
                    System.out.print("Enter student name to search: ");
                    String studentNameToSearch = scanner.nextLine();
                    student.searchStudent(studentNameToSearch);
                    break;
                case 4:
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    course.addCourse(courseName, courseCode);
                    break;
                case 5:
                    System.out.print("Enter course code to delete: ");
                    String courseCodeToDelete = scanner.nextLine();
                    course.deleteCourse(courseCodeToDelete);
                    break;
                case 6:
                    System.out.print("Enter course name to search: ");
                    String courseNameToSearch = scanner.nextLine();
                    course.searchCourse(courseNameToSearch);
                    break;
                case 7:
                    System.out.print("Enter instructor name: ");
                    String instructorName = scanner.nextLine();
                    System.out.print("Enter instructor ID: ");
String instructorId = scanner.nextLine();
                    instructor.addInstructor(instructorName, instructorId);
                    break;
                case 8:
                    System.out.print("Enter instructor ID to delete: ");
                    String instructorIdToDelete = scanner.nextLine();
                    instructor.deleteInstructor(instructorIdToDelete);
                    break;
                case 9:
                    System.out.print("Enter instructor name to search: ");
                    String instructorNameToSearch = scanner.nextLine();
                    instructor.searchInstructor(instructorNameToSearch);
                    break;
                case 10:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }
    }
}