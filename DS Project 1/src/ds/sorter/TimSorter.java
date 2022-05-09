package ds.sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimSorter<E extends Comparable<E>> implements Sorter<E> {
	
	// Variable to base our minimum run
	private static final int MINIMUM_MERGE = 32;
	
	@Override
	public List<E> sort(List<E> input) {
		int minRun = getMinimumRunLength(MINIMUM_MERGE);
        int listSize = input.size();
        
        // We use insertion sort to sort subarrays with size run
        for (int i = 0; i < listSize; i += minRun)
            insertionSort(input, i, Math.min((i + MINIMUM_MERGE - 1), (listSize - 1)));
 
        // We merge from our minimum run
        for (int x = minRun; x < listSize; x = 2 * x) {
 
        	// We merge from our left to (left + 2 * listSize - 1), after ever merge we increase iteration variable to 2*listSize
            for (int left = 0; left < listSize; left += 2 * x) {
 
                // We find the end index for left array, right array will start with middle + 1
                int mid = left + x - 1;
                int right = Math.min((left + 2 * x - 1), (listSize - 1));
 
                // We merge if mid index is less than right index
				if(mid < right) {
					merge(input, left, mid, right);
				}
            }
        }
        // return our input array, sorted
		return input;
   	}
	
	// Method to get the minimum run length based on our collection size
	public int getMinimumRunLength(int size)  {
       
        // Becomes 1 if any 1 bits are shifted off
        int r = 0;
        // check if array size is greater than our set minimum merge run, if so we shift bits until we get to the minimum run
        while (size >= MINIMUM_MERGE) {
            r |= (size & 1);
            size >>= 1;
        }
        // return size + r, we add r just in case we shifted all our bits
        return size + r;
    }
	
	// Merge using insertion sort from left to right index based on run
    public void insertionSort(List<E> input, int left, int right) {
    	//loop through left to right
        for (int x = left + 1; x <= right; x++) {
        	// assign our element to temp variable
            E element = input.get(x);
            // get index of previous element
            int y = x - 1;
            // we compare then check if the element is greater that our current element, if so, we set it to y+1 index 
            while (y >= left && input.get(y).compareTo(element) == 1) {
                input.set(y + 1, input.get(y));
                y--;
            }
            input.set(y + 1, element);
        }
    }
    
    // Merge function merges the sorted runs
    public void merge(List<E> input, int left, int middle, int right) {
        // Original array is broken in two parts
        // left and right array
        int leftLength = middle - left + 1;
        int rightLength = right - middle;
        
        // We create temporary List containers for our element
        List<E> leftList = new ArrayList<>();
        List<E> rightList = new ArrayList<>();
        
        // We assign from left part and right part to our temporary list collections
        for (int x = 0; x < leftLength; x++) {
            leftList.add(x, input.get(left + x));
        }
        for (int x = 0; x < rightLength; x++) {
            rightList.add(x, input.get(middle + 1 + x));
        }
 
        int i = 0;
        int j = 0;
        int k = left;
 
        // Merge two array after comparison
        while (i < leftLength && j < rightLength) {
            if (leftList.get(i).compareTo(rightList.get(j)) == 1) {
                input.set(k,leftList.get(i));
                i++;
            } else {
                input.set(k, rightList.get(j));
                j++;
            }
            k++;
        }
 
        // set remaining elements from left
        while (i < leftLength) {
            input.set(k, leftList.get(i));
            k++;
            i++;
        }
 
        // set remaining elements from right
        while (j < rightLength) {
            input.set(k, rightList.get(j));
            k++;
            j++;
        }
    }
    
    //just for testing purposes only
    void printArray(List<E> input) {
        for(E e : input) {
        	System.out.print(e + " ");
        }
        System.out.println("end");
    }
    
    // tester main method
    public static void main(String[] args) {
		TimSorter<Integer> ob = new TimSorter<Integer>();
		List<Integer> eee = new ArrayList<>();
		
		eee.addAll(Arrays.asList(-2, 7,  15,  -14, 0, 15,  0, 7, -7, -4, -13, 5, 8, -14, 12));
		System.out.println("Given Array");
	    ob.printArray(eee);
	    
	    ob.sort(eee);
	    
	    System.out.println("sort Array");
	    ob.printArray(eee);
	    
	}

}
