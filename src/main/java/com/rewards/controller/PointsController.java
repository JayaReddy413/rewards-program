package com.rewards.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.repos.TransactionRepository;
import com.rewards.model.Transaction;
import com.rewards.service.PointsService;

@RestController
@RequestMapping("/api/v1")
public class PointsController {

	@Autowired
	private TransactionRepository repo;

	@Autowired
	private PointsService service;

	/**
	 * This function will calcualte transaction points based on the duration provided
	 * @param userId actual userid for which transactions need to be consolidated
	 * @param duration should be in months
	 * @return
	 */
	@GetMapping("/user/{userId}/transactions/{duration}")
	public List<Transaction> getUserTrasanctionsWithPoints(@PathVariable("userId") Long userId,@PathVariable("duration") Short duration){
		List<Transaction> transactions = repo.getTransForUserByDuration(userId, duration);
		processPoints(transactions);
		return transactions;
	}

	/**
	 * Wrapper function to process points
	 * assuming multiple transactions are a possibility
	 * @param transactions
	 */
	private void processPoints(List<Transaction> transactions) {
		for(Transaction transaction: transactions){
			transaction.setPoints(service.calculatePoints(transaction.getTotal().intValue()));
		}
	}
}