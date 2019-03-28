package com.example.UseCaseSpringBoot;

import java.util.Date;

public class Transaction {
	private Integer transId;
	private Date timestamp;
	private String formatedDate;
	
	public Transaction() {
	
	}
	
	public Transaction(Integer transId, Date timestamp, String formatedDate) {
		super();
		this.transId = transId;
		this.timestamp = timestamp;
		this.formatedDate = formatedDate;
	}
	
	public Integer getTransId() {
		return transId;
	}
	public void setTransId(Integer transId) {
		this.transId = transId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timeStamp) {
		this.timestamp = timeStamp;
	}
	public String getFormatedDate() {
		return formatedDate;
	}
	public void setFormatedDate(String formatedDate) {
		this.formatedDate = formatedDate;
	}

	@Override
    public boolean equals(Object obj) {
	    // checking if both the object references are  
	    // referring to the same object. 
	    if(this == obj) 
	            return true; 
        // it checks if the argument is of the  
        // type Geek by comparing the classes  
        // of the passed argument and this object. 
        // if(!(obj instanceof Geek)) return false; ---> avoid. 
        if(obj == null || obj.getClass()!= this.getClass()) 
            return false; 
          
        // type casting of the argument.  
        Transaction geek = (Transaction) obj; 
          
        // comparing the state of argument with  
        // the state of 'this' Object. 
        return (geek.transId == this.transId); 
    } 
	      
	@Override
	public int hashCode() {
        // We are returning the Geek_id  
        // as a hashcode value. 
        // we can also return some  
        // other calculated value or may 
        // be memory address of the  
        // Object on which it is invoked.  
        // it depends on how you implement  
        // hashCode() method. 
        return this.transId; 
	} 
	
	//ERROR will be thrown if default constructor are NOT available.
	/*{
	    "timestamp": 1516897619316,
	    "status": 400,
	    "error": "Bad Request",
	    "exception": "org.springframework.http.converter.HttpMessageNotReadableException",
	    "message": "JSON parse error: Can not construct instance of io.starter.topic.Topic: no suitable constructor found, can not deserialize from Object value (missing default constructor or creator, or perhaps need to add/enable type information?); nested exception is com.fasterxml.jackson.databind.JsonMappingException: Can not construct instance of io.starter.topic.Topic: no suitable constructor found, can not deserialize from Object value (missing default constructor or creator, or perhaps need to add/enable type information?)\n at [Source: java.io.PushbackInputStream@1ff3f09a; line: 2, column: 9]",
	    "path": "/topics/"
	}*/
}
