import java.awt.*;
import javax.swing.*;

public class CardLayoutDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Layout (Absolute Cinema)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480,260);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Card 1
        JPanel card1 = new JPanel(new FlowLayout());
        card1.add(new JLabel("This is Card 1"));
        card1.add(new JButton("Button A"));

        // Card 2
        JPanel card2 = new JPanel(new FlowLayout());
        card2.add(new JLabel("This is Card 2"));
        card2.add(new JButton("Button B"));

        // Add cards with names
        cardPanel.add(card1, "CARD1");
        cardPanel.add(card2, "CARD2");

        // Control buttons
        JButton btnPrev = new JButton("Previous");
        JButton btnNext = new JButton("Next");

        btnPrev.addActionListener(e -> cardLayout.previous(cardPanel));
        btnNext.addActionListener(e -> cardLayout.next(cardPanel));

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER));
        controls.add(btnPrev);
        controls.add(btnNext);

        frame.setLayout(new BorderLayout());
        frame.add(cardPanel, BorderLayout.CENTER);
        frame.add(controls, BorderLayout.SOUTH);


        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
