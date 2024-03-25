package com.khasim.project;
public class Hostel {
	private String email;
	private String hostelId;
    private String name;
    private int capacity;
    private boolean isVacant;


    // Getters and Setters
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    public String getHostelId() {
        return hostelId;
    }

    public void setHostelId(String hostelId) {
        this.hostelId = hostelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isVacant() {
        return isVacant;
    }

    public void setVacant(boolean vacant) {
        isVacant = vacant;
    }

	 

	
}
