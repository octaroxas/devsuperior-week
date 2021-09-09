package com.devsuperior.dsvendasocta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendasocta.dto.SaleDTO;
import com.devsuperior.dsvendasocta.dto.SaleSuccessDTO;
import com.devsuperior.dsvendasocta.dto.SaleSumDTO;
import com.devsuperior.dsvendasocta.entities.Sale;
import com.devsuperior.dsvendasocta.repositories.SaleRepository;
import com.devsuperior.dsvendasocta.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository; // Responsável por acessar os dados
										 // A classe de serviço chama o repositorio para acessar os dados
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		
		sellerRepository.findAll(); //traz todos os vendedores para a memória (pois são poucos)
		Page<Sale> result =  repository.findAll(pageable); //Armazena as entidades retornadas em result
		return result.map(x -> new SaleDTO(x));
		/*
		 * result é convertido para SellerDTO e retornado
		 * */
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}

}
