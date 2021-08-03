package 키패드누르기;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 성능테스트 {
    private int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};

    @Test
    void test_performance_array_to_list_single(){
        long startTime = System.nanoTime();
        test_array_to_list_single();
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("single : " + estimatedTime);
    }

    void test_array_to_list_single(){
        Arrays.stream(numbers)
                .filter(n -> n == 1 || n == 4 || n == 7);
    }

    @Test
    void test_performance_array_to_list_multiple(){
        long startTime = System.nanoTime();
        test_array_to_list_multiple();
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("multiple : " + estimatedTime);
    }

    void test_array_to_list_multiple(){
        Arrays.stream(numbers)
                .parallel()
                .filter(n -> n == 1)
                .filter(n -> n == 4)
                .filter(n-> n == 7);
    }
}
