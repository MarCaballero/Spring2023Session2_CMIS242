/**
 * This class will define the object of a DVR Set Top Box/Cable box.
 * It will have multiple attrubutes controlled by methods.
 * <p>
 * Class: CMIS 242
 * 
 * @since 3/12/23
 * @author Nick Anderson
 */
public class DVRSetTopBox {

    // Variable declarations/attributes
    private int channel;
    private int input;
    private double volume;
    private boolean on;
    private boolean recording;

    // Constructor to initialize variables for the object
    public DVRSetTopBox(int channel, int input, double volume, boolean on, boolean recording) {
        this.channel = channel;
        this.volume = volume;
        this.on = on;
        this.input = input;
        this.recording = recording;
    }

    // Get methods added 3/15/23
    public int getChannel() {
        return channel;
    }

    public int getInput() {
        return input;
    }

    public double getVolume() {
        return volume;
    }

    public boolean getOn() {
        return on;
    }

    public boolean getRecording() {
        return recording;
    }

    // Set methods added 3/15/23
    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRecording(boolean recording) {
        this.recording = recording;
    }

    // Method to change input up
    public void changeInputUp() {
        input++;
    }

    // Method to change channel up
    public void changeChannelUp() {
        channel++;
    }

    // Method to change volume up
    public void changeVolumeUp() {
        volume++;
    }

    // Method to display the values of attributes
    public void displayAllSettings() {

        System.out.println("Is the power on?: " + on);
        System.out.println("\nCurrent Channel: " + channel);
        System.out.println("Current HDMI Input: " + input);
        System.out.println("Volume level: " + volume);
        System.out.println("Is this being recorded?: " + recording);
        //Author: Maria Caballero - I am adding the print line with the dash to separate the output
        System.out.print("\n--------------------------------------------\n");
    }
}
