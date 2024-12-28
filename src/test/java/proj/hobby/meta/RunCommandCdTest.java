package proj.hobby.meta;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;


class RunCommandCdTest {

    RunCommandCd cmd = new RunCommandCd();

    @Test
    public void testCdRoot(){
        String cd = cmd.cd("/a/b","/p/q");
        assertEquals("/p/q", cd);

        cd = cmd.cd("/a/b", "../p/../q");
        assertEquals("/a/q", cd);

        cd = cmd.cd("/a/b", "../../../../../");
        assertEquals("/", cd);

        cd = cmd.cd("/a/b", "../../../../../c");
        assertEquals("/c", cd);

        cd = cmd.cd("/a", "../..");
        assertEquals("/", cd);
    }


    @Test
    public void testStack() {
        // Creating an empty Stack
        Stack<String> stack = new Stack<>();

        // Use add() method to add elements
        stack.push("Hello");
        stack.push("World!");
        stack.push("Stack");
        stack.push("of");
        stack.push("Stacks");

        // Displaying the Stack
        System.out.println("Initial Stack: " + stack);

        // Removing elements using pop() method
        System.out.println("Popped element: " +
                stack.pop());
        System.out.println("Popped element: " +
                stack.pop());

        // Displaying the Stack after pop operation
        System.out.println("Stack after pop operation " + stack);
    }
}