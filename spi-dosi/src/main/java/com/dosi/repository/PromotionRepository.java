package com.dosi.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.dosi.models.Promotion;

public interface PromotionRepository extends CrudRepository<Promotion, String> {
	@Query(value= "SELECT * from PROMOTION where promotion.code_formation=?1 ", nativeQuery=true)
	List<Promotion> findByFormation(String code_formation);

}
