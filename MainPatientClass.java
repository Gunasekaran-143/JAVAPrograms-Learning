import java.util.*;

// Abstract class Patient
abstract class Patient {
    private String patientName;
    private int patientAge;
    private String patientGender;
    private String patientID;
    private String patientAddress;

    // Constructor
    public Patient(String patientName, int patientAge, String patientGender, String patientID, String patientAddress) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.patientID = patientID;
        this.patientAddress = patientAddress;
    }

    // Getters and setters
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    // Abstract method
    public abstract String getUniqueProperty();
}

// Inpatient class
class Inpatient extends Patient {
    private int bedNumber;

    // Constructor
    public Inpatient(String patientName, int patientAge, String patientGender, String patientID, String patientAddress,
            int bedNumber) {
        super(patientName, patientAge, patientGender, patientID, patientAddress);
        this.bedNumber = bedNumber;
    }

    // Getter and setter
    public int getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    // Implementing abstract method
    @Override
    public String getUniqueProperty() {
        return "Bed Number: " + bedNumber;
    }
}

// Outpatient class
class Outpatient extends Patient {
    private String appointmentDate;

    // Constructor
    public Outpatient(String patientName, int patientAge, String patientGender, String patientID, String patientAddress,
            String appointmentDate) {
        super(patientName, patientAge, patientGender, patientID, patientAddress);
        this.appointmentDate = appointmentDate;
    }

    // Getter and setter
    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    // Implementing abstract method
    @Override
    public String getUniqueProperty() {
        return "Appointment Date: " + appointmentDate;
    }
}

// MedicalRecord interface
interface MedicalRecord {
    void addRecord();

    void deleteRecord();

    void viewRecord();
}

// LaboratoryReport class
class LaboratoryReport implements MedicalRecord {
    private String testName;

    // Constructor
    public LaboratoryReport(String testName) {
        this.testName = testName;
    }

    // Getter and setter
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    // Implementing interface methods
    @Override
    public void addRecord() {
        System.out.println("Adding Laboratory Report: " + testName);
        // Add your logic here to add the laboratory report to the patient's medical records
    }

    @Override
    public void deleteRecord() {
        System.out.println("Deleting Laboratory Report: " + testName);
        // Add your logic here to delete the laboratory report from the patient's medical records
    }

    @Override
    public void viewRecord() {
        System.out.println("Viewing Laboratory Report: " + testName);
        // Add your logic here to view the details of the laboratory report
    }
}

// RadiologyImage class
class RadiologyImage implements MedicalRecord {
    private String imageType;

    // Constructor
    public RadiologyImage(String imageType) {
        this.imageType = imageType;
    }

    // Getter and setter
    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    // Implementing interface methods
    @Override
    public void addRecord() {
        System.out.println("Adding Radiology Image: " + imageType);
        // Add your logic here to add the radiology image to the patient's medical records
    }

    @Override
    public void deleteRecord() {
        System.out.println("Deleting Radiology Image: " + imageType);
        // Add your logic here to delete the radiology image from the patient's medical records
    }

    @Override
    public void viewRecord() {
        System.out.println("Viewing Radiology Image: " + imageType);
        // Add your logic here to view the details of the radiology image
    }
}

// Hospital class
class Hospital {
    private List<Patient> patients;

    // Constructor
    public Hospital() {
        patients = new ArrayList<>();
    }

    // Method to admit a patient
    public void admitPatient(Patient patient) {
        patients.add(patient);
        System.out.println(patient.getPatientName() + " has been admitted to the hospital.");
    }

    // Method to discharge a patient
    public void dischargePatient(Patient patient) {
        patients.remove(patient);
        System.out.println(patient.getPatientName() + " has been discharged from the hospital.");
    }

    // Method to display the list of patients in the hospital
    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients in the hospital.");
        } else {
            System.out.println("List of patients in the hospital:");
            for (Patient patient : patients) {
                System.out.println("Name: " + patient.getPatientName());
                System.out.println("Age: " + patient.getPatientAge());
                System.out.println("Gender: " + patient.getPatientGender());
                System.out.println("ID: " + patient.getPatientID());
                System.out.println("Address: " + patient.getPatientAddress());
                System.out.println(patient.getUniqueProperty());
                System.out.println("----------------------");
            }
        }
    }

    // Method to display the list of medical records for a given patient
    public void displayMedicalRecords(Patient patient) {
        System.out.println("Medical records for " + patient.getPatientName() + ":");
        // Add your logic here to display the medical records for the given patient
    }

    // Getter for patients list
    public List<Patient> getPatients() {
        return patients;
    }
}

