import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HospitalWorld {

    public static void main(String[] args) {
        // your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hospital name: ");
        String hospitalName = scanner.nextLine();

        if (hospitalName.isEmpty()) {
            System.out.println("Error: please enter name of hospital");
            return;
        }

        // instantiating hospital object and the list of doctors
        Hospital hospital = new Hospital(hospitalName);
        ArrayList<Doctor> doctors = new ArrayList<>();
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
        for (int i=0; i < numOfDocs; i++) {
            System.out.print("\nEnter the name of doctor: ");
            String docName = scanner.nextLine();
            if (docName.isEmpty()) {
                System.out.println("Error: please enter name of doctor");
                return;
            }

            System.out.println("\nDoctor specialty: ");
            System.out.println("Enter 1 for Dermatology");
            System.out.println("Enter 2 for Pediatrics");
            System.out.println("Enter 3 for Radiology");
            System.out.println("Enter 4 for Oncology");
            System.out.print("Option: ");
            String choice = scanner.nextLine();
            String docSpec = "";

            if (choice.equals("1")) {
                docSpec = "Dermatology";
            } else if (choice.equals("2")) {
                docSpec = "Pediatrics";
            } else if (choice.equals("3")) {
                docSpec = "Radiology";
            } else if (choice.equals("4")) {
                docSpec = "Oncology";
            } else {
                System.out.println("Error: please enter numbers between 1 and 4");
                return;
            }

            Doctor doctor = new Doctor(docName, docSpec);
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
        for (int j=0; j < numOfPatients; j++) {
            System.out.print("Enter the name of the patient: ");
            String patientName = scanner.nextLine();
            if (patientName.isEmpty()) {
                System.out.println("Error: please enter name of patient");
                return;
            }

            System.out.println("\nSpecialty required: ");
            System.out.println("Enter 1 for Dermatology");
            System.out.println("Enter 2 for Pediatrics");
            System.out.println("Enter 3 for Radiology");
            System.out.println("Enter 4 for Oncology");
            System.out.print("Option: ");
            String choice = scanner.nextLine();
            String reqSpec = "";

            if (choice.equals("1")) {
                reqSpec = "Dermatology";
            } else if (choice.equals("2")) {
                reqSpec = "Pediatrics";
            } else if (choice.equals("3")) {
                reqSpec = "Radiology";
            } else if (choice.equals("4")) {
                reqSpec = "Oncology";
            } else {
                System.out.println("Error: please enter numbers between 1 and 4");
                return;
            }

            // matching required specialities to that of doctors' at the hospital
            Patient patient = new Patient(patientName);
            Doctor matchedDoc = null;
            for (Doctor doctor : hospital.getDoctors()) { //enhanced for loop or for each loop
                if (doctor.getSpecialty().equalsIgnoreCase(reqSpec)) {
                    matchedDoc = doctor;
                    doctor.addPatient(patient);
                    System.out.println(patientName + " has been matched with Dr. " + doctor.getName());
                    break;
                }
            }
            if (matchedDoc == null) {
                System.out.println("No doctor at this hospital has this specialty.");
            }
        }

        // printing hospital details
        System.out.println(hospital);
        scanner.close();
    }


}
