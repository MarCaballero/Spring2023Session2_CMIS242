import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GUI {
    public static void main(String[] args) {
        createWindow();
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Files Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.pink);
    }

    private static void createUI(JFrame frame) {
        JPanel panelButton = new JPanel();
        LayoutManager buttonLayout = new FlowLayout();
        panelButton.setLayout(buttonLayout);

        JPanel panelLabel = new JPanel();
        panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.X_AXIS));

        JButton button1 = new JButton("Select a file");
        button1.setBackground(Color.lightGray);
        button1.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel label1 = new JLabel();

        JButton button4 = new JButton("Exit");
        button4.setBackground(Color.lightGray);
        button4.setFont(new Font("Arial", Font.BOLD, 15));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setMultiSelectionEnabled(true);

                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File[] files = fileChooser.getSelectedFiles();
                    String fileNames1 = "";
                    for (File file : files) {
                        fileNames1 += file.getName() + " ";
                    }
                    label1.setText("File Selected: " + fileNames1);
                    label1.setForeground(Color.blue);
                    label1.setFont(new Font("SANS_SERIF", Font.BOLD, 15));
                    label1.setBackground(Color.lightGray);
                    label1.setAlignmentX(Component.LEFT_ALIGNMENT);
                } else {
                    label1.setText("Open command canceled");
                    label1.setForeground(Color.red);
                    label1.setFont(new Font("SANS_SERIF", Font.BOLD, 15));
                }
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panelButton.add(button1);
        panelLabel.add(label1);

        panelButton.add(button4);

        frame.getContentPane().add(panelButton, BorderLayout.SOUTH);
        frame.getContentPane().add(panelLabel, BorderLayout.NORTH);
    }
}