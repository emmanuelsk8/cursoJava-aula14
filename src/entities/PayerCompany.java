package entities;

public class PayerCompany extends Payer {
	private Integer numberOfEmployees;
	
	public PayerCompany() {
		super();
	}

	public PayerCompany(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployee() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployee(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double taxesPaid() {
		return (numberOfEmployees <= 10) ? (getAnualIncome() * 0.16) : (getAnualIncome() * 0.14);
	}
	
	
}
