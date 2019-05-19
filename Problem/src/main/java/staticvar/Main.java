package staticvar;

public class Main {
    private static int x= 100;
    public static void main(String[] args) {
        Main m1 = new Main();
        m1.x++;
        Main m2 = new Main();
        m2.x++;
        m1 = new Main();
        m1.x++;
        Main.x--;
        System.out.println("x = "+x);
    }
}
