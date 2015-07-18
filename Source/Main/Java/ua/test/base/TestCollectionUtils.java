package ua.test.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;


public class TestCollectionUtils {
	
	/**
	 * Adds an element to a list.
	 * Null safe. If the list doesn't exist, it will be created.
	 * 
	 * @param collection
	 * @return
	 */
	public static <T> List <T> add (List <T> list, T item) {

		if (list == null) {
			list = new ArrayList <T> ();
		}
		
		list.add (item);
		
		return list;
	}
	
	/**
	 * Create a new list with one item in it.
	 * 
	 * @param item
	 * @return
	 */
	public static <T> List <T> asList (T item) {
		
		List <T> list;
		
		list = new ArrayList <T>();
		list.add (item);
		
		return list;
	}

	/**
	 * Create a new list out of an array of items.
	 * 
	 * @param item
	 * @return
	 */
	@SafeVarargs
	public static <T> List <T> asList (T... itemArray) {
		
		List <T> list;
		
		list = new ArrayList <T>();
		
		for (T item: itemArray) {
			list.add (item);
		}
		
		return list;
	}
	
	/**
	 * Creates a new list out of the elements of the collection.
	 * 
	 * @param collection
	 * @return
	 */
	public static <T> List <T> asList (Collection <T> collection) {
		
		List <T> list;
		
		list = new ArrayList <T> ();
		list.addAll (collection);
		
		return list;
	}

	/**
	 * Creates a new list out of the elements of the collection.
	 * 
	 * @param collection
	 * @return
	 */
	public static <T> List <T> asList (Map <?, T> map) {
		
		List <T> list;
		
		list = new ArrayList <T> ();
		
		for (Object key : map.keySet ()) {
			list.add (map.get (key));
		}
		
		return list;
	}

	/**
	 * Returns a sorted list for any collection.
	 * 
	 * @param collection
	 * @return
	 */
	public static <T extends Comparable<? super T>> List<T> asSortedList (Collection<T> collection) {

		// DECLARATIONS:

		List<T>	list;
		
		
		// CODE:
		
		list = new ArrayList<T> (collection);
		java.util.Collections.sort (list);
		
		return list;
	}
	
	public static <T> String concatenateToString (Collection <T> collection, String separator) {

		TestIsFirst			first;
		StringBuilder		stringBuilder;

		stringBuilder = new StringBuilder();
		
		if (isNotEmpty (collection)) {
	
			first = new TestIsFirst();
	
			for (T item : collection) {
				
				if (first.isNotFirst ()) {
					stringBuilder.append (separator);
				}
				
				stringBuilder.append (item.toString ());
			}
		}
		
		return stringBuilder.toString();
	}
	
	public static <T> SortedMap <String, T> filter (SortedMap <String, T> baseMap, String prefix) {

		String prefixEnd; // Next word beyond prefix.	
			
	    if (TestStringUtils.isNotEmpty (prefix)) {
	    	
	    	prefixEnd = TestStringUtils.nextWord (prefix); 
	        return baseMap.subMap (prefix, prefixEnd);
	    }
	    else {
	    	
	    	return baseMap;
	    }
	}

	public static boolean isEmpty (Collection <?> collection) {
		
		return collection == null || collection.isEmpty ();
	}
	
	public static boolean isNotEmpty (Collection <?> collection) {
		
		return ! isEmpty (collection);
	}
	

	
	/**
	 * Returns the size of a collection.
	 * Null safe. Nulls will return 0.
	 * 
	 * @param collection
	 * @return
	 */
	public static <T> int size (Collection <T> collection) {
		
		if (collection != null) {
			return collection.size();
		}
		else {
			return 0;
		}
	}
}
