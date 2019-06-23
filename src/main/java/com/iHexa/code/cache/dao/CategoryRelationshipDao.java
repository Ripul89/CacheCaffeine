package com.iHexa.code.cache.dao;

import java.util.List;

import com.iHexa.code.cache.beans.Ctgry;

public interface CategoryRelationshipDao {	
	public List<Ctgry> loadCategoryRelationship(String ctgryId);
	
}
