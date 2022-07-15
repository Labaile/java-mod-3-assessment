import java.util.ArrayList;
import java.util.Arrays;

public class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    @Override
    public String toString() {
        String string = "\n\n <HOSPITAL DETAILS>\n Hospital Name: " + name + "\n" +
                " Doctors: \n\n";
        for (Doctor doctor : doctors) {
            string += doctor + "\n\n";
        }
        return string;
    }
}
