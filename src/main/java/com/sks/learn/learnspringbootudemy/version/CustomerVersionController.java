package com.sks.learn.learnspringbootudemy.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerVersionController {

	@GetMapping("/v1/customer")
	public CustomerV1 fetchCustomerV1() {
		return new CustomerV1("Sujit Singh");
	}

	@GetMapping("/v2/customer")
	public CustomerV2 fetchCustomerV2() {
		return new CustomerV2("Sujit", "Singh");
	}

	@GetMapping(value = "/customer", params = "version=1")
	public CustomerV1 paramCustomerV1() {
		return new CustomerV1("Sujit Singh");
	}

	@GetMapping(value = "/customer", params = "version=2")
	public CustomerV2 paramCustomerV2() {
		return new CustomerV2("Sujit", "Singh");
	}
	
	@GetMapping(value = "/customer", headers = "SKS_SVC_VERSION=1.0.0")
	public CustomerV1 headerCustomerV1() {
		return new CustomerV1("Sujit Singh");
	}

	@GetMapping(value = "/customer", headers = "SKS_SVC_VERSION=2.0.0")
	public CustomerV2 headerCustomerV2() {
		return new CustomerV2("Sujit", "Singh");
	}
}
