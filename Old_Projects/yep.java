package com.example;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class yep {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        
        System.out.print("Enter the first word: ");
        String word1 = scnr.nextLine();

        System.out.print("Enter the second word: ");
        String word2 = scnr.nextLine();

        String sub = "";
        if (word1.length() >= 2){
            sub = word1.substring(Math.max(word1.length() - 2, 0));
        } else {
            System.out.println("Try again (First word must have 2 letters)");
        }

        String display = "^[a-zA-Z]{1,2}" + sub + "$";
        Pattern p = Pattern.compile(display, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(word2);

        if (m.matches()){
            System.out.println(word2 + " rhymes with "  + word1);
        } else {
            System.out.println("I'm not sure! Sorry!");
        }
        scnr.close();
    }
}