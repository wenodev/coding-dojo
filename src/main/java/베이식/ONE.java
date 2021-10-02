package 베이식;

public class ONE {

    static int result = 0;

    public static void main(String[] args) {
        int[] array = new int[] {20,8,10,1,4,15};
        int length = array.length;
        int[] output = new int[length];
        boolean[] visited = new boolean[length];

        getArray(array, output, visited, 0, length, length);
        System.out.println(result);
    }

    public static void getArray(int[] array, int[] output, boolean[] visited, int depth, int length, int count) {
        if(count==0) {
            if (result < calculate(output)){
                result = calculate(output);
            }
            return;
        }
        for(int i=0; i<length; i++) {
            if(visited[i]!=true) {
                visited[i] = true;
                output[depth] = array[i];
                getArray(array, output, visited, depth+1, length, count-1);
                visited[i] = false;
            }
        }
    }

    public static int calculate(int[] array){
        int sum = 0;
        for (int i=1; i<array.length; i++){
            sum += Math.abs(array[i-1] - array[i]);
        }
        return sum;
    }

}
