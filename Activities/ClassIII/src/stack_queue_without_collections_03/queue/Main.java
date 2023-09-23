package stack_queue_without_collections_03.queue;

public class Main {

    public static void main(String[] args) {
        QueueAbstract<String> myQueue = new QueueCustom<>();

        myQueue.queue("Alexander");
        myQueue.queue("Jorge");
        myQueue.queue("Javier");
        myQueue.queue("Antonella");
        myQueue.queue("Marina");

        System.out.println("Elementos de la fila --> "+myQueue);
        System.out.println("> Cabecera de la Fila: "+myQueue.header().element);
        System.out.println("> Tope de la Fila: "+myQueue.top().element);

        System.out.println("* Tamaño de la Fila: "+myQueue.size());
        System.out.println("* Removiendo un elemento de la fila: "+ myQueue.dequeue());
        System.out.println("Elementos de la fila --> "+myQueue);
    }
}
