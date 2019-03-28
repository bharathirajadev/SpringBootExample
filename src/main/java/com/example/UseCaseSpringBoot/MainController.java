package com.example.UseCaseSpringBoot;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
Create: to create new transaction
Get: to get all the records in last 60 seconds and remove any older records
Delete: to delete all transactions*/

//https://stackoverflow.com/questions/53172851/thread-safe-list-for-all-crud-operations
//https://codereview.stackexchange.com/questions/173545/rest-api-for-realtime-statistics-of-last-60-seconds
		
@RestController
@ComponentScan("com.example.*")
public class MainController {
	
	private final List<Transaction> transactions = new ArrayList<>();
	//private final Set<Transaction> transactions = new HashSet<>();
		
	@RequestMapping("/")
	public String index() {
		return "welcome";
	}
	
	@RequestMapping(value="/add" , method = RequestMethod.POST)
    public synchronized String create(@RequestBody Transaction trans) {
		String responseMsg="";
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			trans.setTimestamp(timestamp);
			
			if(!transactions.contains(trans)) {
				transactions.add(trans);
				responseMsg = "Successfully Added !";
			} else {
				responseMsg ="Already Exists !";
			}
		} catch(Exception e) {
			responseMsg ="Failed";
		}
		return responseMsg;
    }
	@RequestMapping(value="/showAll" , method = RequestMethod.GET)
    public synchronized List<Transaction> getAllRecords() {
    	return transactions;
    }

	@RequestMapping(value="/getLatest" , method = RequestMethod.GET)
    public synchronized List<Transaction> trxsInLast60Seconds() {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, -1);
		
        List<Transaction> filteredTransactions = transactions.stream() 
        						.filter(p -> p.getTimestamp().after(now.getTime()))
        						.collect(Collectors.toList());
        removeOldTransactions(filteredTransactions);
        return filteredTransactions;
    }

    private void removeOldTransactions(List<Transaction> filteredTransactions) {
        transactions.retainAll(filteredTransactions);
    }

    @RequestMapping("/delete")
    public synchronized void deleteTransactions() {
        transactions.clear();
    }
}
