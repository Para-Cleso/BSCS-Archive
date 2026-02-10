package com.mycompany.temp;
import java.util.Scanner;


public class Temp {
    static Scanner scanner = new Scanner(System.in);
    static String username1;
    static String password1;
//One Dimesional Array
    static String[] studentInfo = new String[14]; // Modified the array size for additional information

    public static void main(String[] args) {
        displayLogin();
        displayMenu();
    }

    static void displayLogin() {
        System.out.println("---------------");
        System.out.println("Login");
        System.out.println("---------------");
        System.out.print("Enter username: ");
        username1 = scanner.next();
        System.out.print("Enter password: ");
        password1 = scanner.next();

        if (!confirmUsernamePassword()) {
            System.out.println("Username and password do not match. Login failed.");
             System.exit(0);// Exit login process
        }

        System.out.println("Login successful!");
        //Proceed with authenticated tasks
        
        if (authenticate(username1, password1)) {
            System.out.println("Authentication successful!");
            // Proceed with authenticated tasks
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
            // Handle authentication failure
        }
    }

    static boolean authenticate(String username, String password) {
        // Your authentication logic here
        return true; // Dummy authentication always returns true
    }
     

    static boolean confirmUsernamePassword() {
        // Prompt for confirmation
        System.out.print("Confirm username: ");
        String confirmUsername = scanner.next();
        System.out.print("Confirm password: ");
        String confirmPassword = scanner.next();

        // Check if confirmed username and password match input
        return confirmUsername.equals(username1) && confirmPassword.equals(password1);
    }
// You can add authentication logic here
    

    static void displayMenu() {
        boolean continueEnrollment = true;

        while (continueEnrollment) {
            System.out.println("\n---------------");
            System.out.println("Menu for Enrollment");
            System.out.println("---------------");
            System.out.println("1. Student's Information");
            System.out.println("2. Retrieve Record");
            System.out.println("3. Update Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Course Selection");
            System.out.println("6. Show Summary of Enrolled Students");
            System.out.println("7. Close");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
case 1:
                    addRecord();
                    break;
                case 2:
                    retrieveRecord();
                    break;
                case 3:
                    updateRecord();
                    break;
                case 4:
                    deleteRecord();
                    break;
                case 5:
                    selectCourse();
                    break;
                case 6:
                    showEnrolledRecords();
                    break;
                case 7:
                      closeProgram();
                continueEnrollment = false;
                default:
                    
            }
        }
    }

    static void addRecord() {
        System.out.println("Adding a record...");
        System.out.println("USEP.EDU.PH");
        System.out.println("");
        System.out.println("STUDENT'S PERSONAL INFORMATION SHEET");
        System.out.println("(PLS. ACCOMPLISH THIS FORM TO BE SUBMITTED AT THE REGISTRAR OFFICE)");
        System.out.println("");

        String[] questions = {
                "STUDENT'S LAST NAME:",
                "FIRST NAME:",
                "MIDDLE NAME (N/A if no middle name):",
                "FATHER'S NAME:",
                "FATHER'S EDUCATIONAL ATTAINMENT:",
                "FATHER'S OCCUPATION:",
                "FATHER'S OFFICE & ADDRESS:",
                "MOTHER'S NAME:",
                "MOTHER'S EDUCATIONAL ATTAINMENT:",
                "MOTHER'S OCCUPATION:",
                "MOTHER'S OFFICE & ADDRESS:",
                "NAME EXTENSION (e.g. Jr.,II):"
        };

        scanner.nextLine(); // Consume the newline character after the previous input
        for (int i = 0; i < questions.length; i++) {
            System.out.print(questions[i]);
            studentInfo[i] = scanner.nextLine();
        }
    }

    static void retrieveRecord() {
        System.out.println("Retrieving a record...");
        System.out.println("Student Information:");
        for (int i = 0; i < studentInfo.length; i++) {
            System.out.println(" Retrived Info " + (i + 1) + ": " + studentInfo[i]);
        }
        displayMenu(); // Return to the main menu
    }

    static void updateRecord() {
        System.out.println("Updating a record...");
        System.out.print("Enter the field you want to update (R1): ");
        String fieldToUpdate = scanner.next();

        switch (fieldToUpdate.toUpperCase()) {
            case "R1" -> {
                System.out.print("Enter new last name: ");
                studentInfo[0] = scanner.next();
                System.out.print("Enter new first name: ");
                studentInfo[1] = scanner.next();
                System.out.print("Enter new middle name: ");
                studentInfo[2] = scanner.next();
            }
            default -> System.out.println("Invalid field.");
        }
        // Add cases for other fields as needed

        System.out.println("Record updated successfully.");
        displayMenu(); // Return to the main menu
    }

    static void deleteRecord() {
        System.out.println("Performing a Deleting...");
        for (int i = 0; i < studentInfo.length; i++) {
            System.out.println(" Retrived Info " + (i + 1) + ": " + studentInfo[i-14]);
        }
        System.out.print("Successfully Deleted");

        displayMenu();
    }

    static int enrolledStudents = 0;
    
    static void selectCourse() {
        System.out.println("Selecting a course...");
        System.out.print("Enter student name:");
        studentInfo[11] = scanner.next();
        System.out.print("Enter course selected: ");
        studentInfo[12] = scanner.next();
        System.out.print("Enter year of study (e.g. 1st year, 2nd year): ");
        scanner.nextLine(); // Consume the newline character after the previous input
        studentInfo[13] = scanner.nextLine();
        
        double paymentAmount = calculatePayment();
    
    enrolledStudents++;
    System.out.println("Tuition Fee Amount: " + paymentAmount);
    System.out.print("Enter amount: ");
    double amountPaid = scanner.nextDouble();
    
    // Check if payment is sufficient
    if (amountPaid <= paymentAmount) {
        double remainingBalance = paymentAmount - amountPaid;
        System.out.println("Payment of " + amountPaid + " received. Course enrollment confirmed.");
        System.out.println("Remaining balance: " + remainingBalance);
    } else if (amountPaid >= paymentAmount) {
        double remainingBalance2 = amountPaid - paymentAmount;
        System.out.println("Payment of " + amountPaid + " received. Returned extra credits: " + remainingBalance2 );
    }
    
    displayMenu(); // Return to the main menu
}

static double calculatePayment() {
    
    double paymentAmount = 20000.0; // Sample payment amount
    return paymentAmount;
}
    

    
        static void showEnrolledRecords() {
    System.out.println("Summary of Enrolled Students:");
// Ensure that the array has enough elements to avoid ArrayIndexOutOfBoundsException
if (studentInfo.length >= 14) { // Ensure there's at least one complete record
    // Print information for the first enrolled student
    System.out.println("Student Name: " + studentInfo[11]);
    System.out.println("Course Selected: " + studentInfo[12]);
    System.out.println("Year of Study: " + studentInfo[13]);
    System.out.println("Enrolled Students: " + enrolledStudents);
}
        }
        
    

    static void closeProgram() {
        System.out.println("Thank you for your cooperation!");
        System.out.print("(Click 🔄 to execute form");
        System.out.print("(AUTOMATICALLY DISPLAYS CONDITION)");
    }
}