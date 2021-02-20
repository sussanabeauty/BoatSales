/*
 * This program  Will calculate the total sales for a customer 
 * and also the number of time the customer purchase Boat.
 * The program will validate the user input and 
 * display the appropriate error message for invalid input
 *  This program will make use of loops, If statements, 
 *  Rounding, equalignoreCase and Switch statements 
 * Sussana Beauty Kwabi					07/01/2019
 * 
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class ValidateBoatSales {
	static Scanner scanner;
	static double cGtTotalSales = 0;
	static int cSalesCtr = 0;
	static Scanner userInput = new Scanner(System.in);
	static DecimalFormat DollarAmt = new DecimalFormat("$###,###,###.00");
	static DecimalFormat QtyFormat = new DecimalFormat("#0");	
	static DecimalFormat PennyFormat = new DecimalFormat(".00");	
				
	public static void main(String[] args) {
		init();
		String Continue = "Yes";
				
		while (Continue.equalsIgnoreCase("Yes")) {
			String BoatType = getBoatType();
			int Acc = getAccessoryType();
			int Qty = getQuantity();
			double  BoatCost= getBoatCost();
			double PrepCost = getPrepCost();
			Calcs(BoatType, Acc, Qty, BoatCost, PrepCost); 
					
			Continue = inputContinuation();		
		}
		gtTotal();
	}

	private static String getBoatType() {
		String iBoatType;
		
		while(true) {
			System.out.println("\nBoat Type are: B-Bass, P-Pontoon, S-Ski, C-Canoe ");
			System.out.println("Enter the type of Boat you want(B, P, S, C): ");
			iBoatType = userInput.next().trim();
			if (!iBoatType.matches("[Bb|Pp|Ss|Cc]")) {
				System.out.println("Error.Boat Type is requried!");
				
			}else {
				break;
			}
		}
								
		return iBoatType;
	}
				
	private static int getAccessoryType() {
		int iAcc = 1;
		while (true) {
			System.out.println("\nAccessory Type are 1-Electronic, 2-Ski Package, 3-Fishing Package ");
			System.out.println("Enter the type of Accessory you want(1, 2, 3): ");
			String iData = userInput.next();		
			if (iData.matches("[1|2|3]")) {
				iAcc =  Integer.parseInt(iData);
				break;
			}
			else{
				System.out.println("Error. Accessory type is Required!");
			}
		}
		return iAcc;	
	}
	

				
	private static int getQuantity() {	
		int iQty = 0;
		while(true) {
			System.out.println("Enter quantity of the Boat you have purchase(1-25): ");
			String iData = userInput.next();
			try {
				iQty =  Integer.parseInt(iData);
				if (iQty < 1 || iQty > 25) {
					System.out.println("Invalid Quantity. Quantity must be from 1 - 25!");	
				}
				else {
					break;			
				}
			}
			catch(Exception e){
				System.out.println("Error. Quantity must be from  Numeric!");	
				
				
			}	
		}
		return iQty;	
	}	
				 
	private static double getBoatCost() {
		double iBoatCost = 0;
		while(true) {
			System.out.println("Enter the Boat Cost for the Boat Purchased(2500-15000): ");
			String iData = userInput.next();
			try {			
				iBoatCost =  Double.parseDouble(iData);			
				if (iBoatCost < 2500 || iBoatCost > 15000) {
					System.out.println("Invalid Boat Cost. Boat Cost must be from 2,500 - 150,00!");
					
				}
				else {
					break;
				}
			}
			catch(Exception e)	{
		    	System.out.println("Error. Boat Cost must be Numeric!");
		    	break;
		    	
		    }
		}
		return iBoatCost;	
		
	}
	
				
	private static double getPrepCost() {
		double iPrepCost= 0;
		while(true) {
			System.out.println("Enter the Prep Cost for the Boat Purchased(100-9999.99): ");
			String iData = userInput.next();
			try {
				iPrepCost =  Double.parseDouble(iData);				
				if (iPrepCost < 100 || iPrepCost > 9999.99) {
					System.out.println("Invalid Prep Cost. Prep Cost must be from 100 - 9999.99!");
					
				}
				else {
					break;
				}
			}
			catch(Exception e) {
				System.out.println("Error. Prep Cost must be Numeric");
				
			}
		}
			
		return iPrepCost;	
	}	
				
	public static void Calcs (String BoatType, int Acc, int Qty, double BoatCost, double PrepCost) {
					
	//check for the percentage and calculate the mark up amount
					
	double cPercent = 0;
					
	switch (BoatType) {
		case "B":
		case "b":
			cPercent =  .33;
			break;
		case "P":
		case "p":
			cPercent = .25;
			break;
		case "S":
		case "s":
			cPercent = .425;
			break;
		case "C":
		case "c":
			cPercent = .20;
			break;
	}
					
		double cMarkupAmt = cPercent * BoatCost;
		cMarkupAmt = Math.round(cMarkupAmt * 10)/100.0;
					
					
		//calculate the accessory cost from the accessory type
		double cAccCost = 0;
					
		switch (Acc) {		
			case 1:
				cAccCost =  5415.30;
				break;
			case 2:
				cAccCost =  3980;
				break;
			case 3:
				cAccCost =  345.45;
				break;
		}
					
		// calculate sub total
		double cSubtotal = ( PrepCost + cMarkupAmt + BoatCost + cAccCost ) * Qty;
					
		// calculate Tax
		double cTax = cSubtotal * .06;	
		cTax = Math.round(cTax * 10)/100.0;
				
		// calculate total
		double cTotals = cSubtotal + cTax;
						
		//  calculate global variables
		cSalesCtr ++;
		cGtTotalSales +=  cTotals;
								
		display(BoatType, Acc, Qty, BoatCost, PrepCost, cAccCost, cMarkupAmt, cSubtotal, cTax, cTotals);			
	}
				
	public static void display(String BoatType, int Acc, int Qty, double BoatCost,
		double PrepCost, double cAccCost, double cMarkupAmt, double cSubtotals, double cTax, double cTotals) {
					 
		String oBoatType = "S";
		switch (BoatType) {
		case "B":
		case "b":
			oBoatType = "Bass";
			break;
		case "P":
		case "p":
			oBoatType = "Pontoon";
			break;
		case "S":
		case "s":
			oBoatType =  "Ski";
			break;
		case "C":
		case "c":
			oBoatType =  "Canoe";
			break;
					
				
		}
					
		String oAcc ="Ski Package";
		switch (Acc) {
		case 1:
			oAcc = "Electronic";
			break;
		case 2:
			oAcc = "Ski Package";
			break;
		case 3:
			oAcc =  "Fishing Package";
			break;
		}
					
		String oQty = QtyFormat.format(Qty);
		String oBoatCost = DollarAmt.format (BoatCost);
		String oPrepCost = DollarAmt.format(PrepCost);
		String oAccCost = DollarAmt.format(cAccCost);
		String oMarkupAmt = PennyFormat.format(cMarkupAmt);
		String oTax = PennyFormat.format(cTax);
		String oSubtotals = DollarAmt.format (cSubtotals);
		String oTotals = DollarAmt.format (cTotals);
					
					
		System.out.println("Boat Type is: " + oBoatType);
		System.out.println("Boat Cost is: " + oBoatCost);
		System.out.println("Accessory Type is: " + oAcc);
		System.out.println("Accessory Cost is: " + oAccCost);
		System.out.println("Quantity is: " + oQty);
		System.out.println("Prep Cost is: " + oPrepCost);	
		System.out.println("Markup Amount is: " + oMarkupAmt);
		System.out.println("Subtotals is: " + oSubtotals);	
		System.out.println("Tax is: " + oTax);
		System.out.println("Total Sales is: " + oTotals);	
						
	}
				
				
	public static void gtTotal() {
		// Display grand totals	
		String oGtTotalSales = DollarAmt.format(cGtTotalSales);
					
		System.out.println("Sales Count as: " + cSalesCtr);
		System.out.println("Total Sales as : " + oGtTotalSales);
		
	}
				
				// ask continuation to continue looping
	public static String inputContinuation() {
		System.out.print("Do you want to Purchase another Boat? ");
		System.out.println("Enter Yes to  Continue or No to terminate the program!");
		String iContinue = userInput.next();
		return iContinue;
	}
	
	private static void init() {
		scanner = new Scanner(System.in);
		scanner.useDelimiter("\r\n");
	}
}
