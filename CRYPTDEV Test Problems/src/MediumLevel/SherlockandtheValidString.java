/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediumLevel;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Mohamed El Laithy
 */
public class SherlockandtheValidString {

    /*
        idea of Problem :
        If the count map has only one element, we output "YES" because all characters occur with the same frequency. 
        If the count map has more than 2 elements, we output "NO" because it's impossible to make all characters occur with the same frequency by removing only one character. Otherwise, we check if we can remove one character to make all remaining characters occur with the same frequency. 
        If we can, we output "YES"; otherwise, we output "NO".
    */
    public static String isVaild(String s) {
        String result = "";
        Map<Character, Integer> charsMap = new HashMap<>();

        // Step 1: put string chars in map
        for (char c : s.toCharArray()) {
            if (!charsMap.containsKey(c)) {
                charsMap.put(c, 1);
            } else {
                int count = charsMap.get(c);
                charsMap.put(c, count + 1);
            }
        }
        // Step 2: put all values in another map that refer to how many time this chars in charsMap
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int count : charsMap.values()) {
            countMap.put(count, countMap.getOrDefault(count, 0) + 1);
        }
        System.out.println(charsMap + " " + countMap);

        // Step 3: Make Conditions and return values 
        if (countMap.size() == 1) {
            result = "YES";
        } else if (countMap.size() > 2) {
            result = "NO";
        } else {
            // get maxCounter of keys and minCounter of keys then get maxValue and minValue of Freq depend on maxCounter and minCounter
            int maxCount = Collections.max(countMap.keySet());
            int minCount = Collections.min(countMap.keySet());
            
            // get freq of maxCounter and minCounter
            int maxFreqValue = countMap.get(maxCount);
            int minFreqValue = countMap.get(minCount);
            System.out.println(maxCount + " " + minCount + " " + maxFreqValue + " " + minFreqValue);

            if ((maxCount - minCount == 1 && maxFreqValue == 1) || (minCount == 1 && minFreqValue == 1 && maxFreqValue == 1)) {
                result = "YES";
            } else {
                result = "NO";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("Enter String Input:");
        s = scanner.nextLine();
        System.out.println(isVaild(s));
    }
}
