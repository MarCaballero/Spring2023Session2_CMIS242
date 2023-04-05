
public class Weight {

    // Here I am leaving pounds and ounces as private attributes
    private int pounds;
    private int OUNCES_IN_POUND = 16;
    public double ounces;

    public Weight(int pounds, double ounces) {
        this.pounds = pounds;
        this.ounces = ounces;
        normalize();
    }

    private double ToOunces() {
        return pounds * OUNCES_IN_POUND;
    }

    private void normalize() {
        pounds += (int) ounces / OUNCES_IN_POUND;
        ounces = ounces % OUNCES_IN_POUND;
    }

    public boolean lessThan(Weight other) {
        if (ToOunces() < other.ToOunces()) {
            return true;
        } else {
            return false;
        }
    }

    public void addTo(Weight other) {
        ounces += other.ounces;
        pounds += other.pounds;
    }

    public String toString() {
        return pounds + " pounds and " + ounces + " ounces";
    }
}