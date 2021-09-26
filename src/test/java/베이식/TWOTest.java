package 베이식;

import org.junit.jupiter.api.Test;

/*
- 10 : 1
11 : 0
12 : 1
13 : 1
 */
class TWOTest {
    int n = 11;

    @Test
    void test(){
        StringBuilder stringBuilder = new StringBuilder();
        int sum = 0;
        int result = 0;
        for (int i=1; i<= n; i++){
            if (sum > n){
                break;
            }
            String strNumber = String.valueOf(i);
            sum += strNumber.length();
            result = i;
        }
        System.out.println("result: " + result);
//        System.out.println(Character.getNumericValue(stringBuilder.charAt(n-1)));

    }


}