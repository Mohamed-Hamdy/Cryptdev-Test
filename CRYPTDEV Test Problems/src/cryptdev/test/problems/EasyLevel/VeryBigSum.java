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
public class VeryBigSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        long sum = 0;
        // must use long instead of int becouse int is 32 bits in width while long is 64 bits in width
        List<Long> arr = new ArrayList<>();
        System.out.println("Enter elements of the array:");

        for (int i = 0; i < size; i++) {
            arr.add(scanner.nextLong());
        }

        for (int i = 0; i < size; i++) {
            sum += arr.get(i);
        }
        System.out.println("Sum of array = " + sum);

    }

}
