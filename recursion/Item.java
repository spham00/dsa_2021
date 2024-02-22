package recursion;

import list.*;

/**
 * The Item class represents one Item, where each item has a name.
 * 
 * @author	(Sarah Pham)
 * @version	(October 2021)
 */
public abstract class Item 
{

	protected String name;
	
	/**
	 * Creates an item with the given name.
	 * @param name The name given to the item.
	 */
	public Item(String name) 
	{
		this.name = name;
	}
	
	/**
	 * @return	A list of all the documents making up this Item (and all
	 * 			contained folders) in any order.
	 */
	public abstract List<Document> getAllDocs();
	
	/**
	 * Display the name of this Item; also display all the items which it
	 * contains, on separate lines.
	 */
	public abstract void show();
	
	/**
	 * Changes the name of the item.
	 * @param name	The name the user wants to change the item's name to.
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	
	/**
	 * @return	The name of the item.
	 */
	public String getName() 
	{
		return name;
	}
}
