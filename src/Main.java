import state.*;

public class Main {
    public static void main(String[] args) {
        String path = "graph.txt";
        Context context = new Context(null, path);
        context.update();
        context.update();
        context.update();
    }
}