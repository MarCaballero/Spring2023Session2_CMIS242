/**
 * TemperatureConverter class that extends the Converter class (child class)
 */
public class TemperatureConverter extends Converter {
    //Subclass of Converter with additional attributes and methods
        //Private Attributes because are going to be unique to this class 
    private String unit; //C, F, K
    private double convertedValue; //this is the output of the converted value given user input
    private String convertedUnit; //C, F, K
    /**
     * Default constructor for object of class TemperatureConverter
     * @param value
     */
    public TemperatureConverter() {
        super();
        this.unit = "C";
        this.convertedUnit = "F";
    }
    /**
     * constructor for object of class TemperatureConverter with three parameters
     * @Overloading = Same Method name as constructor name BUT different parameters in the same class.
     * @param value = type double (value to convert)
     * @param unit = type String (unit of the value to convert - C, F, K)
     * @param convertedUnit = type String (unit to convert the value to - C, F, K)
     */
    public TemperatureConverter(double value, String unit, String convertedUnit) {
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
     * Method to convert temperature depending on the unit given (C, F, K)
     * This is a representation of Dynamic Binding
     * @Overriding = Same Method name as other super class BUT different activity within method.
     * @return convertedValue
     */
    public double convert(double value) {
        //if statement to check if the value is NaN
        if(Double.isNaN(value)) {
            return Double.NaN;
        //else statement to check if the unit of the value is C, F, or K
        }else{
            //if unit to convert is C then check for the conversion unit is for F or K degrees
            if(unit.equals("C")) {
                //if we want to convert to F then do the following to the value
                if(convertedUnit.equals("F")) {
                    convertedValue = value * 9 / 5 + 32;
                //if we want to convert to K then do the following to the value
                }else if(convertedUnit.equals("K")) {
                    convertedValue = value + 273.15;
                }
            //if unit to convert is F then check for the conversion unit is for C or K degrees
            }if(unit.equals("F")) {
                //if we want to convert to C then do the following to the value
                if(convertedUnit.equals("C")) {
                    convertedValue = (value - 32) * 5 / 9;
                //if we want to convert to K then do the following to the value
                }else if(convertedUnit.equals("K")) {
                    convertedValue = (value - 32) * 5 / 9 + 273.15;
                }
            //if unit to convert is K then check for the conversion unit is for C or F degrees
            }if(unit.equals("K")) {
                //if we want to convert to C then do the following to the value
                if(convertedUnit.equals("C")) {
                    convertedValue = value - 273.15;
                //if we want to convert to F then do the following to the value 
                }else if(convertedUnit.equals("F")) {
                    convertedValue = (value - 273.15) * 9 / 5 + 32;
                }
            }
            //return the converted value
            return convertedValue;
        }
    }
}
