import java.awt.*;
import javax.swing.*;

public class FlowLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Flow Layout (Absolute Cinema)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,250);

            //layout
            frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10 , 10));


            //amazing buttons that do nothing
            frame.add(new JButton("One"));
            frame.add(new JButton("Two"));
            frame.add(new JButton("Three"));
            frame.add(new JButton("Four"));
            frame.add(new JButton("Five"));

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
    }
}
