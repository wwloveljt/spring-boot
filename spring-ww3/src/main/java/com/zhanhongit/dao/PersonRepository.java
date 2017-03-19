package com.zhanhongit.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.zhanhongit.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {
	@Query("select distinct city as city from Person")
	List<String> withCitys();
	
	@Query("select distinct area as area from Person where city = :city")
	List<String> withAreas(@Param("city") String city);
	
	@Query("select distinct school as school from Person where city =:city and area =:area")
	List<String> withSchools(@Param("city") String city, @Param("area") String area);
	
	@Query("select distinct grade as school from Person where city =:city and area =:area and school=:school")
	List<String> withGrades(@Param("city") String city, @Param("area") String area, @Param("school") String school);
	
	@Query("select distinct bj as school from Person where city =:city and area =:area and school=:school and grade=:grade")
	List<String> withBjs(@Param("city") String city, @Param("area") String area, @Param("school") String school, @Param("grade") String grade);
	
	
	@Query("select p from Person p")
	List<Person> withPersons();
	
	/*@Query("select p from Person p where city =:city limit :pageIndex, :pageSize")
	List<Person> withPersonsByCity(@Param("city") String city, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize );*/
	
	@Query("select p from Person  p where city =:city and area =:area and school=:school and grade=:grade and bj=:bj")
	List<Person> withAllPersons(@Param("city") String city, @Param("area") String area, @Param("school") String school, @Param("grade") String grade, @Param("bj") String bj);
	
	@Query("select count(*) as count from Person p where p.city = :city")
	Integer withCountByCity(@Param("city") String city);
	
	@Query("select p from Person p where patriarch_tel=:tel")
	List<Person> withPersonByTel(@Param("tel") String tel);
	
	@Query("select p from Person p where id=:id")
	Person withPersonById(@Param("id") Long id);
	
	/*@Query("update Person p p.set state=true where id=:id")
	void upPersonById(@Param("id") Long id);*/
}
