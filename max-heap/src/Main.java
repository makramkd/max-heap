import java.util.Arrays;

/**
 * Created by Makram on 6/29/16.
 */
public class Main {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(maxHeap.backingArray()));
    }
}
