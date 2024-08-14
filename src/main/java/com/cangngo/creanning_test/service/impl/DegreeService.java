package com.cangngo.creanning_test.service.impl;

import com.cangngo.creanning_test.dao.IContractDAO;
import com.cangngo.creanning_test.dao.IDegreeDAO;
import com.cangngo.creanning_test.dao.impl.ContractDAO;
import com.cangngo.creanning_test.dao.impl.DegreeDAO;
import com.cangngo.creanning_test.entity.Contract;
import com.cangngo.creanning_test.entity.Degree;
import com.cangngo.creanning_test.service.IDegreeService;

import java.util.List;

public class DegreeService implements IDegreeService {
    IDegreeDAO degreeDAO;
    public DegreeService() {
        degreeDAO = new DegreeDAO();
    }

    @Override
    public List<Degree> findAll() {
        return degreeDAO.findAll();
    }
}
