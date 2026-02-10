import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Fr extends JFrame {

 //important variables

 static String $emplyName;

 static double $hrRate, $hrWorked;

 static DefaultTableModel model;

 static JTable table;

 static JScrollPane scrollPane;

 static JTextField txtEmplyName, txtHrRate, txtHrWorked;

 public static void main(String[] args) {

  new Fr();

  }

  //gui for payroll management system

Fr(){


 //header texts


 JLabel lblEmplyName = new JLabel("Employee Name");
 add(lblEmplyName).setBounds (40, 50, 188, 27);   //text for employee name


 JLabel lblHrRate = new JLabel("Hourly Rate");
 add(lblHrRate).setBounds  (40, 110, 188, 27);   //text for hourly rate



 JLabel lblHrWorked = new JLabel("Hours Worked");
 add(lblHrWorked).setBounds  (40, 170, 188, 27);  //text for hours worked


 //textfields


 txtEmplyName = new JTextField("Employee Name");
 add(txtEmplyName).setBounds (40, 80, 170, 27);   //textfield for employee name


 txtHrRate = new JTextField("Hourly Rate");
 add(txtHrRate).setBounds  (40, 140, 170, 27);   //textfield for hourly rate


 txtHrWorked = new JTextField("Hours Worked");
 add(txtHrWorked).setBounds  (40, 200, 170, 27);   //textfield for hours worked



 //buttons



 JButton btnCalcSlry = new JButton("Calculate Salary");
 add(btnCalcSlry).setBounds(40,250,170,34); //button for calculating salary


 JButton btnAdd = new JButton("Add to Table");
 add(btnAdd).setBounds(40,300,170,34);  //button to add to table


 JButton btnClear = new JButton("Clear");
 add(btnClear).setBounds(40,350,170,34); //button to delete



 btnClear.addActionListener(e->{

  setTextField();

 });



  //gui for showing employees


  String[] columns = {"Employee Name", "Hourly Rate", "Hours Worked", "Gross Pay","Tax Deduction","Net Pay"};

  model =    new DefaultTableModel(columns, 0);

  table =    new JTable(model);

  scrollPane =  new JScrollPane(table);

  add(scrollPane).setBounds(230, 30, 600, 400);

  //button calculate function, calculates salary


  btnCalcSlry.addActionListener(e->{

    try {

      refreshTableWithSalaries();

      JOptionPane.showMessageDialog(null, "Calculated for all employees");

    } catch (Exception ie) {

    JOptionPane.showMessageDialog(null, "Error: " + ie.getMessage() + "\nMake sure Employees.txt exists and has valid data.");

    }

  });


  //button add function, adds details to the table


  btnAdd.addActionListener(e->{


  //stores values into each respective variables

  try{

  $emplyName =   txtEmplyName.getText();

  $hrRate =      Double.parseDouble(txtHrRate.getText());

  $hrWorked =    Double.parseDouble(txtHrWorked.getText());

  //calls the file creator method and emptying method

  saveToFile();

  setTextField();

  } catch (NumberFormatException | IOException xe) {

   JOptionPane.showMessageDialog(null, "Please input numbers on the hourly rate and hours worked. Try again");

  }

  refreshTable();

  });


 //gui enabler idk


 setLayout(null);

 setTitle("JU Enrollment System");

 setSize(850,500);

 setVisible(true);

 setResizable(true);

 setLocationRelativeTo(null);

 setDefaultCloseOperation(EXIT_ON_CLOSE);

  }


 //writes a file for all employees


 private static void saveToFile()throws IOException{

    FileWriter file = new FileWriter("Employees.txt",true);

    BufferedWriter bw = new BufferedWriter(file);


    bw.write($emplyName + "#" + $hrRate + "#" + $hrWorked);

    bw.write("\n");

    bw.close();

    JOptionPane.showMessageDialog(null, "Added to the table");

  }


 //after submitting, empties the field


private static void setTextField(){

 txtEmplyName.setText("");

 txtHrRate.setText("");

 txtHrWorked.setText("");


  }


//reads employees, calculates salary for each, and displays full table with gp/tax/net



private static void refreshTableWithSalaries() throws IOException {

  model.setRowCount(0);

  try (BufferedReader br = new BufferedReader(new FileReader("Employees.txt"))) {

    String line;

    while ((line = br.readLine()) != null) {

      String[] parts = line.split("#");

      if (parts.length >= 3) {

        String name = parts[0];

        double hrRate = Double.parseDouble(parts[1].trim());

        double hrWorked = Double.parseDouble(parts[2].trim());

        double gp, tax, net;

        if (hrWorked <= 40) {

          gp = hrRate * hrWorked;

        } else {

          double rp = 40 * hrRate;

          double op = (hrWorked - 40) * (hrRate * 1.5);

          gp = rp + op;

        }

        tax = gp * 0.12;

        net = gp - tax;

        String[] row = { name, String.valueOf(hrRate), String.valueOf(hrWorked),

            String.format("%.2f", gp), String.format("%.2f", tax), String.format("%.2f", net) };

        model.addRow(row);

      }

    }

  }

}



//displays the information of the enrollees



private static void refreshTable(){

  model.setRowCount(0);

  try(

    BufferedReader br = new BufferedReader(new FileReader("Employees.txt"))

    ){

      String line;

      while((line = br.readLine()) != null) {

        String[] row = line.split("#");

        model.addRow(row);

      }

    }

  catch(Exception r){

    JOptionPane.showMessageDialog(null, "Lmao " + r);

    }

  }

}