package com.iHexa.code.cache.service;

import java.util.List;

import com.iHexa.code.cache.beans.Ctgry;

public interface CategoryRelationshipService {
	public List<Ctgry> loadCategoryRelationship(String ctgryId);
}
