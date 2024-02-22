package hashDriver;

/**
 * The Book class represents a book, each with its own characteristics.
 * 
 * @author Sarah Pham
 * @version	November 6, 2021
 */
public class Book {
	
	String title;
	String author;
	int pageCount;
	Date copyRight;
	
	public Book(String title, String author, int pageCount, Date copyRight) {
		super();
		this.title = title;
		this.author = author;
		this.pageCount = pageCount;
		this.copyRight = copyRight;
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + title.hashCode();			// title
		hash = 31 * hash + ((author == null) ? 0 : author.hashCode());		// author
		hash = 31 * hash + ((copyRight == null) ? 0 : copyRight.hashCode());	// copyright
		return hash;
	}
	
	/**
	 * Checks for each field except pageCount since same hashcode does NOT mean the two objects are equal
	 * @return whether the user-entered object is equal to this Book
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			Book other = (Book)obj;
			return title.equals(other.getTitle()) && author.equals(other.getAuthor()) &&
					copyRight.equals(other.getCopyRight());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return title + " : " + author + " : " + copyRight + " : " + pageCount + " pages";
	}
	
	// Getters
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	
	public Date getCopyRight() {
		return copyRight;
	}

}
