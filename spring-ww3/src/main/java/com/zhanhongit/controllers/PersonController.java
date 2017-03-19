package com.zhanhongit.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.zhanhongit.dao.PersonPageRepository;
import com.zhanhongit.dao.PersonRepository;
import com.zhanhongit.model.*;

@Controller
@RequestMapping("")
@SessionAttributes({ "id" })
public class PersonController {
	@Autowired
	PersonPageRepository personPageRepository;

	@Autowired
	PersonRepository personRepository;

	@RequestMapping("/")
	public String getMain() {
		return "main";
	}

	@RequestMapping("/persons")
	@ResponseBody
	public List<Person> getPersons() {
		List<Person> persons = personRepository.withPersons();
		return persons;
	}

	@RequestMapping("/second")
	public ModelAndView toSecond(ModelMap model) {
		ModelAndView mView = new ModelAndView("second");
		Long id = (Long) model.get("id");
		Person person = personRepository.withPersonById(id);
		person.setState(true);
		personRepository.saveAndFlush(person);
		mView.addObject(person);
		return mView;
	}

	@RequestMapping("/index")
	public String getIndex() {
		return "index";
	}

	@RequestMapping("/third/{id}")
	public String toThird(@PathVariable Long id, ModelMap map){
		map.addAttribute("id", id);
		Person person = personRepository.withPersonById(id);
		if (person.getCity().trim().equals("济南")){
			if (person.getArea().trim().equals("长清区".trim())) {return "four";}
		    else if (person.getArea().trim().equals("平阴县".trim()) ){
				return "six";
			} else {
				return "third";	
			}
		}else if (person.getCity().trim().equals("烟台")) {
			return "four";
		}
			
		return "six";
	}

	@SuppressWarnings("unused")
	private PageDate convertPageDate(PageDate pageData) {
		PageDate record = new PageDate();
		record.setPageIndex(pageData.getPageIndex() * pageData.getPageSize());
		record.setPageSize(pageData.getPageSize());
		record.setSortField(pageData.getSortField());
		record.setSortOrder(pageData.getSortOrder());
		return record;
	}

	@RequestMapping("/getcity")
	@ResponseBody
	public List<JsonValue> getCitys() {
		List<String> citys = personRepository.withCitys();
		List<JsonValue> values = JsonValue.getJsonValues(citys);
		return values;
	}

	@RequestMapping("/getarea/{city}")
	@ResponseBody
	public List<JsonValue> getAreas(@PathVariable String city) {
		List<String> areas = personRepository.withAreas(city);
		List<JsonValue> values = JsonValue.getJsonValues(areas);
		return values;
	}

	@RequestMapping("/personbyTel/{tel}")
	@ResponseBody
	public List<Person> getPersonByTel(@PathVariable String tel) {
		List<Person> persons = personRepository.withPersonByTel(tel);
		return persons;
	}

	@RequestMapping("/getschool/{city}/{area}")
	@ResponseBody
	public List<JsonValue> getSchools(@PathVariable String city, @PathVariable String area) {
		List<String> areas = personRepository.withSchools(city, area);
		List<JsonValue> values = JsonValue.getJsonValues(areas);
		return values;

	}

	@RequestMapping("/getgrade/{city}/{area}/{school}")
	@ResponseBody
	public List<JsonValue> getGrades(@PathVariable String city, @PathVariable String area,	@PathVariable String school) {
		List<String> areas = personRepository.withGrades(city, area, school);
		List<JsonValue> values = JsonValue.getJsonValues(areas);
		return values;
	}

	@RequestMapping("/getbj/{city}/{area}/{school}/{grade}")
	@ResponseBody
	public List<JsonValue> getBjs(@PathVariable String city, @PathVariable String area, @PathVariable String school,
			@PathVariable String grade) {
		List<String> areas = personRepository.withBjs(city, area, school, grade);
		List<JsonValue> values = JsonValue.getJsonValues(areas);
		return values;
	}

	@RequestMapping("/personsbyAll/{city}/{area}/{school}/{grade}/{bj}")
	@ResponseBody
	public List<Person> personsbyAll(@PathVariable String city, @PathVariable String area, @PathVariable String school,
			@PathVariable String grade, @PathVariable String bj) {
		List<Person> persons = personRepository.withAllPersons(city, area, school, grade, bj);
		return persons;
	}

	/*@RequestMapping(value = "/personsbycity", method = RequestMethod.POST)
	@ResponseBody
	public SendData<Person> getPersonsByCity(String city, Integer pageIndex, Integer pageSize, String sortField,
			String sortOrder) {
		// String city ="济南";
		// Integer pageIndex=1; Integer pageSize=1; String sortField=""; String sortOrder="";
		PageDate pageData = new PageDate(pageIndex, pageSize, sortField, sortOrder);
		System.out.println(pageData.getPageIndex() + ": " + pageData.getPageSize());
		SendData<Person> senddata = new SendData<Person>();
		senddata.setData(Lists
				.newArrayList(getpage(city, pageData.getSortField(), pageData.getPageIndex(), pageData.getPageSize())));
		senddata.setTotal(personRepository.withCountByCity(city));
		getpage(city, pageData.getSortField(), pageData.getPageIndex(), pageData.getPageSize()).toString();
		return senddata;
	}*/

	/*public Page<Person> getpage(String city, String sortField, int page, int size) {
		Pageable pageable = new PageRequest(page, size, new Sort(sortField));
		Specification<Person> spec = new Specification<Person>() {
			@Override
			public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate p1 = cb.like(root.get("name").as(String.class), "%" + city + "%");
				return query.where(p1).getRestriction();
			}
		};
		return personPageRepository.findAll(spec, pageable);
	}*/
}
