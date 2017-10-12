
public class InsertionSort {

	public InsertionSort() {
		// Initialize algorithm if necessary
	}
		
	public int[] executeInsertionSort(int[] arr){
    	for (int i = 1, j; i < arr.length; i++){
    		int tmp = arr[i];			//Put number out
    		for (j = i; j > 0 && tmp < arr[j-1]; j--)
    			arr[j] = arr[j-1];		
    		arr[j] = tmp; 				//Insertion part (put number back in)
    	} 
    	return arr;
    }

}
