package com.sac.foodorder.service.implementation;

import com.sac.foodorder.enums.Response;
import com.sac.foodorder.exception.DataNullException;
import com.sac.foodorder.model.Chef;
import com.sac.foodorder.repository.ChefRepository;
import com.sac.foodorder.service.ChefService;
import com.sac.foodorder.vo.CommonResponseVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Sachith Harshamal
 */
@Service
public class ChefServiceImpl implements ChefService {

    private final ChefRepository chefRepository;

    public ChefServiceImpl(ChefRepository chefRepository) {
        this.chefRepository = chefRepository;
    }

    @Override
    public List<Chef> findAllChefs() {
        return chefRepository.findAll();
    }

    @Override
    public List<Chef> findAllAvailableChefs() {
        return chefRepository.findAllAvailableChefs();
    }

    @Override
    public List<Chef> findAllBusyChefs() {
        return chefRepository.findAllBusyChefs();
    }

    @Override
    public Chef findAChefById(long chefId) throws DataNullException {
        Optional<Chef> chef = chefRepository.findById(chefId);
        if(!chef.isPresent()) {
            throw new DataNullException("Chef is not available");
        }
        return chef.get();
    }

    @Override
    public CommonResponseVO saveNewChef(String firstName, String lastName, String gender, int experience, String skill, double price) throws DataNullException {
        try {
            Chef chef = new Chef();
            chef.setFirstName(firstName);
            chef.setLastName(lastName);
            chef.setGender(gender);
            chef.setExperience(experience);
            chef.setRate(0.0);
            chef.setSkill(skill);
            chef.setStatus("available");
            chef.setPrice(price);

            Chef result = chefRepository.save(chef);
            if (result.getFirstName().equals(chef.getFirstName())) {
                return new CommonResponseVO(Response.SUCCESS);
            } else {
                return new CommonResponseVO(Response.FAILED);
            }
        } catch (NullPointerException nullPointerException) {
            throw new DataNullException("Chef did not save");
        }
    }

    @Override
    public CommonResponseVO changeStatusOfAChef(long chefId, String status) throws DataNullException {
        Optional<Chef> optionalChef = chefRepository.findById(chefId);
        if(optionalChef.isPresent()) {
            Chef chef = optionalChef.get();
            chef.setStatus(status);
            Chef result = chefRepository.save(chef);
            if(result.getChefId() == chef.getChefId()) {
                return new CommonResponseVO(Response.SUCCESS);
            } else {
                return new CommonResponseVO(Response.FAILED);
            }
        } else {
            throw new DataNullException("Chef is not available");
        }
    }

    @Override
    public CommonResponseVO updateChef(long chefId, double price, String skill, int experience) throws DataNullException {
        Optional<Chef> optionalChef = chefRepository.findById(chefId);
        if(optionalChef.isPresent()) {
            Chef chef = optionalChef.get();
            chef.setPrice(price);
            chef.setSkill(skill);
            chef.setExperience(experience);
            Chef result = chefRepository.save(chef);
            if(result.getChefId() == chef.getChefId()) {
                return new CommonResponseVO(Response.SUCCESS);
            } else {
                return new CommonResponseVO(Response.FAILED);
            }
        } else {
            throw new DataNullException("Chef is not available");
        }
    }

    @Override
    public CommonResponseVO deleteChef(long chefId) {
        Optional<Chef> chef = chefRepository.findById(chefId);
        if(chef.isPresent()) {
            chefRepository.deleteById(chefId);
            return new CommonResponseVO(Response.SUCCESS);
        } else {
            return new CommonResponseVO(Response.FAILED);
        }
    }
}
