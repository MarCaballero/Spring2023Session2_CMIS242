
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
 
    private static void createUI(JFrame frame){  
         JPanel panelButton = new JPanel();
         LayoutManager buttonLayout = new FlowLayout();  
         panelButton.setLayout(buttonLayout);   
            
         JPanel panelLabel = new JPanel(new SpringLayout());
         panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
         panelLabel.setBackground(Color.pink);

         //LayoutManager panelLayout = new FlowLayout();

         JButton button1 = new JButton("Choose first file");
         button1.setFont(new Font("Arial", Font.BOLD, 15));
         JLabel label1 = new JLabel();

         JButton button2 = new JButton("Choose second file");
         button2.setFont(new Font("Arial", Font.BOLD, 15));
         JLabel label2 = new JLabel();

         JButton button3 = new JButton("Compare files");
         button3.setFont(new Font("Arial", Font.BOLD, 15));
         JLabel label3 = new JLabel();

         JButton button4 = new JButton("Exit");
         button4.setFont(new Font("Arial", Font.BOLD, 15));


 
       button1.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             JFileChooser fileChooser = new JFileChooser();
             fileChooser.setMultiSelectionEnabled(true);
 
             int option = fileChooser.showOpenDialog(frame);
             if(option == JFileChooser.APPROVE_OPTION){
                File[] files = fileChooser.getSelectedFiles();
                String fileNames1 = "";
                for(File file: files){
                   fileNames1 += file.getName() + " ";
                }
                label1.setText("File Selected: " + fileNames1);
                label1.setForeground(Color.blue);
                label1.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
                label1.setAlignmentY(Component.TOP_ALIGNMENT);
             }else{
               label1.setText("Open command canceled");
               label1.setForeground(Color.red);
               label1.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
             }
          }
       });

      button2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);

            int option = fileChooser.showOpenDialog(frame);
            if(option == JFileChooser.APPROVE_OPTION){
               File[] files = fileChooser.getSelectedFiles();
               String fileNames2 = "";
               for(File file: files){
                  fileNames2 += file.getName() + " ";
               }
               label2.setText("File Selected: " + fileNames2);
               label2.setForeground(Color.red);
               label2.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
               label1.setAlignmentY(Component.CENTER_ALIGNMENT);
              
            }else{
               label2.setText("Open command canceled");
               label2.setForeground(Color.red);
               label2.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
            }
         }
      });

      button3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if(label1.getText().equals(label2.getText())){
               label3.setText("Files are same");
               label3.setForeground(Color.BLACK);
               label3.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
               label3.setAlignmentY(Component.CENTER_ALIGNMENT);
            }else{
               label3.setText("Files are different");
               label3.setForeground(Color.BLACK);
               label3.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
               label3.setAlignmentY(Component.CENTER_ALIGNMENT);
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

      panelButton.add(button2);
      panelLabel.add(label2);

      panelButton.add(button3);
      panelLabel.add(label3);

      panelButton.add(button4);

      frame.getContentPane().add(panelButton, BorderLayout.SOUTH);
      frame.getContentPane().add(panelLabel, BorderLayout.WEST);    
    }  
 } 