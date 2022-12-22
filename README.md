•Use case:
        A retailer offers a rewards program to its customers, awarding points based on each recorded purchase. 
	
	A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points). 
	Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.
	
	• Implementation :
		○ Technologies used : Java 8, Spring boot , Rest api, H2 database and Maven
		○ To Start application 
			§ Run main method in RetailerOffersApplication.java (package: com.retailer.offers)
			§ Set up H2 Database :
				□ Login to H2 console (localhost:8080/console) using user/password details from application.properties file
				□ Run the scripts from data.sql file resources file.
			§ APIs:
				□ GET :  http://localhost:8080/v1/rewards/{customerId
					® This api provides rewards for each customer by customer id and throws exception if customer is not present.
				□ GET :  http://localhost:8080/v1/transactions
					® This api provides transaction details from all the customers.
			§ Unit test cases:
				□ Added Junit test cases for reward calculations and service layer.
			§ Database:
				□ CUSTOMER - table is primary table which holds all customers information
				□ TRASACTIONS - table holds transaction details for all customers (CUSTOMER_ID as Fkey)
		○ Assumptions: As we only need previous 3 months of information, data can be archived from main tables using utils or triggers.
