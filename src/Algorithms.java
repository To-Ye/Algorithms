import javax.sound.midi.SysexMessage;
import java.util.Arrays;
import java.util.Random;


public class Algorithms {
    public static void main(String args[]){
        int element = 3;
        int[] sortedArr = {1,2,4,5,6};
        int[] unsortedArr = {6,5,4,3,2,1};

        System.out.println(Arrays.toString(insertionSort(unsortedArr)));






    }


    public static int recBinarySearch(int start, int end, int element, int[] arr){
        if(end == start){
            if(arr[start-1] == element){
                return start-1;
            }
            return -1;
        }



        if(element <= start+((end-start)/2)){
            return recBinarySearch(start, start+((end-start)/2), element, arr);
        } else {
            return recBinarySearch(start+((end-start)/2) + 1, end, element, arr);
        }

    }

    public static int binarySearch(int start, int end, int element, int[] arr){

        while(start != end){
            if(element <= arr[start+((end-start)/2)]){
                end = start+((end-start)/2);
            } else {
                start = start+((end-start)/2) + 1;
            }
        }

        return start;
    }

    public static int[] bubbleSort(int[] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j+1 < arr.length; j++){
                if(arr[j] > arr[j+1]){
                    int smaller = arr[j+1];
                    int bigger = arr[j];
                    arr[j] = smaller;
                    arr[j+1] = bigger;
                }
            }
        }

        return arr;
    }

    public static int[] insertionSort(int[] arr){
        int[] out = {};
        for(int i = 0; i < arr.length; i++){
            int temp = arr[i];
            int index = binarySearch(0, i, temp, out);
            out = moveUp(index, out);
            out[index] = temp;
        }

        return out;
    }

    public static int[] moveUp(int start, int[] arr){
        int[] out = Arrays.copyOf(arr, arr.length + 1);
        for(int i = arr.length-1; i >= start; i--){
            out[i+1] = out[i];
        }

        return out;
    }
}
