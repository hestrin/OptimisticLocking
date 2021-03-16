package main;


import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EqualSumSubset {

    ImmutablePair<int[], List<List<Integer>>> findSubsetWithEqualSum(int[] set) {
        Arrays.sort(set);
        int goalSum = sum(set) / 2;
        System.out.println("Goal sum is: " + goalSum);

        int[] maxSubsetSumsLessThanGoal = new int[set.length];
        List<List<Integer>> itemsInSubsetSums = new ArrayList<>();

        for (int i = 0; i < set.length; i++) {
            int[] subsetOfData = Arrays.copyOfRange(set, 0, i + 1);
            print(subsetOfData);
            int totalSubsetSum = sum(subsetOfData);
            if (totalSubsetSum <= goalSum) {
                maxSubsetSumsLessThanGoal[i] = totalSubsetSum;
                List<Integer> allElems = Arrays.stream(subsetOfData).boxed().collect(Collectors.toList());
                itemsInSubsetSums.add(allElems);
                System.out.println("Items is subset: " + itemsInSubsetSums);
            } else {
                int indexOfPrevItem = 0;
                for (int j = 0; j < i; j++) {
                    if (maxSubsetSumsLessThanGoal[j] + subsetOfData[i] <= goalSum) {
                        indexOfPrevItem = j;
                    }
                }
                if (i > 1 && maxSubsetSumsLessThanGoal[indexOfPrevItem] + subsetOfData[i] >= maxSubsetSumsLessThanGoal[i - 1] &&
                        maxSubsetSumsLessThanGoal[indexOfPrevItem] + subsetOfData[i] <= goalSum) {
                    maxSubsetSumsLessThanGoal[i] = maxSubsetSumsLessThanGoal[indexOfPrevItem] + subsetOfData[i];
                    List<Integer> newList = new ArrayList<>(itemsInSubsetSums.get(indexOfPrevItem));
                    newList.add(subsetOfData[i]);
                    itemsInSubsetSums.add(newList);
                    System.out.println("Items is subset: " + itemsInSubsetSums);
                } else {
                    maxSubsetSumsLessThanGoal[i] = maxSubsetSumsLessThanGoal[i - 1];
                    List<Integer> newList = new ArrayList<>(itemsInSubsetSums.get(i - 1));
                    itemsInSubsetSums.add(newList);
                    System.out.println("Items is subset: " + itemsInSubsetSums);
                }
            }
        }

        return ImmutablePair.of(maxSubsetSumsLessThanGoal, itemsInSubsetSums);
    }

    private int sum(int[] set) {
        return Arrays.stream(set).sum();
    }

    public static void main(String[] args) {
        EqualSumSubset ess = new EqualSumSubset();
        int[] set = {1, 2, 4, 6};
        ImmutablePair<int[], List<List<Integer>>> results = ess.findSubsetWithEqualSum(set);
        print(results.left);
        System.out.println(results.right);
    }

    private static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
