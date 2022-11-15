package com.arpit;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    final private Map<Integer, Node> map = new HashMap<>();

    final private int capacity;
    final private Node head,tail;

    public LRU(int capacity){
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }


    public void put(int key, int val){
        Node n = map.get(key);
        if(n != null) {
            updateUsage(n);
        }else{
            if(map.size() >= capacity){
                deleteLRUNode();
            }
            n = new Node(key,val);
            insertNextToHead(n);
            map.put(key,n);
        }
    }

    private void deleteLRUNode() {
        Node lru = tail.prev;
        if(lru != head){
            lru.prev.next = tail;
            tail.prev = lru.prev;
            map.remove(lru.key);
        }
    }

    public int get(int key){
        Node n = map.get(key);
        if(n != null){
            int result = n.val;
            updateUsage(n);
            return result;
        }
        return -1;
    }

    private void updateUsage(Node n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
        insertNextToHead(n);
    }
    private void insertNextToHead(Node n){
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
    }

    static class Node{
        Node next, prev;
        int key,val;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public int size(){
        return map.size();
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        Assertions.assertEquals(3,lru.size());
        Assertions.assertEquals(-1,lru.get(1));
        Assertions.assertEquals(2,lru.get(2));
        lru.put(5,5);
        Assertions.assertEquals(3,lru.size());
        Assertions.assertEquals(-1,lru.get(3));
        Assertions.assertEquals(2,lru.get(2));
    }
}
