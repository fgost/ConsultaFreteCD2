package com.example.viaCep.services;

import com.example.viaCep.ViaCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {
	
	@Autowired
	RestTemplate restTemplate;
	
	public ViaCep getCep(String cep){
		return  restTemplate.getForObject("https://viacep.com.br/ws/{cep}/json/" , ViaCep.class, cep);
	}

}
