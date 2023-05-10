/**
 * Converter class (Parent class)
 */
public class Converter {
    //Attributes
    private double value;
    /**
     * Default constructor for object of class Converter
     */
    public Converter() {
        this.value = Double.NaN;
    }
    /**
     * Overload constructor for object of class Converter
     * @param value
     */
    public Converter(double value) {
        this.value = value;
    }

    /**
     * Get method for value
     * @return the value
     */
    public double getValue() {
        return value;
    }
    /**
     * Set method for value
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }
    /**
     * Convert method
     * @return the converted value
     */
    public double convert() {
        if(Double.isNaN(value)) {
            return Double.NaN;
        }else{
            return value;
        }
    }
}