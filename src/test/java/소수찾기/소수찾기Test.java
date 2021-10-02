package 소수찾기;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class 소수찾기Test {

    String numbers = "17";
    static boolean prime[] = new boolean[10000000];

    /*
    - String을 char배열로 바꾼다.
    - char 배열을 int로 바꾼다.
     */
    @Test
    void makeStringToInteger(){
        char[] charArray = numbers.toCharArray();
        int[] intArray = new int[charArray.length];

        for (int i=0; i<charArray.length; i++){
            intArray[i] = Character.getNumericValue(charArray[i]);
        }
        assertThat(intArray[0]).isEqualTo(1);
    }

    /*
    - '에라토스테네스의 체' 를 사용한다.
     */
    @Test
    void getPrimeNumber(){
        // 구하고자 하는 숫자 범위
        int N = 9999999;

        // 소수는 false
        // 1은 소수가 아니므로 제외
        prime[0] = prime[1] = true;

        for(int i=2; i*i<=N; i++){
            // prime[i]가 소수라면
            if(!prime[i]){
                // prime[j] 소수가 아닌 표시
                for(int j=i*i; j<=N; j+=i) prime[j] = true;
            }
        }

        // 소수 출력
        for(int i=1; i<=N;i++){
            if(!prime[i]) System.out.print(i+" ");
        }
    }

}