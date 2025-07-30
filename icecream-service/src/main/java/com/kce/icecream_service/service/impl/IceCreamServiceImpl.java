package com.kce.icecream_service.service.impl;


import com.kce.icecream_service.model.Flavour;
import com.kce.icecream_service.repository.IceCreamRepository;
import com.kce.icecream_service.service.IceCreamService;

import com.kce.icecream_service.utility.FlavourNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IceCreamServiceImpl implements IceCreamService {

    @Autowired
    private IceCreamRepository iceCreamRepository;

    @Override
    public List<Flavour> getFlavours() {
        return iceCreamRepository.findAll();
    }

    @Override
    public Optional<Flavour> getFlavour(String id) {
        Optional<Flavour> flavour=iceCreamRepository.findById(id);
        if(flavour.isEmpty())
        {
            throw new FlavourNotFoundException(id);
        }
        else{
            return flavour;
        }
//         iceCreamRepository.findById(id);
    }

    @Override
    public Flavour addFlavour(Flavour flavour) {
        return iceCreamRepository.save(flavour);
    }

    @Override
    public Flavour updateFlavour(Flavour flavour,String id) {
        Optional<Flavour> oldflavour =iceCreamRepository.findById(id);
        Flavour updateFlavour=oldflavour.isPresent() ? oldflavour.get() : flavour;
        if(oldflavour.isEmpty())
        {
            throw new FlavourNotFoundException(id);
        }
        else{
            updateFlavour.setDescription(flavour.getDescription());
            updateFlavour.setName(flavour.getName());
            updateFlavour.setPrice(flavour.getPrice());
            iceCreamRepository.save(updateFlavour);
        }
        return updateFlavour;
    }

    @Override
    public Flavour deleteFlavour(String id) {
        Optional<Flavour> flavour=iceCreamRepository.findById(id);
        Flavour flavour1=flavour.isPresent() ? flavour.get() : null;
        if(flavour1==null)
        {
            throw new FlavourNotFoundException(id);
        }
        else{
            iceCreamRepository.delete(flavour1);
            return flavour1;
        }
//        return iceCreamRepository.deleteById(id);
    }
}
