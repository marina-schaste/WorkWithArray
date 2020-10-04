package com.company;

import java.util.Scanner;

public class WorkWithArrays {
    public void start() {
        int[] arr;
        String sNun;
        int n;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Enter numbers of array: ");
            sNun = in.nextLine();
            n = checking(sNun);
        } while (n<0);

        arr = new int [n];
        for (int i = 0; i < n; i++)  {
            arr[i] = i+1;
        }

        printArr(arr);

        int random_number = random(0, n-1);
        System.out.println("Random item: " + arr[random_number]);

        arr = removeItem(arr, random_number);
        printArr(arr);

        int[] massNew = arrShuffle(arr);
        printArr(massNew);

        int summMas = (1 + n) * n /2;  //amount 1 array
        int summMassNew = arraySum(massNew); //amount 2 array
        int abandonedItem = summMas - summMassNew; //find the item
        
        System.out.println("Random item: " + abandonedItem);
    }
    public int checking(String s) {  //checking on number and number>10
        int intS;
        try {
            intS = Integer.parseInt(s);
        } catch(NumberFormatException e) {
            System.out.println("It isn't a integer. Input only integers.");
            return -1;
        } catch(NullPointerException e) {
            System.out.println("It isn't a integer. Input only integers.");
            return -1;
        }
        if ((intS > 10)) {
            return intS;
        } else {
            System.out.println("Your number should be more than 10.");
            return -1;
        }
    }
    public int[] arrShuffle(int[] intArr) {  //mix array items
        int x, y;
        for (int i = 0; i < intArr.length; i++)  {
            x = random(0, intArr.length-1);
            if (x != i) {
                y = intArr[i];
                intArr[i] = intArr[x];
                intArr[x] = y;
            }
        }
        return intArr;
    }
    public int random(int a, int b) {  //random
        return a + (int) (Math.random() * b);
    }
    public void printArr(int[] arr) { //print array
        System.out.println();
        for (int i = 0; i < arr.length; i++)  {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
    public int[] removeItem(int[] arr, int x) {   //remove item by index
        int[] futureArr = new int[arr.length - 1];

        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == x) {
                continue;
            }
            futureArr[k++] = arr[i];
        }
        return futureArr;
    }
    public int arraySum(int[] arr) {    //sum items in array
        int sum = 0;
        for (int i = 0, k = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }
}
