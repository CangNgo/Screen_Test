package com.cangngo.creanning_test.dao;

import com.cangngo.creanning_test.entity.Degree;

import java.util.List;

public interface IDegreeDAO {
    Degree findDegreeByName(String degreeName);
    List<Degree> findAll();
}
