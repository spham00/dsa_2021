package recursion;

import list.*;

/**
 * The Document class represents a document with a name and a type.
 * 
 * @author	(Sarah Pham)
 * @version (October 2021)
 */
public class Document extends Item 
{
	
	private DocType type;

	/**
	 * Creates a Document with the given name and type.
	 * @param name	The name of the document.
	 * @param type	The type of document.
	 */
	public Document(String name, DocType type) 
	{
		super(name);
		this.type = type;
	}

	/**
	 * @return	The type of document.
	 */
	public DocType getType() {
		return type;
	}

	@Override
	/**	
	 * @return	A list of documents with the size of 1 that includes this Document.
	 */
	public List<Document> getAllDocs() {
		List<Document> docs = new ArrayList<Document>();
		docs.add(this);
		return docs;
	}

	@Override
	/**
	 * Display the name of this Item; also display all the items which it
	 * contains, on separate lines.
	 */
	public void show() {
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return name + "." + type;
	}

}
