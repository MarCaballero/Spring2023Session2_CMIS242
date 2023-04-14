//Student: Maria Caballero
//Date: 10/1/2017
//Description: This program will print the Fibonacci sequence up to the nth term.
    //This is actually the most common assignment young developers are given 
    //when learning recursion
public class Fibonacci{
    public static int fibonacciRecursion(int n){
    if(n == 0){
        return 0;
    }
    if(n == 1 || n == 2){
            return 1;
    }
    return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
    }
    public static void main(String args[]) {
    int fibonacciNum = 10;
    System.out.print("Fibonacci Series of "+ fibonacciNum +" numbers: ");
    for(int i = 0; i <= fibonacciNum; i++){
            System.out.print(fibonacciRecursion(i) +" ");
        }
    }
}