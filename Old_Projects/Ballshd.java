package com.mycompany.ballshd;
import java.util.*;
public class Ballshd {
static String newpass;
static String reg;
static String name;
static String pass;
static boolean sysNum = false;
static Scanner sc = new Scanner(System.in);
     static String reg(){
      System.out.print("\n" + "Username: ");
                     reg = sc.nextLine();
                     System.out.print("Password: ");
                     newpass = sc.nextLine();
                System.out.println("\n" + "Successfully Registered");  
    return reg+newpass;
     }
         static String login() {
             System.out.print("\n" + "Enter Username: ");
                name = sc.nextLine();
                System.out.print("Enter Password: ");
                pass = sc.nextLine();
                if(null == reg || null == newpass){
                    System.out.println("Invalid Credentials");
                }else if(reg.equals(name)&&newpass.equals(pass)){
                     System.out.println("\n" + "Logged in as, " + name);
                     System.out.println("What would you like to do?");
                     System.out.println("WIP");
                 sysNum = true;
                }else if(reg.equals(name)||newpass.equals(pass)){
                     System.out.println("Please Check your Username and Password and Try Again");
                 }
    return name+pass+sysNum;
         }
 public static void main(String[] args) {
         do{ 
             System.out.println("\n" + "Type 1 for Login" + "\n" + "2 for Register" + "\n" + "3 to Exit");
         String register = sc.nextLine();
         switch (register){
            case "1" :
              login();
                break;
            case "2":
                reg();
                break;
            case "3":
                System.exit(1);
            default: System.out.println("Invalid Input, Try Again");
            break;
        }
       }while(sysNum == false);
    }
}