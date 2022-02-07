package com.example.viaCep.controllers;

import com.example.viaCep.ValorConsultaFrete;
import com.example.viaCep.ViaCep;
import com.example.viaCep.services.FreteService;
import com.example.viaCep.services.ViaCepService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
@Api(value="API REST Fretes")
@CrossOrigin(origins="*")
public class ViaCepController {

	@Autowired
	private ViaCepService viaCepService;

	@Autowired
	private FreteService freteService;

	@PostMapping("/consultar-frete/{cepOrigem}/{cepDestino}/{peso}/{nomeDestinatario}")
	public ResponseEntity <String> consultarFrete(@PathVariable String cepOrigem, @PathVariable String cepDestino, @PathVariable Double peso, @PathVariable String nomeDestinatario){
		Gson gson = new Gson();

		Double vlFrete = 0.0;

		//constroi um objeto apartir do cep de origem e destino recebidos do formulario
		ViaCep cepDeOrigem = viaCepService.getCep(cepOrigem);

		ViaCep cepDeDestino = viaCepService.getCep(cepDestino);

		Date dataConsulta = new Date();

		Date dataPrevistaEntrega;
		//acrescentar os dias a mais apartir da data de consulta
		Calendar cal = Calendar.getInstance();

		if(cepDeDestino.getCep() == null || cepDeOrigem.getCep() == null){
			return new ResponseEntity<>("CEP de origem ou CEP de destino invalidos", HttpStatus.BAD_REQUEST);
		}

		if(cepDeOrigem.getDdd().equals(cepDeDestino.getDdd())){
			vlFrete = peso - (peso * 0.5);
			cal.setTime(dataConsulta );
			cal.add(Calendar.DATE, 1);
			dataPrevistaEntrega = cal.getTime();
			freteService.salvarConsultaFrete(peso, cepDeOrigem.getCep(), cepDeDestino.getCep(), nomeDestinatario, vlFrete, dataPrevistaEntrega, dataConsulta);

			ValorConsultaFrete frete = new ValorConsultaFrete(vlFrete, cepDeOrigem.getCep(), cepDeDestino.getCep(), dataPrevistaEntrega);
			String jsonObject = gson.toJson(frete);
			return new ResponseEntity<>(jsonObject, HttpStatus.OK);
		}
		else if(!cepDeOrigem.getDdd().equals(cepDeDestino.getDdd())&&cepDeOrigem.getUf().equals(cepDeDestino.getUf())){
			vlFrete = peso - (peso * 0.75);
			cal.setTime(dataConsulta );
			cal.add(Calendar.DATE, 3);
			dataPrevistaEntrega = cal.getTime();
			freteService.salvarConsultaFrete(peso, cepDeOrigem.getCep(), cepDeDestino.getCep(), nomeDestinatario, vlFrete, dataPrevistaEntrega, dataConsulta);

			ValorConsultaFrete frete = new ValorConsultaFrete(vlFrete, cepDeOrigem.getCep(), cepDeDestino.getCep(), dataPrevistaEntrega);
			String jsonObject = gson.toJson(frete);
			return new ResponseEntity<>(jsonObject, HttpStatus.OK);
		}
		else if(!cepDeOrigem.getUf().equals(cepDeDestino.getUf())){
			vlFrete = peso;
			cal.setTime(dataConsulta );
			cal.add(Calendar.DATE, 10);
			dataPrevistaEntrega = cal.getTime();
			freteService.salvarConsultaFrete(peso, cepDeOrigem.getCep(), cepDeDestino.getCep(), nomeDestinatario, vlFrete, dataPrevistaEntrega, dataConsulta);

			ValorConsultaFrete frete = new ValorConsultaFrete(vlFrete, cepDeOrigem.getCep(), cepDeDestino.getCep(), dataPrevistaEntrega);
			String jsonObject = gson.toJson(frete);
			return new ResponseEntity<>(jsonObject, HttpStatus.OK);

		}

		return new ResponseEntity<>("CEP de origem ou CEP de destino invalidos", HttpStatus.BAD_REQUEST);
	}
}