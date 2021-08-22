package com.sac.foodorder.service;

import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.Chef;

import java.util.List;

/**
 * @author Sachith Harshamal
 */
public interface ChefService {

    List<Chef> findAllChefs();

    List<Chef> findAllAvailableChefs();

    List<Chef> findAllBusyChefs();

    Chef findAChefById(long chefId) throws DataNullException;

    String saveNewChef(String firstName, String lastName, String gender, int experience, String skill, double price) throws DataNullException;

    String changeStatusOfAChef(long chefId, String status) throws DataNullException;

    String updateChef(long chefId, double price, String skill, int experience) throws DataNullException;

    String deleteChef(long chefId);
}
