
/**
 * CMIS 242: Final Project
 * Student Name: Maria Caballero
 * Date: 05/02/2023
 * Program Summary:
 *          This program is a media rental system that will be displayed as a GUI with 4 buttons.
 *          The user will be allowed to choose from the following options:
 *          1. Load Media Objects: 
 *              - The program will ask the user to enter the path of the directory where to load the files from.
 *                  ~ If the path is invalid, the program will display "The media couldn't be loaded, please try again."
 *                  ~ If the path is valid but files don't contain media objects "The files of this directory are not Media type. Try again!"
 *                  ~ If the path is valid and files contain media objects, the program will display "The media was successfully loaded."
 *         2. Find Media Objects:
 *             - The program will ask the user to enter the type of media object to be found by JOptionPane. The options are:
 *                  ~ EBook
 *                  ~ MovieDVD
 *                  ~ MusicCD
 *              - The program will then ask the user to enter the title of the media object to be found.
 *                  ~ If the title is not found, the program will display "There is no media with this title: *title*."
 *                  ~ If the title is found, the program will display "Media was found" and display the media object.
 *                  ~ If the title is found but the type is not the same, the program will display "Media title was found but it is not of the media type you are looking for."
 *        3. Rent Media Object:
 *             - The program will ask the user to enter the type of media object to be rented by JOptionPane. The options are:
 *                 ~ EBook
 *                 ~ MovieDVD
 *                 ~ MusicCD
 *            - The program will then ask the user to enter the ID of the media object to be rented.
 *                ~ If the ID is found and the availability is true then it will display the media object and the fee to be paid.
 *                ~ If the ID is found and the availability is false then it will display "Media is not available for rent. Sorry, try next time!"
 *                ~ If the ID is not found then it will display "Media was not found. Sorry!"               
 */
