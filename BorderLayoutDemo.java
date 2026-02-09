import java.awt.*;
import javax.swing.*;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid Layout (Absolute Cinema)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520,250);

            //layout
            frame.setLayout(new BorderLayout(10, 10));

            //i am pro gamer
            frame.add(new JButton("North"), BorderLayout.NORTH);
            frame.add(new JButton("South"), BorderLayout.SOUTH);
            frame.add(new JButton("East"), BorderLayout.EAST);
            frame.add(new JButton("West"), BorderLayout.WEST);
            
            //sintir
            JTextArea centerArea = new JTextArea("61");
            frame.add(new JScrollPane(centerArea), BorderLayout.CENTER);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

    }
    
}
