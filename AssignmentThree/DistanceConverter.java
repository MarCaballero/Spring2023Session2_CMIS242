/**
 * DistanceConverter class that extends Converter class (child class)
 */
public class DistanceConverter extends Converter{
    //Subclass of Converter with additional attributes and methods
        //Private Attributes because are going to be unique to this class
    private String unit; //m, km, cm
    private double convertedValue; //this is the output of the converted value given user input
    private String convertedUnit; //m, km, cm
    /**
     * Default constructor for object of class DistanceConverter
     * @param value
     */
    public DistanceConverter() {
        super();
        this.unit = "mi";
        this.convertedUnit = "km";
    }
    /**
     * constructor for object of class DistanceConverter with three parameters
     * @Overloading = Same Method name as constructor name BUT different parameters in the same class.
     * @param value = type double (value to convert)
     * @param unit = type String (unit of the value to convert - m, km, cm)
     * @param convertedUnit = type String (unit to convert the value to - m, km, cm)
     */
    public DistanceConverter(double value, String unit, String convertedUnit) {
        super(value);
        this.unit = unit;
        this.convertedUnit = convertedUnit;
    }
    /**
     * Get method for the unit to convert
     * This is a representation of Dynamic Binding
     * @Overriding = Same Method name as other super class AND same activity within method.
     * @return String unit
     */
    public String getUnit(){
        return this.unit;
    }
    /**
     * Get method for the converted unit
     * This is a representation of Dynamic Binding
     * @Overriding = Same Method name as other super class AND same activity within method.
     * @return String convertedUnit
     */
    public String getConvertedUnit(){
        return this. convertedUnit;
    }
    /**
     * Method to convert distance depending on the unit given (m, km, cm)
     * This is a representation of Dynamic Binding
     * @Overriding = Same Method name as other super class BUT different activity within method.
     * @return convertedValue
     */
    public double convert(double value) {
        //if statement to check if the value is NaN
        if(Double.isNaN(value)) {
            return Double.NaN;
        //else statement to check if the unit of the value is m, km, or cm
        }else{
            //if unit to convert is m then check for the conversion unit is for km or cm
            if(unit.equals("mi")) {
                //if we want to convert to km then do the following to the value
                if(convertedUnit.equals("km")) {
                    convertedValue = value * 1.609;
                //if we want to convert to cm then do the following to the value
                }else if(convertedUnit.equals("cm")) {
                    convertedValue = value * 160900;
                }
            //if unit to convert is km then check for the conversion unit is for m or cm
            }else if(unit.equals("km")) {
                //if we want to convert to m then do the following to the value
                if(convertedUnit.equals("mi")) {
                    convertedValue = value / 1.609;
                //if we want to convert to cm then do the following to the value
                }else if(convertedUnit.equals("cm")) {
                    convertedValue = value * 100000;
                }
            //if unit to convert is cm then check for the conversion unit is for m or km
            }else if(unit.equals("cm")) {
                //if we want to convert to m then do the following to the value
                if(convertedUnit.equals("mi")) {
                    convertedValue = value / 160900;
                //if we want to convert to km then do the following to the value
                }else if(convertedUnit.equals("km")) {
                    convertedValue = value / 100000;
                }
            }
            //return the converted value
            return convertedValue;
        }
    }
    
}