/**
 * Importing the necessary libraries
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;

public class MediaRentalSystem {
    // creating a manager object that will be use throughout the program
    private static Manager manager = new Manager();

    /**
     * Main method
     * It will create the window for the GUI to be displayed
     */
    public static void main(String[] args) {
        createWindow();
    }

    /**
     * This will create the frame of the window for the GUI
     */
    private static void createWindow() {
        JFrame frame = new JFrame("Welcome to Media Rental System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        createGUI(frame);
    } // end of createWindow method

    /**
     * This will create the GUI for the program
     */
    private static void createGUI(JFrame frame) {
        // creating Media Objects
        EBook ebook1 = new EBook(1234, "The Lord of the Rings", 1954, true, 61);
        EBook ebook2 = new EBook(2869, "Harry Potter", 1937, true, 36);
        EBook ebook3 = new EBook(3456, "The Twilight", 1977, true, 52);
        EBook ebook4 = new EBook(4812, "Maybe in Another Life", 2015, true, 8);
        EBook ebook5 = new EBook(5613, "Untamed", 2019, true, 10);
        EBook ebook6 = new EBook(6250, "Before We Were Strangers", 2015, true, 14);
        EBook ebook7 = new EBook(7219, "The Way I Used To Be", 2017, true, 9);
        EBook ebook8 = new EBook(8899, "Reminders of Him", 2022, true, 12);

        MovieDVD movieDVD1 = new MovieDVD(4631, "Just Go With It", 2001, true, 186.25);
        MovieDVD movieDVD2 = new MovieDVD(5111, "Harry Potter", 2005, true, 58.20);
        MovieDVD movieDVD3 = new MovieDVD(6862, "Spider Man", 2011, true, 20.36);
        MovieDVD movieDVD4 = new MovieDVD(7340, "Peter Pan", 2003, true, 124.89);
        MovieDVD movieDVD5 = new MovieDVD(8178, "Alicia in Wonderland", 2018, true, 115.40);
        MovieDVD movieDVD6 = new MovieDVD(9842, "Scary Movie", 2003, true, 38.56);
        MovieDVD movieDVD7 = new MovieDVD(7991, "Pirates of the Caribbean", 2014, true, 17.80);

        MusicCD musicCD1 = new MusicCD(7430, "Moana", 2022, true, 25);
        MusicCD musicCD2 = new MusicCD(8912, "Adele", 2014, true, 36);
        MusicCD musicCD3 = new MusicCD(9650, "Selena Gomez", 2021, true, 20);
        MusicCD musicCD4 = new MusicCD(1763, "Demi Lovato", 2016, true, 24);
        MusicCD musicCD5 = new MusicCD(2345, "Taylor Swift", 2019, true, 30);

        // adding the media objects to the manager
        manager.addMedia(ebook1);
        manager.addMedia(ebook2);
        manager.addMedia(ebook3);
        manager.addMedia(ebook4);
        manager.addMedia(ebook5);
        manager.addMedia(ebook6);
        manager.addMedia(ebook7);
        manager.addMedia(ebook8);
        manager.addMedia(movieDVD1);
        manager.addMedia(movieDVD2);
        manager.addMedia(movieDVD3);
        manager.addMedia(movieDVD4);
        manager.addMedia(movieDVD5);
        manager.addMedia(movieDVD6);
        manager.addMedia(movieDVD7);
        manager.addMedia(musicCD1);
        manager.addMedia(musicCD2);
        manager.addMedia(musicCD3);
        manager.addMedia(musicCD4);
        manager.addMedia(musicCD5);
        // try and catch block to create the media files
        try {
            manager.createMediaFiles(
                    "C:\\Users\\Maria\\OneDrive - UMGC\\Desktop\\UMGC\\SpringSemester2023\\Spring2023Session2\\CMIS-242\\Week#8\\FinalProjectFiles");
        } // if there is any error, the catch block will catch it and display the trace of
          // the error
        catch (IOException e) {
            // catch exception
            e.printStackTrace();
        }
        // Displaying the files to the console to make sure they were created
        System.out.println("Displaying all the available media to the console:");
        manager.displayMedia();

        // Creating the panel for the buttons
        JPanel panelButton = new JPanel();
        LayoutManager buttonLayout = new GridLayout(2, 2);
        panelButton.setLayout(buttonLayout);

        // loadMedia button
        JButton loadMedia = new JButton("Load Media Objects");
        loadMedia.setFont(new Font("TimesRoman", Font.BOLD, 20));
        loadMedia.setBackground(Color.PINK);

        // findMedia button
        JButton findMedia = new JButton("Find Media Objects");
        findMedia.setFont(new Font("TimesRoman", Font.BOLD, 20));
        findMedia.setBackground(Color.LIGHT_GRAY);

        // rentMedia button
        JButton rentMedia = new JButton("Rent Media Object");
        rentMedia.setFont(new Font("TimesRoman", Font.BOLD, 20));
        rentMedia.setBackground(Color.LIGHT_GRAY);

        // quit button
        JButton quit = new JButton("Quit");
        quit.setFont(new Font("TimesRoman", Font.BOLD, 20));
        quit.setBackground(Color.PINK);

        /**
         * Adding action listener to buttons
         */

        // loadMedia button action listener
        loadMedia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // JFileChooser let's the user to select the directory where the files would be
                // loaded from
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    String path = file.getAbsolutePath();
                    // try and catch block to load the media files
                    try {
                        manager.loadMediaFiles(path);
                        // if the files are not media type, the user will be prompted to try again
                        if (manager.checkMediaFiles() == false) {
                            JOptionPane.showMessageDialog(null,
                                    "The files of this directory are not Media type. Try again!",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        } // if the files are media type, the user will be prompted that the files were
                          // successfully loaded
                        else {
                            JOptionPane.showMessageDialog(null, "The media was successfully loaded.", "Success",
                                    JOptionPane.INFORMATION_MESSAGE);
                            // Displaying a message into the console to confirm this method worked
                            System.out.println("Successful load of media files.");
                        }
                    } // if there is any error, the catch block will catch it and display an error
                      // message
                    catch (FileNotFoundException e1) {
                        JOptionPane.showMessageDialog(null, "The media couldn't be loaded, please try again.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }); // end of loadMedia button

        // findMedia button action listener
        findMedia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // JOptionPane to prompt the user to select the type of media object to be found
                String[] options = { "EBook", "MovieDVD", "MusicCD" };
                String input = (String) JOptionPane.showInputDialog(null,
                        "Choose the type of media object to be found: ", "Find Media Objects",
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                // JOptionPane to prompt the user to enter the title of the media object to be
                // found
                String title = JOptionPane
                        .showInputDialog("Enter the title of the media to be found: ");

                // if the user doesn't select the media type to be found, the user will be
                // prompter an error message
                if (input == null || input.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You did not select the media type, please try again.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } // if the user doesn't enter a title, the user will be prompted an error message
                else if (title == null || title.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You did not entered a title, please try again.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } // if the user enters a number instead of letters, the user will be prompted to
                  // an error message
                else if (title.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "You did not entered a valid title, please try again.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } // if the user enters a valid title and selects the media type, the media object
                  // will be displayed
                else {
                    // result will hold the media object
                    String result = null;
                    // try and catch block to find the media object and display any error if there
                    // is any
                    try {
                        result = manager.findMedia(title, input);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, result, "Rent Media Objects",
                            JOptionPane.INFORMATION_MESSAGE);
                    // Displaying the media into the console to make sure the method worked
                    System.out.println(result);
                }
            }
        }); // end of findMedia button

        // rentMedia button action listener
        rentMedia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // JOptionPane to prompt the user to select the type of media object to be
                // rented
                String[] options = { "EBook", "MovieDVD", "MusicCD" };
                String input = (String) JOptionPane.showInputDialog(null,
                        "Choose the type of media object to be rented: ", "Rent Media Objects",
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                // JOptionPane to prompt the user to enter the id of the media object to be
                // rented
                int id = Integer.parseInt(
                        JOptionPane.showInputDialog("Enter the id of the media to be rented (just numbers): "));
                // if the user doesn't enter an id, the user will be prompted to try again
                if (id <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid ID, please try again.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } // if the user doesn't select the media type to be rented, the user will be
                  // prompted to try again
                else if (input == null) {
                    JOptionPane.showMessageDialog(null, "You did not select the media type, please try again.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } // if the user enters a valid id and selects the media type, the media object
                  // will be displayed along with the rental fee
                else {
                    String rented = null;
                    // try and catch block to catch any exceptions
                    try {
                        rented = manager.rentMedia(id);
                    } catch (Exception e1) {
                        // Print error message if any
                        e1.printStackTrace();
                    }
                    // Displaying the message to the user depending if media was found or not
                    JOptionPane.showMessageDialog(null, rented, "Was Found?", JOptionPane.INFORMATION_MESSAGE);
                    // making sure what is the media the user is trying to rent
                    System.out.println(rented);
                }
            }
        }); // end of rentMedia button

        // quit button action listener
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // gratefully letting the user know that the program is closing
                JOptionPane.showMessageDialog(null, "Thank you for using Media Rental System. See you next time!");
                System.exit(0);
            }
        }); // end of quit button

        // Adding the buttons to the panel
        panelButton.add(loadMedia);
        panelButton.add(findMedia);
        panelButton.add(rentMedia);
        panelButton.add(quit);

        // Adding the panelButton to the frame
        frame.getContentPane().add(panelButton, BorderLayout.CENTER);

    } // end of constructor CreateGUI
} // end of class MediaRentalSystem