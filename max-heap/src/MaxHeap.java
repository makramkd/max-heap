/**
 * Created by Makram on 6/29/16.
 */
public class MaxHeap {
    /*
    The backing array store of the heap.
     */
    private int[] array;
    /*
    The size of the heap.
     */
    private int heapSize;

    public MaxHeap() {

    }

    public MaxHeap(int[] array) {
        this.array = new int[array.length + 1];
        System.arraycopy(array, 0, this.array, 1, array.length);
        this.heapSize = 0;
    }

    public int[] backingArray() {
        return array;
    }
}
