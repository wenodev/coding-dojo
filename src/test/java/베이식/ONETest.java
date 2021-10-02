package 베이식;


import org.junit.jupiter.api.Test;

class ONETest {

    int[] v = {20,8,10,1,4,15};

    @Test
    void solution(){
        int answer = 0;
        boolean[] visited = new boolean[v.length];

        for(int r = 1; r <= v.length ; r++) {
            System.out.println("\n" + v.length + "개 중에 " + r  + "개 뽑음");
            getArray(v, visited, 0, r);
        }
    }

    private void getArray(int[] arr, boolean[] visited, int depth, int r) {
        if(r == 0) {
            print(arr, visited);
            return;
        }
        if(depth == arr.length) {
            return;
        } else {
            visited[depth] = true;
            getArray(arr, visited, depth + 1, r - 1);

            visited[depth] = false;
            getArray(arr, visited, depth + 1, r);
        }
    }

    static void print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
