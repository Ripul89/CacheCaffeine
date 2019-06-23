package com.iHexa.code.cache.serviceImpl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.iHexa.code.cache.beans.Ctgry;
import com.iHexa.code.cache.dao.CategoryRelationshipDao;
import com.iHexa.code.cache.service.CategoryRelationshipService;

@Service
public class CategoryRelationshipServiceImpl implements CategoryRelationshipService {

	@Autowired
	CategoryRelationshipDao categoryRelationshipDao;

	LoadingCache<String, List<Ctgry>> pairsCacheCtgry = null;

	CacheContext context = new CacheContext();


	@Override
	@Cacheable(value = "ctgryRelationship", key = "#ctgryId", unless = "#result==null")
	public List<Ctgry> loadCategoryRelationship(String ctgryId) {

		if (pairsCacheCtgry == null) {

			pairsCacheCtgry = Caffeine.newBuilder().maximumSize(1000).refreshAfterWrite(11, TimeUnit.MINUTES)
					.build(title -> { // Using a jOOQ repository
						System.out.println("!!!!!!!!!!!!!!!!");
						return categoryRelationshipDao.loadCategoryRelationship(ctgryId);
					});
		}
		return pairsCacheCtgry.get("");		
	}

}
