public class SelectionSort extends SortAlgorithm {

    public SelectionSort(int input_array[]) {
        super(input_array);
    }

    @Override
    public void sort() {
        int min_index; // index of minimum element
        for (int i = 0; i < arr.length - 1; i++) {
            min_index = i; // assume the first element is the smallest
            for (int j = i + 1; j < arr.length; j++) {
                comparison_counter++; // comparison_counter increment
                if (arr[j] < arr[min_index]) { // If current element is smaller than the minimum element
                    min_index = j;
                }
            }

            swap(min_index, i); 

        }
    }

    @Override
    public void print() {
        System.out.print("Selection Sort\t=>\t");
        super.print();
    }
}
