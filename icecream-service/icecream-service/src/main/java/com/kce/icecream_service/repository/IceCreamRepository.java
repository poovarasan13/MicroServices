package com.kce.icecream_service.repository;

import com.kce.icecream_service.model.Flavour;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IceCreamRepository extends MongoRepository<Flavour, String> {


}
