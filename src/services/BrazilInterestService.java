package services;

public class BrazilInterestService implements InterestService {
	
	private final static double INTERESTRATE = 2.0;
	
	public double getInterestRate() {
		return INTERESTRATE;
	}

}
