package collections;

public class LRUCacheDesignArray {

    private int[] cacheArray;
    private int capacity;
    private int size;

    public LRUCacheDesignArray(int capacity) {

        this.cacheArray = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void access(int value) {
        int index = -1;

        // search the value
        for (int i = 0; i < size; i++) {
            if (cacheArray[i] == value) {
                index = i;
                break;
            }
        }

        // Element already exists move to front
        if (index != -1) {
            int temp = cacheArray[index];
            for (int i = index; i > 0; i--) {
                cacheArray[i] = cacheArray[i - 1];
            }
            cacheArray[0] = temp;
        }

        // Element not found
        else {
            // Cache full
            if (size == capacity) {
                for (int i = capacity - 1; i > 0; i--)
                    cacheArray[i] = cacheArray[i - 1];
                cacheArray[0] = value;
            }

            // Space available
            else {
                for (int i = size; i > 0; i--)
                    cacheArray[i] = cacheArray[i - 1];
                cacheArray[0] = value;
                size++;
            }

        }
    }

    public void display() {
        for (int i = 0; i < size; i++)
            System.out.print(cacheArray[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        LRUCacheDesignArray lru = new LRUCacheDesignArray(4);

        lru.access(1);
        lru.access(2);
        lru.access(3);
        lru.display();
        lru.access(2);
        lru.display();
        lru.access(4);
        lru.display();

        lru.access(5);
        lru.display();
        lru.access(5);
        lru.display();
        lru.access(3);
        lru.display();
        lru.access(6);
        lru.display();

    }

}
