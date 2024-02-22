package graph;

/** An Airport has a name 
 * @author (sdb)
 * @version (2020)
 */

public class Airport implements Comparable<Airport>
{ 
	String name;
	boolean visited = false;
	boolean hub = false;		// Whether this airport is a hub or not

	public Airport (String name) { 
		this.name = name;
	}
	
	// Constructor to make an Airport as a hub
	public Airport(String name, boolean hub) {
		this.name = name;
		this.hub = hub;
	}
	
	// Mutator method to change an existing Airport to a (non) hub
	public void setHub(boolean hub) {
		this.hub = hub;
	}

	public boolean equals(Object obj) { 
		if (! (obj instanceof Airport))
			return false;
		Airport other = (Airport) obj;
		return name.equals (other.name);
	}
	
	/**
	 * @return 	0 if this Airport and the other are/aren't both hubs
	 * 			1 if this Airport is a hub and the other isn't
	 * 		   -1 if the other Airport is a hub and this one isn't
	 */
	public int compareTo(Airport anotherAirport) {
		if(hub && anotherAirport.hub)
			return 0;
		if(hub && !anotherAirport.hub)
			return 1;
		if(anotherAirport.hub && !hub)
			return -1;
		return 0;
	}

	public String toString() {
		String s = " is";
		if(hub) 
			s = s + " a hub";
		else
			s = s + "n't a  hub";
		return name + s;
	}

}