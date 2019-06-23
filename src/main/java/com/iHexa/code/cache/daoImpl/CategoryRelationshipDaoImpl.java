package com.iHexa.code.cache.daoImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.github.benmanes.caffeine.cache.LoadingCache;
import com.iHexa.code.cache.beans.Ctgry;
import com.iHexa.code.cache.dao.CategoryRelationshipDao;




@Service
public class CategoryRelationshipDaoImpl implements CategoryRelationshipDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Ctgry> loadCategoryRelationship(String ctgryId) {
		System.out.println("@@Category@@  "  + new Date());
		List<Ctgry> ctgryResult = jdbcTemplate.query(
				"select c.CTGRY_ID,c.CTGRY_TYP_ID,c.FROM_DT,c.THRU_DT, \r\n"
						+ "cd.locale_cd,cd.ctgry_nm,cd.ctgry_dsc,cd.mkt_dsc \r\n" + "from U90PIDP.CTGRY c\r\n"
						+ "left join U90PIDP.CTGRY_DSC cd\r\n" + "on c.CTGRY_ID=cd.CTGRY_ID\r\n"
						+ "where c.CTGRY_TYP_ID in (3,25,31,67) "
						//+ "and cd.LAST_UPDT_BY_ID = 'RS17456' "
						+ "order by c.CTGRY_ID\r\n",
				(rs, rowNum) -> new Ctgry(rs.getInt("CTGRY_ID"), rs.getInt("CTGRY_TYP_ID"), rs.getString("FROM_DT"),
						rs.getString("THRU_DT"), rs.getString("locale_cd"), rs.getString("ctgry_nm"),
						rs.getString("ctgry_dsc"), rs.getString("mkt_dsc")));

		System.out.println("@@Category@@  END"  + new Date());

		return ctgryResult;
	}
}
