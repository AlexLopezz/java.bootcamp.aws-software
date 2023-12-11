package excercise1;


public class Demo {
    public static void main(String[] args) {
        IStackeable<String> myStack = new StackeableCustom<>();
        myStack.push("Hernan");
        myStack.push("Jose");
        myStack.push("Fernando");

        System.out.println("> Ejemplo de Pila(Stack)");
        System.out.println("* Lista creada con los siguientes elementos --> " +myStack);

        myStack.push("Alexander");
        System.out.println("* Agregamos un nuevo elemento a la cima de la lista --> "+ myStack);

        myStack.pop();
        System.out.println("* Elemento de la cima de la lista eliminado --> " +myStack);

        System.out.println("La lista ¿Contiene elementos? "+ myStack.isEmpty());
        System.out.println("¿Cuantos elementos, tiene la lista? "+ myStack.length());

    }

}
