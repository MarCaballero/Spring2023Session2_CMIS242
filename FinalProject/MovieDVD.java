/**
 * MovieDVD class extends Media class which makes it a subclass of Media
 */
public class MovieDVD extends Media {
    // Additional attributes
    private double size;
    private final double MOVIE_RENTAL_FEE = 7.99;

    // Constructor
    public MovieDVD(int id, String title, int year, Boolean availability, double size) {
        super(id, title, year, availability);
        this.size = size;
    }

    // constructor to Parse String with XML tags for its values
    public MovieDVD(String xmlString) {
        super(xmlString);
        this.size = Double.parseDouble(xmlString.substring(xmlString.indexOf("<size>") + String.valueOf(size).length(),
                xmlString.indexOf("</size>")));
    }

    // Getters
    public double getSize() {
        return size;
    }

    public double getRentalFee() {
        return MOVIE_RENTAL_FEE;
    }

    public String getMediaType() {
        return "MovieDVD";
    }

    // Setters
    public void setSize(double size) {
        this.size = size;
    }

    // toString method to make the XML tags
    public String toString() {
        return "<MovieDVD>" +
                "<id>" + this.getId() + "</id>" +
                "<title>" + this.getTitle() + "</title>" +
                "<year>" + this.getYear() + "</year>" +
                "<available>" + this.getAvailability() + "</available>" +
                "<size>" + this.getSize() + "</size>" +
                "</MovieDVD>";
    }

}
