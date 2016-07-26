package problems;

/*
Problem 19
14 June 2002

You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/

public class Nineteen {

	private static final int NO_OF_DAYS_A_YEAR = 365;
	private static final double MAX_YEAR = 2000;
	private static final double MIN_YEAR = 1901;
	private static final double BASE_YEAR = 1900;



	public static void main(String args[]) {

		//for (int i=1900; i<= 1901;i++){
		//	NO_OF_DAYS_A_YEAR
		//}
		
		
		int[] daysInMonth = new int[12];
		
		daysInMonth[0] = 31;
		daysInMonth[1] = 28;
		daysInMonth[2] = 31;
		daysInMonth[3] = 30;
		daysInMonth[4] = 31;
		daysInMonth[5] = 30;
		daysInMonth[6] = 31;
		daysInMonth[7] = 31;
		daysInMonth[8] = 30;
		daysInMonth[9] = 31;
		daysInMonth[10] = 30;
		daysInMonth[11] = 31;
		
		
		int noOfDays = NO_OF_DAYS_A_YEAR;
		if (1900%4==0 && (1900%100!=0))
			noOfDays++;
		else if(1900%400==0)
			noOfDays++;
		int day = noOfDays%7;
		
		System.out.println("Day at the end: " + day);
		
		
		int totalDays = noOfDays;
		// do not remove previous still in use
		
		
		for (int i = 1901; i <= MAX_YEAR; i++) {
			totalDays = totalDays+NO_OF_DAYS_A_YEAR;
			if (i%4==0 && (i%100!=0))
				totalDays++;
			else if(i%400==0)
				totalDays++;	
		}
		
		System.out.println("Old version total days "+(totalDays-NO_OF_DAYS_A_YEAR));
		System.out.println("Old version "+totalDays%7);

		
		/////// New Version ignore previous
		
		
		int totalNoOfDays= 0;
		int sundayCounter = 0;
		for (int i=1;i<=MAX_YEAR-MIN_YEAR+1;i++){
			System.out.println("Year: " + i);
			
			if (((BASE_YEAR+i)%4==0 && ((BASE_YEAR+i)%100!=0))||((BASE_YEAR+i)%400==0)){
				daysInMonth[1] = 29;
				System.out.println("Leap year: " + i);
			}else
				daysInMonth[1] = 28;
			
			for (int j =0;j<12;j++){
				System.out.println("Month of Year: " + j);
				totalNoOfDays += daysInMonth[j];
				System.out.println("Total No OF Days: " + totalNoOfDays);
				if ((totalNoOfDays+2)%7==0){
					sundayCounter++;
					System.out.println("sundayCounter "+sundayCounter);	
				}
				
			}
		}
		
		
		System.out.println("Answer "+sundayCounter);
	}
}
