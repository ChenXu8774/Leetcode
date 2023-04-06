//The functions get and put must each run in O(1) average time complexity.
class LRUCache {
    Node dummyHead;
    Node dummyTail;
    int capacity;
    int size;
    Map<Integer, Node> keyToNode = new HashMap<>();
    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        dummyTail = new Node(-1,-1);
        dummyHead = new Node(-1,-1);
        dummyTail.prev = dummyHead;
        dummyHead.next = dummyTail;
    }
    
    private void disconnect(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        dummyHead.next.prev = node;
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next = node;
        
    }
    private void removeTail() {
        Node node = dummyTail.prev;
        node.prev.next = dummyTail;
        dummyTail.prev = node.prev;
        node = null;
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        Node cur = keyToNode.get(key);
        disconnect(cur);
        addToHead(cur);
        return cur.value;
    }
    
    public void put(int key, int value) {
        if (keyToNode.containsKey(key)) {
            Node cur = keyToNode.get(key);
            disconnect(cur);
            addToHead(cur);
            keyToNode.remove(cur.key);
            cur.value = value;
            keyToNode.put(key, cur);
            return;
        }
        Node node = new Node(key, value);
        addToHead(node);
        keyToNode.put(key, node);
        size++;
        if (size > capacity) {
            Node tailNode = dummyTail.prev;
            keyToNode.remove(tailNode.key);
            removeTail();
            size--;
        }
    }
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
}