package ua.test.utils.crud;

import java.util.ArrayList;
import java.util.List;

import ua.test.base.TestCounter;
import ua.test.base.TestItemNotFoundException;

public class CrudInMemory <Item extends WithId> implements Crud <Item>  {
	
	private static final int	INDEX_NOT_FOUND = -1;
	
	private List <Item>			items			= new ArrayList <Item> ();
	private TestCounter			nextIdCounter	= new TestCounter (true);
	

	@Override
	public Item create (Item item) {

		item.setId (nextIdCounter.getNext());
		items.add (item);
		return item;
	}

	
	@Override
	public void delete (long id) throws TestItemNotFoundException {
		
		int index;
		
		index = findIndex (id);

		if (index != INDEX_NOT_FOUND) {
			items.remove (index);
		}
		else {
			throw new TestItemNotFoundException ("Item not found.");
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

		int index;
		Item item;
		
		index = findIndex (id);

		if (index != INDEX_NOT_FOUND) {
			item = items.get (index);
		}
		else {
			throw new TestItemNotFoundException ("Item not found.");
		}
		
		return item;
	}

	
	@Override
	public List <Item> retrieveAll() {

		return items;
	}

	
	@Override
	public void update (Item item) throws TestItemNotFoundException {
		
		int index;
		
		index = findIndex (item);

		if (index != INDEX_NOT_FOUND) {
			items.set (index, item);
		}
		else {
			throw new TestItemNotFoundException ("Item not found.");
		}
	}
	
	
	private int findIndex (Item item) {
		
		if (item != null) {
			return findIndex (item.getId());
		}
		else {
			
			return INDEX_NOT_FOUND;
		}
	}

	
	private int findIndex (long id) {
		
		int index = INDEX_NOT_FOUND;

		for (int i = 0; i < items.size(); i++) {
			
			if (items.get(i).getId() == (int) id) {
				index = i;
				break;
			}
		}
		
		return index;
	}
}
