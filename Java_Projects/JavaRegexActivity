package JavaRegexActivity;
import java.util.*;
import java.util.regex.*;

public class JavaRegexActivity {
	static Scanner sc = new Scanner(System.in);
	
	/* 
	 * Main method contains the switch case to display the menu on console.
	 * Each case contains a method referring to the activity chosen on the scanner input.
	 * Each method has its own program of handling each cases for each activity.
	 * Case handled for exiting and invalid input as well.
	 */
	
	public static void main(String[] args) {
		
		while (true) {
		    System.out.printf("""
		            ========================================
		                   JAVA REGEX ACTIVITY
		            ========================================
		            1. Validate Student Information
		            2. Check Password Strength
		            3. Analyze Text
		            4. Exit
		            ========================================
		            Enter your choice: """);

		    int choice = sc.nextInt();
		    sc.nextLine();
		    
		    switch (choice) {
		        case 1 -> studentInfo();
		        case 2 -> passwordStrength();
		        case 3 -> analyzeText();
		        case 4 -> {
		            System.out.println("Exiting program...");
		            sc.close();
		            return;
		        }
		        default -> System.out.println("Invalid choice!");
		}
	}
}
	
	
	/*
	 * studentInfo() takes the relevant information asked and puts it on a matcher.
	 * Each relevant info is compiled with its own requirement for Regex.
	 * i.e. namePattern is for fullName where the fullName variable has to follow the pattern "[a-zA-Z]+".
	 * "[a-zA-Z]+" translates into only letters and spaces.
	 * After each string has been matched, it outputs a boolean on whether or not they are a valid information.
	 */
	
		static void studentInfo() {

		    System.out.print("Enter Full Name: ");
		    String fullName = sc.nextLine();

		    System.out.print("Enter Email Address: ");
		    String email = sc.nextLine();

		    System.out.print("Enter Phone Number: ");
		    String phone = sc.nextLine();

		    System.out.print("Enter Student ID: ");
		    String studentID = sc.nextLine();
		    
		    Pattern namePattern = Pattern.compile("[a-zA-Z ]+");
		    Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@gmail\\.com");
		    Pattern phonePattern = Pattern.compile("09\\d{9}");
		    Pattern idPattern = Pattern.compile("2026-\\d{5}");

		    System.out.println("Full Name valid: " +
		        namePattern.matcher(fullName).matches());

		    System.out.println("Email valid: " +
		        emailPattern.matcher(email).matches());

		    System.out.println("Phone valid: " +
		        phonePattern.matcher(phone).matches());

		    System.out.println("Student ID valid: " +
		        idPattern.matcher(studentID).matches());
	}
		
		/*
		 *  passwordStrength() takes your given password and gives a score rating depending on its criteria.
		 *  The criteria given are length, uppercase, lowercase, number, and special characters.
		 *  Each criteria is made into a boolean to output a boolean for a score increase.
		 *  Each true output increments the score variable by 1.
		 *  Depending on what score the user got, it displays the strength of the password.
		 */
		
		static void passwordStrength() {
		    System.out.print("Enter Password: ");
		    String password = sc.nextLine();

		    boolean length = Pattern.matches(".{8,}", password);
		    boolean upper = Pattern.matches(".*[A-Z].*", password);
		    boolean lower = Pattern.matches(".*[a-z].*", password);
		    boolean number = Pattern.matches(".*\\d.*", password);
		    boolean special = Pattern.matches(".*[^a-zA-Z0-9].*", password);

		    int score = 0;
		    if (length) score++;
		    if (upper) score++;
		    if (lower) score++;
		    if (number) score++;
		    if (special) score++;

		    System.out.println("\n========== PASSWORD RESULT ==========\n");

		    System.out.printf("Minimum 8 characters : %s%n", length ? "PASSED" : "FAILED");
		    System.out.printf("Uppercase letter     : %s%n", upper ? "PASSED" : "FAILED");
		    System.out.printf("Lowercase letter     : %s%n", lower ? "PASSED" : "FAILED");
		    System.out.printf("Number               : %s%n", number ? "PASSED" : "FAILED");
		    System.out.printf("Special character    : %s%n", special ? "PASSED" : "FAILED");

		    if (score == 5) {
		        System.out.println("\nPassword Strength: STRONG");
		    } else if (score >= 3) {
		        System.out.println("\nPassword Strength: MEDIUM");
		    } else {
		        System.out.println("\nPassword Strength: WEAK");
		    }
		}
		
		
		/*
		 * analyzeText() takes a text and breaks it apart to get the relevant information.
		 * The method of breaking apart the text to get the relevant information is using Pattern and Matcher.
		 * It uses a while loop to scan through the characters until it finds a match.
		 * When it finds a match, it prints the output of the matched characters.
		 * i.e.  matcher = emailPattern.matcher(text);
		    while (matcher.find()) {
		        System.out.println(matcher.group());
		    }
		 * ...finds email addresses using "[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}" and when it does, it outputs that email.
		 */
		
		
		static void analyzeText() {
		    String text = """
		            Welcome to Java Programming!
		            Contact us at java@gmail.com or support@school.edu.
		            For assistance, call 09171234567.
		            Our website is https://www.example.com.
		            The system contains 25 students and 5 instructors.
		            """;

		    Pattern emailPattern = Pattern.compile("[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}");
		    Pattern phonePattern = Pattern.compile("09\\d{9}");
		    Pattern numberPattern = Pattern.compile("\\d+");
		    Pattern urlPattern = Pattern.compile("https?://[\\w.-]+(?:\\.[a-zA-Z]{2,})+");

		    Matcher matcher;

		    System.out.println("\n========== TEXT ANALYSIS RESULT ==========");

		    System.out.println("\nEmail Addresses:");
		    matcher = emailPattern.matcher(text);
		    while (matcher.find()) {
		        System.out.println(matcher.group());
		    }

		    System.out.println("\nPhone Numbers:");
		    matcher = phonePattern.matcher(text);
		    while (matcher.find()) {
		        System.out.println(matcher.group());
		    }

		    System.out.println("\nNumbers:");
		    matcher = numberPattern.matcher(text);
		    while (matcher.find()) {
		        System.out.println(matcher.group());
		    }

		    System.out.println("\nWebsite URLs:");
		    matcher = urlPattern.matcher(text);
		    while (matcher.find()) {
		        System.out.println(matcher.group());
		    }
		}
		
		//˙◠˙
}
