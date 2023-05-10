/**
 * CMIS 242: Assignment #3
 * Student Name: Maria Caballero
 * Date: 04/19/2023
 * Program Summary: 
 *          -This program will create a GUI that will allow the user to convert distances and temperatures as well as
 *           giving the user the option to exit whenever he/she wants.
 *          -The user will be able to choose between the two converters and then enter the unit to convert from, 
 *           the unit to convert to, and the value to convert.
 *          -The program will then display the converted value.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIConverter {
    private static void GUI() {
        //Creating and setting up the window frame.
        JFrame frame = new JFrame("Welcome to the Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createGUI(frame);
        frame.setSize(600, 300);    
        frame.setLocationRelativeTo(null);  
        frame.setVisible(true);
        }
    private static void createGUI(JFrame frame){  
        //Creating the panel for the buttons distance converter and temperature converter
        JPanel panelButton = new JPanel();
        LayoutManager buttonLayout = new GridLayout(1,2); 
        panelButton.setSize(600, 225); 
        panelButton.setLayout(buttonLayout);
        panelButton.setBackground(Color.LIGHT_GRAY);

        //Creating the panel for the exit button
        JPanel panelExit = new JPanel();
        LayoutManager exitLayout = new BorderLayout();
        panelExit.setLayout(exitLayout);
        panelExit.setBackground(Color.LIGHT_GRAY);

        //Button1 for Distance Converter
        JButton button1 = new JButton("Distance Converter");
        button1.setFont(new Font("Serif Plain", Font.BOLD, 20));
        button1.setBackground(Color.PINK);
        button1.setForeground(Color.BLACK);
  
          
        //Button2 for Temperature Converter
        JButton button2 = new JButton("Temperature Converter");
        button2.setFont(new Font("Serif Plain", Font.BOLD, 20));
        button2.setBackground(Color.ORANGE);
        button2.setForeground(Color.BLACK);
        

        //Button3 for exiting the program
        JButton button3 = new JButton("Exit");
        button3.setFont(new Font("Serif Plain", Font.BOLD, 20));
        button3.setBackground(Color.BLUE);
        button3.setForeground(Color.BLACK);
  
  
        //Button1 action listener      
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This are the options for the JOptionPanel
                String[] distConversion = {"mi", "km", "cm"};
                //This is the default instance object of the DistanceConverter class
                DistanceConverter distance = new DistanceConverter();

                //This is the JOptionPanel that will ask the user for the unit to convert from
                String distFromUnit = (String)JOptionPane.showInputDialog(frame, "Convert from?", "Distance Unit", JOptionPane.QUESTION_MESSAGE, null, distConversion, distConversion[0]);
                //This is the JOptionPanel that will ask the user for the unit to convert to
                String distToUnit = (String)JOptionPane.showInputDialog(frame, "Convert to?", "Distance Unit", JOptionPane.QUESTION_MESSAGE, null, distConversion, distConversion[0]);
                //This is the JOptionPanel that will ask the user for the value to convert
                Double value = Double.parseDouble(JOptionPane.showInputDialog(frame, "Input " + distFromUnit + ". distance to convert: ", "Value", JOptionPane.QUESTION_MESSAGE));
                //This is the instance object of the DistanceConverter class that will be using the attributes from the JOptionPanel to convert the given value
                distance = new DistanceConverter(value, distFromUnit, distToUnit);
                //This is the JOptionPanel that will display the converted value which it's the final output
                JOptionPane.showMessageDialog(null, value + " " + distance.getUnit() + " = " + String.format("%.3f",distance.convert(distance.getValue())) + " " + distance.getConvertedUnit());
            }
        });
           
        //Button2 action listener
        button2.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                //This are the options for the JOptionPanel
                String[] tempConversion = {"C", "F", "K"};
                //This is the default instance object of the TemperatureConverter class
                TemperatureConverter temp = new TemperatureConverter();

                //This is the JOptionPanel that will ask the user for the unit to convert from
                String tempFromUnit = (String)JOptionPane.showInputDialog(frame, "Convert from?", "Temperature Unit", JOptionPane.QUESTION_MESSAGE, null, tempConversion, tempConversion[0]);
                //This is the JOptionPanel that will ask the user for the unit to convert to
                String tempToUnit = (String)JOptionPane.showInputDialog(frame, "Convert to?", "Temperature Unit", JOptionPane.QUESTION_MESSAGE, null, tempConversion, tempConversion[0]);
                //This is the JOptionPanel that will ask the user for the value to convert
                Double value = Double.parseDouble(JOptionPane.showInputDialog(frame, "Input " + tempFromUnit + ". temperature to convert: ", "Value", JOptionPane.QUESTION_MESSAGE));
                //This is the instance object of the TemperatureConverter class that will be using the attributes from the JOptionPanel to convert the given value
                temp = new TemperatureConverter(value, tempFromUnit, tempToUnit);
                //This is the JOptionPanel that will display the converted value which it's the final output
                JOptionPane.showMessageDialog(null, value + " " + temp.getUnit() + " = " + String.format("%.3f",temp.convert(temp.getValue())) + " " + temp.getConvertedUnit());

            }
        });
  
        //Button3 action listener
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This is the JOptionPanel that will display the message when the user exits the program
                JOptionPane.showMessageDialog(null, "Thank You for Using the Converter System. Goodbye!");
                //This is the command that will exit the program
                System.exit(0);
           }
        });
         
        //Adding Distance Converter button to the panel
        panelButton.add(button1);
        //Adding Temperature Converter button to the panel
        panelButton.add(button2);
        //Adding Exit button to the panel
        panelExit.add(button3, BorderLayout.SOUTH);

        //Adding panels to the frame
        frame.getContentPane().add(panelButton);
        frame.getContentPane().add(panelExit);
  
    
    //Main class that will display GUI
      }
    public static void main(String[] args){
        GUI();
      }
  }

