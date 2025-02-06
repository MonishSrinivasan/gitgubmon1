import java.math.BigInteger;
import java.util.*;
class Bookingtrain{
	int seat_ac;
	int seat_nac;
	int seat_s;
	String name;
	int age;
	BigInteger adhar;
	BigInteger phone;
	String coach;

	Bookingtrain(String name, int age, BigInteger adhar, BigInteger phone, String coach, int seat){
		if(coach.equals("ac")) {
			this.seat_ac = seat;
		}
		else if(coach.equals("nac")) {
			this.seat_nac = seat;
		}
		else if(coach.equals("s")) {
			this.seat_s = seat;
		}
		this.name = name;
		this.age = age;
		this.adhar = adhar;
		this.phone = phone;
		this.coach = coach;
	}
}
class Availability{
	static int ac = 60;
	static int wac = 10;
	static int nac = 60;
	static int wnac = 10;
	static int s = 60;
	static int ws = 10;
	
	public static String checkavl(String coach) {
		if(coach.equals("ac")) {
			if(ac > 0 && ac <= 60) {
				return "Yac";
			}
			else if(wac > 0 && wac <= 10) {
				return "wa";
			}
			else {
				return "No";
			}
		}
		else if(coach.equals("nac")) {
			if(nac > 0 && nac <= 60) {
				return "Ynac";
			}
			else if(wnac > 0 && wnac <= 10) {
				return "wna";
			}
			else {
				return "No";
			}
		}
		else if(coach.equals("s")) {
			if(s > 0 && s <= 60) {
				return "Ys";
			}
			else if(ws > 0 && ws <= 10) {
				return "wss";
			}
			else {
				return "No";
			}
		}
		return "No";
	}
	}
class Waiting{
	int w_ac = 0;
	int w_nac = 0;
	int w_s = 0;
	String name;
	int age;
	BigInteger adhar;
	BigInteger phone;
	String coach;
	
