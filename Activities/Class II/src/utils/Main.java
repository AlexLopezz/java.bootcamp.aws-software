import java.util.Scanner;

public abstract class Main implements IConsolable{
    protected Scanner read;

    public Main() {
        read = new Scanner(System.in);
    }

    public Main(Scanner read) {
        this.read = read;
    }

    @Override
    public int getNumberUser() {
        System.out.print("> Ingrese un numero: ");
        return read.nextInt();
    }
}
