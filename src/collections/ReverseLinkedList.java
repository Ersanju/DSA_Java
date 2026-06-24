package collections;

public class ReverseLinkedList {

    static class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node reverseLinkedList(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {

            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;

        }
        return prev;
    }

    public static void printList(Node head) {

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        printList(head);
        printList(reverseLinkedList(head));
    }

}
