import java.util.Arrays;

import javax.xml.transform.Templates;

/**
 * lesson2
 */
public class lesson2 {

    public static void main(String[] args) {

        int[] array = { 12, 32, 45, 3, 78, 90, 1, 4, 8, 13, 63, 77, 51, 91, 99 };

        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(array));
        heapsort(array);
        System.out.println("Отсортированный массив");
        System.out.println(Arrays.toString(array));

    }

    public static int LEFT(int i) {
        return (2 * i + 1);
    }

    public static int RIGHT(int i) {
        return (2 * i + 2);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void heapify(int[] array, int i, int size) {
        int left = LEFT(i);
        int right = RIGHT(i);
        int largets = i;
        if (left < size && array[left] > array[i]) {
            largets = left;
        }
        if (right < size && array[right] > array[largets]) {
            largets = right;
        }
        if (largets != i) {
            swap(array, i, largets);
            heapify(array, largets, size);
        }
    }

    public static int pop(int[] array, int size) {
        if (size <= 0) {
            return -1;
        }
        int top = array[0];
        array[0] = array[size - 1];
        heapify(array, 0, size - 1);
        return top;
    }

    public static void heapsort(int[] array) {
        int n = array.length;
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(array, i--, n);
        }
        while (n > 0) {
            array[n - 1] = pop(array, n);
            n--;
        }
    }

}