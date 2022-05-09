package ds.sorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSorter<E extends Comparable<E>> implements Sorter<E> {
	
	@Override
	public List<E> sort(List<E> input) {
		int left = 0;
		int right = input.size() - 1;
		if(left < right) {
			// get middle point
			int middle = left + (right-left)/2;
			
			// sort 1st half
			sort(input, left, middle);
			//sort 2nd half
			sort(input, middle + 1, right);
			
			//merge sorted halfs
			merge(input, left, middle, right);
		}
		return input;
	}
	
	// method to sort based on left and right integers
	public void sort(List<E> input, int left, int right) {
		if(left < right) {
			// get middle point
			int middle = left + (right-left)/2;
			
			// sort 1st half
			sort(input, left, middle);
			//sort 2nd half
			sort(input, middle + 1, right);
			
			//merge sorted halfs
			merge(input, left, middle, right);
		}
	}
	
	 // method to merge two arrays
	private void merge(List<E> input, int left, int middle, int right) {
		
		int leftLength = middle - left + 1;
		int rightLength = right - middle;
		
		// create temp array list
		List<E> leftList = new ArrayList<>(leftLength);
		List<E> rightList = new ArrayList<>(rightLength);
		System.out.println(input.size());
		
		// We add data to our temporary list
		for (int i = 0; i < leftLength; ++i) {
			leftList.add(i, input.get(left + i));
		}
		for(int q = 0; q < rightLength; ++q) {
			rightList.add(q, input.get(middle + 1 + q));
		}
		
        // Initial indexes of first and second subarrays
        int w = 0;
        int e = 0;
  
        // Initial index of merged subarray array
        int k = left;
        while (w < leftLength && e < rightLength) {
            if (rightList.get(e).compareTo(leftList.get(w)) > 0) {
                input.set(k, leftList.get(w));
                w++;
            }
            else {
                input.set(k, rightList.get(e));
                e++;
            }
            k++;
        }
  
        // Copy remaining elements of leftList if any
        while (w < leftLength) {
            input.set(k, leftList.get(w));
            w++;
            k++;
        }
  
        // Copy remaining elements of rightList if any
        while (e < rightLength) {
            input.set(k, rightList.get(e));
            e++;
            k++;
        }
			
	}
	
	 // just for testing purposes only
	 void printArray(List<E> input) {
        for(E e : input) {
        	System.out.println(e);
        }
        System.out.println("end");
     }
	
	// tester main method
	public static void main(String[] args) {
		MergeSorter<Integer> ob = new MergeSorter();
		List<Integer> eee = new ArrayList<>();
		
		eee.addAll(Arrays.asList(12, 11, 13, 5, 6, 7));
		 System.out.println("Given Array");
	    ob.printArray(eee);
	    
	    ob.sort(eee);
	    
	    System.out.println("sort Array");
	    ob.printArray(eee);
	    
	}
}
