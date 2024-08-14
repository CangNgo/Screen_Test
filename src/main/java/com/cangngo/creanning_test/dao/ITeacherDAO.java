package com.cangngo.creanning_test.dao;

import com.cangngo.creanning_test.dto.teacherdto.TeacherCreationRequest;
import com.cangngo.creanning_test.dto.teacherdto.TeacherUpdateRequest;
import com.cangngo.creanning_test.entity.Teacher;

import java.util.List;

public interface ITeacherDAO {
    String createTeacher(TeacherCreationRequest request);

    String updateTeacher(Long id, TeacherUpdateRequest request);

    List<Teacher> findAllTeachers();

    Teacher findTeacherById(Long id);

    List<Teacher> findByNameOrId(String findNameOrId);

    List<Teacher> findByDegree(int degree);
}
