package com.assessment.Transaction;

import java.util.List;


public interface TransactionService {
	
	public Transaction saveTransaction(Transaction transaction);

	public List<Transaction> fetchTransactionList();

	public Transaction fetchTransactionById(Long transactionId);

	public List<Transaction> retrieveAllTransaction();

	public Transaction retrieveTransactionById(Long transactionsId);

	public List<Transaction> addNewTransaction(Transaction transaction);

}
