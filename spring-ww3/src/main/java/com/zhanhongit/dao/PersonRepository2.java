package com.zhanhongit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import com.zhanhongit.model.Person;
import com.zhanhongit.support.CustomRepository;

public interface PersonRepository2 extends CustomRepository<Person, Long> {
	
	@Query("select p from Person p where p.city=:city and p.area=:area")
	Person withCityAndAreaQuery(String city,String area);
	
	@Query("select p from Person p where p.patriarch_tel =:tel")
	List<Person> withPatriarchTelQuery(String tel);
	
}
