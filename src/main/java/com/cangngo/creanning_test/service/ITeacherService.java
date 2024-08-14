package com.cangngo.creanning_test.service;

import com.cangngo.creanning_test.dto.teacherdto.TeacherCreationRequest;
import com.cangngo.creanning_test.dto.teacherdto.TeacherUpdateRequest;
import com.cangngo.creanning_test.entity.Teacher;

import java.util.List;

public interface ITeacherService {
    String createTeacher(TeacherCreationRequest request);

    String updateTeacher(Long id, TeacherUpdateRequest request);

    List<Teacher> findAllTeacher();

    Teacher findTeacherById(Long id);
    List<Teacher> findByNameOrId(String findName);
    List<Teacher> findByDegree(int degree);
}
