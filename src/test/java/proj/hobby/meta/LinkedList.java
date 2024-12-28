package proj.hobby.meta;

public class LinkedList {

    class Node {
        Node next;
        int val;
        Node(int val) {
            this.val = val;
        }
    }
    public Node head;

    public void insert(int val) {
        if(head == null) {
            head = new Node(val);
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node(val);
        }
    }

    public void display(){
        display(head);
    }

    public void display(Node head){
        Node current = head;
        while(current != null) {
            System.out.print(current.val+ (current.next != null ? " -> " : "\n"));
            current = current.next;
        }
    }

    public int isPalindrome(Node head) {
        Node current = head;
        Node mid = mid();
        Node reverse = reverse(mid);
        while(reverse != null) {
            if(current.val != reverse.val) {
                return 0;
            }
            current = current.next;
            reverse = reverse.next;
        }
        // TODO: restore original
        return 1;
    }

    public Node mid() {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node reverse(Node head) {
        Node next = null;
        Node current = head;
        Node previous = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

}