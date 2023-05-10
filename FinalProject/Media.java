/**
 * Class Summary:
 * This class will be the parent class for all the media types. It will
 * contain the attributes and methods that will be common to all the media
 * types.
 * 
 */
public abstract class Media {
    // Attributes
    private int id;
    private String title;
    private int year;
    private Boolean availability;

    // Constructor
    public Media(int id, String title, int year, Boolean availability) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.availability = availability;
    }

    // constructor to Parse String with XML tags for its values
    public Media(String xmlString) {
        this.id = Integer.parseInt(xmlString.substring(xmlString.indexOf("<id>") + 4, xmlString.indexOf("</id>")));
        this.title = xmlString.substring(xmlString.indexOf("<title>") + title.length(), xmlString.indexOf("</title>"));
        this.year = Integer
                .parseInt(xmlString.substring(xmlString.indexOf("<year>") + 4, xmlString.indexOf("</year>")));
        this.availability = Boolean.parseBoolean(
                xmlString.substring(xmlString.indexOf("<availability>") + String.valueOf(availability).length(),
                        xmlString.indexOf("</availability>")));
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Boolean getAvailability() {
        return availability;
    }

    // abstract method that will be implemented in the subclasses and will return
    // the rental fee
    public abstract double getRentalFee();

    // abstract method to get the media type
    public abstract String getMediaType();

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

}