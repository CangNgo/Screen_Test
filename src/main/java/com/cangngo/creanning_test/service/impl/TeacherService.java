package com.cangngo.creanning_test.service.impl;

import com.cangngo.creanning_test.dao.ITeacherDAO;
import com.cangngo.creanning_test.dao.impl.TeacherDAO;
import com.cangngo.creanning_test.dto.teacherdto.TeacherCreationRequest;
import com.cangngo.creanning_test.dto.teacherdto.TeacherUpdateRequest;
import com.cangngo.creanning_test.entity.Teacher;
import com.cangngo.creanning_test.service.ITeacherService;

import java.util.List;

public class TeacherService implements ITeacherService {
    private final ITeacherDAO teacherDAO;
    public  TeacherService(){
    teacherDAO = new TeacherDAO();
    }

    @Override
    public String createTeacher(TeacherCreationRequest request) {
        return teacherDAO.createTeacher(request);
    }

    @Override
    public String updateTeacher(Long id, TeacherUpdateRequest request) {
        return  teacherDAO.updateTeacher(id, request);
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return teacherDAO.findAllTeachers();
    }

    @Override
    public Teacher findTeacherById(Long id) {
        return teacherDAO.findTeacherById(id);
    }

    @Override
    public List<Teacher> findByNameOrId(String findName) {
        return teacherDAO.findByNameOrId(findName);
    }

    @Override
    public List<Teacher> findByDegree(int degree) {
        return teacherDAO.findByDegree(degree);
    }
}
