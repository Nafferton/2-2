package application;

public class User {
	private static String[] usernames = new String[100];
	private static String[] passwords = new String[100];
	
	public User() {
		//		
	}
	public void addUser(String username, String password) {
		for(int i = 0; i < usernames.length; i++) {
			if(usernames[i] == null) {
				usernames[i] = username;
				passwords[i] = password;
				break;
			}
		}
	}
	public boolean validateUser(String username, String password) {
		for(int i = 0; i < usernames.length; i++) {
			if(usernames[i] != null && usernames[i].equals(username) && passwords[i].equals(password)) {
				return true;
			}
		}
		return false;
	}
}
