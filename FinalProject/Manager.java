
/**
 * This class is to manage all media objects
 */
import java.util.*;
import java.io.*;

/**
 * Manager class that manages all media objects the following are the methods in
 * this class:
 * - loadMediaFiles: Loads media files from external data files
 * - checkMediaFiles: Checks that media files are of media type
 * - createMediaFiles: Creates media files and adds them to mediaList
 * - addMedia: Adds media object to mediaList
 * - findMedia: Finds media object by title
 * - rentMedia: Rents media object by id and sets availability to false
 * - displayMedia: Displays all media objects
 */
public class Manager {
    // Atributes
    private ArrayList<Media> mediaList;
    // This arrayList is to store files from directory
    private ArrayList<String> mediaFiles;

    // default constructor
    public Manager() {
        // initialize empty MediaList arraylist
        this.mediaList = new ArrayList<Media>();
    }

    /**
     * Load all media files from directory
     * Assuming file name convention starts with Media type of either "MusicCD",
     * "EBook", or "MovieDVD"
     * If directory is not found it will throw an exception
     */
    // error here
    public void loadMediaFiles(String directory) throws FileNotFoundException {
        // Initialize empty arrayList of strings
        mediaFiles = new ArrayList<String>();
        // Create a File object for the directory
        File directoryPath = new File(directory);
        // Get list of all files in the directory
        File[] filesList = directoryPath.listFiles();

        // if filesList is null, throw exception
        if (filesList == null) {
            throw new FileNotFoundException("Could not load, no such directory");
        }

        // create a scanner object to read file
        Scanner scanner;
        // read line of file
        String line;

        // loop through all files to process them one by one and adding them into
        // mediaList arraylist
        for (File file : filesList) {
            // if file is a file and not a directory
            if (file.isFile() && file.getName().contains("EBook") || file.getName().contains("MovieDVD")
                    || file.getName().contains("MusicCD")) {
                // create scanner object to read file
                scanner = new Scanner(file);
                // while there is a next line in the file
                while (scanner.hasNextLine()) {
                    // read line
                    line = scanner.nextLine();
                    // if line contains MusicCD then create MusicCD object
                    if (line.contains("MusicCD")) {
                        mediaFiles.add(line); // add line to mediaFiles arraylist
                    } // else if line contains EBook then create EBook object
                    else if (line.contains("EBook")) {
                        mediaFiles.add(line); // add line to mediaFiles arraylist
                    } // else if line contains MovieDVD then create MovieDVD object
                    else if (line.contains("MovieDVD")) {
                        mediaFiles.add(line); // add line to mediaFiles arraylist
                    }
                }
            }
        }
    }

    /**
     * This method is to check that the mediaFiles ArrayList contains files of media
     * type
     */
    public boolean checkMediaFiles() {
        Boolean contains = false;
        // loop through all mediaFiles
        for (String mediaFile : this.mediaFiles) {
            // if mediaFile contains the media type return set contains to true
            if (mediaFile.contains("MusicCD") || mediaFile.contains("EBook") || mediaFile.contains("MovieDVD")) {
                contains = true;
            }
        }
        // else return false
        return contains;
    }

    /**
     * Creates or Overwrites a file for each Pet object in pets attribute
     * in the directory specified
     */
    public void createMediaFiles(String directory) throws IOException {
        // create a PrintWriter object
        PrintWriter out = null;
        // for all Media objects create a file using Media type and title value as
        // file Name
        for (Media media : this.mediaList) {
            // create file
            out = new PrintWriter(
                    directory + "/" + media.getMediaType() + "_" + media.getTitle().replaceAll("\\s", "") + ".txt");
            // write media object to file
            out.println(media.toString());
            // flush all data to the file
            out.flush();
            // close file
            out.close();
        }

    }

    /**
     * Add Media object to mediaList
     */
    public void addMedia(Media media) {
        this.mediaList.add(media);
    }

    /**
     * Find Media object in mediaList by title and type and return the media object
     * if found, if not return an error message
     */
    public String findMedia(String title, String type) {
        // this will hold the media object if found
        String foundMedia = "";
        // this will hold the message if the media title was found but not of the type
        // media the user is looking for
        String notFound = "";
        // this will hold the message if media object is not found
        String foundMediaButNoType = "";

        // loop through all media objects in mediaList
        for (Media media : this.mediaList) {
            // if media object title matches title and instance class of media return media
            if (media.getTitle().equalsIgnoreCase(title) && media.getMediaType() == type) {
                foundMedia = "Media was found:\n" + media.toString();
            } // else if media object title matches title but not type return message
            else if (media.getTitle().equalsIgnoreCase(title) && media.getMediaType() != type) {
                foundMediaButNoType = "Media title was found but it is not of the media type you are looking for.\n"
                        + media.toString();
            } // else if Media object does not match any title and type return message
            else {
                notFound = "There is no media with this title: " + title;
            }
        }
        /**
         * we return the foundMedia variable if it is not empty else we return the
         * foundMediaButNoType variable if it is not empty else we return the notFound
         * variable
         */
        if (foundMedia != "") {
            return foundMedia;
        } else if (foundMediaButNoType != "") {
            return foundMediaButNoType;
        } else {
            return notFound;
        }
    }

    /**
     * Rents media object from the mediaList if available else will return a message
     * stating that the media is not
     * available.
     */
    public String rentMedia(int id) {
        // this will hold the media object if found
        String displayRentedMedia = "";
        // this will hold the message if media object is not found
        String notFound = "";
        // this will hold the message if media object is not available
        String notAvailable = "";
        // loop through all media objects in mediaList
        for (Media media : this.mediaList) {
            // if media object id matches id and is available then display message and set
            // availability to false
            if (media.getId() == id && media.getAvailability() == true) {
                displayRentedMedia = (media.toString() + " has been rented for " + media.getRentalFee() + " dollars.");
                media.setAvailability(false);
            } // else if media matches id but is not available display another message
            else if ((media.getId() == id && media.getAvailability() == false)) {
                notAvailable = ("Media is not available for rent. Sorry, try next time!");
            } // else if media does not matches id display another message
            else {
                notFound = ("Media was not found. Sorry!");
            }
        }
        /**
         * Here we check if displayRentedMedia is empty, if it is then we check if
         * notAvailable is empty, if it is then we return the notFound variable
         */
        if (displayRentedMedia != "") {
            return displayRentedMedia;
        } else if (notAvailable != "") {
            return notAvailable;
        } else {
            return notFound;
        }
    }

    /**
     * Displays all media objects in mediaList that are available
     */
    public void displayMedia() {
        for (Media media : this.mediaList) {
            if (media.getAvailability()) {
                System.out.println(media.toString() + "\n");
            }
        }
    }
}
