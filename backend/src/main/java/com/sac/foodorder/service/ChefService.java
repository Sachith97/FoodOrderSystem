package com.sac.foodorder.service;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.Chef;
import com.sac.foodorder.vo.CommonResponseVO;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
public interface ChefService {

    List<Chef> findAllChefs();

    List<Chef> findAllAvailableChefs();

    List<Chef> findAllBusyChefs();

    Chef findAChefById(long chefId) throws DataNullException;

    CommonResponseVO saveNewChef(String firstName, String lastName, String gender, int experience, String skill, double price) throws DataNullException;

    CommonResponseVO changeStatusOfAChef(long chefId, String status) throws DataNullException;

    CommonResponseVO updateChef(long chefId, double price, String skill, int experience) throws DataNullException;

    CommonResponseVO deleteChef(long chefId);
}
