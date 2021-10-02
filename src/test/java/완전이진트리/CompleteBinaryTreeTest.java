package 완전이진트리;

import org.junit.jupiter.api.Test;

class CompleteBinaryTreeTest {

    String message = "ABCDEF";

    @Test
    void test(){
        int SIZE = message.length();
        char[][] tree = new char[SIZE][2];
        for (int i=0; i<SIZE; i++){
            tree[i][1] = message.charAt(i+1);
            tree[i][2] = message.charAt(i+2);
        }

    }

}