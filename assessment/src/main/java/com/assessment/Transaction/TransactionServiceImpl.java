package com.assessment.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;


@Service
public class TransactionServiceImpl implements TransactionService {
	
private static List<Transaction> transaction = new ArrayList<>();
	
	private TransactionRepository repository;
	
	public TransactionServiceImpl(TransactionRepository repository) {	
		this.repository = repository;
	}
	
	static {
	Transaction transaction1 = new Transaction(1000000001,parseDate("2022-11-01 09:25"),10.25,2000000001,110.25);
	Transaction transaction2 = new Transaction(1000000002,parseDate("2022-11-02 10:25"),20.25,2000000002,220.25);
	Transaction transaction3 = new Transaction(1000000003,parseDate("2022-11-03 11:25"),30.25,2000000003,330.25);
	Transaction transaction4 = new Transaction(1000000004,parseDate("2022-11-04 12:25"),40.25,2000000004,440.25);
	Transaction transaction5 = new Transaction(1000000005,parseDate("2022-11-05 13:25"),-10.25,2000000005,550.25);
		transaction = new ArrayList<>(Arrays.asList(transaction1,
			transaction2, transaction3,transaction4,transaction5));
	}
	
	
	
	public static Date parseDate(String date){
		 try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		}
	
	public List<Transaction> retrieveAllTransaction() {
		return transaction;
	}

	public Transaction retrieveTransactionById(Long transactionsId) {
		Predicate<? super Transaction> predicate=
				transaction-> (transaction.getTransactionId()==(transactionsId));
		Optional<Transaction> optionalsurvey = transaction.stream().filter(predicate).findFirst();
		if(optionalsurvey.isEmpty()) return null;
		return optionalsurvey.get();
		
	}

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		return repository.save(transaction);
		
	}

	@Override
	public List<Transaction> fetchTransactionList() {
		return repository.findAll();
	}

	@Override
	public Transaction fetchTransactionById(Long transactionId) {
		Predicate<? super Transaction> predicate=
				transaction-> (transaction.getTransactionId()==(transactionId));
		Optional<Transaction> optionalsurvey = transaction.stream().filter(predicate).findFirst();
		if(optionalsurvey.isEmpty()) return null;
		return optionalsurvey.get();
	}

	@Override
	public List<Transaction> addNewTransaction(Transaction transaction) {
		saveTransaction(transaction);
		List<Transaction> transactions=retrieveAllTransaction();
		transactions.add(transaction);
		return transactions;
	}

}
