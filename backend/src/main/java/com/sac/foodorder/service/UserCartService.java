package com.sac.foodorder.service;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.UserCart;
import com.sac.foodorder.vo.CommonResponseVO;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
public interface UserCartService {

    List<UserCart> getCartDetailsByUser();

    CommonResponseVO newCartDetail(int itemCode, int quantity) throws DataNullException;

    CommonResponseVO updateCartDetails(int itemCode, int quantity) throws DataNullException;

    CommonResponseVO deleteCartDetails(int itemCode) throws DataNullException;
}
