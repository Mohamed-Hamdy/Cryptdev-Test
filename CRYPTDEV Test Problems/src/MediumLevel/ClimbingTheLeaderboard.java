/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediumLevel;

import java.util.*;

/**
 *
 * @author Mohamed El Laithy
 */


public class ClimbingTheLeaderboard {

    public static void main(String[] args) {
        List<Integer> ranked = new ArrayList<>();
        List<Integer> player = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Size of Array 1 :");
        int n = scanner.nextInt();
        System.out.println("Enter Ranked Array :");

        for (int i = 0; i < n; i++) {
            ranked.add(scanner.nextInt());
        }

        System.out.println("Enter Size of Array 2 :");
        int m = scanner.nextInt();
        System.out.println("Enter Player Array :");
        for (int i = 0; i < m; i++) {
            player.add(scanner.nextInt());
        }
        result = climbingLeaderboard(ranked, player);
        System.out.println(result);
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> rankedMap = new HashMap<>();
        // step 1 remove duplicated rankes
        List<Integer> uniqueRanked = new ArrayList<>(new HashSet<>(ranked));

        // step 2 sort list reverse
        Collections.sort(uniqueRanked, Collections.reverseOrder());
        Collections.sort(player);
        int rank = 1;
        for (int r : uniqueRanked) {
            rankedMap.put(rank, r);
            rank++;
        }
        // put rankes with score
        boolean flag = false;
        int index = 1; // it's used for elements that not found in map and cursor at the end
        for (int i = 0; i < player.size(); i++) {
            for (Map.Entry<Integer, Integer> entry : rankedMap.entrySet()) {
                // if player score is larger than ranked value so it mean the player score should be at the same place that the ranked value (should be swapped with it)
                if (player.get(i) >= entry.getValue() ) {
                    // System.out.print(entry.getKey() + " ");
                    result.add(entry.getKey());
                    flag = true;
                    break;
                }else{
                    index = entry.getKey();
                }
            }
            // System.out.println("index : " + index);
            
            if(flag == false){
                result.add(++index);
            }
        }

        System.out.println(rankedMap);

        return result;

    }
}
