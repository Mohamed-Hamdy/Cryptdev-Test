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

public class matrixRotationLayer {

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2, 3, 4));
        matrix.add(Arrays.asList(5, 6, 7, 8));
        matrix.add(Arrays.asList(9, 10, 11, 12));
        matrix.add(Arrays.asList(13, 14, 15, 16));
        int r = 2;
        matrixRotation(matrix, r);
        /*
        matrix.add(Arrays.asList(1, 2, 3, 4));
        matrix.add(Arrays.asList(7, 8, 9, 10));
        matrix.add(Arrays.asList(13, 14, 15, 16));
        matrix.add(Arrays.asList(19, 20, 21, 22));
        matrix.add(Arrays.asList(25, 26, 27, 28));
        int r = 7;
        matrixRotation(matrix, r);
        */
    }

    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        for (int layer = 0; layer < Math.min(m, n) / 2; layer++) {
            for (int i = 0; i < r; i++) {
                rotateLayer(matrix, layer);
            }
        }

        printMatrix(matrix);
    }

    static void rotateLayer(List<List<Integer>> matrix, int layer) {
        
        int m = matrix.size();
        int n = matrix.get(0).size();

        List<Integer> temp = new ArrayList<>();

        // Copy elements from top row
        for (int j = layer; j < n - layer; j++) {
            temp.add(matrix.get(layer).get(j));
        }

        // Copy elements from right column
        for (int i = layer + 1; i < m - layer - 1; i++) {
            temp.add(matrix.get(i).get(n - layer - 1));
        }

        // Copy elements from bottom row
        for (int j = n - layer - 1; j >= layer; j--) {
            temp.add(matrix.get(m - layer - 1).get(j));
        }

        // Copy elements from left column
        for (int i = m - layer - 2; i > layer; i--) {
            temp.add(matrix.get(i).get(layer));
        }

        // Left Rotate elements in temp array
        Collections.rotate(temp, -1);

        // Copy elements back into matrix
        int index = 0;

        // Top row
        for (int j = layer; j < n - layer; j++) {
            matrix.get(layer).set(j, temp.get(index++));
        }

        // Right column
        for (int i = layer + 1; i < m - layer - 1; i++) {
            matrix.get(i).set(n - layer - 1, temp.get(index++));
        }

        // Bottom row
        for (int j = n - layer - 1; j >= layer; j--) {
            matrix.get(m - layer - 1).set(j, temp.get(index++));
        }

        // Left column
        for (int i = m - layer - 2; i > layer; i--) {
            matrix.get(i).set(layer, temp.get(index++));
        }
    }

    static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
