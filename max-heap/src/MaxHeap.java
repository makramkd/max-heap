import java.util.Arrays;

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

    /*
    Get the backing array store of this heap.
     */
    public int[] backingArray() {
        return array;
    }

    /*
    Return the index of the node that is the parent of the node at index i.
     */
    private int parent(int i) {
        return i / 2;
    }

    /*
    Return the index of the node that is the left child of the node at index i.
     */
    private int left(int i) {
        return i * 2;
    }

    /*
    Return the index of the node that is the right child of the node at index i.
     */
    private int right(int i) {
        return left(i) + 1;
    }

    public String toString() {
        return Arrays.toString(array);
    }
}
