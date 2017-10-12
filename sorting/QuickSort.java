package sorting;

public class QuickSort {

	public QuickSort() {
		// Initialize algorithm if necessary
	}
	
	// *** NOTE *** Quick Sort, partition, and swap code is from WEB. URL = http://codereview.stackexchange.com/questions/4022/java-implementation-of-quick-sort  (w/some alterations)
	protected int[] executeQuickSort(int[] arr, int p, int arrLength){
        if(p<arrLength)
        {
            int q=partition(arr,p,arrLength);
            executeQuickSort(arr,p,q);
            executeQuickSort(arr,q+1,arrLength);
        }
		return arr;
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
