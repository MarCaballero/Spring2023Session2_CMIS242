public class Pet{
    // attributes
    private int id;
    private String name;

    // constructor
    public Pet(int id, String name){
        this.id = id;
        this.name = name;
    }

    // constructor to parse string with xml tags for its values
    public Pet(String line){
        id = Integer.parseInt(line.substring(line.indexOf("<id>") + 4, line.indexOf("</id>")));
        name = line.substring(line.indexOf("<name>") + 6, line.indexOf("</name>"));
    }

    // get method for id
    public int getId(){
        return id;
    }

    // get method for name
    public String getName(){
        return name;
    }

    // set method for id
    public void setId(int id){
        this.id = id;
    }

    // set method for name
    public void setName(String name){
        this.name = name;
    }
}