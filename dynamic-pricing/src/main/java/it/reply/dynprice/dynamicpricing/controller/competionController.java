package it.reply.dynprice.dynamicpricing.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.reply.dynprice.dynamicpricing.easynotes.repository.SparseComp;
import it.reply.dynprice.dynamicpricing.easynotes.repository.amazon;
import it.reply.dynprice.dynamicpricing.persistence.model.competion;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")

public class competionController {
    @Autowired
    amazon product;
    @GetMapping("/allPrices")
    public List<competion> getProducts() {
        return product.findAll();
    } // Get all Prices for a product on Amazon

    @GetMapping("/allPricess")
    public HashMap<Date,Double> getProductsDao() {


        HashMap<Date,Double> list = new HashMap<Date, Double>();

       for(competion i : getProducts()){
           list.put(i.getUpdated(),i.getPrice());

       }

        return list;
    }
}
