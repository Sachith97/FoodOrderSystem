package com.sac.foodorder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Sachith Harshamal
 */
@Entity
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private ItemData item_data;
	
	private int item_quantity;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@Column
	@Temporal(TemporalType.TIME)
	private Date orderTime;
	
	private int price;
	private String status;

	public Date getOrderDate() {
		return orderDate;
	}

	public OrderItems() {
		super();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ItemData getItem_data() {
		return item_data;
	}
	public void setItem_data(ItemData item_data) {
		this.item_data = item_data;
	}
	public int getItem_quantity() {
		return item_quantity;
	}
	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}
	public String getOrder_date() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMMM dd");
		return dateFormat.format(this.orderDate);
	}
	public void setOrder_date(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrder_time() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
		return dateFormat.format(this.orderTime);
	}
	public void setOrder_time(Date orderTime) {
		this.orderTime = orderTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
