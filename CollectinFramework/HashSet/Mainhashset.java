package HashSet;


import java.util.ArrayList;
import java.util.Scanner;

class MyHashSet {
    private ArrayList<Integer>[] hashset;
    private int maxSpace;
    private double loadFactor;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        maxSpace = 1000;
        loadFactor = 0.75;
        size = 0;
        hashset = new ArrayList[maxSpace];
        for (int i = 0; i < maxSpace; i++) {
            hashset[i] = new ArrayList<>();
        }
    }

    public void add(int key) {
        if (!contains(key)) {
            int index = key % maxSpace;
            hashset[index].add(key);
            size++;
            if ((double) size / maxSpace >= loadFactor) {
                resize();
            }
        }
    }

    public boolean remove(int key) {
        int index = key % maxSpace;
        for (int i = 0; i < hashset[index].size(); i++) {
            if (hashset[index].get(i) == key) {
                hashset[index].remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

   //function to check hashset already contains the key
    public boolean contains(int key) {
        int index = key % maxSpace;
        for (int k : hashset[index]) {
            if (k == key) {
                return true;
            }
        }
        return false;
    }

    private void resize() {
        maxSpace *= 2;
        ArrayList<Integer>[] oldBuckets = hashset;
        hashset = new ArrayList[maxSpace];
        for (int i = 0; i < maxSpace; i++) {
            hashset[i] = new ArrayList<>();
        }
        for (ArrayList<Integer> bucket : oldBuckets) {
            for (int key : bucket) {
                int index = key % maxSpace;
                hashset[index].add(key);
            }
        }
    }


    public void display() {
        for (int i = 0; i < maxSpace; i++) {
            for (int key : hashset[i]) {
                System.out.print(key + " ");
            }
        }
        System.out.println();
    }
}

public class Mainhashset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //constructor is called
        MyHashSet set = new MyHashSet();

        System.out.println("Enter the no of elements you want to add");
        int noofElements = scanner.nextInt();

        for (int element = 0; element < noofElements; element++) {
            System.out.println("Enter the Element");
            int currentElement = scanner.nextInt();
            set.add(currentElement);

        }


        set.display();


        System.out.println("Enter the element you want to check (contains in HashSet or Not) : ");
        int checkElement = scanner.nextInt();
        System.out.println( set.contains(checkElement));


        System.out.println("Enter the element you want to remove from Hashset : ");
        int removeElement=scanner.nextInt();
        System.out.println(set.remove(removeElement));

    }
}
