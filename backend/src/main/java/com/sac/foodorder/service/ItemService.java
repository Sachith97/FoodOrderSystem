package com.sac.foodorder.service;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.ItemData;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
public interface ItemService {

    List<ItemData> findAllItems();

    ItemData findAItem(int code) throws DataNullException;

    String saveNewItem(String title, String item, String description, String currency, int price, String type, String image);

    String updateItem(int code, String description, String currency, int price, String type) throws DataNullException;

    String deleteItem(int code) throws DataNullException;
}
