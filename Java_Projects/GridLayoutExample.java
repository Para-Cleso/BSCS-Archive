import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {

    JPanel buttonPanel;

    public static void main(String[] args) {
        new GridLayoutExample();
    }

    GridLayoutExample() {
        buttonPanel = new JPanel();

        // GridLayout(rows, cols) — 2 rows, 3 columns
        buttonPanel.setLayout(new GridLayout(2, 3));

        // Add 6 buttons with a loop
        for (int i = 1; i <= 6; i++) {
            buttonPanel.add(new JButton(String.valueOf(i)));
        }

        add(buttonPanel);

        setTitle("GridLayout demo");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
