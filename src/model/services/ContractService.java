package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installments;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		// basicQuota = Valor Total dividido pela quantidade de meses
		for (int i = 1; i <= months; i++) {
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			// updateQuota vai estar valendo basicQuota + basicQuota(valor da parcela) * 0.01;
			double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
			// fullQuota vai estar valendo updateQuota + updateQuota(valor da parcela) * 0.02;
			Date dueDate = addMonths(contract.getDate(), i);
			contract.getInstallments().add(new Installments(dueDate, fullQuota));
			
		}
	}
	private Date addMonths(Date date, int numMonths) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, numMonths);
		return calendar.getTime();
	}
}
