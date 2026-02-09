import java.awt.*;
import javax.swing.*;

public class GUI_StudentEnrollment_Grid extends JFrame{
    public static void main(String[] args) {
        new GUI_StudentEnrollment_Grid();
    }

    GUI_StudentEnrollment_Grid(){
        JPanel pnlInformation = new JPanel();
        pnlInformation.setBackground(Color.GREEN);
        pnlInformation.setLayout(new GridLayout(3,2,10,10));
        add(pnlInformation).setBounds(10,10,300,100);

        JLabel lblName = new JLabel("Name: ");
        JTextArea txt = new JTextArea();

        JLabel lblAge = new JLabel("Age: ");
        JTextArea age = new JTextArea();

        JLabel lblAdd = new JLabel("Address ");
        JTextArea add = new JTextArea();

        pnlInformation.add(lblName);
        pnlInformation.add(txt);
        pnlInformation.add(lblAge);
        pnlInformation.add(age);
        pnlInformation.add(lblAdd);
        pnlInformation.add(add);

        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(pnlButtons).setBounds(10,150,300,30);
        pnlButtons.setBackground(Color.BLUE);

        JButton btnAdd = new JButton("Add");
        JButton btnDel = new JButton("Delete");
        JButton btnUpd = new JButton("Update");

        pnlButtons.add(btnAdd);
        pnlButtons.add(btnDel);
        pnlButtons.add(btnUpd);

        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,500);
        setVisible(true);
    }
}

