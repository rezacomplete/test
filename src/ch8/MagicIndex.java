package ch8;

public class MagicIndex {

    public static void main(String[] args) {
        int[] array = RecursionUtil.buildDistinctSortedArray();
        int index = getMagicIndex(array, 0, array.length - 1);
        System.out.println(index);
    }

    private static int getMagicIndex(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (array[mid] == mid) {
            return mid;
        }
        else if (array[mid] > mid) {
            return getMagicIndex(array, start, mid - 1);
        }
        else {
            return getMagicIndex(array, mid + 1, end);
        }
    }

    private static int getMagicIndex2(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        }

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];

        if (midIndex == midValue) {
            return midIndex;
        }

        int leftIndex = Math.min(midIndex -1 , midValue);
        int left = getMagicIndex2(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        int rightIndex = Math.max(midIndex + 1, midValue);
        return getMagicIndex2(array, rightIndex, end);
    }

}
