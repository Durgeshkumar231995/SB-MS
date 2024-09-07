package com.trans.restfulservices.RestFulWebServices.dynamicfiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	// return field1,field2
		@GetMapping("/filtering")
		public MappingJacksonValue retrieveSomeBean() {
			SomeBean someBean = new SomeBean("Dk", "SBNM", "DKumar");

			SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

			FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

			MappingJacksonValue mapping = new MappingJacksonValue(someBean);

			mapping.setFilters(filters);

			return mapping;
		}
	

		// return field2, field3
		@GetMapping("/filtering-list")
		public MappingJacksonValue retrieveListOfSomeBeans() {
			List<SomeBean> list = Arrays.asList(new SomeBean("Dk", "SBNM", "DKumar"),
					new SomeBean("Dk gupta", "SBNM sharma", "DKumar"));

			SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");

			FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

			MappingJacksonValue mapping = new MappingJacksonValue(list);

			mapping.setFilters(filters);

			return mapping;
		}

	}