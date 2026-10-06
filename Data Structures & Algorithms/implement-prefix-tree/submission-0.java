class PrefixTree {
    class Node {
        Node[] children;
        boolean eow;
        Node next;

        Node() {
            children = new Node[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
                eow = false;
            }
        }
    }

    Node head;

    public PrefixTree() {
        head = new Node();
    }

    public void insert(String word) {
        Node curr = head;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                Node newNode = new Node();
                curr.children[idx] = newNode;
                curr.next = newNode;
                curr = newNode;
            } else {
                curr = curr.children[idx];
            }
        }

        curr.eow = true;
    }

    public boolean search(String word) {
        Node curr = head;
        for (char ch : word.toCharArray()) {
            if (curr == null)
                return false;
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                return false;
            } else {
                curr = curr.children[idx];
            }
        }

        return curr.eow;
    }

    public boolean startsWith(String prefix) {
        Node curr = head;
        for (char ch : prefix.toCharArray()) {
            if (curr == null)
                return false;
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                return false;
            } else {
                curr = curr.children[idx];
            }
        }

        return true;
    }
}
