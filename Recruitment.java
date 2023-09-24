import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

class Recruitment {
    private String name;
    private String qualification;
    private int experience;
    private Date dob;
    private char gender;

    public Recruitment(String name, String qualification, int experience, Date dob, char gender) {
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

    public Date getDob() {
        return dob;
    }

    public char getGender() {
        return gender;
    }
}

class RecruitmentSorter implements Comparator<Recruitment> {
    public int compare(Recruitment r1, Recruitment r2) {
        if (r1.getExperience() != r2.getExperience()) {
            return Integer.compare(r2.getExperience(), r1.getExperience());
        } else {
            return r1.getName().compareTo(r2.getName());
        }
    }
}

public class RecruitmentMain {
    public static void main(String[] args) {
        Recruitment[] candidates = {
                new Recruitment("Jennie", "PhD", 3, new Date(1990, 0, 1), 'F'),
                new Recruitment("Lisa", "MSc", 2, new Date(1995, 5, 15), 'F'),
                new Recruitment("Jisoo", "PhD", 1, new Date(1992, 2, 28), 'F'),
                new Recruitment("Rose", "MSc", 3, new Date(1987, 9, 3), 'F'),
                new Recruitment("Eve", "PhD", 2, new Date(1989, 7, 12), 'F')
        };

        System.out.println("Before sorting:");
        for (Recruitment r : candidates) {
            System.out.println(r.getName() + ", " + r.getExperience());
        }

        Arrays.sort(candidates, new RecruitmentSorter());

        System.out.println("\nAfter sorting:");
        for (Recruitment r : candidates) {
            System.out.println(r.getName() + ", " + r.getExperience());
        }
    }
}