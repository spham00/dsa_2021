package hashDriver;

/**
 * The Date class represents the date, including a day, month, and year.
 * 
 * @author Sarah Pham
 * @version	November 6, 2021
 */
public class Date {

	int day;
	int month;
	int year;
	
	public Date(int month, int day, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	@Override
	/**
	 * @return a hash code following Joshua Block's rule of thumb
	 */
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + day;			// day
		hash = 31 * hash + month;		// month
		hash = 31 * hash + year;		// year
		return hash;
	}
	
	/**
	 * Checks for each field since same hashcode does NOT mean the two objects are equal
	 * @return whether the user-entered object is equal to this Date
	 */
	public boolean equals(Object obj) {
		if(obj instanceof Date) {
			Date other = (Date)obj;
			return day == other.getDay() && month == other.getMonth() && year == other.getYear();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return year + "/" + month + "/" + day;
	}
	
	// Getters
	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
	
}
