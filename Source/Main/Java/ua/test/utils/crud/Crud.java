package ua.test.utils.crud;

import java.util.Collection;

import ua.test.base.TestItemNotFoundException;


public interface Crud <Item extends WithId>{

	public boolean		contains (long id);
	public boolean		contains (Item item);
	public Item			create (Item item);
	public void			delete (long id) throws TestItemNotFoundException;
	public void			delete (Item item) throws TestItemNotFoundException;
	public Item			retrieve (long id) throws TestItemNotFoundException;
	public Collection<Item>	retrieveAll();
	public void			update (Item item) throws TestItemNotFoundException;
}
