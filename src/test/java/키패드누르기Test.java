import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class 키패드누르기Test {

    private int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
    private String hand= "left";
    private static int[][] button = {
            {3,1},
            {0,0},
            {0,1},
            {0,2},
            {1,0},
            {1,1},
            {1,2},
            {2,0},
            {2,1},
            {2,2},
    };

    @Test
    void test_키패드누르기(){

        StringBuilder answer = new StringBuilder();
        int[] currentLeft = {3,0};
        int[] currentRight = {3,2};

        for (int i=0; i<numbers.length; i++){
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer.append("L");
                currentLeft = button[numbers[i]];
            }else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer.append("R");
                currentRight = button[numbers[i]];
            }else{
                if (getDistance(currentLeft, button[numbers[i]]) < getDistance(currentRight, button[numbers[i]])){
                    answer.append("L");
                    currentLeft = button[numbers[i]];
                }else if (getDistance(currentLeft, button[numbers[i]]) > getDistance(currentRight, button[numbers[i]])){
                    answer.append("R");
                    currentRight = button[numbers[i]];
                }else{
                    if (hand.equals("right")){
                        answer.append("R");
                        currentRight = button[numbers[i]];
                    }else{
                        answer.append("L");
                        currentLeft = button[numbers[i]];
                    }
                }
            }
        }

        assertThat(answer.toString()).isEqualTo("LRLLRRLLLRR");

        System.out.println("answer: " + answer);

    }

    int getDistance (int[] start, int[] destination) {
        return Math.abs(start[0] - destination[0]) + Math.abs(start[1] - destination[1]);
    }

}
