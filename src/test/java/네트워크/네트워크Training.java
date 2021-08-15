package 네트워크;

import org.junit.jupiter.api.Test;

public class 네트워크Training {

    int n = 3;
    int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

    @Test
    void test(){
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i=0; i < n; i++){
            if (!visited[i]){
                dfs(computer, visited, i);
                answer++;
            }
        }

    }

    void dfs(int[][] computer, boolean[] visited, int count) {
        visited[count] = true;

    }


}
