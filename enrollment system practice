package dreamlast;

import java.io.*;
import javax.swing.*;

public class Fr extends JFrame {

 //important variables
  static String stdnName, address, course, lastSchool;
  static int age;
  static JTextField txtStdnName, txtAddress, txtCourse, txtAge, txtLastSchool;

 public static void main(String[] args) {
    new Fr();
 }

  //gui for enrollment system
  Fr(){

  //header texts

  JLabel lblStdnName = new JLabel("Student name");
  add(lblStdnName).setBounds (50, 30, 188, 27); //text for name

  JLabel lblAddress = new JLabel("Address");
  add(lblAddress).setBounds  (50, 90, 188, 27); //text for address

  JLabel lblCourse = new JLabel("Course");
  add(lblCourse).setBounds  (50, 150, 188, 27); //text for course

  JLabel lblAge = new JLabel("Age");
  add(lblAge).setBounds    (50, 210, 188, 27); //text for age

  JLabel lblLastSchool = new JLabel("Last School Attended");
  add(lblLastSchool).setBounds (50, 270, 188, 27); //text for last school attended




  //textfields


  txtStdnName = new JTextField("Name");
  add(txtStdnName).setBounds (50, 60, 188, 27); //textfield for name

  txtAddress = new JTextField("Address");
  add(txtAddress).setBounds  (50, 120, 188, 27); //textfield for address

  txtCourse = new JTextField("Course");
  add(txtCourse).setBounds  (50, 180, 188, 27); //textfield for course

  txtAge = new JTextField("Age");
  add(txtAge).setBounds    (50, 240, 188, 27); //textfield for age

  txtLastSchool = new JTextField("Last School");
  add(txtLastSchool).setBounds (50, 300, 188, 27); //textfield for last school attended


  //buttons



  JButton btnEnroll = new JButton("Enroll Student");
  add(btnEnroll).setBounds(70,360,126,34); //button for enrolling



  btnEnroll.addActionListener(e->{

   //stores values into each respective variables

    stdnName =      txtStdnName.getText();
    address =       txtAddress.getText();
    course =        txtCourse.getText();
    age =           Integer.parseInt(txtAge.getText());
    lastSchool =    txtLastSchool.getText();


    //calls the file creator method and emptying method
   try { 

    saveToFile();

    setTextField();

    } catch (Exception xe) {

      JOptionPane.showMessageDialog(null, "Lmao");

    }

  });




  //gui enabler idk



  setLayout(null);
  setTitle("JU Enrollment System");
  setSize(750,600);
  setVisible(true);
  setResizable(true);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(EXIT_ON_CLOSE);

 }





 //writes a file for all enrollees

 private static void saveToFile()throws IOException{

  FileWriter file = new FileWriter("EnrolledStudents.txt",true);
  BufferedWriter bw = new BufferedWriter(file);

  bw.write(stdnName + " | " + address + " | " + course + " | " + age + " | " + lastSchool);
  bw.write("\n");
  bw.close();

  JOptionPane.showMessageDialog(null, "Enrolled!");

 }





 //after enrolling, empties the field

public static void setTextField(){

 txtStdnName.setText("");

 txtAddress.setText("");

 txtAge.setText("");

 txtCourse.setText("");

 txtLastSchool.setText("");



}







}

