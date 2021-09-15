package com.sac.foodorder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Sachith Harshamal
 */
@Entity
@Table(name = "item_data")
public class ItemData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	private String title;
	private String item;
	private String description;
	private String currency;
	private int price;
	private String type;
	private String photos;
	private String status;

	@OneToMany(mappedBy = "item_data")
	@JsonIgnore
	private List<OrderItems> orderItems;

	@OneToMany(mappedBy = "itemData")
	@JsonIgnore
	private List<UserCart> userCart;
	
	public ItemData() {
	}

	public ItemData(String title, String item, String description, String currency, int price, String type,
			String photos, String status) {
		this.title = title;
		this.item = item;
		this.description = description;
		this.currency = currency;
		this.price = price;
		this.type = type;
		this.photos = photos;
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	public List<UserCart> getUserCart() {
		return userCart;
	}

	public void setUserCart(List<UserCart> userCart) {
		this.userCart = userCart;
	}
}
