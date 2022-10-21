package at.ac.fhcampuswien;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Random;

public class App {
    public static int daysHelper = 0;

    // Implement all methods as public static

    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        System.out.println(Arrays.toString(lcg(888888888)));
        oneMonthCalendar(28,2);
        System.out.println(camelCase("Hallo ich bin Fredi"));



    }

    public static long[] lcg(long seed){
        long[] lngArr = new long[10];
        long m = (long) Math.pow(2,31);
        int c = 12345;
        long a = 1103515245;
        long x = seed;

        for(int i = 0; i < lngArr.length; i++){
            lngArr[i] = (a * x + c) % m;
            x = lngArr[i];
        }
        return lngArr;

    }

    public static boolean swapArrays(int[] a, int[] b){
        int aLength = 0;
        int bLength = 0;
        int helpA = 0;
        int helpB = 0;
        for(int i: a){
            aLength++;
        }
        for(int j: b){
            bLength++;
        }
        if(aLength != bLength){
            return false;
        }
        for(int x = 0; x < aLength; x++){
            helpA = a[x];
            helpB = b[x];
            a[x] = helpB;
            b[x] = helpA;
        }
        return true;
    }


    public static void oneMonthCalendar(int days, int start){
        int sp = start-1;
        int dayCnt = 1;
        int[][] prntArr = new int[5][7];

        for(int x = 0; x < prntArr.length; x++){
            for(int i = 0; i < prntArr[x].length; i++){
                if(sp > 0){
                    prntArr[x][i] = 0;
                    sp--;
                }
                else if(dayCnt > days){
                    prntArr[x][i] = 0;
                }
                else{
                    prntArr[x][i] = dayCnt;
                    dayCnt++;
                }
            }
        }
        for(int[] row: prntArr){
            printRow(row);
            System.out.println();
        }


    }

    public static void printRow(int[] row) {
    int help = 0;
    int cnt;
        for (int i = 0; i < row.length; i++) {
            help = row[i];
            if(help == 0 && daysHelper < 7) {
                System.out.print("   ");
            }else if(help == 0 && daysHelper > 7) {
                return;
            }else if(help < 10) {
                System.out.printf(" %d ", help);
            }
            else {
                System.out.printf("%d ", help);
            }
            daysHelper++;
        }
    }

    public static int randomNumberBetweenOneAndHundred(){
        Random rand = new Random();
        int min = 1;
        int max = 99;
        int randNumb = rand.nextInt(min + max) + min;
        return randNumb;
    }

    public static void guessingGame(int numberToGuess){
        int numberCount = 1;
        Scanner scn = new Scanner(System.in);
        int input = 0;
        if (numberToGuess > 100 || numberToGuess < 1){
            System.out.println("Please enter a number between 1 and 100!");
            return;
        }
        while(numberCount <= 10){
            System.out.print("Guess number " + numberCount + ": ");
            input = scn.nextInt();

            if (input > numberToGuess && numberCount == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                return;
            }
            else if (input < numberToGuess && numberCount == 10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                return;
            }
            else if(input < numberToGuess){
                System.out.println("The number AI picked is higher than your guess.");
            }else if (input > numberToGuess){
                System.out.println("The number AI picked is lower than your guess.");
            }
            else {
                System.out.println("You won wisenheimer!");
                return;
            }
            numberCount++;
            }
            System.out.print("You lost! Have you ever heard of divide & conquer?");
            return;
    }

    public static String camelCase(String a) {
        boolean space = true;
        char[] chArr = a.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i : chArr) {
            if(i == ' '){
                space = true;
            }
            if(space){
                if(i >= 'A' && i <= 'Z'){
                    sb.append((char) i);
                    space = false;
                }
                else if (i >= 'a' && i <= 'z'){
                    sb.append((char) (i - 32));
                    space = false;
                }
            }
            else {
                if (i >= 'A' && i <= 'Z'){
                    sb.append((char) (i + 32));
                }
                else if (i >= 'a' && i <= 'z'){
                    sb.append((char) i);
                }
            }
        }
        return sb.toString();

    }

    public static int checkDigit (int[] inputArr){
        int checkSum = 0;
        for (int i = 0; i < inputArr.length; i++){
            inputArr[i] *= i + 2;
            checkSum += inputArr[i];
        }

        checkSum = 11 - checkSum % 11;
        if (checkSum == 10) {
            return 0;
        }else if(checkSum == 11){
            return 5;
        }
        return checkSum;
    }

}