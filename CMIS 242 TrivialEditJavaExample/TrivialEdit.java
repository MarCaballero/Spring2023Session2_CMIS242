import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.swing.*;

/**
 * This program lets the user edit short text files in a window.
 * When a file is being edited, the name of the file is displayed
 * in the window's title bar.  A "File" menu provides the following commands:
 *      New -- Clears all text from the Window
 *      Open -- Allows the user to select a file to be loaded into the window.
 *      The previous contents of the window are lost.
 *      Save -- Let's the user specify an output file and saves
 *             the contents of the window in that file.
 *      Quit -- Closes the window and ends the program.
 * 
 * This very simple program is not meant for serious text editing. In particular, 
 * a limit of 10,000 charactersis put on the size of the files that it can read.
 */
public class TrivialEdit extends JFrame{
    /**
     * The main program just opens a window belonging to this TrivialEdit class.
     * Then the window takes care of itself until the program is ended with the
     * Quit command or when the user closes the window.
     */
    public static void main(String[] args) {
        JFrame window = new TrivialEdit();
        window.setVisible(true);
    }

    private JTextArea text;  // The text area holds the text that is displayed in the window.
    private JFileChooser fileDialog;  // A dialog box for selecting files.
    private File editFile;  // The file being edited, or null if none.

    /**
     * The constructor creates the TrivialEdit window and sets it up.
     * With a JTextArea where the user can edit somme text and with a menu bar.
     */
     public TrivialEdit(){
        super("TrivialEdit: Untitled"); // Specifies title of the window.
        setJMenuBar(makeMenuBar()); // Set up the menu bar.
        text = new JTextArea(25,50); // Create the text area.
        text.setMargin(new Insets(3,5,0,0)); //Some space around the text
        JScrollPane scroller = new JScrollPane(text);
        setContentPane(scroller); // Put the text area in a scroll pane.
        setDefaultCloseOperation(EXIT_ON_CLOSE); // End program when window is closed.
        pack(); // Set size of window to be just big enough for the text area.
        setLocation(50,50); // Set position of window on the screen.
     }

     /**
      * Create and return a menu bar containing a single menu, the
      * "File" menu.  The File menu contains four commands: New, Open, Save, and Quit.
    */
    private JMenuBar makeMenuBar(){
    
        ActionListener listener = new ActionListener(){
            //An object that will serve as listener for menu items.
            public void actionPerformed(ActionEvent evt){
                //This will be called when the user makes a selection
                //from the File menu. This routine just checks
                //which command was selected and calls another
                //routine to carry out the command.
                String command = evt.getActionCommand();
                if(command.equals("New"))
                    doNew();
                else if(command.equals("Open"))
                    doOpen();
                else if(command.equals("Save"))
                    doSave();
                else if(command.equals("Quit"))
                    doQuit();
            }
        };
        JMenu fileMenu = new JMenu("File"); // Create File menu.
        JMenuItem item; // An item in the menu.
        item = new JMenuItem("New"); // Create New command.
        item.addActionListener(listener);
        fileMenu.add(item);

        item = new JMenuItem("Open"); // Create Open command.
        item.addActionListener(listener);
        fileMenu.add(item);

        item = new JMenuItem("Save"); // Create Save command.
        item.addActionListener(listener);
        fileMenu.add(item);

        fileMenu.addSeparator(); // Add a separator line to the menu.

        item = new JMenuItem("Quit"); // Create Quit command.
        item.addActionListener(listener);
        fileMenu.add(item);

        JMenuBar menuBar = new JMenuBar(); // Create menu bar.
        menuBar.add(fileMenu); // Add File menu to it.
        return menuBar; // Return the menu bar that was created.
    } // end makeMenuBar()

    /**
     * Carry out the "New" command by clearing the window.
     * the text from the JTextArea. Also sets the title bar of the
     * window to read "TrivialEdit: Untitled".
     */
    private void doNew(){
        text.setText("");
        editFile = null;
        setTitle("TrivialEdit: Untitled");
    }
    /** 
     * Carry out the Save command by letting the user specify an output file
     * and writing the text from the JTextArea to that file.
    */
    private void doSave(){
        if(fileDialog == null){
            fileDialog = new JFileChooser();
        }
        File selectedFile; //The file that the user selects.
        if(editFile == null){
            selectedFile = new File("filename.txt");
        }else{
            selectedFile = new File(editFile.getName());
        }
        fileDialog.setSelectedFile(selectedFile);
        fileDialog.setDialogTitle("Select File to be Saved");
        int option = fileDialog.showSaveDialog(this);
        if(option != JFileChooser.APPROVE_OPTION)
            return;
        selectedFile = fileDialog.getSelectedFile();
        if(selectedFile.exists()){
            int response = JOptionPane.showConfirmDialog(this,
            "The file \"" + selectedFile.getName() + "\" already exists.\nDo you want to replace it?",
            "Confirm Save",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
            if(response != JOptionPane.YES_OPTION)
                return;
        }
        PrintWriter out;
        try{
            FileWriter stream = new FileWriter(selectedFile);
            out = new PrintWriter(stream);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,
            "Sorry, but an error occurred while trying to open the file:\n" + e);
            return;
        }
        try{
            out.print(text.getText()); // Write text from the TextArea to the file.
            out.close();
            if(out.checkError()){ // (need to check for errors in PrintWriter)
                throw new IOException("Some error occurred while writing the file."); //need to check for errors in PrintWriter
            }
            editFile = selectedFile;
            setTitle("TrivialEdit: " + editFile.getName());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,
            "Sorry, but an error occurred while trying to write the file:\n" + e);
        }
    } // end doSave()

    /**
     * Carry out the Open command by letting the user specify a file to be opened
     * and reading up to 10,000 characters from the file into the JTextArea.
     * If the file is read successfully and is not too long, then the text from the
     * file replaces the text in the JTextArea.
     */
    private void doOpen(){
        if(fileDialog == null){
            fileDialog = new JFileChooser();
        }
        fileDialog.setDialogTitle("Select File to be Opened");
        fileDialog.setSelectedFile(null);
        int option = fileDialog.showOpenDialog(this);
        if(option != JFileChooser.APPROVE_OPTION)
            return; // User canceled or clicked the dialog's close box.
        File selectedFile = fileDialog.getSelectedFile();
        Scanner scanner;
        try{
            scanner = new Scanner(selectedFile);
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(this,
            "Sorry, but an error occurred while trying to open the file:\n" + e);
            return;
        }
        try{
            StringBuilder contents = new StringBuilder();
            while(scanner.hasNextLine()){
                String lineFromFile = scanner.nextLine();
                if(lineFromFile == null){
                    break; //end of line has been reached.
                }
                contents.append(lineFromFile);
                contents.append("\n");
                if(contents.length() > 10000){
                    throw new IOException("File is too large.");
                }
                text.setText(contents.toString());
                editFile = selectedFile;
                setTitle("TrivialEdit: " + editFile.getName());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,
            "Sorry, but an error occurred while trying to read the file:\n" + e);
        }finally{
            scanner.close();
        }
    } // end doOpen()

    /**
     * Carry out the Quit command by ending the program.
     */
    private void doQuit(){
        System.exit(0);
    } // end doQuit()
} // end class TrivialEdit
