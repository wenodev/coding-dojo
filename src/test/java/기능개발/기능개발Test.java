package 기능개발;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 기능개발Test {
    @Test
    void test_solution(){
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] result = solution(progresses, speeds);

        assertThat(result).containsExactly(2,1);

    }

    @Test
    void test_getResult(){
        List<Integer> days = List.of(7, 3, 9);
        List<Integer> result = getResult(days);

        assertThat(result).containsExactly(2, 1);
    }

    @Test
    void test_getDays(){
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        List<Integer> days = getDays(progresses, speeds);

        days.forEach(System.out::println);
        assertThat(days).containsExactly(7,3, 9);
    }


    private int[] solution(int[] progresses, int[] speeds) {
        List<Integer> days = getDays(progresses, speeds);
        List<Integer> result = getResult(days);

        int[] answer = new int[result.size()];
        for (int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    private List<Integer> getDays(int[] progresses, int[] speeds) {
        List<Integer> days = new ArrayList<>();
        for (int i=0; i<progresses.length; i++){
            int temp = progresses[i];
            int count = 0;
            while(temp < 100){
                count++;
                temp += speeds[i];
            }
            days.add(count);
        }
        return days;
    }

    private List<Integer> getResult(List<Integer> input) {
        List<Integer> days = new ArrayList<>(input);
        List<Integer> result = new ArrayList<>();

        while (days.size() > 0){

            if (days.size() == 1){
                result.add(1);
                break;
            }
            int count = 1;

            while (days.size() >= 2 && days.get(0) >= days.get(1) ){
                days.remove(1);
                count++;
            }
            days.remove(0);
            result.add(count);
        }
        return result;
    }

}
