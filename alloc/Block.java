package alloc;

/**
 * A Block of memory has a starting address and a size.
 * @author sdb
 */
class Block {

	int start;
	int size;	// # of memory units in the block
	
	Block (int start, int size) {
		this.start = start;
		this.size = size;
	}
	
	public String toString() {
		return "(" + start + "." + size + ")";
	}
	
}