	Waiting(String name, int age, BigInteger adhar, BigInteger phone, String coach){
		if(coach.equals("wa")) {
			w_ac += 1;
		}
		else if(coach.equals("wna")) {
			w_nac += 1;
		}
		else if(coach.equals("wss")) {
			w_s += 1;
		}
		this.name = name;
		this.age = age;
		this.adhar = adhar;
		this.phone = phone;
		this.coach = coach;
	}
}
public class Railwaticketbooking {
	static ArrayList<Bookingtrain> bookingsac = new ArrayList<>();
	static ArrayList<Waiting> waitingac = new ArrayList<>();
	static ArrayList<Bookingtrain> bookingsnac = new ArrayList<>();
	static ArrayList<Waiting> waitingnac = new ArrayList<>();
	static ArrayList<Bookingtrain> bookingss = new ArrayList<>();
	static ArrayList<Waiting> waitings = new ArrayList<>();
	static int acseatno = 0;
	static int nacseatno = 0;
	static int sseatno = 0;
	public static void ticketbooking(String name, int age, BigInteger adhar, BigInteger phone, String coach) {
		String avl = Availability.checkavl(coach);
		if(!avl.equals("No")) {
			if(avl.equals("Yac")) {
				boolean flag = true;
				for(int i = 0; i < bookingsac.size(); i++) {
					if(bookingsac.get(i) == null) {
						acseatno++;
						Bookingtrain b = new Bookingtrain(name, age, adhar, phone, coach, i + 1);
						bookingsac.set(i, b);
						flag = false;
						Availability.ac--;
						System.out.println("mr " + name + " your ticket has been conformed your set no is " + b.seat_ac);
						break;
					}
				}
				if(flag) {
					acseatno++;
					Bookingtrain b = new Bookingtrain(name, age, adhar, phone, coach, acseatno);
					bookingsac.add(b);
					System.out.println("mr " + name + " your ticket has been conformed your set no is " + b.seat_ac);
					Availability.ac--;
				}
			}
			else if(avl.equals("wa")){
				waitingac.add(new Waiting(name, age, adhar, phone, avl));
				System.out.println("mr " + name + " your ticket is in waiting list");
				Availability.wac--;
			}
			else if(avl.equals("Ynac")) {
				boolean flag = true;
				for(int i = 0; i < bookingsnac.size(); i++) {
					if(bookingsnac.get(i) == null) {
						nacseatno++;
						Bookingtrain b = new Bookingtrain(name, age, adhar, phone, coach, i + 1);
						bookingsnac.set(i, b);
						flag = false;
						Availability.nac--;
						System.out.println("mr " + name + " your ticket has been conformed your set no is " + b.seat_nac);
						break;
					}
				}
				if(flag) {
					nacseatno++;
					Bookingtrain b = new Bookingtrain(name, age, adhar, phone, coach, nacseatno);
					bookingsnac.add(b);
					System.out.println("mr " + name + " your ticket has been conformed your set no is " + b.seat_nac);
					Availability.nac--;
				}
			}
			else if(avl.equals("wna")) {
				waitingnac.add(new Waiting(name, age, adhar, phone, avl));
				System.out.println("mr " + name + " your ticket is in waiting list");
				Availability.wnac--;
			}
			else if(avl.equals("Ys")) {
				boolean flag = true;
				for(int i = 0; i < bookingss.size(); i++) {
					if(bookingss.get(i) == null) {
						sseatno++;
						Bookingtrain b = new Bookingtrain(name, age, adhar, phone, coach, i + 1);
						bookingss.set(i, b);
						flag = false;
						Availability.s--;
						System.out.println("mr " + name + " your ticket has been conformed your set no is " + b.seat_s);
						break;
					}
				}
				if(flag) {
					sseatno++;
					Bookingtrain b = new Bookingtrain(name, age, adhar, phone, coach, sseatno);
					bookingss.add(b);
					System.out.println("mr " + name + " your ticket has been conformed your set no is " + b.seat_ac);
					Availability.s--;
				}
			}
			else if(avl.equals("wss")) {
				waitings.add(new Waiting(name, age, adhar, phone, avl));
				System.out.println("mr " + name + " your ticket is in waiting list");
				Availability.ws--;
			}
		}
		else {
			System.out.println("sorry sir there is no tickets");
		}
	}
	public static void cancelation(BigInteger adhar, String coatch, int seatno) {
		if(coatch.equals("ac")) {
			bookingsac.set(seatno - 1, null);
			if(waitingac.size() > 0) {
				Waiting wt = waitingac.get(0);
				Bookingtrain b = new Bookingtrain(wt.name, wt.age, wt.adhar, wt.phone, wt.coach, seatno);
				bookingsac.set(seatno - 1, b);
				waitingac.remove((int) 0);
			}
			else {
//				bookingsac.set((int) seatno - 1, null);
				acseatno--;
			}
			System.out.println("cancelation has been succesfully done");
		}
		else if(coatch.equals("nac")) {
			bookingsnac.set(seatno - 1, null);
			if(waitingnac.size() > 0) {
				Waiting wt = waitingnac.get(0);
				Bookingtrain b = new Bookingtrain(wt.name, wt.age, wt.adhar, wt.phone, wt.coach, seatno);
				bookingsnac.set(seatno - 1, b);
				waitingnac.remove((int) 0);
			}
			else {
//				bookingsnac.set((int) seatno - 1, null);
				nacseatno--;
			}
			System.out.println("cancelation has been succesfully done");
		}
		else if(coatch.equals("s")) {
			bookingss.set(seatno - 1, null);
			if(waitings.size() > 0) {
				Waiting wt = waitings.get(0);
				Bookingtrain b = new Bookingtrain(wt.name, wt.age, wt.adhar, wt.phone, wt.coach, seatno);
				bookingss.set(seatno - 1, b);
				waitings.remove((int) 0);
			}
			else {
//				bookingss.remove((int) seatno - 1);
				sseatno--;
			}
			System.out.println("cancelation has been succesfully done");
		}
	}
	public static void display() {
		for(Bookingtrain bok : bookingsac) {
			if(bok == null) {
				continue;
			}
			else {
				System.out.println("Name : " + bok.name);
				System.out.println("Age : " + bok.age);
				System.out.println("Coach : " + bok.coach);
				System.out.println("Seat No : " + bok.seat_ac);
				System.out.println("==============================================");
			}
		}
		for(Bookingtrain bok : bookingsnac) {
			if(bok == null) {
				continue;
			}
			else {
				System.out.println("Name : " + bok.name);
				System.out.println("Age : " + bok.age);
				System.out.println("Coach : " + bok.coach);
				System.out.println("Seat No : " + bok.seat_nac);
				System.out.println("==============================================");
			}
			
		}
		for(Bookingtrain bok : bookingss) {
			if(bok == null) {
				continue;
			}
			else {
				System.out.println("Name : " + bok.name);
				System.out.println("Age : " + bok.age);
				System.out.println("Coach : " + bok.coach);
				System.out.println("Seat No : " + bok.seat_s);
				System.out.println("==============================================");
			}
		}
	}
    public static void main(String[] args) {
    	ticketbooking("Monish", 21, new BigInteger("6513513651"), new BigInteger("653112132"), "ac");
    	ticketbooking("srinivasan", 53, new BigInteger("651513321"), new BigInteger("653613132"), "ac");
    	ticketbooking("lavanya", 21, new BigInteger("65651132112"), new BigInteger("6565161113"), "ac");
    	ticketbooking("vishwa", 21, new BigInteger("4351322321"), new BigInteger("65652651123"), "ac");
    	display();
    	cancelation(new BigInteger("6513513651"), "ac", 1);
    	ticketbooking("kiran", 54, new BigInteger("6513515451"), new BigInteger("653622132"), "ac");
    	ticketbooking("kamali", 53, new BigInteger("651513321"), new BigInteger("653613132"), "ac");
    	display();
    	
    }
}
