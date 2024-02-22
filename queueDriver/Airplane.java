package queueDriver;

/**
 * The Airplane class represents an airplane that has a flight number, arrvial
 * time, and fuel level in gallons.
 * @author Sarah Pham
 * @version Nov 2021
 */
public class Airplane implements Comparable<Airplane> {

	int flight;
	int arrivalTime;
	int fuelLevel;       // gallons of jet fuel remaining

	public Airplane (int arrival, int fuel, int flight) {   
		arrivalTime = arrival;
		fuelLevel = fuel;
		this.flight = flight;
		System.out.println (this + " has arrived at time " + arrival);      
	}

	/**
	 * @return	0 					the fuel levels are the same
	 * 			negative number		this Airplane's fuel level is less prioritized than the other
	 * 			positive number		this Airplane's fuel level is more prioritized than the other
	 */
	public int compareTo(Airplane anotherAirplane) {
		int compare = anotherAirplane.fuelLevel - fuelLevel;
		if(compare == 0) {
			compare = anotherAirplane.arrivalTime - arrivalTime;
		}
		return compare;
	}
	
	@Override
	public String toString() {
		return "Airplane " + flight + ", Arrival Time: " + arrivalTime + ", Fuel Level: " + fuelLevel;
	}
	
}
