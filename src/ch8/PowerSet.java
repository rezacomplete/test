package ch8;

import java.util.ArrayList;

public class PowerSet {

    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;

        if (set.size() == index) { // Base case
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>()); // Empty set
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();

            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }

        return allSubsets;
    }

    private static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        if (set.isEmpty()) {
            ArrayList<Integer> emptySet = new ArrayList<>();
            ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
            subsets.add(emptySet);
            return subsets;
        }

        int item = set.remove(set.size() - 1);
        ArrayList<ArrayList<Integer>> subsets = getSubsets2(set);
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
        for (ArrayList<Integer> subset : subsets) {
            ArrayList<Integer> newSubset = new ArrayList<>();
            newSubset.addAll(subset);
            newSubset.add(item);
            allSubsets.add(newSubset);
        }

        allSubsets.addAll(subsets);
        return allSubsets;
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);

        ArrayList<ArrayList<Integer>> subsets = getSubsets2(set);
        printSubsets(subsets);
    }

    private static void printSubsets(ArrayList<ArrayList<Integer>> subsets) {
        for (ArrayList<Integer> subset : subsets) {
            for (Integer item : subset) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
