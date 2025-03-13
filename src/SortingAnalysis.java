import java.util.Arrays;
import java.util.Random;

public class SortingAnalysis {
    public static int bubbleSort(int[] arr) {
        int operations = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                operations++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return operations;
    }

    public static int insertionSort(int[] arr) {
        int operations = 0;
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                operations++;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return operations;
    }

    public static int mergeSort(int[] arr) {
        return mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int operations = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            operations += mergeSort(arr, temp, left, mid);
            operations += mergeSort(arr, temp, mid + 1, right);
            operations += merge(arr, temp, left, mid, right);
        }
        return operations;
    }

    private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int operations = 0;
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            operations++;
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        System.arraycopy(temp, left, arr, left, right - left + 1);
        return operations;
    }

    public static int quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private static int quickSort(int[] arr, int low, int high) {
        int operations = 0;
        if (low < high) {
            int[] result = partition(arr, low, high);
            int pi = result[0];
            operations += result[1];
            operations += quickSort(arr, low, pi - 1);
            operations += quickSort(arr, pi + 1, high);
        }
        return operations;
    }

    private static int[] partition(int[] arr, int low, int high) {
        int operations = 0;
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            operations++;
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return new int[]{i, operations};
    }

    public static void main(String[] args) {
        int[] sizes = {0, 100, 1000, 10000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] testArray = rand.ints(size, 0, 10000).toArray();
            
            int[] arrCopy = Arrays.copyOf(testArray, testArray.length);
            long startTime = System.nanoTime();
            int operations = bubbleSort(arrCopy);
            long endTime = System.nanoTime();
            System.out.println("Bubble Sort - Size: " + size + ", Time: " + (endTime - startTime) / 1e6 + " ms, Operations: " + operations);
            
            arrCopy = Arrays.copyOf(testArray, testArray.length);
            startTime = System.nanoTime();
            operations = insertionSort(arrCopy);
            endTime = System.nanoTime();
            System.out.println("Insertion Sort - Size: " + size + ", Time: " + (endTime - startTime) / 1e6 + " ms, Operations: " + operations);
            
            arrCopy = Arrays.copyOf(testArray, testArray.length);
            startTime = System.nanoTime();
            operations = mergeSort(arrCopy);
            endTime = System.nanoTime();
            System.out.println("Merge Sort - Size: " + size + ", Time: " + (endTime - startTime) / 1e6 + " ms, Operations: " + operations);
            
            arrCopy = Arrays.copyOf(testArray, testArray.length);
            startTime = System.nanoTime();
            operations = quickSort(arrCopy);
            endTime = System.nanoTime();
            System.out.println("Quick Sort - Size: " + size + ", Time: " + (endTime - startTime) / 1e6 + " ms, Operations: " + operations);
        }
    }
}
