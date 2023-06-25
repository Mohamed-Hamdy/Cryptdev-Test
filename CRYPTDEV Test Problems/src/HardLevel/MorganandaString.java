/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HardLevel;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author Mohamed El Laithy
 */
import java.util.*;

public class MorganandaString {

    static String morganAndString(String a, String b) {

        int l1 = a.length();
        int l2 = b.length();

        StringBuilder s = new StringBuilder("");
        int flag = 0;

        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        // push first string to stack (reverse push operation)
        for (int i = l1 - 1; i >= 0; i--) {
            s1.push(a.substring(i, i + 1));
        }
        // push second string to stack (reverse push operation)

        for (int i = l2 - 1; i >= 0; i--) {
            s2.push(b.substring(i, i + 1));
        }

        while (!s1.isEmpty() && !s1.isEmpty()) {
            String v1 = s1.peek();
            String v2 = s2.peek();
            if (v1.compareTo(v2) > 0) {
                s.append(s2.pop());
            } else if (v1.compareTo(v2) < 0) {
                s.append(s1.pop());
            } else {
                s.append(s1.pop());
            }
        }
        while (!s1.isEmpty()) {
            s.append(s1.pop());

        }
        while (!s2.isEmpty()) {
            s.append(s2.pop());
        }

        String ans = s.toString();
        return ans;
    }

    public static void main(String[] args) {
        /* test cases 
        case 1 : 
        2
        JACK
        DANIEL
        ABACABA
        ABACABA
        case 2 :
        
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of test cases : ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter String one in iteration " + (i + 1));
            String a = scanner.nextLine();
            System.out.println("Enter String two in iteration " + (i + 1));

            String b = scanner.nextLine();

            String result = morganAndString(a, b);

            System.out.println("The result of iteration " + i + 1 + " is :" + result);
            System.out.println();
        }
    }
}
