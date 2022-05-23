public class LinkedListDeque<T> {
    public class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node(T i) {
            item = i;
        }
    }

    public int size;
    public Node head;
    public Node tail;

    public LinkedListDeque() {
        size = 0;
        head = null;
        tail = null;
    }

    public void addFirst(T x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        size += 1;
    }

    public void addLast(T x) {
        Node newNode = new Node(x);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        newNode.prev = head;
        tail = newNode;
        size += 1;
    }

    public boolean isEmpty() {
        return head == null;

    }

    public int size() {
        return size;

    }

    public Node removeFirst() {
        if (head == null) {
            throw new RuntimeException("Deque is empty");
        }
        Node first = head;
        if (head.next == null) {
            tail = null;
        } else {
            head.next.prev = null;

        }
        head = head.next;
        size = size - 1;
        return first;

    }

    public Node removeLast() {
        if (tail == null) {
            throw new RuntimeException("Deque is empty");
        }
        Node last = tail;
        if (tail.prev == null) {
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;
        size = size - 1;
        return last;
    }

    public void printDeque() {
        Node current = head;
        while (current != null) {
            System.out.println(current.item + " ");
            current = current.next;
        }
        System.out.println(" ");
    }

    public T get(int index) {
        if (index > size) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> s1 = new LinkedListDeque<Integer>();
        s1.addFirst(1);
        s1.addLast(2);
        s1.addFirst(0);
        s1.removeFirst();
        s1.printDeque();
        System.out.println(s1.get(0));

    }

}
