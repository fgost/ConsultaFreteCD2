package com.example.viaCep.services;

import com.example.viaCep.entities.Frete;
import com.example.viaCep.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FreteService {

    @Autowired
    FreteRepository freteRepository;

    public void salvarConsultaFrete(Double peso,
                                    String cepOrigem,
                                    String cepDestino,
                                    String nomeDestinatario,
                                    Double vlTotalFrete,
                                    Date dataPrevistaEntrega,
                                    Date dataConsulta){

        Frete frete = new Frete(peso,cepOrigem,cepDestino,nomeDestinatario,vlTotalFrete,dataPrevistaEntrega,dataConsulta);

        freteRepository.save(frete);

    }

}