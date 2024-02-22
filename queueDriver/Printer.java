package queueDriver;

import queue.*;

/**
 * A Printer has a speed, in blocks of printing per step, and a queue of Docs to be printed
 * 
 * @author (sdb)
 * @author (Sarah Pham)
 * @version (2020)
 */
public class Printer
{
	private int speed;      			// speed of this printer, blocks per step
	private QueueADT <Doc> docs;    	// Queue of documents waiting to be printed
	private String id;      			// name of this Printer

	private int blocks = 0;				// The # of blocks left for the current document
	private Doc doc;					// Stores current doc being printed
	private boolean more;				// Whether there are more docs to print

	/**
	 * Constructor for objects of class Printer
	 */
	public Printer(int speed, String id)
	{
		this.speed = speed;
		this.id = id;
		docs = new Queue<Doc>();
	}

	/** Add a document to this printer's queue 
       Display the document and printer on stdout.
	 */
	public void add (Doc doc)
	{    
		docs.add(doc);
		more = true;		// If docs are being added, there are more docs to print

		//////////// Do not change this println statement ///////////////
		System.out.println(doc + " added to " + this);
	}

	/** Print several blocks, if necessary, determined by this printer's speed.
	 * Display a completion message, if necessary.
	 *  
	 */
	public void print()
	{  
		for(int i = speed; i > 0; i--) {
			setDoc();
			if(!more) {		// If there are no more docs, break free from the for loop
				break;
			}

			// To clarify which printer is being used, which document is printed, and
			// which blocks have printed
			System.out.println(id + " " + doc + ": Block " + blocks + " printed");
			blocks--;
		}
	}

	/**
	 * If the number of blocks of the current document is 0, then set up
	 * for the next document to print.
	 */
	private void setDoc() {
		if(blocks == 0) {
			more = !docs.isEmpty();
			if(more) {
				doc = docs.remove();
				blocks = doc.size();
				System.out.println("\n" + doc + " is printing now!");
			}
			else {
				System.out.println("No other documents to print for " + id);
			}
		}
	}

	/** @return the number of documents in this Printer's queue */
	public int size()
	{   return docs.size();  }

	public String toString()
	{   return id + ", speed: " + speed + ", docs in queue: " + size();  }
}
