//Author: Maria Caballero
//Date: 04/07/2023
/*Program Summary: This program will create a GUI that will allow the user to pick between two types of snacks: 
                   Fruit Snack and Salty Snack. If the user don't want to pick any snack he can click the "Exit" button.
                   The user will be able to pick the size of the snack and the type: Is citrus? (for Fruit Snack) and
                   Is nut? (for Salty Snack). At the end, the program will display the size and type of the snack, the ID
                   and the total price.
*/

//Imported the necessary packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OrderSystem {
    private static void createWindow() {
      //Creating and setting up the window frame.
      JFrame frame = new JFrame("Snack Ordering System");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      createUI(frame);
      frame.setSize(600, 300);    
      frame.setLocationRelativeTo(null);  
      frame.setVisible(true);
     }
  
   private static void createUI(JFrame frame){  
      //Creating the panel for the buttons
      JPanel panelButton = new JPanel();
      LayoutManager buttonLayout = new FlowLayout();  
      panelButton.setLayout(buttonLayout);
      panelButton.setBackground(Color.LIGHT_GRAY);   
        
      //Creating the panel for the labels
      JPanel panelLabel = new JPanel();
      panelLabel.setLayout(new BoxLayout(panelLabel, BoxLayout.Y_AXIS));
      panelLabel.setBackground(Color.BLACK);
 
      //Button1 for picking Fruit Snack
      JButton button1 = new JButton("Fruit Snack");
      button1.setFont(new Font("Serif Plain", Font.BOLD, 20));
      button1.setBackground(Color.PINK);
      button1.setForeground(Color.BLACK);

      //THIS LABELS ARE FOR FRUIT SNACK
      //label1 will display the size and type (citrus or not) of snack that the user picked
      JLabel label1 = new JLabel();
      //label2 will display the ID of the snack that the user picked
      JLabel label2 = new JLabel();
      //label3 will display the price of the snack that the user picked
      JLabel label3 = new JLabel();
        
      //Button2 for picking Salty Snack
      JButton button2 = new JButton("Salty Snack");
      button2.setFont(new Font("Serif Plain", Font.BOLD, 20));
      button2.setBackground(Color.RED);
      button2.setForeground(Color.BLACK);

      //THIS LABELS ARE FOR SALTY SNACK
      //label4 will display the size and type (nut or not) of snack that the user picked
      JLabel label4 = new JLabel();
      //label5 will display the ID of the snack that the user picked
      JLabel label5 = new JLabel();
      //label6 will display the price of the snack that the user picked
      JLabel label6 = new JLabel();

      //LABEL TO DISPLAY THE INTRO TO THE PROGRAM
      JMenu labelIntro = new JMenu("Welcome to the Snack Bar!");
      labelIntro.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
      labelIntro.setForeground(Color.BLACK);
      

      //Button3 for restarting program
      JButton button3 = new JButton("Restart");
      button3.setFont(new Font("Serif Plain", Font.BOLD, 20));
      button3.setBackground(Color.GREEN);
      button3.setForeground(Color.BLACK);

      //Button4 for exiting the program
      JButton button4 = new JButton("Exit");
      button4.setFont(new Font("Serif Plain", Font.BOLD, 20));
      button4.setBackground(Color.BLUE);
      button4.setForeground(Color.BLACK);


      //Button1 action listener      
      button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //This are the options for the JOptionPanel
            String[] selection = {"Yes", "No"};
            String[] sizes = {"S", "M", "L"};

            //This are the labels UI designs
            label1.setFont(new Font("Serif Bold Italic", Font.BOLD, 15));
            label1.setForeground(Color.YELLOW);
            label2.setFont(new Font("Serif Bold Italic", Font.BOLD, 15));
            label2.setForeground(Color.YELLOW);
            label3.setFont(new Font("Serif Bold Italic", Font.BOLD, 15));
            label3.setForeground(Color.YELLOW);

            //This is the JOptionPanel that will ask the user if the snack is citrus or not and the size of the snack
            String isCitrus = (String)JOptionPane.showInputDialog(frame, "Is the snack citrus?", "Citrus", JOptionPane.QUESTION_MESSAGE, null, selection, selection[0]);
            String size = (String)JOptionPane.showInputDialog(frame, "What size is the snack?", "Size", JOptionPane.QUESTION_MESSAGE, null, sizes, sizes[0]);
            
            //This creates the instance of the FruitSnack class and it will be use in the if statements
            FruitSnack citrusSnack = new FruitSnack();

            //This creates the instance of a Snack in case the FruitScanck is not citrus
            Snack snack = new Snack();
            double price = 0.0;


               //This if statements will check if the user selected citrus or not and the size of the snack
               if(isCitrus.equals("Yes")){
                  if(size.equals("S")){
                     citrusSnack.setPrice(true, "S");
                     price = citrusSnack.getPrice();
                     label1.setText("You selected a small citrus Fruit Snack");
                     label2.setText("ID: " + citrusSnack.getID());
                     label3.setText("Price: " + String.format("%.2f",price));
                  }
                  else if(size.equals("M")){
                     citrusSnack.setPrice(true, "M");
                     price = citrusSnack.getPrice();
                     label1.setText("You selected a medium citrus Fruit Snack");
                     label2.setText("ID: " + citrusSnack.getID());
                     label3.setText("Price: " + String.format("%.2f",price));
                  }
                  else if(size.equals("L")){
                     citrusSnack.setPrice(true, "L");
                     price = citrusSnack.getPrice();
                     label1.setText("You selected a large citrus Fruit Snack");
                     label2.setText("ID: " + citrusSnack.getID());
                     label3.setText("Price: " + String.format("%.2f",price));
                  }
               }
               if(isCitrus.equals("No")){
                  if(size.equals("S")){
                     snack.setPrice("S");
                     price = snack.getPrice();
                     label1.setText("You selected a small Fruit Snack");
                     label2.setText("ID: " + snack.getID());
                     label3.setText("Price: " + String.format("%.2f",price));

                  }
                  else if(size.equals("M")){
                     snack.setPrice("M");
                     price = snack.getPrice();
                     label1.setText("You selected a medium Fruit Snack");
                     label2.setText("ID: " + snack.getID());
                     label3.setText("Price: " + String.format("%.2f",price));
                  }
                  else if(size.equals("L")){
                     snack.setPrice("L");
                     price = snack.getPrice();
                     label1.setText("You selected a large Fruit Snack");
                     label2.setText("ID: " + snack.getID());
                     label3.setText("Price: " + String.format("%.2f",price));
                  }
               }
            }
         });
         
         //Button2 action listener
      button2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            //This are the options for the JOptionPanel
            String[] selection = {"Yes", "No"};
            String[] sizes = {"S", "M", "L"};

            //This are the labels UI designs
            label4.setFont(new Font("Serif Bold Italic", Font.BOLD, 15));
            label4.setForeground(Color.GREEN);
            label5.setFont(new Font("Serif Bold Italic", Font.BOLD, 15));
            label5.setForeground(Color.GREEN);
            label6.setFont(new Font("Serif Bold Italic", Font.BOLD, 15));
            label6.setForeground(Color.GREEN);

            //This is the JOptionPanel that will ask the user if the snack is citrus or not and the size of the snack
            String isNut = (String)JOptionPane.showInputDialog(frame, "Is the snack nut?", "Nut", JOptionPane.QUESTION_MESSAGE, null, selection, selection[0]);
            String size = (String)JOptionPane.showInputDialog(frame, "What size is the snack?", "Size", JOptionPane.QUESTION_MESSAGE, null, sizes, sizes[0]);

            //This creates the instance of the SaltySnack class and it will be use in the if statements
            SaltySnack nutSnack = new SaltySnack();

            //This creates the instance of a Snack in case the SaltySnack is not nut
            Snack snack = new Snack();
            double price = 0.0;

               //This if statements will check if the user selected nut or not and the size of the snack
               if(isNut.equals("Yes")){
                  if(size.equals("S")){
                     nutSnack.setPrice(true, "S");
                     price = nutSnack.getPrice();
                     label4.setText("You selected a small nut Salty Snack");
                     label5.setText("ID: " + nutSnack.getID());
                     label6.setText("Price: " + String.format("%.2f", price));
                  }
                  else if(size.equals("M")){
                     nutSnack.setPrice(true, "M");
                     price = nutSnack.getPrice();
                     label4.setText("You selected a medium nut Salty Snack");
                     label5.setText("ID: " + nutSnack.getID());
                     label6.setText("Price: " + String.format("%.2f", price));
                  }
                  else if(size.equals("L")){
                     nutSnack.setPrice(true, "L");
                     price = nutSnack.getPrice();
                     label4.setText("You selected a large nut Salty Snack");
                     label5.setText("ID: " + nutSnack.getID());
                     label6.setText("Price: " + String.format("%.2f", price));
                  }
               }
               if(isNut.equals("No")){
                  if(size.equals("S")){
                     snack.setPrice("S");
                     price = snack.getPrice();
                     label4.setText("You selected a small Salty Snack");
                     label5.setText(" ID: " + snack.getID());
                     label6.setText("Price: " + String.format("%.2f", price));
                  }
                  else if(size.equals("M")){
                     snack.setPrice("M");
                     price = snack.getPrice();
                     label4.setText("You selected a medium Salty Snack");
                     label5.setText("ID: " + snack.getID());
                     label6.setText("Price: " + String.format("%.2f", price));
                  }
                  else if(size.equals("L")){
                     snack.setPrice("L");
                     price = snack.getPrice();
                     label4.setText("You selected a large Salty Snack");
                     label5.setText("ID: " + snack.getID());
                     label6.setText("Price: " + String.format("%.2f", price));
                  }
               }      
            }
         });

      button3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            //Restart the program
            createWindow();
         }
      });

      button4.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Thank you for using the Snack Ordering System. Goodbye!");
            System.exit(0);
         }
      });
       
      //Adding to the Panel button 1 and labels 1, 2, 3
      panelButton.add(button1);
      panelLabel.add(label1);
      panelLabel.add(label2);
      panelLabel.add(label3);
      
      //Adding to the Panel button 2 and labels 4, 5, 6
      panelButton.add(button2);
      panelLabel.add(label4);
      panelLabel.add(label5);
      panelLabel.add(label6);

      //Adding Intro label
      panelLabel.add(labelIntro);

      //Adding to the Panel for the restart button (without layout because we are not displaying anything else, we are just restarting program)
      panelButton.add(button3);

      //Adding Panel for the exit button (without layout because we are not displaying anything else)
      panelButton.add(button4);
      
      //Adding the panels to the frame
      frame.getContentPane().add(panelButton, BorderLayout.SOUTH);
      frame.getContentPane().add(panelLabel, BorderLayout.CENTER);
      frame.getContentPane().add(labelIntro, BorderLayout.NORTH);

   //Main class for the program where we are displaying the frame
    }
    public static void main(String[] args){
        createWindow();
    }
}
