package com.sac.foodorder.service.implementation;

import com.sac.foodorder.enums.Response;
import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.ItemData;
import com.sac.foodorder.model.User;
import com.sac.foodorder.model.UserCart;
import com.sac.foodorder.repository.UserCartRepository;
import com.sac.foodorder.service.ItemService;
import com.sac.foodorder.service.UserCartService;
import com.sac.foodorder.service.UserService;
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
public class UserCartServiceImpl implements UserCartService {

    private static final Logger log = LoggerFactory.getLogger(UserCartServiceImpl.class);

    private final UserCartRepository userCartRepository;
    private final UserService userService;
    private final ItemService itemService;

    public UserCartServiceImpl(UserCartRepository userCartRepository, UserService userService, ItemService itemService) {
        this.userCartRepository = userCartRepository;
        this.userService = userService;
        this.itemService = itemService;
    }

    @Override
    public List<UserCart> getCartDetailsByUser() {
        return userCartRepository.findByUser(getCurrentUser());
    }

    @Override
    public CommonResponseVO newCartDetail(int itemCode, int quantity) throws DataNullException {
        UserCart userCart = new UserCart();
        userCart.setUser(getCurrentUser());
        userCart.setItemData(getItem(itemCode));
        userCart.setQuantity(quantity);
        try {
            userCartRepository.save(userCart);
        } catch (Exception exception) {
            log.error("error occurred in inserting phase | " + exception);
            return new CommonResponseVO(Response.FAILED);
        }
        return new CommonResponseVO(Response.SUCCESS);
    }

    @Override
    public CommonResponseVO updateCartDetails(int itemCode, int quantity) throws DataNullException {
        Optional<UserCart> optionalUserCart = userCartRepository.findByUserAndItemData(getCurrentUser(), getItem(itemCode));
        if(!optionalUserCart.isPresent()) {
            throw new DataNullException("requested item not available in cart for code: " + itemCode);
        }
        UserCart userCart = optionalUserCart.get();
        userCart.setQuantity(quantity);
        try {
            userCartRepository.save(userCart);
        } catch (Exception exception) {
            log.error("error occurred in updating phase | " + exception);
            return new CommonResponseVO(Response.FAILED);
        }
        return new CommonResponseVO(Response.SUCCESS);
    }

    @Override
    public CommonResponseVO deleteCartDetails(int itemCode) throws DataNullException {
        Optional<UserCart> optionalUserCart = userCartRepository.findByUserAndItemData(getCurrentUser(), getItem(itemCode));
        if(!optionalUserCart.isPresent()) {
            throw new DataNullException("requested data not available in cart for code: " + itemCode);
        }
        UserCart userCart = optionalUserCart.get();
        try {
            userCartRepository.delete(userCart);
        } catch (Exception exception) {
            log.error("error occurred in deleting phase | " + exception);
            return new CommonResponseVO(Response.FAILED);
        }
        return new CommonResponseVO(Response.SUCCESS);
    }

    private User getCurrentUser() {
        return userService.getCurrentUser();
    }

    private ItemData getItem(int itemCode) throws DataNullException {
        return itemService.findAItemByCode(itemCode);
    }
}
