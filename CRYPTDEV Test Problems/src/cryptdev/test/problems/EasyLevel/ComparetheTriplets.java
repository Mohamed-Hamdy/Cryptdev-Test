/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptdev.test.problems.EasyLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mohamed El Laithy
 */
public class ComparetheTriplets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        test cases:
            17 28 30
            99 16 8
            output = 2 1
        */
        Scanner scanner = new Scanner(System.in);
        int arrayCounter1 = 0;
        int arrayCounter2 = 0;

        List<Integer> array1 = new ArrayList<>();
        List<Integer> array2 = new ArrayList<>();

        System.out.println("Enter elements of the array1:");
        for (int i = 0; i < 3; i++) {
            array1.add(scanner.nextInt());
        }

        System.out.println("Enter elements of the array2:");
        for (int i = 0; i < 3; i++) {
            array2.add(scanner.nextInt());
        }

        // get counter value of two array 
        for (int i = 0; i < 3; i++) {
            if (array1.get(i) > array2.get(i)) {
                arrayCounter1++;
            } else if (array1.get(i) < array2.get(i)) {
                arrayCounter2++;
            }
        }
        System.out.println(arrayCounter1 + " " + arrayCounter2);

    }

}
