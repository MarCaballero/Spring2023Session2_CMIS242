public class Profit{
    public static void main(String[] args){
        int numStores = 25; //number of the many stores there are
        int numMonths = 12; //number of months in a year
        double[][] profit = new double[numStores][numMonths]; //2D array of the profits of each store for each month
        double totalProfit = 0; //Company's total profit in 2014
        int store, month; //loop control variables

        //use random generated data to load into the profit table
        for(store = 0; store < numStores; store++){
            for(month = 0; month < numMonths; month++){
                profit[store][month] = (int) (Math.random() * 100 + 25); //values between 25 and 125
            }
        }

        //print the values in formatted table
        for(store = 0; store < numStores; store++){
            for(month = 0; month < numMonths; month++){
                System.out.printf("$%7.2f\t", profit[store][month]);
            }
            System.out.println();
        }

        //calculate the total profit
        for(store = 0; store < 25; store++){
            for(month = 0; month < 12; month++){
                totalProfit += profit[store][month];
            }
        }

        //print the total profit
        System.out.printf("\nTotal profit for the year 2014: $%.0f in thousands", totalProfit);

        //calculate December profit
        double decemberProfit = 0;
        int storeNum;
        for(storeNum = 0; storeNum < numStores; storeNum++){
            decemberProfit += profit[storeNum][11];
        }

        //print the December profit
        System.out.printf("\nTotal profit for December 2014: $%.0f in thousands", decemberProfit);
    }
}