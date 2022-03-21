package model.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.entities.Contract;
import model.entities.Installments;

public class PaymentService {

	List<Installments> installments = new ArrayList<>();
	public Contract contract;
	public Integer numContracts;

	public PaymentService(Contract contract, Integer numContracts) {
		this.contract = contract;
		this.numContracts = numContracts;

	}

	public List<Installments> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installments> installments) {
		this.installments = installments;
	}

	public void Payment(PaymentService PS) {
		Date dt1 = contract.getDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt1);
		Double totalParcel = null;
		double parcela = contract.getTotalValue() / numContracts;
		for (int i = 1; i <= numContracts; i++) {
			cal.add(Calendar.MONTH, 1);
			dt1 = cal.getTime();
			totalParcel = (parcela * ((0.01 * i) + 1)) * 1.02;
			installments.add(new Installments(dt1, totalParcel));
		}
		for (Installments p : installments) {
			System.out.println(p);
		}

	}
}
