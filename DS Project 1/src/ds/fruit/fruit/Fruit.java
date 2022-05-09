package ds.fruit;

import java.util.ArrayList;
import java.util.List;

// We implement comparable interface so we can compare it to other Fruit class
public class Fruit implements Comparable<Fruit> {
	
	private TYPE type;
	private double weight;
	private double ripeness;
	
	// We define our own enum TYPE 
	public enum TYPE {
	    APPLE, PEAR, BANANA, GRAPE
	}
	
	/**
	 * Constructor to set our type, weight, and ripeness in our Fruit class
	 * @param type
	 * @param weight
	 * @param ripeness
	 * @throws InvalidFruitWeightException 
	 * @throws InvalidFruitRipenessException 
	 */
	public Fruit(TYPE type, double weight, double ripeness) throws InvalidFruitWeightException, InvalidFruitRipenessException {
		// If weight is less than 0, we throw InvalidFruitWeightException  
		if(weight < 0)
			throw new InvalidFruitWeightException("Fruit weight cannot be negative!");
		// If ripeness is outside of range 0-1 we throw InvalidFruitWeightException
		if(ripeness > 1.0 || ripeness < 0)
			throw new InvalidFruitRipenessException("Fruit ripeness must be in range of 0-1");
		this.type = type;
		this.weight = weight;
		this.ripeness = ripeness;
	}
	
	// We set our getter and setters for our class fields
	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getRipeness() {
		return ripeness;
	}

	public void setRipeness(double ripeness) {
		this.ripeness = ripeness;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		return String.format("%s, %.2f, %.2f", this.type, this.weight, this.ripeness);
	}

	@Override
	public int compareTo(Fruit f2) {
		if(getType() == TYPE.PEAR && f2.getType() != TYPE.PEAR) {
			return 1;
		} else if(getType() != TYPE.PEAR && f2.getType() == TYPE.PEAR) {
			return -1;
		} else if (((getType() == TYPE.APPLE || getType() == TYPE.GRAPE)  && (f2.getType() == TYPE.APPLE || f2.getType() == TYPE.GRAPE)) || getType().equals(f2.getType())) {
			if(Math.abs(f2.getWeight() - getWeight()) <= 0.05) {
				if(getRipeness() > f2.getRipeness()) {
					return 1;
				} else return -1;
			}
			if(getRipeness() > f2.getRipeness()) {
				return 1;
			} else return -1;
			
		} else if (getType() != TYPE.BANANA && f2.getType() == TYPE.BANANA) {
			return 1;
		} else if (getType() == TYPE.BANANA && f2.getType() != TYPE.BANANA) {
			return -1;
		}
		return 0;
	}
	
	public static void main(String[] args) throws InvalidFruitWeightException, InvalidFruitRipenessException {
		Fruit f = new  Fruit(TYPE.APPLE, 1, 1);
		Fruit f2 = new  Fruit(TYPE.PEAR, 0.3, 0.4);
		
		List<Fruit> list = new ArrayList<Fruit>();
		list.add(f);
		list.add(f2);
		System.out.println(f2);
		
	}
}
