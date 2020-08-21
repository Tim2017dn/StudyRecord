package learnLRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int _key,int _value){key = _key;value=_value;}
    }


    private Map<Integer , DLinkedNode> cache = new HashMap<Integer,DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head ,tail;

    public LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }

        moveToHead(node);
        return node.value;
    }


    public void put(int key,int value){
        DLinkedNode node = cache.get(key);
        if(node == null){
            //create
            DLinkedNode newNode = new DLinkedNode(key,value);
            //add to cache
            cache.put(key,newNode);

            //add to head
            addToHead(newNode);
            //if size > capicty
            //removeTail\
            size++;
            if(size>capacity){
                DLinkedNode res = removeTail();
                cache.remove(res.key);
                --size;
            }


        }else{

            //change value
            node.value = value;
            // move to head
            moveToHead(node);

        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node){

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedNode node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;

    }

    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;

    }

    public static void main(String[] args) {
        LRUCache ca = new LRUCache(2);
        ca.put(1,1);
        ca.put(2,2);
        System.out.println(ca.get(1));
        ca.put(3,3);
        System.out.println(ca.get(2));
        ca.put(4,4);
        System.out.println(ca.get(1));
        System.out.println(ca.get(3));
        System.out.println(ca.get(4));


    }


}
