package ezsw.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 함수를 끝내는 코드 영역을 base case 라고 한다.
 */
class FactorialTest {

    @Test
    void start(){
        int sum = factorial(5);
        System.out.println(sum);
    }

    private int factorial(int number) {
        if (number == 1){
            return 1;
        }
        return number + factorial(number - 1);
    }

}