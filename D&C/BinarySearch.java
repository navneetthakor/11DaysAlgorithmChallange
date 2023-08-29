


// main class 

import java.util.Scanner;
import java.util.Arrays;

public class BinarySearch{
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of inputs");
        n= sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Start entering the data : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Calling the binary search");
        binarySearch(arr, 5);


    }

    static void binarySearch(int[] arr, int n){
        Arrays.sort(arr);
        innerSearch(arr, 0, arr.length-1, n);
    }

    static void innerSearch(int[] arr, int first, int last, int find){
        if(first > last){
            System.out.println("Element not found");
            return;
        }

        int mid = (first + last) / 2;
        if(arr[mid] == find){
            System.out.println("Element found : " + arr[mid]);
            return;
        }
        else if(arr[mid] < find){
            innerSearch(arr, mid+1, last, find);
        }else{
            innerSearch(arr, first, mid-1, find);
        }


    }
}