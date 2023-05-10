public class Snake extends Pet{

    // attributes
    private double length; // in feet

    // constructor
    public Snake(int id, String name, double length){
        super(id, name);
        this.length = length;
    }

    // constructor to parse string with xml tags for its values
    public Snake(String line){
        super(line);
        length = Double.parseDouble(line.substring(line.indexOf("<length>") + 8, line.indexOf("</length>")));
    }

    // get method for length
    public double getLength(){
        return length;
    }

    // set method for length
    public void setLength(double length){
        this.length = length;
    }

    // toString method
    public String toString(){
        return "<Snake>"
                + "<id>" + getId() + "</id>"
                + "<name>" + getName() + "</name>"
                + "<length>" + length + "</length>"
                + "</Snake>";
    }
}