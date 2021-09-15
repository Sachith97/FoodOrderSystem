package com.sac.foodorder.service.implementation;

import com.sac.foodorder.enums.Response;
import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.ItemData;
import com.sac.foodorder.repository.ItemDataRepository;
import com.sac.foodorder.service.ItemService;
import com.sac.foodorder.vo.CommonResponseVO;
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

    private final ItemDataRepository itemRepository;

    public ItemServiceImpl(ItemDataRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemData> findAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public ItemData findAItemByCode(int code) throws DataNullException {
        Optional<ItemData> itemData = itemRepository.findById(code);

        if(itemData.isPresent()) {
            return itemData.get();
        } else {
            throw new DataNullException("requested item not available for code: " + code);
        }
    }

    @Override
    public List<ItemData> findItemsByTitle(String title) {
        return itemRepository.findByTitle(title);
    }

    @Override
    public CommonResponseVO saveNewItem(String title, String item, String description, String currency, int price, String type, String image) {
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
            return new CommonResponseVO(Response.FAILED);
        }
        return new CommonResponseVO(Response.SUCCESS);
    }

    @Override
    public CommonResponseVO updateItem(int code, String description, String currency, int price, String type) throws DataNullException {
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
            return new CommonResponseVO(Response.FAILED);
        }
        return new CommonResponseVO(Response.SUCCESS);
    }

    @Override
    public CommonResponseVO deleteItem(int code) throws DataNullException {
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
            return new CommonResponseVO(Response.FAILED);
        }
        return new CommonResponseVO(Response.SUCCESS);
    }
}
