package proj.hobby.jvm;

public class StackDepthTest {

    static int depth = 0;

    public static void main(String[] args) {
        try
        {
            recurse();
        } catch (StackOverflowError e) {
            System.out.println("Max depth = " + depth);
        }
    }

    static void recurse() {
        depth++;
        recurse();
    }
}
