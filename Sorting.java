
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random; 
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;



public class Sorting {
	public static void main(String[] args) throws Exception {
	
		error(args[0],args[1],args[2]);
	
		String order = args[0].toLowerCase();			// Get the desired order (Asc./Dec./Rand.) determined by user 
		int arrLength = Integer.parseInt(args[1]);		// Get the length of array determined by user
		String algorithm = args[2].toLowerCase();		// Get the desired algorithm, determined by user
		String outputFile = args[3];					// Get the desired name for the output file (Where the sorted lists will be written to)
	
		int[] arr = new int[arrLength]; 
	
		if (order.equals("ascending")){
			arr = ascendingArray(arr);
			if(algorithm.equals("bubble")){
				long startTime = System.nanoTime();
				bubbleSort(arr);
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime; 
				System.out.println("Time to sort: " + totalTime + " nanoseconds");
			}
			else if (algorithm.equals("insertion")){
				long startTime = System.nanoTime();
				insertionSort(arr);
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.println("Time to sort: " + totalTime + " nanoseconds");
			}
			else if (algorithm.equals("merge")){
				long startTime = System.nanoTime();
				mergeSort(arr);
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.println("Time to sort: " + totalTime + " nanoseconds");
			}
			else {
				long startTime = System.nanoTime();
				quickSort(arr, 0, arrLength-1);
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.println("Time to sort: " + totalTime + " nanoseconds");
			}		
		}
		if (order.equals("descending")){
			arr = descendingArray(arr);
			if(algorithm.equals("bubble")){
				long startTime = System.nanoTime();
				bubbleSort(arr);
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime; 
				System.out.println("Time to sort: " + totalTime + " nanoseconds");
			}
			else if (algorithm.equals("insertion")){
				long startTime = System.nanoTime();
				insertionSort(arr);
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime; 
				System.out.println("Time to sort: " + totalTime + " nanoseconds");
			}
			else if (algorithm.equals("merge")){
				long startTime = System.nanoTime();
				mergeSort(arr);
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime; 
				System.out.println("Time to sort: " + totalTime + " nanoseconds");
			}
			else {
				long startTime = System.nanoTime();
				quickSort(arr, 0, arrLength-1);
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime; 
				System.out.println("Time to sort: " + totalTime + " nanoseconds");
			}		
		}
		if (order.equals("random")){
			arr = randomArray(arr);
			if(algorithm.equals("bubble")){
				long startTime = System.nanoTime();
				bubbleSort(arr);
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime; 
				System.out.println("Time to sort: " + totalTime + " nanoseconds");
			}
			else if (algorithm.equals("insertion")){
				long startTime = System.nanoTime();
				insertionSort(arr);
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime; 
				System.out.println("Time to sort: " + totalTime + " nanoseconds");
			}
			else if (algorithm.equals("merge")){
				long startTime = System.nanoTime();
				mergeSort(arr);
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime; 
				System.out.println("Time to sort: " + totalTime + " nanoseconds");
			}
			else {
				long startTime = System.nanoTime();
				quickSort(arr, 0, arrLength-1);
				long endTime = System.nanoTime();
				long totalTime = endTime - startTime; 
				System.out.println("Time to sort: " + totalTime + " nanoseconds");
			}
		}
		printOut(arr, outputFile);
	}
	// Method to print out the sorted array into a text file
	public static void printOut(int[] arr, String fileName){
		try {
			BufferedWriter pOut = new BufferedWriter(new FileWriter(fileName + ".txt"));
			for (int i = 0; i < arr.length; i++){
				pOut.write("" + arr[i]);
				pOut.newLine();
			}	
			pOut.close();}
			catch (IOException e){
		}
	}
	
	

