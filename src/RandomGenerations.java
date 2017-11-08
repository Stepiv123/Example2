import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * <b>Description:</b>Class contains methods of prime number generations
 *
 * @author Ivan Stepanov
 * @version 1.05
 * @see Scanner
 */
public class RandomGenerations {

    /**
     * <b>Description:</b>Generate random Prime number in [2..10e9]
     *
     * @return result prime number
     */
    public static int getRandomPrime() {
        Random rand = new Random();

        return getNext(rand.nextInt((int) 10e9) - 1);
    }

    /**
     * <b>Description:</b>Generate array of random Prime number
     *
     * @param length set length of array
     * @return array of prime numbers
     */
    public static int[] getRandomArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = getRandomPrime();
        }
        Arrays.sort(arr);
        return arr;
    }

    /**
     * <b>Description:</b>Return next prime number after specified number
     *
     * @param prime natural number greater than 1 that has no positive divisors other than 1 and itself.
     * @return generated number
     */
    private static int getNext(int prime) {
        if (prime < 2) {
            return 2;
        }
        do {
            prime++;
        }
        while (!isPrime(prime));
        return prime;
    }

    /**
     * <b>Description:/b> Check number for primary
     *
     * @param arg0 checked number
     * @return check result
     */
    private static boolean isPrime(int arg0) {
        /*extract variable*/
        final boolean isLow = arg0 <= 3;
        if (isLow || isEven(arg0)) {
            return arg0 == 2 || arg0 == 3;
        }
        for (int i = 3; i * i <= arg0; i += 2) {
            if (arg0 % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * <b>Description:</b> Define even
     *
     * @param arg0 checked number
     * @return checking result
     */
    private static boolean isEven(int arg0) {
        /*replace temp with query*/
        return arg0 % 2 == 0;
    }

    /**
     * <b>Description:</b> Main method
     *
     * @param args command line params
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        print("Welcome to RandomArrayProject");
        print("Enter length of array:");
        while (!scan.hasNextInt()) {
            scan.next();
            print("Int not find, try else:");
        }
        /*extract variable*/
        int length = scan.nextInt();
        print(getArray(length));
    }

    /**
     * <b>Description:</b>Get String contain random array of prime numbers
     *
     * @param length of array
     * @return array
     */
    private static String getArray(int length) {
        /*extract method*/
        return Arrays.toString(getRandomArray(length));
    }

    /**
     * <b>Description:</b> Print to console
     *
     * @param x printed string
     */
    private static void print(String x) {
        /*extract method*/
        System.out.println(x);
    }
}
