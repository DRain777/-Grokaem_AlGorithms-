import java.util.Arrays;
// Дано; отсортированный по возрастанию массив с повторяющимися элементами,
// например 0,1,0,1,1,2,2,3,3,4
// нужно схлопнуть  повторяющие элементы в этом же массиве
// оставшиеся элементы могут быть любыми 
// должно полуится так 0,1,2,3,4......
// https:// leetcode.com/problems/remove-duplicates-from-sorted-array/ 

public class test {


  public static void main(String[] args) {
  int[] arr = {0,0,1,1,1,2,2,3,3,4};
  removeDuplicaes(arr);
  System.out.println(Arrays.toString(arr)); 
        
    }
public static void removeDuplicaes(int[] array ) {
    int i = 0;
    for (int j = 1; j < array.length;j++) {
        if(array[j] != array[i]) {
            i +=1;
            array[i] = array[j];
            System.out.println(array[j]); 
        }
    }
    
}



    
}
