package stack_queue_without_collections_03.stack;

import stack_01.IStackeable;

public class SampleStack {
    public static void main(String[] args) {
        IStackeable<String> myStack = new StackCustom<>();

        myStack.push("Gabriel");
        myStack.push("Jonas");
        myStack.push("Antonia");
        myStack.push("Hernan");
        myStack.push("Alex");

        String addTest = "Chispitas";

        System.out.println("*Elementos de la Pila --> "+myStack);

        System.out.println(">Probando metodo de agregar elemento a la Pila (debe agregarse al final de la Pila actual) --> "+ addTest);
        myStack.push(addTest);
        System.out.println("Elementos actuales de la Pila --> "+myStack);

        System.out.println("*Cantidad de elementos en la Pila --> "+ myStack.length());
        System.out.println(">Probando metodo de eliminar, este elemento se eliminara de la Pila(tendria que ser el ultimo elemento de la Pila actual) -->  "+ myStack.pop());

        System.out.println("Elementos actuales de la Pila --> "+myStack);
    }
}
