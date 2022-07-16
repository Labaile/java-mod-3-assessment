import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Doctor {
    private List<Patient> patients;
    private String name;
    private Specialty specialty;

    public Doctor(String name, Specialty specialty) {
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

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    @Override
    public String toString() {
        String str =  "     Doctor Name: " + name + "\n" +
                "     Specialty: " + specialty.getName() + "\n" +
                "     Patients: \n";
        for (Patient patient : patients) {
            str += "          " + patient + "\n";
        }

        return str;
    }
}
