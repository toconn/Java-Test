package ua.test.utils.crud;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import ua.test.base.TestCounter;
import ua.test.base.TestItemNotFoundException;

public class CrudInMemory<Item extends WithId> implements Crud<Item>  {
	
	private Map<Long, Item>		itemMap			= new TreeMap<>();
	private TestCounter			nextIdCounter	= new TestCounter (true);
	

	@Override
	public boolean contains (long id) {
		
		return itemMap.containsKey(id);
	}
	
	
	@Override
	public boolean contains (Item item) {
		
		return itemMap.containsKey(item.getId());
	}

	
	@Override
	public Item create (Item item) {

		item.setId (nextIdCounter.getNext());
		itemMap.put (item.getId(), item);
		return item;
	}

	
	@Override
	public void delete (long id) throws TestItemNotFoundException {
		
		if (contains (id)) {
			itemMap.remove (id);
		}
		else {
			throw newItemNotFoundException (id);
		}
	}

	
	@Override
	public void delete (Item item) throws TestItemNotFoundException {
		
		if (item != null) {
			delete (item.getId());
		}
	}
	
	
	@Override
	public Item retrieve (long id) throws TestItemNotFoundException {

		if (contains (id)) {
			return itemMap.get (id);
		}
		else {
			throw newItemNotFoundException (id);
		}

	}

	
	@Override
	public Collection<Item> retrieveAll() {

		return itemMap.values();
	}

	
	@Override
	public void update (Item item) throws TestItemNotFoundException {
		
		if (contains (item)) {
			itemMap.put (item.getId(), item);
		}
		else {
			throw newItemNotFoundException (item.getId());
		}
	}
	
	
	private TestItemNotFoundException newItemNotFoundException (long id) {
		
		return new TestItemNotFoundException ("Item not found (id " + id + ").");
	}

}
