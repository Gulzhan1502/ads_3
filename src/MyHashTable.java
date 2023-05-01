import java.util.ArrayList;
import java.util.Objects;
import java.util.Arrays;
public class MyHashTable<K, V> {
    private class HashNode <K, V> {
        private K key;
        private V value;
        private HashNode<K, V > next;

        public HashNode(K key, V value){
            this.key=key;
            this.value=value;
        }
        @Override
        public String toString(){
            return"{"+key+" "+value+"}";

        }
    }
    private HashNode<K, V> [] chainArray;// the hash table array
    private int M = 11; // length of the hash table array
    private int size; // the number of key-value pairs stored in the hash table
    public MyHashTable(){
        chainArray = new HashNode[M];
        size = 0;

        for (int i = 0; i < M; i++) {
            chainArray[i] = null;
        }
    }
    public MyHashTable (int M){
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;

        for (int i = 0; i < M; i++) {
            chainArray[i] = null;
        }
    }
    private int hash (K key){
        int hashCode = key.hashCode();
        int index = hashCode % M;
        return index;
    }
    public void put (K key, V value) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];

        while (node != null) {
            if (node.key.equals(key)) { // If the key already exists, update its value and return
                node.value = value;
                return;
            }
            node = node.next;
        }

        HashNode<K, V> newNode = new HashNode<K, V>(key, value);// If the key doesn't exist, create a new HashNode and add it to the front of the linked list
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }
    public V get (K key){
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];

        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }
    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];
        HashNode<K, V> prevNode = null;

        while (node != null) {
            if (node.key.equals(key)) {
                if (prevNode == null) {
                    chainArray[index] = node.next;
                } else {
                    prevNode.next = node.next;
                }
                size--;
                return node.value;
            }
            prevNode = node;
            node = node.next;
        }
        return null;
    }
    public boolean contains(V value){
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                if (node.value.equals(value)) {
                    return true; // If the value is found, return true
                }
                node = node.next;
            }
        }
        return false;// If the value is not found, return false
    }
    public K getKey(V value){
        for (int i = 0; i < M; i++) {
            HashNode<K, V> node = chainArray[i];

            while (node != null) {
                if (node.value.equals(value)) {
                    return node.key;// If the value is found, return the corresponding key
                }
                node = node.next;
            }
        }
        return null;// If the value is not found, return null
    }
    }


