package com.sac.foodorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String firstname;
	private String lastname;
	private String address;
	private int mobile;
	private String email;
	private String username;
	private String password;
	private String type;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<OrderItems> order_data;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<PartyRoomBooking> partyRoomBookings;
	
	public int getUid() {
		return uid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.password = passwordEncoder.encode(password).toString();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<OrderItems> getOrder_data() {
		return order_data;
	}

	public void setOrder_data(List<OrderItems> order_data) {
		this.order_data = order_data;
	}

	public List<PartyRoomBooking> getPartyRoomBookings() {
		return partyRoomBookings;
	}

	public void setPartyRoomBookings(List<PartyRoomBooking> partyRoomBookings) {
		this.partyRoomBookings = partyRoomBookings;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
				+ ", mobile=" + mobile + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", type=" + type + ", order_data=" + order_data + "]";
	}
}
