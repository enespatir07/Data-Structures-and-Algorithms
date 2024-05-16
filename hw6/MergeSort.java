public class MergeSort extends SortAlgorithm {

    public MergeSort(int input_array[]) {
        super(input_array);
    }

    private void merge(int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];
        for (int i = 0; i < n1; i++) // Copy data to temp arrays
            leftArray[i] = arr[l + i];
        for (int j = 0; j < n2; j++) // Copy data to temp arrays
            rightArray[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) { // Merge the temp arrays
            comparison_counter++;
            if (leftArray[i] <= rightArray[j]) { 
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {// Copy remaining elements of leftArray[] if any
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) { // Copy remaining elements of rightArray[] if any
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void sort(int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2; // Find the middle point
            sort(l, m); // Sort first and second halves
            sort(m + 1, r); // Sort first and second halves
            merge(l, m, r); // Merge the sorted halves
        }
    }

    @Override
    public void sort() {
        sort(0, arr.length - 1);
    }

    @Override
    public void print() {
        System.out.print("Merge Sort\t=>\t");
        super.print();
    }
}
