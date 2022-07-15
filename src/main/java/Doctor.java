import java.util.ArrayList;
import java.util.Arrays;

public class Doctor {

    private String name;
    private String specialty;
    private ArrayList<Patient> patients;


    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    @Override
    public String toString() {
        String str =  "     Doctor Name: " + name + "\n" +
                "     Specialty: " + specialty + "\n" +
                "     Patients: \n";
        for (Patient patient : patients) {
            str += "          " + patient + "\n";
        }

        return str;
    }
}
