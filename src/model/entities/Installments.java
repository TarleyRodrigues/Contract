package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installments {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date duoDate;
	private Double amount;

	public Installments() {
	}

	public Installments(Date duoDate, Double amount) {
		this.duoDate = duoDate;
		this.amount = amount;
	}

	public Date getDuoDate() {
		return duoDate;
	}

	public void setDuoDate(Date duoDate) {
		this.duoDate = duoDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(sdf.format(duoDate));
		builder.append(" - ");
		builder.append(String.format("%.2f", amount));
		return builder.toString();
	}

}