public class MainPatientClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a hospital
        Hospital hospital = new Hospital();

        // Admit inpatients
        System.out.println("Enter details for inpatients:");
        System.out.print("Number of inpatients: ");
        int numInpatients = scanner.nextInt();
        for (int i = 1; i <= numInpatients; i++) {
            System.out.println("Inpatient #" + i);
            System.out.print("Name: ");
            String inpatientName = scanner.next();
            System.out.print("Age: ");
            int inpatientAge = scanner.nextInt();
            System.out.print("Gender: ");
            String inpatientGender = scanner.next();
            System.out.print("ID: ");
            String inpatientID = scanner.next();
            System.out.print("Address: ");
            String inpatientAddress = scanner.next();
            System.out.print("Bed Number: ");
            int bedNumber = scanner.nextInt();

            Inpatient inpatient = new Inpatient(inpatientName, inpatientAge, inpatientGender, inpatientID,
                    inpatientAddress, bedNumber);
            hospital.admitPatient(inpatient);
        }

        // Admit outpatients
        System.out.println("Enter details for outpatients:");
        System.out.print("Number of outpatients: ");
        int numOutpatients = scanner.nextInt();
        for (int i = 1; i <= numOutpatients; i++) {
            System.out.println("Outpatient #" + i);
            System.out.print("Name: ");
            String outpatientName = scanner.next();
            System.out.print("Age: ");
            int outpatientAge = scanner.nextInt();
            System.out.print("Gender: ");
            String outpatientGender = scanner.next();
            System.out.print("ID: ");
            String outpatientID = scanner.next();
            System.out.print("Address: ");
            String outpatientAddress = scanner.next();
            System.out.print("Appointment Date: ");
            String appointmentDate = scanner.next();

            Outpatient outpatient = new Outpatient(outpatientName, outpatientAge, outpatientGender, outpatientID,
                    outpatientAddress, appointmentDate);
            hospital.admitPatient(outpatient);
        }

        // Display the list of patients in the hospital
        hospital.displayPatients();

        // Add medical records
        System.out.println("Adding medical records for patients:");
        for (Patient patient : hospital.getPatients()) {
            System.out.println("Medical records for " + patient.getPatientName() + ":");
            System.out.print("Number of laboratory reports: ");
            int numLabReports = scanner.nextInt();
            for (int i = 1; i <= numLabReports; i++) {
                System.out.print("Laboratory Report #" + i + " Test Name: ");
                String testName = scanner.next();

                LaboratoryReport labReport = new LaboratoryReport(testName);
                labReport.addRecord();
            }

            System.out.print("Number of radiology images: ");
            int numRadiologyImages = scanner.nextInt();
            for (int i = 1; i <= numRadiologyImages; i++) {
                System.out.print("Radiology Image #" + i + " Image Type: ");
                String imageType = scanner.next();

                RadiologyImage radiologyImage = new RadiologyImage(imageType);
                radiologyImage.addRecord();
            }
        }

        // Display medical records for a given patient
        System.out.println("Enter the patient name to view medical records:");
        String patientName = scanner.next();
        for (Patient patient : hospital.getPatients()) {
            if (patient.getPatientName().equalsIgnoreCase(patientName)) {
                hospital.displayMedicalRecords(patient);
                break;
            }
        }

        // Delete medical records
        System.out.println("Deleting medical records for patients:");
        for (Patient patient : hospital.getPatients()) {
            System.out.println("Medical records for " + patient.getPatientName() + ":");
            System.out.print("Number of laboratory reports to delete: ");
            int numLabReports = scanner.nextInt();
            for (int i = 1; i <= numLabReports; i++) {
                System.out.print("Laboratory Report #" + i + " Test Name: ");
                String testName = scanner.next();

                LaboratoryReport labReport = new LaboratoryReport(testName);
                labReport.deleteRecord();
            }

            System.out.print("Number of radiology images to delete: ");
            int numRadiologyImages = scanner.nextInt();
            for (int i = 1; i <= numRadiologyImages; i++) {
                System.out.print("Radiology Image #" + i + " Image Type: ");
                String imageType = scanner.next();

                RadiologyImage radiologyImage = new RadiologyImage(imageType);
                radiologyImage.deleteRecord();
            }
        }

        // Discharge patients
        System.out.println("Discharging patients:");
        System.out.print("Number of patients to discharge: ");
        int numPatientsToDischarge = scanner.nextInt();
        for (int i = 1; i <= numPatientsToDischarge; i++) {
            System.out.print("Enter the name of the patient to discharge: ");
            String patientNameToDischarge = scanner.next();

            for (Patient patient : hospital.getPatients()) {
                if (patient.getPatientName().equalsIgnoreCase(patientNameToDischarge)) {
                    hospital.dischargePatient(patient);
                    break;
                }
            }
        }

        // Display the list of patients in the hospital again
        hospital.displayPatients();

        scanner.close();
    }
}
