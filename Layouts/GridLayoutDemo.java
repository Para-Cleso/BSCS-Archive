import java.awt.*;
import javax.swing.*;

public class GridLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Grid Layout (Absolute Cinema)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,250);

            //layout
            frame.setLayout(new GridLayout(2, 3, 10, 10));



            //me prog amer so i loop
            for (int i = 1; i <= 6; i++) {
                frame.add(new JButton("Button " + i));
            }

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
    }
}
