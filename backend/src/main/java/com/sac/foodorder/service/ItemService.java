package com.sac.foodorder.service;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.ItemData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Sachith Harshamal
 */
public interface ItemService {

    List<ItemData> findAllItems();

    ItemData findAItem(int code) throws DataNullException;

    String saveNewItem(String title, String item, String description, String currency, int price, String type, MultipartFile multipartFile) throws IOException;

    String updateItem(int code, String description, String currency, int price, String type) throws DataNullException;

    String deleteItem(int code) throws DataNullException, IOException;
}
