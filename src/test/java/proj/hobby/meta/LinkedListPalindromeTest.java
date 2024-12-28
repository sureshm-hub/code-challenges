package proj.hobby.meta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListPalindromeTest {

    @Test
    public void testLinkedListOps(){
        LinkedList l = new LinkedList();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);
        LinkedList.Node mid = l.mid();
        System.out.println("mid val: " + mid.val);
        LinkedList.Node reverse = l.reverse(l.head);
        System.out.println("Linkedlist head after reverse: ");
        l.display();
        System.out.println("Reversed Linkedlist: ");
        l.display(reverse);
    }

    @Test
    public void testLinkedListPalindromeEven(){
        LinkedList l = new LinkedList();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);
        l.insert(5);
        l.insert(4);
        l.insert(3);
        l.insert(2);
        l.insert(1);
        int palindrome = l.isPalindrome(l.head);
        assertEquals(1, palindrome);
    }

    @Test
    public void testLinkedListPalindromeOdd(){
        LinkedList l = new LinkedList();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);
        l.insert(4);
        l.insert(3);
        l.insert(2);
        l.insert(1);
        int palindrome = l.isPalindrome(l.head);
        assertEquals(1, palindrome);
    }

    @Test
    public void testLinkedListNoPalindrome(){
        LinkedList l = new LinkedList();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);
        l.insert(6);
        l.insert(4);
        l.insert(3);
        l.insert(2);
        l.insert(1);
        int palindrome = l.isPalindrome(l.head);
        assertEquals(0, palindrome);
    }

}