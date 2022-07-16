// TODO: add toString() methods
// TODO: fix gradle dependencies for ObjectMapper JSON
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HospitalWorld {

    public static void main(String[] args) {
        // your code here
        List<Patient> patients = new ArrayList<>();
        List<Ailment> ailments = new ArrayList<>();
        List<Specialty> specialties = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String hospitalName = "";

        do {
            System.out.print("Enter hospital name: ");
            hospitalName = scanner.nextLine();
            if (hospitalName.isBlank()) {
                System.out.println("Error: please enter name of hospital");
            }
        } while (hospitalName.isBlank());

        // instantiating hospital object and the list of doctors
        Hospital hospital = new Hospital(hospitalName);
        List<Doctor> doctors = new ArrayList<>();
        int numOfDocs = -1;

        // allowing user to define number of doctors

        while (numOfDocs < 0) {
            System.out.print("Please enter number of doctors (in integers): ");
            try {
                numOfDocs = scanner.nextInt();
                if (numOfDocs < 0) {
                    System.out.println("Please enter a positive number.");
                }
            } catch (InputMismatchException e) {
                numOfDocs = -1;
                System.out.println("\nERROR: Integer not entered.\nPlease enter an integer.\n");
            }
            scanner.nextLine();
        }


        // instantiating doctor objects based on user input, and adding to hospital list of docs
        for (int i = 0; i < numOfDocs; i++) {
            String docName = "";
            do {
                System.out.print("\nEnter the name of doctor: ");
                docName = scanner.nextLine();
                if (docName.isBlank()) {
                    System.out.println("Error: please enter name of doctor");
                }
            } while (docName.isBlank());

            System.out.println("\nDoctor specialty: ");
            System.out.println("Enter 1 for Dermatology");
            System.out.println("Enter 2 for Cardiology");
            System.out.println("Enter 3 for Radiology");
            System.out.println("Enter 4 for General");
            System.out.print("Option: ");
            String choice = scanner.nextLine();
            String docSpec = "";
            int numOfTreatments;
            boolean hasFullCure;

            if (choice.equals("1")) {
                docSpec = "Dermatology";
                numOfTreatments = 5;
                hasFullCure = false;
            } else if (choice.equals("2")) {
                docSpec = "Cardiology";
                numOfTreatments = 8;
                hasFullCure = true;
            } else if (choice.equals("3")) {
                docSpec = "Radiology";
                numOfTreatments = 10;
                hasFullCure = false;
            } else if (choice.equals("4")) {
                docSpec = "General";
                numOfTreatments = 2;
                hasFullCure = true;
            } else {
                System.out.println("Error: please enter numbers between 1 and 4");
                return;
            }

            Specialty specialty = new Specialty(docSpec, numOfTreatments, hasFullCure);
            specialties.add(specialty);
            Doctor doctor = new Doctor(docName, specialty);
            doctors.add(doctor);
        }
        hospital.setDoctors(doctors);


        int numOfPatients = -1;

        while (numOfPatients < 0) {
            // allowing user to define number of patients
            System.out.print("Please enter number of patients (in integers): ");
            try {
                numOfPatients = scanner.nextInt();
                if (numOfPatients < 0) {
                    System.out.println("Please enter a positive number.");
                }
            } catch (InputMismatchException e) {

                numOfPatients = -1;
                System.out.println("\nERROR: Integer not entered.\nPlease enter an integer.\n");
            }
            scanner.nextLine();
        }


        // instantiating patient objects and asking about required specialities
        for (int j = 0; j < numOfPatients; j++) {
            String patientName = "";
            do {
                System.out.print("Enter the name of the patient: ");
                patientName = scanner.nextLine();
                if (patientName.isBlank()) {
                    System.out.println("Error: please enter name of patient");
                }
            } while (patientName.isBlank());


            if (patientName.isEmpty()) {
                System.out.println("Error: please enter name of patient");
                return;
            }

            System.out.println("\nPatient's ailment: ");
            System.out.println("Enter 1 for Skin Problems");
            System.out.println("Enter 2 for Heart Problems");
            System.out.println("Enter 3 for Fractured Bones");
            System.out.println("Enter 4 for General Problems");
            System.out.print("Option: ");

            String choice = scanner.nextLine();
            String reqSpecialityName = "";
            String ailmentName = "";
            int startingHealthIndex = 0;

            if (choice.equals("1")) {
                reqSpecialityName = "Dermatology";
                ailmentName = "Skin Problems";
                startingHealthIndex = 96;
            } else if (choice.equals("2")) {
                reqSpecialityName = "Cardiology";
                ailmentName = "Heart Problems";
                startingHealthIndex = 50;
            } else if (choice.equals("3")) {
                reqSpecialityName = "Radiology";
                ailmentName = "Fractured Bones";
                startingHealthIndex = 70;
            } else if (choice.equals("4")) {
                reqSpecialityName = "General";
                ailmentName = "General Problems";
                startingHealthIndex = 85;
            } else {
                System.out.println("Error: please enter numbers between 1 and 4");
                return;
            }

            Specialty reqSpeciality = null;
            for (Specialty specialty : specialties) {
                if (specialty.getName().equalsIgnoreCase(reqSpecialityName)) {
                    reqSpeciality = specialty;
                }
            }

            if (reqSpeciality != null) {
                Ailment ailment = new Ailment(ailmentName, reqSpeciality, startingHealthIndex);
                // matching required specialities to that of doctors' at the hospital
                Patient patient = new Patient(patientName, ailment);
                ailments.add(ailment);
                //Doctor matchedDoc = null;
                for (Doctor doctor : hospital.getDoctors()) { //enhanced for loop or for each loop
                    if (doctor.getSpecialty().getName().equalsIgnoreCase(reqSpeciality.getName())) {
                        //matchedDoc = doctor;
                        doctor.addPatient(patient);
                        patients.add(patient);
                        System.out.println(patientName + " has been matched with Dr. " + doctor.getName());
                        break;
                    }
                }
            } else {
                System.out.println("No doctor at this hospital has this specialty.");
            }
        }

        String choice = "";
        System.out.print("Would you like to treat a patient? (Y/N): ");
        choice = scanner.nextLine();

        while (!choice.equals("N")) { // look out for issues
            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Choose patient below: ");
                int i = 1;
                for (Patient patient : patients) {
                    System.out.println("Enter " + i + " for " + patient);
                    i++;
                }
                System.out.print("Choice: ");
                int patientNo = scanner.nextInt();
                if (patientNo >= 1 && patientNo <= patients.size()) {
                    Patient patient = patients.get(patientNo-1);
                    int reqNumOfTreatments = patient.getMyDisease().getAssociatedSpecialty().getNumOfTreatments();
                    if (!patient.isDead() && !patient.isHealed() && reqNumOfTreatments > 0) {
                        System.out.println("Number of treatments: " + reqNumOfTreatments);
                        int gainFromTreatment = (100 - patient.getHealthIndex()) / reqNumOfTreatments;
                        System.out.println(patient.getName() + "'s health index: " + patient.getHealthIndex());
                        patient.receiveTreatment(gainFromTreatment);
                        System.out.println(patient.getName() + "'s new health index: " + patient.getHealthIndex());
                    } else {
                        System.out.println("Patient does not need to be treated");
                    }
                }
            } else {
                break;
            }
            scanner.nextLine();
            System.out.print("Would you like to treat a patient? (Y/N): ");
            choice = scanner.nextLine();
        }

        // printing hospital details
        System.out.println(hospital);
        scanner.close();
    }


}
