import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class LabPractice extends JFrame {

  public static void main(String[] args) {

    new LabPractice();

  }

  LabPractice(){

    //header texts
    JLabel lblCstType = new JLabel("Customer Type");
    add(lblCstType).setBounds(50, 30, 188, 27); //text for customer type
    JLabel lblCnsmp = new JLabel("Consumption");
    add(lblCnsmp).setBounds(50, 60, 188, 27); //text for consumption
    JLabel lblTtlBill = new JLabel("Total Bill");
    add(lblTtlBill).setBounds(50, 90, 188, 27); //text for total bill



    //textfields
    JTextField txtCstType = new JTextField();
    add(txtCstType).setBounds(200, 30, 188, 27); //textfield for customer type
    JTextField txtCnsmp = new JTextField();
    add(txtCnsmp).setBounds(200, 62, 188, 27); //textfield for consumption
    JTextField txtTtlBill = new JTextField();
    add(txtTtlBill).setBounds(200, 94, 188, 27); //textfield for total bill



    //buttons
    JButton btnCstType = new JButton("Add");
    add(btnCstType).setBounds(50,140,94,24); //button for customer type
    JButton btnCnsmp = new JButton("Update");
    add(btnCnsmp).setBounds(170,140,94,24); //button for consumption
    JButton btnTtlBill = new JButton("Delete");
    add(btnTtlBill).setBounds(290,140,94,24); //button for total bill



    //gui enabler idk
    setLayout(null);
    setTitle("Vehicle Rental System");
    setSize(461,252);
    setVisible(true);
    setResizable(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

}
