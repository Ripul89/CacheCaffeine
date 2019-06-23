package com.iHexa.code.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iHexa.code.cache.beans.Ctgry;
import com.iHexa.code.cache.service.CategoryRelationshipService;



@RestController
@Component
public class CategoryTypeController {

	@Autowired
	CategoryRelationshipService categoryRelationshipService;
	
	@RequestMapping(value = "/loadRelationShip", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Ctgry> loadRelationShip() {
		List<Ctgry> ctgries = null;
		try {	
			ctgries = categoryRelationshipService.loadCategoryRelationship("ctgryId");
			
			
		} catch (Exception ee) {
			System.out.println(ee);
		}
		return ctgries;
	}
	
	@RequestMapping(value = "/loadRelationShipById/{r_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Ctgry loadRelationShipById(@PathVariable String r_id) {
		Ctgry ctgries = null;
		List<Ctgry> list = null;
		try {
			list = categoryRelationshipService.loadCategoryRelationship(r_id);
			if(list != null) {
			ctgries = list.stream()
		            .filter(x -> Integer.parseInt(r_id) == x.getCtgry_id())
		            .findAny()
		            .orElse(null);
			}
			
		} catch (Exception ee) {
			System.out.println(ee);
		}
		return ctgries;
	}	
}
