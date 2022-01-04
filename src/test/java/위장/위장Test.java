package 위장;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class 위장Test {
    String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
    int result = 5;

    @Test
    void 경우의_수_구하기(){
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (Integer value : new ArrayList<>(map.values())){
            answer *= value + 1;
        }

        answer = answer-1;

        assertThat(answer).isEqualTo(result);
    }

}
