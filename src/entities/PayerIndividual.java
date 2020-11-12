package entities;

public class PayerIndividual extends Payer {
	private Double healthExpenditures;
	
	public PayerIndividual() {
		super();
	}
	
	public PayerIndividual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double taxesPaid() {
		double tax = (getAnualIncome() < 20000) ? (getAnualIncome() * 0.15) - (healthExpenditures * 0.50) : (getAnualIncome() * 0.25) - (healthExpenditures * 0.50);
		return (tax < 0) ? 0 : tax;
	}

}
