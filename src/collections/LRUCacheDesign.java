package collections;

import java.util.HashMap;
import java.util.Map;

class Node {

    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCacheDesign {

    private final int capacity;
    private final Map<Integer, Node> map;

    private final Node head;
    private final Node tail;

    public LRUCacheDesign(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        remove(node);
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node existingNode = map.get(key);

            existingNode.value = value;
            remove(existingNode);
            insertAtFront(existingNode);

            return;
        }

        if (map.size() == capacity) {
            Node lruNode = tail.prev;
            remove(lruNode);
            map.remove(lruNode.key);
        }

        Node newNode = new Node(key, value);
        insertAtFront(newNode);
        map.put(key, newNode);
    }

    public void insertAtFront(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void display() {

        Node current = head.next;

        while (current != tail) {
            System.out.println("(" + current.key + "," + current.value + ") ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        LRUCacheDesign cache = new LRUCacheDesign(3);

        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);

        cache.display();

        cache.get(1);

        cache.display();

        cache.put(4, 400);

        cache.display();

        System.out.println(cache.get(2));
    }
}
