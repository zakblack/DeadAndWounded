package frontend.game;

import java.util.HashMap;
import java.util.Random;

import frontend.modele.module.Jouer;
import frontend.modele.module.User;

public class Rooms {
	public static HashMap<String, User> usersInRoom=new HashMap<String, User>();
	
	public static HashMap<String, Jouer> rooms=new HashMap<String, Jouer>();

	public Rooms() {
	}
	
	public static boolean isThere(String room) {
		return rooms.containsKey(room);
	}
	
	public static void setJouer(String room, Jouer jouer) {
		rooms.put(room, jouer);
	}
	
	public static Jouer getJouer(String room) {
		return rooms.get(room);
	}
	
	public static void removeJouer(String room) {
		rooms.remove(room);
	}
	
	public static String generateRoom() {
		String chaine="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int length=4;
		String room="";
		int n;
		char c;
		Random rand = new Random();
		
		for (int i = 0; i < length; i++) {
			 n = rand.nextInt(chaine.length());
			 c=chaine.charAt(n);
			 room+=c;
		}
		
		return room;
	}
	
	public static String generateUniqueRoom() {
		String room="";
		
		do {
			room=Rooms.generateRoom();
		} while (Rooms.isThere(room));
		
		return room;
	}
	
	
	public static boolean analyseRoom(Jouer j) {
		if(j!=null && j.getId_u1()!=0 && j.getId_u2()!=0 && j.getRoom()!="" && j.getNombre_u1()!=0 && j.getNombre_u2()!=0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void addUserInRoom(String room, User user, int u1ORu2) {
		usersInRoom.put(room+"_u"+u1ORu2, user);
	}
	
	public static User getUserInRoom(String room, int u1ORu2) {
		if(usersInRoom.containsKey(room+"_u"+u1ORu2)) {
			return usersInRoom.get(room+"_u"+u1ORu2);
		}
		else {
			return null;
		}
	}
	
	public static void removeUserInRoom(String room, int u1ORu2) {
		if(usersInRoom.containsKey(room+"_u"+u1ORu2)) {
			usersInRoom.remove(room+"_u"+u1ORu2);
		}
	}
	
	public static boolean isThereUserInRoom(String room, int u1ORu2) {
		if(usersInRoom.containsKey(room+"_u"+u1ORu2)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
