package 네트워크;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class 네트워크Test {
    int n = 3;
    int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

    @Test
    void test(){
        int answer = 0;
        boolean[] check = new boolean[n];
        for (int i=0; i<n; i++){
            if (!check[i]){
                dfs(computer, check, i);
                answer++;
            }

        }

        System.out.println("answer: " + answer);

    }

    void dfs(int[][] computer, boolean[] check, int start) {
        check[start] = true;

        for (int i=0; i<computer.length; i++){
            if (computer[start][i] == 1 && !check[i]){
                dfs(computer, check, i);
            }
        }
    }

}
