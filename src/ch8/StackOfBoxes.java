package ch8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StackOfBoxes {

    public static void main(String[] args) {
        Box b1 = new Box(1);
        Box b2 = new Box(2);
        Box b3 = new Box(3);

        ArrayList<Box> boxes = new ArrayList<>();
        boxes.add(b1);
        boxes.add(b2);
        boxes.add(b3);

        int height = createStack(boxes);
        System.out.println("height = " + height);
    }

    private static class Box {
        int height;

        public Box(int height) {
            this.height = height;
        }

        public boolean canBeAbove(Box bottom) {
            return this.height < bottom.height;
        }
    }

    private static int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int maxHeight = 0;

        for (int i = 0; i < boxes.size(); i++) {
            int height = createStack(boxes, i);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxHeight;
    }

    private static int createStack(ArrayList<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;

        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = createStack(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }

        maxHeight += bottom.height;
        return maxHeight;
    }

    private static class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box x, Box y) {
            return y.height - x.height;
        }
    }
}
