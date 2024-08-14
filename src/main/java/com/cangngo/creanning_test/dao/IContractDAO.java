package com.cangngo.creanning_test.dao;

import com.cangngo.creanning_test.entity.Contract;
import com.cangngo.creanning_test.entity.Degree;

import java.util.List;

public interface IContractDAO {
    Contract findContractByName(String contractName);
    List<Contract> findAll();
}
