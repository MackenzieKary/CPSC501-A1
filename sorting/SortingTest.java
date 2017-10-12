package sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortingTest {

	
	@Test
	public void testAscendingArrayCreation(){
		int[] intArr = new int[10];
		int[] ascArr = Sorting.ascendingArray(intArr);
		assertArrayEquals(new int[] {1,2,3,4,5,6,7,8,9,10}, ascArr);
	}
	@Test
	public void testDescendingArrayCreation(){
		int[] intArr = new int[5];
		int[] ascArr = Sorting.descendingArray(intArr);
		assertArrayEquals(new int[] {5,4,3,2,1}, ascArr);
	}
	@Test
	public void testBubbleSort(){
		int[] intArr = new int[] {2, 23, 3, 16, 1, 94, 12};
		BubbleSort bubble = new BubbleSort();
		int[] sortedArr = bubble.executeBubbleSort(intArr);
		assertArrayEquals(new int[] {1,2,3,12,16,23,94}, sortedArr);
	}
	@Test
	public void testInsertionSort(){
		int[] intArr = new int[] {2, 23, 3, 16, 1, 94, 12};
		InsertionSort insert = new InsertionSort();
		int[] sortedArr = insert.executeInsertionSort(intArr);
		assertArrayEquals(new int[] {1,2,3,12,16,23,94}, sortedArr);
	}
	@Test
	public void testMergeSort(){
		int[] intArr = new int[] {2, 23, 3, 16, 1, 94, 12};
		MergeSort merge = new MergeSort();
		int[] sortedArr = merge.executeMergeSort(intArr);
		assertArrayEquals(new int[] {1,2,3,12,16,23,94}, sortedArr);
	}
	@Test
	public void testQuickSort(){
		int[] intArr = new int[] {2, 23, 3, 16, 1, 94, 12};
		QuickSort quick = new QuickSort();
		int[] sortedArr = quick.executeQuickSort(intArr, 0, intArr.length-1);
		assertArrayEquals(new int[] {1,2,3,12,16,23,94}, sortedArr);
	}
	@Test(expected = java.lang.IllegalArgumentException.class) 
	public void testErrorCheck(){
		String arrayOrder = "wejweovjv";	// Invalid
		String arraySize = "2000";			// Valid
		String sortingAlg = "bubble";		// Valid
		
		Sorting.error(arrayOrder, arraySize, sortingAlg);
				
		
	}
	
	

}
