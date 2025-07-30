package com.kce.icecream_service.service;

import com.kce.icecream_service.dto.FlavourDTO;
import com.kce.icecream_service.model.Flavour;

import java.util.*;

public interface IceCreamService {
      List<Flavour> getFlavours();
    Optional<Flavour> getFlavour(String id);
    Flavour addFlavour(Flavour flavour);
    Flavour updateFlavour(Flavour flavour,String id);
    Flavour deleteFlavour(String id);

}