	// Method to check command line arguments for errors which could crash the program. 
	public static void error(String ord, String Length, String alg){
		try {
        	int arrLength = Integer.parseInt(Length);		// Get the length of array determined by user
        	if (arrLength < 1){
        		throw new IllegalArgumentException("Array size must be larger than 0");
			}
        } catch (NumberFormatException e) {
        	System.out.println("Array length is not a valid integer");
            System.exit(0);
		}
		// Check that a proper type of array is provided (Ascending, Descending, or Random)
		String order = ord.toLowerCase();
		if (!order.equals("ascending") && !order.equals("descending") && !order.equals("random")){
			throw new IllegalArgumentException("Please indicate order of array. (Ascending/Descending/Random)");
		}
		// Check that a proper type of algorithm is provided (Bubble, Insertion, Merge, or Quick)
		String algorithm = alg.toLowerCase();
		if (!algorithm.equals("bubble") && !algorithm.equals("insertion") && !algorithm.equals("merge") && !algorithm.equals("quick")){
			throw new IllegalArgumentException("Please choose one of the available sorting methods. (Bubble/Insertion/Merge/Quick)");
		}
		
	}
	

	
	
	
	// Create an initial ascending array
	public static int[] ascendingArray(int[] arr){
		for (int i = 0; i < arr.length; i++){
			arr[i] = i + 1;
		}
		return arr;
	}	
	// Create an initial descending array
	public static int[] descendingArray(int[] arr){
		for (int i = 0; i < arr.length; i++){
			arr[i] = arr.length - i;
		}
		return arr;
	}
	// Create an initial random array
	public static int[] randomArray(int[] arr){
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++){
			arr[i] = rand.nextInt();
		}
		return arr;
	}
	
	// *** NOTE *** Code is from slide 22 of lecture (w/some alterations)
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++){
			for (int j = arr.length-1; j > i; j--){
				if (arr[j] < arr[j-1]){
        			swap(arr,j,j-1);
        		}
        	}
        }
    }
    
    // *** NOTE *** Code is from lecture slides (w/some alterations)
    public static void insertionSort(int[] arr){
    	for (int i = 1, j; i < arr.length; i++){
    		int tmp = arr[i];			//Put number out
    		for (j = i; j > 0 && tmp < arr[j-1]; j--)
    			arr[j] = arr[j-1];		
    		arr[j] = tmp; 				//Insertion part (put number back in)
    	} 
    }
    
    // *** NOTE *** Merge Sort, leftHalf, and rightHalf code is from WEB. URL = http://www.buildingjavaprograms.com/code_files/3ed/ch13/MergeSort.java
	public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            // split array into two halves
            int[] left = leftHalf(arr);
            int[] right = rightHalf(arr);
            
            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);
            
            // merge the sorted halves into a sorted whole
            merge(arr, left, right);
        }
    }
    
    // Returns the first half of the given array.
    public static int[] leftHalf(int[] arr) {
        int size1 = arr.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = arr[i];
        }
        return left;
    }
    
    // Returns the second half of the given array.
    public static int[] rightHalf(int[] arr) {
        int size1 = arr.length / 2;
        int size2 = arr.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = arr[i + size1];
        }
        return right;
    }
    
    public static void merge(int[] result, 
                             int[] left, int[] right) {
        int i1 = 0;   // index into left array
        int i2 = 0;   // index into right array
        
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && 
                    left[i1] <= right[i2])) {
                result[i] = left[i1];    // take from left
                i1++;
            } else {
                result[i] = right[i2];   // take from right
                i2++;
            }
        }
    }
    // *** NOTE *** Quick Sort, partition, and swap code is from WEB. URL = http://codereview.stackexchange.com/questions/4022/java-implementation-of-quick-sort  (w/some alterations)
   	public static void quickSort(int[] a, int p, int r){
        if(p<r)
        {
            int q=partition(a,p,r);
            quickSort(a,p,q);
            quickSort(a,q+1,r);
        }
    }
    private static int partition(int[] a, int p, int r) {

        int x = a[p];
        int i = p-1 ;
        int j = r+1 ;
        while (true) {
            i++;
            while ( i< r && a[i] < x)
                i++;
            j--;
            while (j>p && a[j] > x)
                j--;

            if (i < j)
                swap(a, i, j);
            else
                return j;
        }
    }
	private static void swap(int[] a, int i, int j) {
        // TODO Auto-generated method stub
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}



