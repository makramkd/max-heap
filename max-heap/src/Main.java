import java.util.Arrays;

/**
 * Created by Makram on 6/29/16.
 */
public class Main {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7});
        System.out.println(Arrays.toString(maxHeap.backingArray()));
    }
}
