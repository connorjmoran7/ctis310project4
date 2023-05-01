package edu.guilford;

public class SortAndSearch {
    // Add a static selectionSort method that takes an array of integers as a
    // parameter
    // and sorts the array using the selection sort algorithm

    public static void selectionSort(int[] array) {
        // Loop over all elements in the array and find the smallest one
        for (int i = 0; i < array.length; i++) {
            // Assume the first element is the smallest
            int smallest = i; // Keep track of the index, not the value

            // Loop over all elements after the first one
            // End of the array has i = array.length - 1
            // j would start at array.length, which is not less than array.length
            // the next loop won't do anything for the last element
            for (int j = i + 1; j < array.length; j++) {
                // If the current element is smaller than the smallest element
                if (array[j] < array[smallest]) {
                    // Set the current element to the smallest element
                    smallest = j;
                }
            }
            // Swap the smallest element with the first element
            swap(array, i, smallest);
        }

        // Swap the smallest element with the first element
        // Repeat for all elements except the first one

    }

    // Add a static quickSort method that takes an array of integers as a
    // parameter and sorts the array using the quick sort algorithm
    public static void quickSort(int[] array) {
        // Call the recursive quickSort method
        quickSort(array, 0, array.length - 1);
    }

    // Add a static quickSort method that takes an array of integers as a
    // parameter and sorts the array using the quick sort algorithm
    // This method is recursive
    public static void quickSort(int[] array, int start, int end) {
        // If the array has more than one element
        if (start < end) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(array, start, end);
            // Sort the left side of the array
            quickSort(array, start, pivotIndex - 1);
            // Sort the right side of the array
            quickSort(array, pivotIndex + 1, end);
        }
    }

    // Add a static partition method that takes an array of integers as a
    // parameter and partitions the array using the quick sort algorithm
    public static int partition(int[] array, int start, int end) {
        // Set the pivot to the last element in the array
        int pivot = array[end];
        // Set the pivot index to the first element in the array
        int pivotIndex = start;
        // Loop over all elements in the array
        for (int i = start; i < end; i++) {
            // If the current element is less than the pivot
            if (array[i] < pivot) {
                // Swap the current element with the element at the pivot index
                swap(array, i, pivotIndex);
                // Increment the pivot index
                pivotIndex++;
            }
        }
        // Swap the pivot with the element at the pivot index
        swap(array, end, pivotIndex);
        // Return the pivot index
        return pivotIndex;
    }

    // Let's create a method that swaps two elements in an array
    public static void swap(int[] array, int i, int j) {
        // Create a temporary variable to hold the value of the first element
        int temp = array[i];
        // Set the value of the first element to the value of the second element
        array[i] = array[j];
        // Set the value of the second element to the value of the first element
        array[j] = temp;
    }

    // Add a linear or sequential search algorithm
    public static int linearSearch(int[] array, int target) {
        // Loop over all elements in the array
        for (int i = 0; i < array.length; i++) {
            // If the current element is equal to the value
            if (array[i] == target) {
                // Return the index of the element
                return i;
            }
        }
        // Return -1 if the value is not found
        return -1;
    }

    // Add a binary search algorithm
    public static int binarySearch(int[] array, int target) {
        // Set the start index to 0
        int start = 0;
        // Set the end index to the last index in the array
        int end = array.length - 1;
        // Loop over all elements in the array
        while (start <= end) {
            // Set the middle index to the average of the start and end indices
            int middle = (start + end) / 2;
            // If the current element is equal to the target
            if (array[middle] == target) {
                // Return the index of the current element
                return middle;
            }
            // If the current element is less than the target
            if (array[middle] < target) {
                // Set the start index to the middle index plus one
                start = middle + 1;
            } else {
                // Set the end index to the middle index minus one
                end = middle - 1;
            }
        }
        // Return -1 if the target is not found (we get to the end of the array and we
        // can't
        // find it)
        return -1;
    }
}
