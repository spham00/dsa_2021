package alloc;

import list.*;

/**
 * Simulate the allocation and freeing of memory.
 * @author sdb
 */
public class Memory {

	// Blocks which are in use, not available
	List<Block> allocated = new LinkedList<Block>();
	
	// Available blocks
	List<Block> free = new LinkedList<Block>();
	
	static final int MAX = 4096;	// total size of memory
	
	public Memory() {
		free.add(new Block(0, MAX));		// all of memory is free at creation
	}
	
	/**
	 * Allocate a block of the given size, if possible.
	 * @return its position in memory or -1 if not possible.
	 * Algorithm: First-fit (as soon as you find a block big enough, use it)
	 */
	public int allocate(int size) {
		Block b, newBlock = null;
		Iterator<Block> freeItty = free.iterator();
		
		// First-fit algorithm below
		/**
		while(freeItty.hasNext()) {
			b = freeItty.next();
			if(b.size >= size) {						// big enough?
				newBlock = new Block(b.start, size);	// makes a block of given size
				allocated.add(newBlock);				// allocates a block of memory for user
				b.start = b.start + size;				// need to adjust b's size since location has changed
				b.size = b.size - size;					// decreases b/c you're allocating the memory for it,
														// the size will always be smaller
				if(b.size == 0)
					freeItty.remove();					// if size is 0, it's not free anymore
				return newBlock.start;					// since a found fit was successful, return its position
			}
		}
		
		return -1;	// no blocks were big enough (first-fit)
		*/
		
		int min_size = 0;					// least found size
		int index = -1;						// position 
		Block changed = null;				// the block to be changed if found
		
		// Best-fit algorithm
		while(freeItty.hasNext()) {
			b = freeItty.next();
			
			if(b.size >= size) {				// big enough?
				if (index == -1) {				// if no block has been found yet,
					index = b.start;			// set new index
					min_size = b.size;			// set the min_size for future blocks to beat
					changed = b;				// set changed block for future changing
				}
				else if (index != -1 && min_size < b.size) {	// if not first time finding good enough block
					index = b.start;							// and the size is less than the one previously found
					min_size = b.size;							// set the new index, min_size, and changed block
					changed = b;
				}
			}
		}
		
		if (index != -1) {							// if an index isn't -1, we found a suitable block
			newBlock = new Block(index, size);
			allocated.add(newBlock);
			changed.start = changed.start + size;
			changed.size = changed.size - size;
			
			if(changed.size == 0)
				free.remove(changed.start);
		}
		
		return index;
	}
	
	/**
	 * Make the block at the given start position available
	 * @return true iff there is such a block
	 */
	public boolean free(int start) {
		Block b, f;								// blocks for iterators
		boolean next = false, prev = false;		// whether a free block exists after or before the one found
		Block nextB = null, prevB = null;		// the neighbor blocks, if found
		Block newBlock = null;					// the new block to be added to free
		
		Iterator<Block> itty = allocated.iterator();
		Iterator<Block> freeItty = free.iterator();
		
		while(itty.hasNext()) {
			b = itty.next();
			if(b.start == start) {						// if we find it, remove
				itty.remove();
				//index = b.start + b.size;		// the index of the next block
				
				while(freeItty.hasNext()) {		// step through the free iterator
					f = freeItty.next();
					if(f.start == b.start + b.size) {		// search for if it's the next block
						next = true;
						nextB = f;
					}
					else if(f.start + f.size == b.start) {
						prev = true;
						prevB = f;
					}
				}
				
				// merge depending on if there was a previous and/or next block
				if (prev && next) {			// if 2 neighbor blocks found
					free.remove(prevB);		// remove current neighbor blocks from free
					free.remove(nextB);		// create new block big as all three blocks (merge)
					newBlock = new Block(prevB.start, prevB.size + b.size + nextB.size);
					free.add(0, newBlock);
				} else if (prev) {			// if only a previous block was found
					free.remove(prevB);
					newBlock = new Block(prevB.start, prevB.size + b.size);
					free.add(0, newBlock);
				} else if (next) {			// if only a next block was found
					free.remove(nextB);		
					newBlock = new Block(b.start, b.size + nextB.size);
					free.add(0, newBlock);
				} else {					// reaches here if no neighbors found
					free.add(0, b);			// add at beginning of free list (doesn't matter order)
											// block is freed up and is now available
				}
				return true;
			}
		}
		
		return false;									// didn't find the block
	}
	
	public String toString() {
		return "Free memory: " + free + "\nAllocated memory: " + allocated;
	}
	
}
