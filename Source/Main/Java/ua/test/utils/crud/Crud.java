package ua.test.utils.crud;

import java.util.List;

import ua.test.base.TestItemNotFoundException;


public interface Crud <Item extends WithId>{

	public Item			create (Item item);
	public void			delete (long id) throws TestItemNotFoundException;
	public void			delete (Item item) throws TestItemNotFoundException;
	public Item			retrieve (long id) throws TestItemNotFoundException;
	public List <Item>	retrieveAll();
	public void			update (Item item) throws TestItemNotFoundException;
}
