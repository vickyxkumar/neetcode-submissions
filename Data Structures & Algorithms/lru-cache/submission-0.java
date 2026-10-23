class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {

    HashMap<Integer, Node> nodeList = new HashMap<>();
    int maxCapacity;
    int currentCapacity = 0;
    Node head;
    Node tail;

    

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void removeNodeFromFront() {
        Node nextNodeFromHead = head.next;
        Node temp = nextNodeFromHead.next;
        temp.prev = head;
        head.next = temp;
    }

    private void removeNodeFromMiddle(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

    }

    private void addNewNodeInBack(Node newNode) {
        Node temp = tail.prev;
        temp.next = newNode;
        tail.prev = newNode;
        newNode.next = tail;
        newNode.prev = temp;
    }

    public int get(int key) {
        if (nodeList.containsKey(key)) {
            Node middleNode = nodeList.get(key);
            nodeList.remove(key);
            // remove the node and 
            removeNodeFromMiddle(middleNode);
            // add the new node in the back
            addNewNodeInBack(middleNode);

            nodeList.put(key, tail.prev);

            return middleNode.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if (nodeList.containsKey(key)) {
            Node middleNode = nodeList.get(key);
            nodeList.remove(key);
            // remove the node and add the new node in the back
            removeNodeFromMiddle(middleNode);

        }

        if (nodeList.size() == maxCapacity) {
            // remove the element from the front and add the new node in the back
            nodeList.remove(head.next.key);
            // removeNodeFromFront();
            removeNodeFromMiddle(head.next);
        }

        addNewNodeInBack(newNode);
        currentCapacity++;
        nodeList.put(key, tail.prev);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */