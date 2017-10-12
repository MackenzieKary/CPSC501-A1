
public class BubbleSort {

	public BubbleSort() {
		// Initialize algorithm if necessary
	}
	public int[] executeBubbleSort(int[] arr){
		for (int i = 0; i < arr.length-1; i++){
			for (int j = arr.length-1; j > i; j--){
				if (arr[j] < arr[j-1]){
        			swap(arr,j,j-1);
        		}
        	}
        }
		return arr;
	}
	private static void swap(int[] a, int i, int j) {
        // TODO Auto-generated method stub
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
