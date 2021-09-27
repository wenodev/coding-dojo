package ezsw.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 주어진 함수를 1로 다 변경하라, 단 1로 이미 되어있는곳은 지날 수 없다.
 */
class FloodFillTest {

    @Test
    void start(){
        int[][] arr = {
                {0,0,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,0},
                {1,1,1,1,0},
                {0,0,0,0,0},
        };
        fill(arr,4, 3);
        printArr(arr);
    }

    private void fill(int[][] arr, int x, int y) {
        if (x < 0 || x > arr.length - 1 || y < 0 || y > arr.length - 1){
            return;
        }
        if (arr[x][y] != 0){
            return;
        }

        arr[x][y] = 1;

        fill(arr, x, y+1);
        fill(arr, x, y-1);
        fill(arr, x-1, y);
        fill(arr, x+1, y);
    }

    private void printArr(int[][] arr) {
        for (int i=0; i< arr.length; i++){
            for (int j=0; j<arr.length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

}