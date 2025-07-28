package epam.learning;

import java.util.HashMap;

public class LRUCache {

    Node head=null, tail = null;
    int capacity, count;
    HashMap<Integer, Node> hm;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.count=0;
        hm = new HashMap<>();
        head = new Node(-1, -1); //dummy head
        tail = new Node(-1, -1); //dummy tail, every node will be in these 2 dummy nodes. Hence, no need to handle the null cases separately.
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            removeBetween(node);
            insertAtEnd(node);
            return node.value;
        }
        return -1;

    }

    public void set(int key, int value) {

        if(hm.containsKey(key)){
            Node node = hm.get(key);
            removeBetween(node);
            insertAtEnd(node);
            node.value = value;
        }else{

            Node newNode = new Node(key, value);

            if(count==capacity){
                Node removedNode = removeFromFront();
                hm.remove(removedNode.key);
                insertAtEnd(newNode);

            }else{
                insertAtEnd(newNode);
                count++;
            }
            hm.put(key, newNode);
        }

    }

    private void removeBetween(Node node){
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;

    }

    private void insertAtEnd(Node newNode){
        Node tailPrev = tail.prev;
        tailPrev.next = newNode;
        newNode.prev = tailPrev;
        newNode.next = tail;
        tail.prev = newNode;
    }

    private Node removeFromFront(){
        Node headNext = head.next;
        Node ptr = headNext.next;
        ptr.prev = head;
        head.next = ptr;
        return headNext;
    }




}

class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}


