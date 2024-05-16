public class BubbleSort extends SortAlgorithm {

    public BubbleSort(int input_array[]) {
        super(input_array);
    }

    @Override
    public void sort() {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                comparison_counter++; // comparison_counter increment
                if (arr[j] > arr[j + 1]) { // If current element is greater than the next element
                    swap(j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) { // If no two elements were swapped in the inner loop, then break
                break;
            }
        }
    }

    @Override
    public void print() {
        System.out.print("Bubble Sort\t=>\t");
        super.print();
    }
}
