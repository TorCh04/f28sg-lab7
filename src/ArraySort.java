import java.util.ArrayList;
import java.util.Iterator;

public class ArraySort {

	/** Insertion sort of an array
	 * @param arr the array to be sorted in-place
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > cur) {
				arr[j + 1] = arr[j--];
				arr[j + 1] = cur;
			}
		}
	}

	/** Insertion sort of an array
	 * 
	 * This is Question 3
	 * 
	 * TODO Where N is the number of elements in the array 'arr' the complexity is:
	 *
	 * O(n^2)
	 * 
	 * @param arr the array to be sorted in-place
	 */
	public static void bubbleSort(int[] arr) {
		boolean swaps = true;
		int temp;
		// Loops while swaps is true
		while (swaps) 
		{
			swaps = false;
			// Loops through every element in array
			for (int i = 0; i < arr.length-1; i++) 
			{
				// If the next value in the array is greater than the current one
				if (arr[i+1] < arr[i]) 
				{
					// Swaps the 2 values and sets swaps to true incase there is more to be swapped
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swaps = true;
				}
			}
		}
	}

	/** Quick sort of an array. This method creates a new array with
	 * its values sorted, based on the values in the unsorted input array S.
	 * 
	 * This is Question 5
	 * 
	 * TODO Where N is the number of elements in the array 'S' the complexity is:
	 *
	 * O(n log n)
	 * 
	 * @param S the unsorted input array
	 * @return the sorted output array
	 */
	public static ArrayList<Integer> quickSort(ArrayList<Integer> S) {
		// Checks for an empty list
		if (S.size() <= 1)
			return S;

		else
		{
			// Creates a Pivot pointing to the last element in the Array List and 3 Array Lists
			// Storing values lower than pivot, equal to pivot and higher than pivot 
			ArrayList<Integer> lower = new ArrayList<Integer>();
			ArrayList<Integer> higher = new ArrayList<Integer>();
			ArrayList<Integer> equal = new ArrayList<Integer>();
			int pivot = S.get(S.size() - 1);

			// Loops while the list isn't empty
			while (S.size() > 0) 
			{
				// Creates a variable that stores the removed value of the first item of the Array List
				int current = S.remove(0);
				// If pivot is bigger then add it to lower list
				if (pivot > current)
				{
					lower.add(current);
				}		
				// If pivot is smaller then add it to higher list
				else if (pivot < current)
				{
					higher.add(current);
				}
				// Adds it to equal list
				else
					equal.add(current);
			}
			
			// Recursively calls quickSort on lower and higher list and store them in respective Array List
			ArrayList<Integer> sortedLower = quickSort(lower);
			ArrayList<Integer> sortedHigher = quickSort(higher);
			ArrayList<Integer> sorted = new ArrayList<>();

			// Adds the sorted values into the sorted list
			sorted.addAll(sortedLower);
			sorted.addAll(equal);
			sorted.addAll(sortedHigher);

			return sorted;
		}
	}

	
	/** predicate to check if array is sorted
	 * @param arr the array to be checked
	 * @return true if the array is sorted, false otherwise
	 */
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1])
				return false;
		return true;
	}

	
	/** predicate to check if arrayList is sorted.
	 *  Useful for checking ArrayList<Integer> lists returned
	 *  from Quick Sort.
	 * 
	 * @param arr the array to be checked
	 * @return true is the aray is sorted, flalse otherwise
	 */
	public static boolean isSorted(ArrayList<Integer> arr) {
		Iterator i = arr.iterator();
		int val;
		if (i.hasNext())
			val = (int) i.next();
		else
			return true;
		while (i.hasNext()) {
			int nv = (int) i.next();
			if (val > nv)
				return false;
			val = nv;
		}
		return true;
	}

	
	/** Helper printing methods for testing
	 * @param arr the array to print
	 */
	private static void printIntArray(int[] arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	private static void printIntArrayList(ArrayList<Integer> arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	public static void main(String[] args) {
		// testing part1
		int[] arr1 = { 5, 4, 3, 2, 1};
		bubbleSort(arr1);
		printIntArray(arr1);

		// testing part2
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(1);
		arr2.add(6);
		arr2.add(5);
		ArrayList<Integer> arr2_sorted = quickSort(arr2);
		printIntArrayList(arr2_sorted);
		// {5,4,3,5,1};

	}

}
