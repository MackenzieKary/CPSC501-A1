
import java.util.Random; 
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
		}
		else if (order.equals("descending")){
			arr = descendingArray(arr);	
		}
		else if (order.equals("random")){
			arr = randomArray(arr);
		}
		executeSort(arr, algorithm, outputFile);
	}
	
	public static void executeSort(int[] arr, String algorithm, String outputFile){
		long startTime = System.nanoTime();
		
		if(algorithm.equals("bubble")){
			BubbleSort bubbleAlg = new BubbleSort();
			arr = bubbleAlg.executeBubbleSort(arr);
		}
		else if (algorithm.equals("insertion")){
			InsertionSort insertAlg = new InsertionSort();
			arr = insertAlg.executeInsertionSort(arr);
		}
		else if (algorithm.equals("merge")){
			MergeSort mergeAlg = new MergeSort();
			arr = mergeAlg.executeMergeSort(arr);
		}
		else if (algorithm.equals("quick")){
			QuickSort quickAlg = new QuickSort();
			arr = quickAlg.executeQuickSort(arr, 0, arr.length-1);
		}
		
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("\nTime to sort: " + totalTime + " nanoseconds, using %s sort.", algorithm);
		
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
}



