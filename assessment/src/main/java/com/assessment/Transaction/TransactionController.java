package com.assessment.Transaction;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class TransactionController {
	
	private TransactionService transactionService;
	
	public TransactionController(TransactionService transactionService) {
		super();
		this.transactionService = transactionService;
	}
	
	@GetMapping("/transactions")
	public List<Transaction> retrieveAllSurveys() {
		return transactionService.retrieveAllTransaction();
	}
	
	@GetMapping("/transactions/{transactionsId}")
	public Transaction retrieveAllTransaction(@PathVariable Long transactionsId) {
		Transaction transaction = transactionService.retrieveTransactionById(transactionsId);
		if(transaction==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
				return  transaction;
	}
	
	@PostMapping("/transactions")
	public ResponseEntity<Object> addNewTransactions(@RequestBody Transaction transaction) {
		List<Transaction> transactions=transactionService.addNewTransaction(transaction);
		return ResponseEntity.created(null).build();
		
		
	}
	
}
