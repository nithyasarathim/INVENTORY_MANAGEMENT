package service;

import dao.TransactionDAO;
import dao.TransactionDAOimpl;

public class TransactionLogService {
	
	private final TransactionDAO transactionDAO;
	
	public TransactionLogService() {
		this.transactionDAO=new TransactionDAOimpl();
	}

	public void viewTransactions() {
		transactionDAO.viewTransactions();
		
	}

}
