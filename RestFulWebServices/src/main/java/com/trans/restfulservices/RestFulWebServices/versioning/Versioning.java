package com.trans.restfulservices.RestFulWebServices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Versioning {
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Dk Kumar");
	}

	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Durgesh", "Gupta"));
	}
	
//http://localhost:8080/person/param?version=1
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Durgesh Gupta");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("sbnm", "srma"));
	}

	/*http://localhost:8080/person/header
	 * Go in postman,past url in get 
	 * select headers, type X-API-VERSION in below key box and type 1 in below value box 
	 * check mark box front of key
	 * */
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Durgeshkumar");
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Durgesh", "kumar"));
	}
	
	/*http://localhost:8080/person/produces
	 * Go in postman,past url in get 
	 * select headers, type accept in below key box and type "application/vnd.company.app-v1+json" in below value box 
	 * check mark box front of key
	 * */

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Jai Pal");
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Jay", "Pal"));
	}

}