package queue_02;

public class SampleQueue {
    public static void main(String[] args) {
        IQueue<String> myQueue = new CustomQueue<>();
        myQueue.queue("Javier");
        myQueue.queue("Gabriel");
        myQueue.queue("Hernan");


        System.out.println("> Ejemplo de Fila/Cola(Queue)");
        System.out.println("* Lista creada con los siguientes elementos --> " +myQueue);

        myQueue.queue("Alexander");
        System.out.println("* Agregamos un nuevo elemento en la lista --> "+ myQueue);


        System.out.println("* Elemento eliminado de la lista --> " +myQueue.dequeue());
        System.out.println("* Lista actualizada --> "+myQueue);


        System.out.println("La lista ¿Contiene elementos? "+ myQueue.isEmpty());
        System.out.println("¿Cuantos elementos, tiene la lista? "+ myQueue.size());
    }

}
