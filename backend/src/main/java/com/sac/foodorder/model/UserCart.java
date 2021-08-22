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
	private int uid;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "item_code")
	private ItemData item_data;

	public UserCart() {
		super();
	}
	
	public UserCart(int uid, ItemData item_data, int quantity) {
		super();
		this.uid = uid;
		this.item_data = item_data;
		this.quantity = quantity;
	}

	public int getCart_id() {
		return cart_id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public ItemData getItemData() {
		return item_data;
	}

	public void setItemData(ItemData itemData) {
		this.item_data = itemData;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
