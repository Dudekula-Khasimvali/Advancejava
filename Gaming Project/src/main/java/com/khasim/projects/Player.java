package com.khasim.projects;

public class Player {
    private String username;
    private String password;
    private int level;
    
    
    //Constructor
    public Player(String username, String password, int level) {
		super();
		this.username = username;
		this.password = password;
		this.level = level;
	}
    
	public Player() {
		// TODO Auto-generated constructor stub
	}

	//Getters and Setter
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}		
}