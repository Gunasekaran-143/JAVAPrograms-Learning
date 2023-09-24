import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
class Recruitment {
private String name;
private String qualification;
private int experience;
private LocalDate dob;
private String gender;
public Recruitment(String name, String qualification, int experience,
LocalDate dob, String gender) {
this.name = name;
this.qualification = qualification;
this.experience = experience;
this.dob = dob;
this.gender = gender;
}
public String getName() {
return name;
}
public String getQualification() {
return qualification;
}
public int getExperience() {
return experience;
}
public LocalDate getDob() {
return dob;
}
public String getGender() {
return gender;
}
@Override
public String toString() {
return "Name: " + name + ", Qualification: " + qualification + ", Experience:" + experience +", DOB: " + dob + ", Gender: " + gender;
}
}
public class RecruitmentSorting {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the number of candidates: ");
int n = scanner.nextInt();
scanner.nextLine(); 
List<Recruitment> candidates = new ArrayList<>();
for (int i = 1; i <= n; i++) {
System.out.println("Enter details for candidate " + i + ":");
System.out.print("Name: ");
String name = scanner.nextLine();
System.out.print("Qualification: ");
String qualification = scanner.nextLine();
System.out.print("Experience (in years): ");
int experience = scanner.nextInt();
scanner.nextLine(); 
System.out.print("Date of Birth (YYYY-MM-DD): ");
String dobString = scanner.nextLine();
System.out.print("Gender: ");
String gender = scanner.nextLine();

LocalDate dob = LocalDate.parse(dobString);
Recruitment candidate = new Recruitment(name, qualification,
experience, dob, gender);
candidates.add(candidate);
}
for (int i = 1; i < candidates.size(); i++) {
Recruitment key = candidates.get(i);
int j = i - 1;
while (j >= 0 && candidates.get(j).getExperience() >
key.getExperience()) {
candidates.set(j + 1, candidates.get(j));
j--;
}
candidates.set(j + 1, key);
}
for (Recruitment candidate : candidates) {
System.out.println(candidate);
}
}}
