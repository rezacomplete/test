package ch3;

public class ThreeInOne {

    private static final int NUMBER_OF_STACKS = 3;

    static int[] array;
    static int[] index = new int[3];
    static int[] limit = new int[3];
    static int[] base = new int[3];

    public static void main(String[] args) {
        buildStacks(5);
        printArray(array);
        push(1, 0);
        push(1, 0);
        push(1, 0);
        push(1, 0);
        push(1, 0);
        push(2, 1);
        push(2, 1);
        push(2, 1);
        push(2, 1);
        push(2, 1);
        push(3, 2);
        push(3, 2);
        push(3, 2);
        push(3, 2);
        push(3, 2);
        printArray(array);
        System.out.println(pop(2));
        System.out.println(pop(2));
        System.out.println(pop(2));
        System.out.println(pop(2));
        System.out.println(pop(2));

    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void buildStacks(int stackSize) {
        array = new int[stackSize * NUMBER_OF_STACKS];

        index[0] = -1;
        index[1] = index[0] + stackSize;
        index[2] = index[1] + stackSize;

        base[0] = 0;
        base[1] = base[0] + stackSize;
        base[2] = base[1] + stackSize;

        limit[0] = index[1];
        limit[1] = index[2];
        limit[2] = array.length - 1;
    }

    private static void push(int item, int stackNumber) {
        if (index[stackNumber] + 1 > limit[stackNumber]) {
            throw new RuntimeException("too high buddy");
        }
        index[stackNumber]++;
        array[index[stackNumber]] = item;
    }

    private static int peek(int stackNumber) {
        return array[index[stackNumber]];
    }

    private static int pop(int stackNumber) {
        if (index[stackNumber] < base[stackNumber]) {
            throw new RuntimeException("too low buddy");
        }

        int result = array[index[stackNumber]];
        index[stackNumber]--;
        return result;
    }
}
