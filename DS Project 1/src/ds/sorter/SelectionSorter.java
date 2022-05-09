package ds.sorter;

import java.util.List;

public class SelectionSorter<E extends Comparable<E>> implements Sorter<E> {

	@Override
	public List<E> sort(List<E> input) {
		// we get the length of our array size
		int size = input.size();
		
		// We check value one by one
		for(int i = 0; i < size - 1; i++) {
			// we initialize minimum index
			int minIndex = i;
			for(int j = i + 1; j< size; j++) {
				// we check if current loop is less than the minIndex, if yes we set it to the minimum index
				if(input.get(j).compareTo(input.get(minIndex)) == -1) {
					minIndex = j;
				}
			}
			// We swap the minimum element found in the second loop to our main loop
			E temp = input.get(minIndex);
			input.set(minIndex, input.get(i));
			// set current item to our temp minimum element
			input.set(i, temp);
		}
		// we return the sorted list
		return input;
   	}

}
