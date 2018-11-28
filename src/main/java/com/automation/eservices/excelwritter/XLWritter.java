package com.automation.eservices.excelwritter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class XLWritter {
	
	
	    @Scheduled(fixedRate = 5000)
	    public void reportCurrentTime() {
	        System.out.println("Hi");
	        
	        
	    }
	

}
