package com.Bank.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Bank.model.Bank;

@Repository
public interface Bankrepo extends CrudRepository<Bank, Long> {

}
