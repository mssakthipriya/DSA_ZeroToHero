package A.basics;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SwitchStatements {
	
	public static void dayFinder(){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Please enter your date in this format(dd/MM/yyyy): if you want to know the the day for June 5,1995: Enter: 05/06/1995");
		String dateString = sc.nextLine();
		Date date;
		try {
			date = dateFormat.parse(dateString);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int day = calendar.get(Calendar.DAY_OF_WEEK);

			System.out.println("day: "+day);
			
			switch(day) {
			case 1:
				System.out.println("It's a Sunday!");
				break;
			case 2:
				System.out.println("It's a Monday!");
				break;
			case 3:
				System.out.println("It's a Tuesday!");
				break;
			case 4:
				System.out.println("It's a Wednesday!");
				break;
			case 5:
				System.out.println("It's a Thursday!");
				break;
			case 6:
				System.out.println("It's a Friday!");
				break;
			case 7:
				System.out.println("It's a Saturday!");
				break;
			default:
				System.out.println("It's an invalid date!");
			}
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("It's an invalid date!");
		}

		

		
		
	}
	
	public static void main(String[] args) {
		dayFinder();
	}

}
