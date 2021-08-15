package 타겟넘버;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/*
- 모든 경우의 수를 비교해야 한다.
- 그래프 탐색이 필요하다.
- 깊이 우선 탐색 vs 너비 우선 탐색
- 모든 노드를 방문 하고자 할 떄에는 깊이 우선 탐색을 사용한다.
- 속도는 넓이 우선 탐색이 더 빠르다.
- 너비 우선 탐색은 최단 경로를 찾을 때 활욯 한다.
- 만들어진 리프노드가 모든 경우의 수가 된다.
 */
class 타겟넘버Test {

    private int[] numbers = {1, 1, 1, 1, 1};
    private int target = 3;

    @Test
    void test_solution(){
        Node node = new Node(0);

        for (int number : numbers){
            node.addNode(node, number);
        }

        int answer = node.countTarget(node, target);
        assertThat(answer).isEqualTo(5);

    }

}

class Node{
    private Node leftNode;
    private Node rightNode;
    private Integer value;

    public Node getLeftNode() {
        return leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public Integer getValue() {
        return value;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node(Integer value){
        this.value = value;
    }

    public void addNode(Node node, Integer number) {
        if (node.isEnded(node)){
            node.setLeftNode(new Node(node.getValue() - number));
            node.setRightNode(new Node(node.getValue() + number));
            return;
        }
        node.addNode(node.getLeftNode(), number);
        node.addNode(node.getRightNode(), number);
    }

    private boolean isEnded(Node node) {
        return node.getLeftNode() == null && node.getRightNode() == null ? true : false;
    }

    /*
    - 리프 노드만 비교 한다.
     */
    public int countTarget(Node node, int target){
        if (node.isEnded(node)){
            return node.getValue() == target ? 1 : 0;
        }
        return countTarget(node.getLeftNode(), target) + countTarget(node.getRightNode(), target);
    }
}
