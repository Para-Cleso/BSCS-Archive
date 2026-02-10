import java.util.*;
public class mycode {
     
    /*
     * below are variables:
     * $syskey for loop stopper
     * $scnr for user input
     * $cmplName for arraylist
     * $adminchoice for menu loop
     */
    static boolean $sysKey = false;
    static Scanner $scnr = new Scanner(System.in);

    static ArrayList<String> $cmplName = new ArrayList<>();

    static String  $adminChoice;
public static void main(String[] args) {
        
        System.out.println("=================================================================="); //omg design amazing wooo
        System.out.println("                      ADMIN ACCESS");
        System.out.println("==================================================================");
        //looping menu
        do{

        System.out.println("\nATTENDANCE CHECKER");
        System.out.println("1. Enter Name");
        System.out.println("2. Name Finder");
        System.out.println("3. Complete Name List");
        System.out.println("4. Exit");
        System.out.print("\n Enter your choice: ");
        $adminChoice = $scnr.nextLine();

        switch ($adminChoice){        
            case "1":
            nameInsert();
            break;

            case "2":
            findName();
            break;

            case "3":
            nameList();
            break;

            case "4":
            System.exit(0);

            default:
            System.out.println("\nPlease Try Again");
            break;
            }
        }
        while ($sysKey == false); //loop stopper
    }

        /* inserts name in the arraylist
         * $cmplName.add($scnr.nextLine()); adds user input into array
         * system returns value
         */
private static ArrayList<String> nameInsert(){
        System.out.print("\nEnter Complete Name: ");
        $cmplName.add($scnr.nextLine());
        
        return $cmplName;
    }
    
    /* checks names on the arraylist
     * if statement $cmplName.contains(name) checks if name exists on the array
     * executes the true or false print condition
     */
    
private static void findName(){
        
   System.out.println($cmplName);
    System.out.print("\nEnter name: ");
    String name = $scnr.nextLine();
        for (String cmplName1 : $cmplName) {
            if ($cmplName.contains(name)){
                System.out.print("Attended\n");
                break;}
            else{   
                System.out.println("Not Found\n");
                break;}
            }
    }

        /*prints the entire arraylist
         * returns value of $syskey
         * must be done last
         */
private static boolean nameList(){
    System.out.println("\nLIST OF NAMES ATTENDED TODAY:");
        for (int i = 0; i < $cmplName.size(); i++) {
            String output = $cmplName.get(i);
            System.out.println(i + 1 + "." + output);}
        return $sysKey = true;
    }
}

