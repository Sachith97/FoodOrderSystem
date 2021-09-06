package com.sac.foodorder.service.implementation;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.ItemData;
import com.sac.foodorder.repository.ItemDataRepository;
import com.sac.foodorder.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sachith Harshamal
 */
@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);
    private static final String ACTIVE_STATUS = "active";
    private static final String INACTIVE_STATUS = "inactive";
    private static final String FOOD_IMAGE_DIRECTORY = "src/main/resources/static/content/foods";

    private final ItemDataRepository itemRepository;

    public ItemServiceImpl(ItemDataRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemData> findAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public ItemData findAItem(int code) throws DataNullException {
        Optional<ItemData> itemData = itemRepository.findById(code);

        if(itemData.isPresent()) {
            return itemData.get();
        } else {
            throw new DataNullException("requested item not available for code: " + code);
        }
    }

    @Override
    public String saveNewItem(String title, String item, String description, String currency, int price, String type, String image) {
        ItemData itemData = new ItemData();
        itemData.setTitle(title);
        itemData.setItem(item);
        itemData.setDescription(description);
        itemData.setCurrency(currency);
        itemData.setPrice(price);
        itemData.setType(type);
        itemData.setPhotos(image);
        itemData.setStatus(ACTIVE_STATUS);

        try {
            itemRepository.save(itemData);
        } catch (Exception e) {
            log.error("error occurred in inserting phase | " + e);
            return "unsuccessful";
        }
        return "successful";
    }

    @Override
    public String updateItem(int code, String description, String currency, int price, String type) throws DataNullException {
        Optional<ItemData> optionalItemData = itemRepository.findById(code);
        if(!optionalItemData.isPresent()) {
            throw new DataNullException("requested item not available for code: " + code);
        }

        ItemData itemData = optionalItemData.get();
        itemData.setDescription(description);
        itemData.setCurrency(currency);
        itemData.setPrice(price);
        itemData.setType(type);

        try {
            itemRepository.save(itemData);
        } catch (Exception e) {
            log.error("error occurred in updating phase | " + e);
            return "unsuccessful";
        }
        return "successful";
    }

    @Override
    public String deleteItem(int code) throws DataNullException {
        Optional<ItemData> optionalItemData = itemRepository.findById(code);
        if(!optionalItemData.isPresent()) {
            throw new DataNullException("requested item not available for code: " + code);
        }
        ItemData itemData = optionalItemData.get();
        itemData.setStatus(INACTIVE_STATUS);
        try {
            itemRepository.save(itemData);
        } catch (Exception e) {
            log.error("error occurred in deleting phase | " + e);
            return "unsuccessful";
        }
        return "successful";
    }
}
