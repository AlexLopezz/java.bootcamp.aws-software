package excercise4;

public class Node {
    private final int element;
    private Node sonleft;
    private Node sonRigth;

    public Node(int element) {
        this.element = element;
    }

    public int getElement() {
        return element;
    }

    public Node getSonleft() {
        return sonleft;
    }

    public void setSonleft(Node sonleft) {
        this.sonleft = sonleft;
    }

    public Node getSonRigth() {
        return sonRigth;
    }

    public void setSonRigth(Node sonRigth) {
        this.sonRigth = sonRigth;
    }
}
