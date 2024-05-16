public class QuickSort extends SortAlgorithm {

    public QuickSort(int input_array[]) {
        super(input_array);
    }

    private int partition(int start, int end) {
        int pivot = arr[end]; // picking pivot
        int i = (start - 1); 
        for (int j = start; j < end; j++) {
            comparison_counter++; // comparison_counter increment
            if (arr[j] < pivot) { // If current element is smaller than the pivot
                i++; 
                swap(i, j); 
            }   
        }
        i++;
        swap(i, end);
        return i; // return the index of the pivot

    }

    private void sort(int start, int end) {
        if (start < end) { // If there are more than one element
            int pi = partition(start, end); // pi is partitioning index
            sort(start, pi - 1); // Recursively sort elements before partition
            sort(pi + 1, end); // Recursively sort elements after partition
        }
    }

    @Override
    public void sort() {
        sort(0, arr.length - 1);
    }

    @Override
    public void print() {
        System.out.print("Quick Sort\t=>\t");
        super.print();
    }
}
