package 키패드누르기;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 키패드누르기_Refactor {
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

    private static int[] currentLeft = {3,0};
    private static int[] currentRight = {3,2};

    @Test
    void test_키패드누르기(){

        StringBuilder answer = new StringBuilder();

        for (int number : numbers){
            switch(number){
                case 1:
                case 4:
                case 7:
                    setLeft(answer, number);
                    break;
                case 3:
                case 6:
                case 9:
                    setRight(answer, number);
                    break;
                case 0:
                case 2:
                case 5:
                case 8:
                    if (getDistance(currentLeft, button[number]) < getDistance(currentRight, button[number])){
                        setLeft(answer, number);
                    }
                    if (getDistance(currentLeft, button[number]) > getDistance(currentRight, button[number])){
                        setRight(answer, number);
                    }
                    if(getDistance(currentLeft, button[number]) == getDistance(currentRight, button[number])) {
                        answer = hand.equals("right") ? setRight(answer, number) : setLeft(answer, number);
                    }
                    break;
                default:
                    new RuntimeException();
            }
        }

        assertThat(answer.toString()).isEqualTo("LRLLRRLLLRR");
        System.out.println("answer: " + answer);
    }

    StringBuilder setLeft(StringBuilder answer, int number) {
        currentLeft = button[number];
        return answer.append("L");
    }

    StringBuilder setRight(StringBuilder answer, int number) {
        currentRight = button[number];
        return answer.append("R");
    }

    int getDistance (int[] start, int[] destination) {
        return Math.abs(start[0] - destination[0]) + Math.abs(start[1] - destination[1]);
    }
}
