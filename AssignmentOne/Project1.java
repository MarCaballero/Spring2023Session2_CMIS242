//Student Name: 	Maria Caballero
//Date:     03/22/2023
//Course:   CMIS 242
/*
 * Note: Here is the code without making pounds and ounces public attributes.
 * Therefore, the division of the 3 weights cannot be done, just the addition of pounds and ounces.
 */

public class Project1 {
    private Weight findMinimum(Weight w1, Weight w2, Weight w3) {
        if (w1.lessThan(w2) && w1.lessThan(w3)) {
            return w1;
        } else if (w2.lessThan(w1) && w2.lessThan(w3)) {
            return w2;
        } else {
            return w3;
        }
    }
    private Weight findMaximum(Weight w1, Weight w2, Weight w3) {
        if (!w1.lessThan(w2) && !w1.lessThan(w3)) {
            return w1;
        } else if (!w2.lessThan(w1) && !w2.lessThan(w3)) {
            return w2;
        } else {
            return w3;
        }
    }
    private Weight findAverage(Weight w1, Weight w2, Weight w3) {
        Weight sum = new Weight(0,0);
        sum.addTo(w1);
        sum.addTo(w2);
        sum.addTo(w3);
        return sum;
    }
    public static void main(String[] args) {
        Weight w1 = new Weight(11, 3);
        Weight w2 = new Weight(7, 20);
        Weight w3 = new Weight(14, 6);
        Project1 min1 = new Project1();
        System.out.println("The minimum weight is " + min1.findMinimum(w1, w2, w3));
        Project1 max1 = new Project1();
        System.out.println("The maximum weight is " + max1.findMaximum(w1, w2, w3));
        Project1 avg1 = new Project1();
        System.out.println("The average weight is " + avg1.findAverage(w1, w2, w3));

        System.out.println();

        Weight w4 = new Weight(12, 8);
        Weight w5 = new Weight(18, 14);
        Weight w6 = new Weight(30, 20);
        Project1 min2 = new Project1();
        System.out.println("The minimum weight is " + min2.findMinimum(w4, w5, w6));
        Project1 max2 = new Project1();
        System.out.println("The maximum weight is " + max2.findMaximum(w4, w5, w6));
        Project1 avg2 = new Project1();
        System.out.println("The average weight is " + avg2.findAverage(w4, w5, w6));

        System.out.println();

        Weight w7 = new Weight(24, 17);
        Weight w8 = new Weight(9, 20);
        Weight w9 = new Weight(3, 10);
        Project1 min3 = new Project1();
        System.out.println("The minimum weight is " + min3.findMinimum(w7, w8, w9));
        Project1 max3 = new Project1();
        System.out.println("The maximum weight is " + max3.findMaximum(w7, w8, w9));
        Project1 avg3 = new Project1();
        System.out.println("The average weight is " + avg3.findAverage(w7, w8, w9));

    }
}
