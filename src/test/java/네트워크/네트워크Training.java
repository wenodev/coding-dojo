package 네트워크;

import org.junit.jupiter.api.Test;

public class 네트워크Training {

    int n = 3;
    int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

    @Test
    void test(){
        int answer = 0;
        boolean visited[] = new boolean[3];
        for (int i=0; i<n; i++){
            if (!visited[i]){
                dfs(computer, visited, i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    void dfs(int[][] computer, boolean[] visited, int start) {
        visited[start] = true;

        /*
        {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}
        true, false, false // start = 0, i = 0
        true, false, false // start = 0, i = 1
        true, true, false // start = 1, i = 0
        true, true, false // start = 1, i = 1
        true, true, false // start = 1, i = 2
        true, true, false // start = 0, i = 2
         */
        for (int i=0; i<computer.length; i++){
            if (computer[start][i] == 1 && visited[i] == false){
                dfs(computer, visited, i);
            }
        }

    }


}
