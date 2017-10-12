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
	

}
