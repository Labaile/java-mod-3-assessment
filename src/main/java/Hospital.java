//import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hospital {
    private String name;
    private List<Doctor> doctors;

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

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void saveHospitalToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("output.txt");
        String hospital = doctors.toString();
        //new ObjectMapper().writeValueAsString(doctors);

        fileWriter.write(hospital);
        fileWriter.close();
    }

    @Override
    public String toString() {
        String string = "\n\n <HOSPITAL DETAILS>\n Hospital Name: " + name + "\n" +
                " Doctors: \n\n";
        for (Doctor doctor : doctors) {
            string += doctor + "\n\n";
        }
        try {
            saveHospitalToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return string;
    }
}
