import java.util.Scanner;
import java.util.ArrayList;

public class MergeSort {
    public static void main(String args[]){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size : ");
        n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Start entering the elements : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        // calling the mergeSort 
        System.out.println("Calling the mergeSort : ");
        mergeSort(arr, 0, n-1);

        System.out.println("Sorted array : ");
        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }
    }

    static void merge(int[] arr, int first, int mid, int last){

        // creating temporory Arrays to store the values
        int tempA[] = new int[(mid - first +1)];
        int tempB[] = new int[(last - mid)];
        
        // puting values in temporory arrays 
        for(int i=first; i<=mid; i++){
            tempA[i-first] = arr[i];
        }
        for(int i=mid+1; i<=last; i++){
            tempB[i-mid-1] = arr[i];
        }

        // temporary indexing
        int indexA=0,indexB=0,indexM = first;

        // merging them in correct order 
        while(indexA<tempA.length && indexB<tempB.length){
            if(tempA[indexA] < tempB[indexB]){
                arr[indexM] = tempA[indexA];
                indexA++;
            }else{
                arr[indexM] = tempB[indexB];
                indexB++;
            }
            // System.out.println("--------------------");
            indexM++;
        }


        // for remaing elements in any array 
        while(indexA < tempA.length){
            arr[indexM] = tempA[indexA];
            indexA++;
            indexM++;
        }
        while(indexB < tempB.length){
            arr[indexM] = tempB[indexB];
            indexB++;
            indexM++;
        }
    }

    static void mergeSort(int arr[], int first, int last){
        if(first >= last)
            return;
        System.out.println("Started");
        int mid = (first + last)/2;
        mergeSort(arr, first, mid);
        mergeSort(arr, mid+1, last);
        merge(arr, first, mid, last);
    }
}
