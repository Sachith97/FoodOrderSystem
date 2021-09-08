package com.sac.foodorder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "item_code")
	private ItemData itemData;

	public UserCart() {
	}
	
	public UserCart(ItemData itemData, int quantity) {
		this.itemData = itemData;
		this.quantity = quantity;
	}

	public int getCart_id() {
		return cart_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ItemData getItemData() {
		return itemData;
	}

	public void setItemData(ItemData itemData) {
		this.itemData = itemData;
	}
}
