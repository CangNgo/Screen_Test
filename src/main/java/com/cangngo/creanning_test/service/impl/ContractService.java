package com.cangngo.creanning_test.service.impl;

import com.cangngo.creanning_test.dao.IContractDAO;
import com.cangngo.creanning_test.dao.impl.ContractDAO;
import com.cangngo.creanning_test.entity.Contract;
import com.cangngo.creanning_test.service.IContractService;

import java.util.List;

public class ContractService implements IContractService {
    IContractDAO contractDAO;
    public ContractService() {
        super();
        contractDAO = new ContractDAO();
    }
    public List<Contract> findAll(){
        return contractDAO.findAll();
    };
}
