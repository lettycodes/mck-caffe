package mck.caffe.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mck.caffe.com.model.Address;
import mck.caffe.com.service.ViaCepService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@GetMapping()
	Address returnAddress(@RequestParam String cep) throws Exception{
		
		ViaCepService cepService = new ViaCepService();
		Address newAddress = null;
		newAddress = cepService.getAddressByCep(cep);	

		return newAddress;
	}
}
