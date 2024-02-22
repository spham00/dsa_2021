package graph;

import map.*;
import list.*;
import queue.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/** An Airline has a collection of direct Flights. The Airline is capable of finding a path from an
 * origin Airport to a destination Airport.
 * @author (sdb)
 * @version (2020)
 */
public class Airline {
	List <Flight> flights; // Direct flights
	// Keys are Airport names, values are Airports
	Map <String,Airport> map;
	int i;		// If set to 1, PHL is a hub

	public static void main (String[] args) { 
		Airline airline = new Airline();

		// Read the direct flights from a text file
		airline.getFlights();
		System.out.println ("Flights: " + airline.flights);
		System.out.println ("Map: " + airline.map);
		System.out.println ("Path from CVG to Paris");
		
		// Find a path:
		System.out.println (airline.path ("CVG","Paris"));
		
		System.out.println("\nPath from CVG to Paris, with PHL as a hub");
		airline.map.clear();
		airline.flights.clear();
		airline.i = 1;
		airline.getFlights();
		System.out.println (airline.path ("CVG","Paris"));
		// Try finding other paths …
	}

	/** Read the direct flights from a text file.
	 * Build the List of Flights, and a Map from
	 * Airport names to Airports.
	 */
	private void getFlights() { 
		// Refer to file name using project folder "dsa" (.)
		File inFile = new File ("./src/flightsORL1.txt");
		map = new HashMap<String,Airport>();
		flights = new ArrayList<Flight>();

		try {
			Scanner scanner = new Scanner (inFile);
			String flight, origin, dest;
			Airport o, d;

			while (scanner.hasNextLine()) { 
				flight = scanner.nextLine(); // has both o and d
				origin = flight.split (" ")[0];
				dest = flight.split (" ")[1];

				if (map.containsKey (origin))
					o = map.get(origin); // Get the origin Airport
				else if (i == 1 && origin.equals("PHL")) {
					o = new Airport(origin, true);
					map.put(origin, o);
				}
				else { // Create entry in the map
					o = new Airport (origin);
					map.put (origin, o);
				}

				if (map.containsKey (dest))
					d = map.get(dest);
				else if (i == 1 && dest.equals("PHL")) {
					d = new Airport(dest, true);
					map.put(dest, d);
				}
				else {
					d = new Airport (dest);
					map.put (dest, d);
				}
				flights.add(new Flight(o,d));
			}
		}

		catch (IOException ioe) {
			System.err.println(ioe);
		}
	}

	/** Find a path from the Airport with the name origin, to the Airport with the name 
	 * dest, if possible. It need not be an optimal path.
	 * @return the path as a List of Airports, empty if no path is found.
	 */
	private List<Airport> path (String origin, String dest) { 
		Airport o = map.get(origin);
		Airport d = map.get(dest);
		List<Airport> result = path(o,d);
		clearAirports(); // Clear visited flags
		return result;
	}

	/** @return the path from origin to dest */
	private List<Airport> path (Airport origin, Airport destination) { 
		List<Airport> result = new LinkedList<Airport>();
		origin.visited = true;
		if (origin.equals (destination)) { // base case
			result.add(origin);
			return result;
		}
		
		// Recursive case
		Airport port;
		Iterator<Airport> it = getDirect(origin).iterator();
		while (it.hasNext()) { 
			port = it.next();
			port.visited = true;
			result = path(port,destination);

			if (result.size() > 0) { 
				result.add(0,origin);
				return result;
			}
		}
		
		return result; // No path found
	}

	/** 
	 * @return a List of Airports which can be reached directly from the given
	 * Airport, and which have not already been visited
	 */
	private List<Airport> getDirect (Airport from) { 
		List<Airport> result = new LinkedList<Airport>();
		Iterator<Flight> it = flights.iterator();
		Flight flight;
		
		QueueADT<Airport> queue = new PriorityQueue<Airport>();

		while (it.hasNext()) { 
			flight = it.next();
			if (flight.origin.equals(from) && ! flight.destination.visited)
				queue.add (flight.destination);
		}
		
		// Add elements of the PriorityQueue to the List
		while(!queue.isEmpty())
			result.add(queue.remove());
		
		return result;
	}

	/** 
	 * Reset visited flag of every Airport
	 */
	private void clearAirports() {
		Flight flight;
		Airport port;
		Iterator<Flight> it = flights.iterator();
		while (it.hasNext()) { 
			flight = it.next();
			flight.origin.visited = false;
			flight.destination.visited = false;
		}
	}
}