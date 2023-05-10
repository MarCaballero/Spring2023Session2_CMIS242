/**
 * EBook class that extends Media class which makes it a subclass of Media
 */
public class EBook extends Media {
    // Additional attributes
    private int numChapters;
    private final double EBOOK_RENTAL_FEE = 12.99;

    // Constructor
    public EBook(int id, String title, int year, Boolean availability, int numChapters) {
        super(id, title, year, availability);
        this.numChapters = numChapters;
    }

    // constructor to Parse String with XML tags for its values
    public EBook(String xmlString) {
        super(xmlString);
        this.numChapters = Integer.parseInt(
                xmlString.substring(xmlString.indexOf("<numChapters>") + String.valueOf(numChapters).length() + 1),
                xmlString.indexOf("</numChapters>"));
    }

    // Getters
    public int getNumChapters() {
        return numChapters;
    }

    public double getRentalFee() {
        return EBOOK_RENTAL_FEE;
    }

    public String getMediaType() {
        return "EBook";
    }

    // Setters
    public void setNumChapters(int numChapters) {
        this.numChapters = numChapters;
    }

    // toString method to make the XML tags
    public String toString() {
        return "<EBook>" +
                "<id>" + this.getId() + "</id>" +
                "<title>" + this.getTitle() + "</title>" +
                "<year>" + this.getYear() + "</year>" +
                "<available>" + this.getAvailability() + "</available>" +
                "<numChapters>" + this.getNumChapters() + "</numChapters>" +
                "</EBook>";
    }

}
