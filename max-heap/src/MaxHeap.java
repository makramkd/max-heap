import java.util.Arrays;

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
        this.array = new int[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
        this.heapSize = array.length;
        maxHeapify();
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

    /*
    Pre-condition:
        - the binary trees rooted at left(i) and right(i) are max-heaps
        - array[i] may be smaller than its children, violating the max heap property
    Post-condition:
        - Puts the value of the node at index i in the correct index, as per the
        max-heap property.
     */
    private void maxHeapify(int i) {
        /*
        Determine which of the elements at array[i], array[left(i)] and array[right(i)]
        is the largest, and extract that index.
         */
        int left = left(i), right = right(i);

        int largest;
        if (left < heapSize && array[left] > array[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right < heapSize && array[right] > array[largest]){
            largest = right;
        }

        /*
        Once we have the index of the largest element out of array[i], array[left(i)], and
        array[right(i)], we swap the largest element to become the parent of this subtree,
        and continue max-heapifying at the largest index.
         */
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeapify(largest);
        }
    }

    /*
    Pre-condition:
        - the array field of this class has been initialized to be a copy of a caller-given
        array, but the array is untampered with and may not be a max-heap.
    Post-condition:
        - the array field comes to represent a max-heap.
        - the heapSize member is mutated.
     */
    private void maxHeapify() {
        for (int i = array.length / 2; i >= 0; --i) {
            maxHeapify(i);
        }
    }

    /*
    Pre-condition:
        - the given array is an array of integers that is unsorted (or sorted).
    Post-condition:
        - the returned array is sorted.
     */
    public static int[] heapsort(int[] a) {
        /*
        First step: construct a max heap with the elements of A.
         */
        MaxHeap heap = new MaxHeap(a);
        int[] arr = heap.array;

        /*
        Second step: the selection sort idea; take the max and place it at the end.
         */
        for (int i = arr.length - 1; i > 0; i--) {
            // swap arr[0] with arr[i]
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap.heapSize--;
            heap.maxHeapify(0);
        }

        return arr;
    }

    /*
    Return the maximum valued element in the max-heap.
     */
    public int max() {
        return array[0];
    }

    /*
    Extract the maximum valued element in the max-heap and return it.
    This mutates the heap.
     */
    public int extractMax() throws EmptyHeapException {
        if (heapSize < 1) {
            throw new EmptyHeapException("Heap underflow");
        }
        int max = max();
        array[0] = array[heapSize - 1];
        heapSize--;
        maxHeapify(0);
        return max;
    }

    public void increaseKey(int i, int key) throws SmallKeyException {
        if (key < array[i]) {
            throw new SmallKeyException("The new key is smaller than current key.");
        }
        array[i] = key;
        while (i > 0 && array[parent(i)] < array[i]) {
            int temp = array[i];
            array[i] = array[parent(i)];
            array[parent(i)] = temp;
            i = parent(i);
        }
    }

    public void add(int key) {
        heapSize++;
        if (heapSize > array.length) {
            resizeArray();
        }
        array[heapSize - 1] = Integer.MIN_VALUE;
        try {
            increaseKey(heapSize, key);
        } catch (SmallKeyException ignored) {

        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < heapSize; ++i) {
            builder.append(array[i]);
            if (i < heapSize - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    private void resizeArray() {
        int[] arr = array;
        array = new int[arr.length * 2];
        // copy elements over
        System.arraycopy(arr, 0, array, 0, arr.length);
    }
}
