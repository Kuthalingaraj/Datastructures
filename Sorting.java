import java.util.Arrays;

class Sorting {

    // Bubble Sorting Method...

    public static void bubleSort(int[] arr) {
        int i, j, temp;
        for (i = 1; i < arr.length; i++) {
            for (j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sorting Method 1;

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1)
            return arr;
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    public static int[] merge(int[] first, int[] second) {
        int[] joined = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                joined[k++] = first[i++];
            } else
                joined[k++] = second[j++];
        }
        while (i < first.length)
            joined[k++] = first[i++];
        while (j < second.length)
            joined[k++] = second[j++];
        return joined;
    }

    // In the above Method is High level space complexity because we create a
    // separate array to divide and store than that array

    // Now we Create a reduce a Space Complexity Method...

    // Merge Sorting Method 2;

    public static void mergeSortInPlace(int[] arr, int start, int end) {
        if (end - start == 1)
            return;
        int mid = (start + end) / 2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);
        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] joined = new int[e - s];
        int i = s, j = m, k = 0;
        while (i < m && j < e) {
            if (arr[i] < arr[j])
                joined[k++] = arr[i++];
            else
                joined[k++] = arr[j++];
        }
        while (i < m)
            joined[k++] = arr[i++];
        while (j < e)
            joined[k++] = arr[j++];

        for (k = 0; k < joined.length; k++) {
            arr[s + k] = joined[k];
        }

    }

    // Quick Sorting Method...

    public static void quickSort(int[] arr, int low, int high) {
        if (low > high)
            return;

        int start = low;
        int end = high;
        int mid = (start + end) / 2;
        int pivot = arr[mid];
        while (start <= end) {
            while (arr[start] < pivot)
                start++;
            while (arr[end] > pivot)
                end--;

            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        // Sorting.bubleSort(arr);
        // System.out.println(Arrays.toString(arr));
        int[] arr = { 6, 5, 4, 3 };
        // arr = Sorting.mergeSort(arr);
        // System.out.println(Arrays.toString(arr));
        // Sorting.mergeSortInPlace(arr, 0, arr.length);
        // System.out.println(Arrays.toString(arr));
        Sorting.quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

}