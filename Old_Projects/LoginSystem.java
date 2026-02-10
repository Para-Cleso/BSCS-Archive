package com.mycompany.balls;
import java.util.*;
public class Balls {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String register;
         String sysUser,sysPass;
        sysUser = "User";
        sysPass = "123123";
        
        System.out.println("""
                           Type 1 for Login
                           2 for Register""");
        register = sc.nextLine();
        
        
        
        
        switch (register){
            case "1" -> {
                System.out.println("Enter username: ");
                String name;
                name = sc.nextLine();
                System.out.println("Enter password: ");
                String pass;
                pass = sc.nextLine();
                if(sysUser.equals(name)){
                    if(sysPass.equals(pass)){
                        System.out.println("Logged in as, User");
                        
                    }else{
                        System.out.println("Please check your password");
                    }
                    
                    
                }else{
                    System.out.println("Please check the username");
                }
            }
            case "2" -> {
                 System.out.println("Username: ");
                     String reg;
                reg = sc.nextLine();
                     System.out.println("Password: ");
                     String newpass;
                     newpass = sc.nextLine();
                System.out.println("Successfully registered");
            }
            default -> System.out.println("Sorry, try again");
        }

    }
}
