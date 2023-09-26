package excercise4;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree implements ITreeable{
    private Node root;
    private List<Integer> elements;
    public BinaryTree() {
        elements = new LinkedList<>();
    }

    public BinaryTree(Node node) {
        this.root = node;
    }

    @Override
    public void insert(int number) {
        elements.add(number);
        Node nodeToInsert = new Node(number);

        if(root == null)
            root = nodeToInsert;
        else {
            Node parentNode = getParentNode(nodeToInsert);

            //Una vez obtenido el padre de nuestro nodo a insertar, debemos indicar que tipo de hijo sera.
            if (nodeToInsert.getElement() < parentNode.getElement()) {
                parentNode.setSonleft(nodeToInsert); //A la izquierda, iran los hijos con los valores menores
            } else {
                parentNode.setSonRigth(nodeToInsert); //A la derecha, iran los hijos con valores mayores
            }
        }
    }

    @Override
    public void preOrder() {
        showPreOrder(root);
        System.out.println();
    }

    private void showPreOrder(Node node) {
        if(node != null) {
            System.out.printf("{%d} - ", node.getElement());
            showPreOrder(node.getSonleft());
            showPreOrder(node.getSonRigth());
        }
    }

    @Override
    public void inOrder() {
        showInOrder(root);
        System.out.println();
    }

    private void showInOrder(Node node) {
        if(node != null) {
            showInOrder(node.getSonleft());
            System.out.printf("{%d} - ", node.getElement());
            showInOrder(node.getSonRigth());
        }
    }

    @Override
    public void postOrder() {
        showPostOrder(root);
    }
    private void showPostOrder(Node node){
        if(node != null){
            showPostOrder(node.getSonleft());
            showPostOrder(node.getSonRigth());
            System.out.printf("{%d} - ", node.getElement());
        }
    }

    private Node getParentNode(Node nodeToInsert){
        Node aux = root, //Con el nodo auxiliar, vamos a recorrer nuestro arbol binario.
                parentNode = null;


        //Recorremos nuestro arbol, para dejarlo ordenado con los valores correspondientes.
        while (aux != null) {
            parentNode = aux;

            //Con este simple if, vamos a ir recorriendo el arbol dependiendo del valor que se ingresa.
            if (nodeToInsert.getElement() < aux.getElement())
                aux = aux.getSonleft();
            else
                aux = aux.getSonRigth();
        }
        //Una vez que tengo ordenado, devolvemos el nodo padre del nodo que deseamos insertar
        return parentNode;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
