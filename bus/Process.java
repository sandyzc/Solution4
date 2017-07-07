package bus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Process extends Thread {

	private int maxSeatCount;
	private Map<Integer, Seat> seatMap;

	public Process() {

	}

	public Process(int maxSeatCount) {
		super();
		this.maxSeatCount = maxSeatCount;

	}

	@Override
	public void run() {
		Scanner s = new Scanner(System.in);
		seatMap = BusReserv.getSeatMap();
		while (maxSeatCount < 4) { // check max 4
			
			HashMap<Integer,String> maps= new HashMap<Integer,String>();
			

			int seats[];

			System.out.println("Enter the Date of Journey in DD/MM/YY");
			String date = s.nextLine();

			System.out.println("Enter No of Seats Required");
			int noofseats = s.nextInt();
			seats = new int[noofseats];
			
			String name;
			
			
			for (int i = 0; i < seats.length; i++) {
				;
				
				System.out.println("Enter your name of Passenger " + seats[i]);
				name = s.next();
				System.out.println("Enter Seat No ");
				int seatNo = s.nextInt();
				maps.put(seatNo, name);
				seats[i]=seatNo;
			}
			printBoardingPass(maps, date,seats);

			System.out.println("Press any Number to Book Another Ticket " + "\n" + "Press 0 To Exit ");

			int choice = s.nextInt();
			if (choice == 0) {
				System.exit(0);
			}
		}

	}

	private void printBoardingPass(HashMap<Integer,	String> map, String date,int[]seatNumber) {
		Seat s = seatMap.get(seatNumber);
		int noofseat = seatNumber.length;

		System.out.println("***********************BUS TICKET***********************");
		
		System.out.println("Date Of Journey " + date);
		System.out.println("No Of Seats " + noofseat);
		for (int i = 0; i < seatNumber.length; i++) {
			System.out.println("Passenger Name " + map.get(seatNumber[i])+ "\n"+"Alloted Seat no "+seatNumber[i]);
		}

	}

}