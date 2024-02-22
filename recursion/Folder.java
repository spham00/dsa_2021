package recursion;

import list.*;

/**
 * The Folder class represents a folder that contains items.
 * 
 * @author	(Sarah Pham)
 * @version	(October 2021)
 */
public class Folder extends Item
{
	
	private List<Item> items;

	/**
	 * Creates an empty folder with the given name.
	 * @param name	The name of the Folder.
	 */
	public Folder(String name) 
	{
		super(name);
		items = new ArrayList<Item>();
	}
	
	/**
	 * @return	A List of the items in the Folder.
	 */
	public List<Item> getItems() 
	{
		return items;
	}
	
	/**
	 * Adds the given Item to this Folder.
	 * @param item	The item to be added.
	 */
	public void addItem(Item item) {
		items.add(item);
	}

	@Override
	/**
	 * @return	A list of all the documents making up this Item (and all
	 * 			contained folders) in any order.
	 */
	public List<Document> getAllDocs() {
		List<Document> list = new LinkedList<Document>();
		for(Iterator<Item> it = items.iterator(); it.hasNext(); ) {
			list.addAll(it.next().getAllDocs());
		}
		return list;
	}

	@Override
	/**
	 * Display the name of this Item; also display all the items which it
	 * contains, on separate lines.
	 */
	public void show() {
		System.out.println("Folder: " + name + "\n");
		for(Iterator<Item> it = items.iterator(); it.hasNext(); ) {
			it.next().show();
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
}
