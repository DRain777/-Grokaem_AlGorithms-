
/**
 * Реализовать сортировку подсчетом
 * [1 2 3 3 2 3 4 2 1 1 2 3 4 4 2 3 1 4 2 3 4 2 1 2 3 4 2 1 3 4 2 1 2 3 4 4 2 3 3 2 4]
 * Подсчитываем, сколько раз встречается конкретный элемент
 * 1 -> 5 (количество единиц в массиве: число взято с потолка!)
 * 2 -> 7 (количество двоек в массиве)
 * 3 -> 3
 * 4 -> 4
 *        * Вставляем единицу 5 раз
 * Вставляем двойку 7 раз
 * Вставялем тройку 3 раза
 * Вставляем четверку 4 раза
 * */

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 2, 3, 4, 2, 1, 1, 2, 3, 4, 4, 2, 3, 1, 4, 2, 3, 4, 2, 1, 2, 3, 4, 2, 1, 3, 4, 2, 1, 2,
                3, 4, 4, 2, 3, 3, 2, 4 };

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        int[] count = new int[max - min + 1];

        for (int num : arr) {
            count[num - min]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                System.out.println("Element " + (i + min) + " occurs " + count[i] + " times");
            }
        }
    }
}
    

