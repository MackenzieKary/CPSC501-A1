package sorting;

public class MergeSort {

	public MergeSort() {
		// Initialize algorithm if necessary
	}
	
	// *** NOTE *** Merge Sort, leftHalf, and rightHalf code is from WEB. URL = http://www.buildingjavaprograms.com/code_files/3ed/ch13/MergeSort.java
	protected int[] executeMergeSort(int[] arr){
        if (arr.length > 1) {
            // split array into two halves
            int[] left = leftHalf(arr);
            int[] right = rightHalf(arr);
            
            // recursively sort the two halves
            executeMergeSort(left);
            executeMergeSort(right);
            
            // merge the sorted halves into a sorted whole
            merge(arr, left, right);
        }
		return arr;
    }  
	
    // Returns the first half of the given array.
    private static int[] leftHalf(int[] arr) {
        int size1 = arr.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = arr[i];
        }
        return left;
    }  
    
    // Returns the second half of the given array.
    private static int[] rightHalf(int[] arr) {
        int size1 = arr.length / 2;
        int size2 = arr.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = arr[i + size1];
        }
        return right;
    } 
    
    private static void merge(int[] result, 
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

}
