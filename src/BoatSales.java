/*
 * This program  Will calculate the total sales for a customer 
 * and also the number of time the customer purchase Boat.
 *  This program will make use of loops, If statements, Rounding, equalignoreCase and Switch statements 
 * Sussana Beauty Kwabi								07/01/2019
 * 
 */
import java.text.DecimalFormat;
import java.util.Scanner;

	
public class BoatSales {

	
	
		//static String continue = "y";
		static double cGtTotalSales = 0;
		static int cSalesCtr = 0;
		static Scanner userInput = new Scanner(System.in);
		static DecimalFormat DollarAmt = new DecimalFormat("$###,###,###.00");
		static DecimalFormat QtyFormat = new DecimalFormat("#0");
		
		public static void main(String[] args) {
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

			System.out.println("Boat Type are: B-Bass, P-Pontoon, S-Ski, C-Canoe ");
			System.out.println("Enter the type of Boat you want(B, P, S, C): ");
			String iBoatType = userInput.next();
			
			
			switch (iBoatType) {
			case "B":
			case "b":
				break;
			case "P":
			case "p":
				break;
			case "S":
			case "s":
				break;
			case "C":
			case "c":
				break;
			default:
				iBoatType = "S";
				System.out.println("Invalid Boat Type!Setting to the default of S");	
			}
			return iBoatType;
		}
		
		private static int getAccessoryType() {
			System.out.println("Accessory Type are 1-Electronic, 2-Ski Package, 3-Fishing Package ");
			System.out.println("Enter the type of Accessory you want(1, 2, 3): ");
			String iData = userInput.next();
			int iAcc =  Integer.parseInt(iData);
			
			if (iAcc < 1 || iAcc > 3) {
				System.out.println("Invalid Accessory Type. Accessory Type must be from 1-3!");
				iAcc = 1;
			}
			return iAcc;	
		}	
		
		private static int getQuantity() {	
				System.out.println("Enter quantity of the Boat you have purchase(1-25): ");
				String iData = userInput.next();
				int iQty =  Integer.parseInt(iData);
				
				if (iQty < 1 || iQty > 25) {
					System.out.println("Invalid Quantity. Quantity must be from 1 -25!");
					iQty = 1;
				}
				return iQty;	
			}	
		
		private static double getBoatCost() {
			System.out.println("Enter the Boat Cost for the Boat Purchased(2,500-150,000): ");
			String iData = userInput.next();
			double iBoatCost =  Double.parseDouble(iData);
			
			if (iBoatCost < 2500 || iBoatCost > 15000) {
				System.out.println("Invalid Boat Cost!");
				iBoatCost = 25000;
			}	
			return iBoatCost;		
		}	
		
		private static double getPrepCost() {
			System.out.println("Enter the Prep Cost for the Boat Purchased(100-9999.99): ");
			String iData = userInput.next();
			double iPrepCost =  Double.parseDouble(iData);
				
			if (iPrepCost < 100 || iPrepCost > 9999.99) {
				System.out.println("Invalid Boat Cost!");
				iPrepCost = 5000;
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
			String oSubtotals = DollarAmt.format (cSubtotals);
			String oTotals = DollarAmt.format (cTotals);
			
			
			System.out.println();
			System.out.println("Boat Type is: " + oBoatType);
			System.out.println("Boat Cost is: " + oBoatCost);
			System.out.println("Accessory Type is: " + oAcc);
			System.out.println("Accessory Cost is: " + oAccCost);
			System.out.println("Quantity is: " + oQty);
			System.out.println("Prep Cost is: " + oPrepCost);	
			System.out.println("Markup Amount is: " + Math.round(cMarkupAmt*100.00)/100.00);
			System.out.println("Subtotals is: " + oSubtotals);	
			System.out.println("Tax is: " + Math.round(cTax*100)/100.00);
			System.out.println("Total Sales is: " + oTotals);
			System.out.println();
				
		}
		
		public static void gtTotal() {
			// Display grand totals	
			String oGtTotalSales = DollarAmt.format(cGtTotalSales);
			
			System.out.println("Sales Count as: " + cSalesCtr);
			System.out.println("Total Sales as : " + oGtTotalSales);
			System.out.println();
		}
		
		// ask continuation to continue looping
		public static String inputContinuation() {
			System.out.print("Do you want to Purchase another Boat? ");
			System.out.println("Enter Yes to  Continue or No to terminate the program!");
			String iContinue = userInput.next();
			return iContinue;
		}
	
}
