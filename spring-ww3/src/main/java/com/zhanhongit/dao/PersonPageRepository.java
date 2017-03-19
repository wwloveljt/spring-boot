package com.zhanhongit.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zhanhongit.model.Person;

public interface PersonPageRepository extends PagingAndSortingRepository<Person, Long>,JpaSpecificationExecutor<Person>   {

}
