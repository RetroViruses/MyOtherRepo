/**
 * This class wraps a generic object from a class T with an integer
 * that represents the number of times the object has been "added"
 * to a collection
 * 
 *
 * @param <T> The type of the underlying object
 */
public class CountedItem<T> implements Comparable<T>
{
	private T element;      /* The data element inside the CountedItem */
	private int frequency;  /* The frequency associated with this CountedItem */
	
	/**
	 * Constructs a CountedItem, and initializes its frequency count to 1
	 * @param value The object being wrapped in the CountedItem
	 */
	public CountedItem(T value)
	{
		element = value;
		frequency = 1;
	}
	
	/**
	 * Constructs a CountedItem, and initializes its frequency count to value
	 * @param value The object being wrapped in the CountedItem
	 * @param freq The frequency count being wrapped in the CountedItem
	 */
	public CountedItem(T value, int freq)
	{
		element = value;
		frequency = freq;
	}
	
	/**
	 * 
	 * @return The frequency count associated with the object
	 */
	public int getFrequency()
	{
		return frequency;
	}
	
	/**
	 * 
	 * @return The data object wrapped into the CountedItem
	 */
	public T getData()
	{
		return element;
	}
	
	/**
	 * Add 1 to the frequency count for the underlying item
	 */
	public void incFrequency()
	{
		frequency++;
	}
	
	/**
	 * Subtract 1 from the frequency count for the underlying item
	 */
	public void decFrequency()
	{
		frequency--;
	}
	
	/**
	 * Compare two CountedItems by comparing the underlying data objects.
	 * @return 0 if this object is equal to obj, a negative value if this
	 * object is less than obj, and a positive value if this object is
	 * greater than obj
	 */
	public int compareTo(T obj)
	{
		return ((Comparable<T>)element).compareTo(((CountedItem<T>) obj).getData());
	}
	
	/**
	 * @return A string representation of the CountedItem
	 */
	public String toString()
	{
		return element.toString() + "\n" + frequency;
	}
	
	/**
	 * @return True if this object contains the same underlying object
	 * as item, and False otherwise
	 */
	public boolean equals(Object item)
	{
		return (((CountedItem<T>)item)).getData().equals(element);
	}
	
}