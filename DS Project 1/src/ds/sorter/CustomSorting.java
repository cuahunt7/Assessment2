package ds.sorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ds.fruit.Fruit;
import ds.fruit.Fruit.TYPE;
import ds.fruit.InvalidFruitRipenessException;
import ds.fruit.InvalidFruitWeightException;

public class CustomSorting {

	
	/**
	 * This method must sort the fruit alphabetically by their type. Fruits must be sorted 
	 *  in the order Apple, Banana, Grape, Pear. The weight and ripeness of a fruit should not
	 *  be considered. 
	 *  
	 * @param list The list to sort. 
	 * @return A sorted list. 
	 */
	public static List<Fruit> sortByType(List<Fruit> list) {
		list.sort(new Comparator<Fruit>() {
			@Override
			public int compare(Fruit o1, Fruit o2) {
				// we compare two enums using compareTo method
				return o1.getType().compareTo(o2.getType());
			}
		});
		return list;
	}
	
	
	/**
	 * This method must sort the fruit by their ripeness value, from 100% ripe to 0% ripe. 
	 * The type and weight of the fruit should not be considered. 
	 * 
	 * @param list The fruit to sort
	 * @return	   A sorted list. 
	 */
	public static List<Fruit> sortByRipeness(List<Fruit> list) {
		list.sort(new Comparator<Fruit>() {
			// Implement your custom compare method here. 
			@Override
			public int compare(Fruit o1, Fruit o2) {
				// we use Double.compare method to compare primitive double data types
				return Double.compare(o1.getRipeness(), o2.getRipeness());
			}
		});
		 return list;
	}
	
	
	// Sample test case,
	public static void main(String[] args) throws InvalidFruitWeightException, InvalidFruitRipenessException {
		Fruit f = new Fruit(TYPE.BANANA, 1,0.3);
		Fruit f2 = new Fruit(TYPE.APPLE, 1,0.5);
		Fruit f3 = new Fruit(TYPE.GRAPE, 1,0.8);
		
		List<Fruit> li = new ArrayList<Fruit>();
		li.add(f);
		li.add(f2);
		li.add(f3);
		
		CustomSorting cs = new CustomSorting();
		List<Fruit> fff = cs.sortByType(li);
		fff.stream().forEach(System.out::println);
	}
}
