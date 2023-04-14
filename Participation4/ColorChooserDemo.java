/**
 * This program will utilize a JPanel and JFrame and the <p>
 * JColorChooser to allow the user to change the background color of the window
 * @author Nick Anderson
 * @since 4/3/23
 */

// Import necessary utilities
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorChooserDemo implements ActionListener {
    // Attributes needed to design to the window
    JFrame frame;
    JPanel panel;
    JButton button;
    JLabel label;

    // Public method to set the window settings
    public ColorChooserDemo() {

        // Set frame/window Title Bar and closing behavior
        frame = new JFrame("Background Color Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // SUGGESTION 1: Maria Caballero - I set the size of the window to 1/3 of the screen size
            //Playing with the dimensions I got the frame to be set to the middle of the screen for better user experience
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(width/3, height/3);
        //Maria Caballero - here's the part where I center the jframe on screen
        frame.setLocationRelativeTo(null);

        // Design the panel that will hold the buttons and their layout
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        //SUGGESTION 2: Maria Caballero - Changing the top, left, bottom and right margins to 30
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // Design the buttons and their text
        button = new JButton("Choose a color");
        button.addActionListener(this);

        //Maria Caballero - This is not a suggestion, I just wanted to play with the border of the button to make it more colorful
        //so that it matches the theme of the program
        button.setBorder(BorderFactory.createBevelBorder(1, Color.green, Color.orange, Color.red, Color.blue));
        panel.add(button);

        //SUGGESTION 3: Maria Caballero - Adding an Exit button for better user experience
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);

        // Design the panel - Maria Caballero
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Design the label
        label = new JLabel("Selected Color Choice", JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.lightGray);
        //SUGGESTION 2: Maria Caballero - Changing the size of the label to 300x100
        label.setPreferredSize(new Dimension(300, 100));
        panel.add(label);

        // Assemble frame
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    // Create method for action event
    public void actionPerformed(ActionEvent e) {
        Color color = JColorChooser.showDialog(frame, "Choose a Color",
                Color.WHITE);
        if (color != null) {
            label.setBackground(color);
        }
    }

    // Main driver
    public static void main(String[] args) {
        // Instantiate the window
        new ColorChooserDemo();
    }
}
