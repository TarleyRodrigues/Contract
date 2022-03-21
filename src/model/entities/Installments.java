package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.enums.status.Status;

public class Installments {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date duoDate;
	private Double amount;
	private Status status;

	public Installments() {
	}

	public Installments(Date duoDate, Double amount) {
		this.duoDate = duoDate;
		this.amount = amount;
		this.status = Status.WAITING_FOR_PAYMENT;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(sdf.format(duoDate));
		builder.append(" - R$");
		builder.append(String.format("%.2f", amount));
		builder.append("\nPayment status: " + status + "\n");
		builder.append("-----------------------------------");
		
		return builder.toString();
	}

}
