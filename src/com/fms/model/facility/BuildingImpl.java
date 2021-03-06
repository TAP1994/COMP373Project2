package com.fms.model.facility;

import com.fms.model.maintenance.Issues;
import com.fms.model.users.Tenants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class BuildingImpl {
	
	private int BuildingID;
	private Address address;
	private ArrayList<Issues> issues = new ArrayList<Issues>();
	private ArrayList<Room> rooms = new ArrayList<Room>();
	//every building is a box
	//this construction method is when the record is not persisting
	@Autowired
	public BuildingImpl(int floors, int rooms, Address a){
		address = a;
		for (int i = 1; i <=floors; i++){
			for (int x = 0; x<rooms; x++){
				Room temp = new RoomImpl();
				int roomno = (i*100) + x;
				temp.setRoomNo(roomno);
				this.rooms.add(temp);
			}
		}
	}
	
	public BuildingImpl(){}
	
	public int getBuildingID() {
		return BuildingID;
	}
	
	public void setBuildingID(int id) {
		BuildingID = id;
	}
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getIssueCount() {
		return issues.size();
	}
	public ArrayList<Issues> getIssues(){
		return issues;
	}
	public void addIssue(Issues i) {
		issues.add(i);
	}
	public ArrayList<Room> getRooms(){
		return rooms;
	}
	public String toString(){
		String s = ("Building " + BuildingID + " at " + address.toString()); 
		s = s + ("\nRooms:");
		for (Room r: rooms){
			s = s + (r.toString());
		}
		return s;
	}
	public void addRoom(Room r){
		rooms.add(r);
	}
	public Room getRoom(int i) {
		for(Room r: rooms){
			if (r.getRoomNo() == i)
				return r;
		} System.out.println("NO MATCH");
		return rooms.get(0);
	}
	public void addTenantToRoom(Tenants t, int roomNo){
		for (Room r: rooms){
			if (r.getRoomNo() == roomNo){
				r.addTenant(t);
			}
		}
	}
}
