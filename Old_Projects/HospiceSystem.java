import java.util.*;

public class Hospice {

    private String flName;
    private String age;
    private String sex;
    private String symptoms;
    private String cntNumber;
    private String date;


public static void main(String[] args) {

        System.out.println("-----------------------------------------------------------------------");
        System.out.println("                   Welcome to LoremIpsumMed");
        System.out.println("\n\nLocated at:\n       Lorem Ipsum, Dolor, Sit Amet, Davao City\n\n");
        menu();
    }

public static void menu(){
    Scanner scnr = new Scanner(System.in);


    System.out.println("\n                        Patient's Menu");
    System.out.println("-----------------------------------------------------------------------\n");
    System.out.println("1. Doctor's public records");
    System.out.println("2. Analytics this Month");
    System.out.println("3. Book an Appointment");
    System.out.println("4. Inquire about us");
    System.out.print("=> ");
    int a = scnr.nextInt();
    
    switch (a) {
        case 1:
            rec();
            break;
        case 2:
            stat();
            break;
        case 3:
            Hospice hospice = new Hospice();
            hospice.run();
            break;
        case 4:
            inq();
            break;
        default:
            System.out.println("Please try again");
            menu();
    }
}


public static void rec(){

    System.out.println("\nList of our doctors in each field: \n");
    System.out.println("Gynaecology (24): \n Doc. Lorem Ipsum Dolor, LPT");
    System.out.println("Surgery (48): \n Doc. Lorem Ipsum Dolor, LPT");
    System.out.println("Orthopedics (13): \n Doc. Lorem Ipsum Dolor, LPT");
    System.out.println("Neurology (20):: \n Doc. Lorem Ipsum Dolor, LPT");
    System.out.println("Cardiology (31): \n Doc. Lorem Ipsum Dolor, LPT\n");
}

public static void stat(){

    System.out.println("Please wait while we load in the stats\n");
    for (int i = 1; i <= 15; i++) {
        System.out.print(".");
    }
    System.out.println("\nTotal Patients: 61,202 (+293.3% prev. year)");
    System.out.println("Patients by gender: 55% Male, 45% Female");
    System.out.println("Patient's satisfaction: Excellent 53%, Poor 22%, Okay 25%");
    System.out.println("Average patients per month: 24.79 per doctor\n");
}

public void book(){
    Scanner scnr = new Scanner(System.in);

    System.out.println("Fill out the form:");

    System.out.print("Fullname: ");
    flName = scnr.nextLine();

    System.out.print("Age: ");
    age = scnr.nextLine();

    System.out.print("Sex (M or F): ");
    sex = scnr.nextLine();

    System.out.print("Symptoms: ");
    symptoms = scnr.nextLine();

    System.out.print("Contact Number: ");
    cntNumber = scnr.nextLine();

    System.out.print("Appointment Date (DD/MM/YY): ");
    date = scnr.nextLine();

    
 }

 private void displayInfo(){
    System.out.println("\nFullname: " + flName);
    System.out.println("Age: " + age);
    System.out.println("Sex (M or F): " + sex);
    System.out.println("Symptoms: " + symptoms);
    System.out.println("Contact Number: " + cntNumber);
    System.out.println("\nWe will have Doc. Lorem Ipsum Dolor, LPT assign your appointment at " + date + "\n");
 }

 public void run(){
    book();
    displayInfo();
 }


public static void inq(){

    Scanner scnr = new Scanner(System.in);

    System.out.print("Enter your email: ");
    String a;
    a = scnr.nextLine();
    
    System.out.print("Enter your query: ");
    String b;
    b = scnr.nextLine();

    System.out.println("Please expect a delay of an hour\n");
    menu();
    }
}

