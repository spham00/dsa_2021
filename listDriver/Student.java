package listDriver;

/**
 * For the LabDeleteListIterator driver.
 * @author Sarah Pham
 */
public class Student {
	
	private String name;
	private int idNumber;
	
	public Student(String name, int idNumber) {
		this.name = name;
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	
	// CHECK WAIT ACTUALLY NOT NECESSARY
	public boolean equals(Student a) {
		if(idNumber == a.getIdNumber()) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return name + " " + idNumber;
	}

}
