package structures;

import java.util.ArrayList;

public class QuickFind {
    private int[] id;
    private int length;

    public QuickFind(int numComponents) {
        id = new int[numComponents];
        for (int i=0; i<numComponents; i++) {
            id[i]=i;
        }
        length = numComponents;
    }

    //Return the parent of component p
    public int find (int p) {
        return id[p];
    }

    //Set parent of p to q
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i=0; i<id.length; i++) {
            if (id[i]==pid) { id[i] = qid; }
        }
    }

    public void printString() {
        //Each index represents an ArrayList of components who share the parent defined by the index
        ArrayList<ArrayList<Integer>> disjointSets = new ArrayList<>();
        for (int i=0; i<length; i++) {
            disjointSets.add(new ArrayList<Integer>());
        }
        System.out.println(disjointSets);
        for (int i=0; i<length; i++) {
            //Access index of ArrayList holding components with the same parent and add the component
            disjointSets.get(id[i]).add(i);
        }
        for (int i=0; i<length; i++) {
            System.out.print("Components with parent " + i + ":");
            if (disjointSets.get(i).size()>0) {
                for (int x:disjointSets.get(i)) {
                    System.out.print(" " + x + ",");
                }
            }
            System.out.println("");
        }
    }
}
