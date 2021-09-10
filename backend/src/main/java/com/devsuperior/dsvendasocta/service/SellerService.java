package com.devsuperior.dsvendasocta.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendasocta.dto.SellerDTO;
import com.devsuperior.dsvendasocta.entities.Seller;
import com.devsuperior.dsvendasocta.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository; // Responsável por acessar os dados
										 // A classe de serviço chama o repositorio para acessar os dados
	
	public List<SellerDTO> findAll(){
		List<Seller> result =  repository.findAll(); //Armazena as entidades retornadas em result
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
		/*
		 * result é convertido para SellerDTO e retornado
		 * */
	}

}
