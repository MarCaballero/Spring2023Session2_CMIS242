/**
 * This class is intended as the test/main/driver class for the object dvr set
 * top box class
 * utilizing get and set methods from DVRSetTopBox object class
 * <p>
 * Class: CMIS 242
 * 
 * @author Nick Anderson
 * @since 3/15/23
 */

public class TestDVRSetTopBox {

    public static void main(String[] args) {

        // Create an instance of the DVR Set Top box
        DVRSetTopBox dvr = new DVRSetTopBox(849, 1, 20, true, true);

        // Get Methods to return attribute/values
        System.out.println("\nPower On: " + dvr.getOn());
        System.out.println("\nChannel: " + dvr.getChannel());
        System.out.println("HDMI Input: " + dvr.getInput());
        System.out.println("Volume Level: " + dvr.getVolume());
        System.out.println("DVR Recording: " + dvr.getRecording());
        System.out.print("\n--------------------------------------------\n");

        // Author: Maria Caballero. I am removing your set methods because it is easier
        // to set new values from your constructor
        // This is a better technique of coding that eliminates unnecessary code.
        /*
         * Removing the following set methods and instead using the constructor for:
         * ~ dvr.setChannel(850);
         * ~ dvr.setInput(2);
         * ~ dvr.setVolume(21);
         * ~ dvr.setOn(false);
         * ~ dvr.setRecording(false);
         */
        DVRSetTopBox drv2 = new DVRSetTopBox(850, 2, 21, false, false);
        drv2.displayAllSettings();

        /*
         * Author: Maria Caballero.
         * I am removing your print statements so that instead of writing again all the
         * statements in your
         * displayAllSettings() class method in the DVRSetTopBox.java file, you just
         * reuse this for each instance object.
         * This way, you can get rid of the redundant code or unnecessary code.
         * Removing the following print statements since you already have them in your
         * display method:
         * ~ System.out.println("\nPower On: " + dvr.getOn());
         * ~ System.out.println("\nChannel: " + dvr.getChannel());
         * ~ System.out.println("HDMI Input: " + dvr.getInput());
         * ~ System.out.println("Volume Level: " + dvr.getVolume());
         * ~ System.out.println("DVR Recording: " + dvr.getRecording());
         */


         /*
          * Author: Maria Caballero.
            * Looking back at the outputs though, they are different. However, if you are displaying
            * different strings than the ones in your displayAllSettings() method, then
            * I would recommend get rid of this method and just print your attributes from this
            * TestDVRSetTopBox.java file, that way you don't have to write redundant code. 
          */

          //Example without using the displayAllSettings() method:
          DVRSetTopBox drv3 = new DVRSetTopBox(875, 14, 35, true, false);
          System.out.println("\nPower On: " + drv3.getOn());
            System.out.println("\nChannel: " + drv3.getChannel());
            System.out.println("HDMI Input: " + drv3.getInput());
            System.out.println("Volume Level: " + drv3.getVolume());
            System.out.println("DVR Recording: " + drv3.getRecording());
            System.out.print("\n--------------------------------------------\n");

    }

}
