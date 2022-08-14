package practicePackage._03_classesObjects.attempts;

public class Job {
	public double hourlyRate, numberOfHours;

	//final because it's value shouldn't change
	//static because only one copy needed irrespective of number of objects
	public final static double MIN_HOURLY_RATE = 21.45;
	


	/**
	 * May be helpful for other methods
	 * 
	 * Parameterized Constructor: assigns parameters to corresponding instance variables
	 * @param h: value intended for hourlyRate
	 * @param n: value intended for numberOfHours
	 * 
	 * assign the higher of h and MIN_HOURLY_RATE into the instance variable hourlyRate.
	 * assign the higher of n and 1 into the instance variable numberOfHours.
	 */
	public Job(double h, double n) {
		hourlyRate = (h > MIN_HOURLY_RATE) ? h : MIN_HOURLY_RATE;
		numberOfHours = (n > 1) ? n : 1;
	}

	/**
	 * May be helpful for other methods
	 * 
	 * @return the total salary offered by this job.
	 * example,
	 * if hourlyRate = 24.5
	 * and numberOfHours = 7.5
	 * return 183.75
	 */
	public double getSalary() {
		return hourlyRate*numberOfHours;
	}

	/**
	 * May be helpful for other methods
	 * 
	 * @param other
	 * @return 
	 * 1 if calling object has a higher salary than parameter object
	 * -1 if calling object has a lower salary than parameter object
	 * 0 if calling object has the same salary than parameter object
	 */
	public int compareTo(Job other) {
		return (getSalary() > other.getSalary()) ? 1 : (getSalary() < other.getSalary()) ? -1 : 0;
	}

	//DEFAULT CONSTRUCTOR, do not modify
	public Job() {
		//DO NOT MODIFY - assigns default value (0) to both instance variables
	}
}