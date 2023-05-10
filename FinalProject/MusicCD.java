/**
 * MusicCD class extends Media class which makes it a subclass of Media
 */
public class MusicCD extends Media {
    // Additional attributes
    private int length;
    private final double MUSIC_RENTAL_FEE = 9.99;

    // Constructor
    public MusicCD(int id, String title, int year, Boolean availability, int length) {
        super(id, title, year, availability);
        this.length = length;
    }

    // constructor to Parse String with XML tags for its values
    public MusicCD(String xmlString) {
        super(xmlString);
        this.length = Integer.parseInt(xmlString.substring(
                xmlString.indexOf("<length>") + String.valueOf(length).length(), xmlString.indexOf("</length>")));
    }

    // Getters
    public int getLength() {
        return length;
    }

    public double getRentalFee() {
        return MUSIC_RENTAL_FEE;
    }

    public String getMediaType() {
        return "MusicCD";
    }

    // Setters
    public void setLength(int length) {
        this.length = length;
    }

    // toString method to make the XML tags
    public String toString() {
        return "<MusicCD>" +
                "<id>" + this.getId() + "</id>" +
                "<title>" + this.getTitle() + "</title>" +
                "<year>" + this.getYear() + "</year>" +
                "<available>" + this.getAvailability() + "</available>" +
                "<length>" + this.getLength() + "</length>" +
                "</MusicCD>";
    }

}
