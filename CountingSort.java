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
    

