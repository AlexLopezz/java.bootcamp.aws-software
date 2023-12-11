package excercise4;

public class Demo {
    public static void main(String[] args) {
        ITreeable myBinaryTree = new BinaryTree();

        //Insertamos elementos al arbol binario.
        myBinaryTree.insert(400);
        myBinaryTree.insert(100);
        myBinaryTree.insert(200);
        myBinaryTree.insert(700);
        myBinaryTree.insert(50);
        myBinaryTree.insert(75);

        System.out.println("*Elementos insertados --> "+ myBinaryTree);

        System.out.println("--- Recorrido de arbol binario ---");
        //Se visitara el nodo, antes de las llamadas recursivas
        System.out.println("> PreOrder: ");
        myBinaryTree.preOrder();

        //Se visitara el nodo, entre las llamadas recursivas
        System.out.println("> InOrder: ");
        myBinaryTree.inOrder();

        //Se visitara el nodo, despues de las llamadas recursivas.
        System.out.println("> PostOrder: ");
        myBinaryTree.postOrder();
    }
}
