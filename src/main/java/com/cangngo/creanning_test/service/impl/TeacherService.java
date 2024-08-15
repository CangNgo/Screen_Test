package com.cangngo.creanning_test.service.impl;

import com.cangngo.creanning_test.dao.ITeacherDAO;
import com.cangngo.creanning_test.dao.impl.TeacherDAO;
import com.cangngo.creanning_test.dto.teacherdto.TeacherCreationRequest;
import com.cangngo.creanning_test.dto.teacherdto.TeacherUpdateRequest;
import com.cangngo.creanning_test.entity.Teacher;
import com.cangngo.creanning_test.service.ITeacherService;

import java.sql.Date;
import java.util.List;

public class TeacherService implements ITeacherService {
    private final ITeacherDAO teacherDAO;

    public TeacherService() {
        teacherDAO = new TeacherDAO();
    }

    @Override
    public String createTeacher(TeacherCreationRequest request) {
        //kiêm tra đủ dữ liệu hay chưa
        String checkRequest = checkTeacherCreationRequest(request);
        if(checkRequest != null) {
            return checkRequest;
        }
        //kiểm tra teacher đã tồn tại hay chưa
        Teacher teacher = teacherDAO.findTeacherByCodeName(request.getCodeTeacher());
        if (teacher != null) {
            return "Teacher " + request.getCodeTeacher() + " đã tồn tại";
        }
        return teacherDAO.createTeacher(request);
    }

    @Override
    public String updateTeacher(Long id, TeacherUpdateRequest request) {
        return teacherDAO.updateTeacher(id, request);
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

    //codeTeacher
    public boolean checkCodeTeacher(String codeTeacher) {
        if (codeTeacher == null || codeTeacher.isEmpty()) {
            return false;
        }
        return true;
    }

    //check request
    public String checkTeacherCreationRequest(TeacherCreationRequest request) {
        if(checkCodeTeacher(request.getCodeTeacher())) {
            return "Mã giảng viên chưa được nhập";
        }
        if(checkFirstName(request.getFirstName())) {
            return "Họ giảng viên chưa được nhập";
        }
        if(checkLastName(request.getLastName())) {
            return "Tên giảng viên chư được nhập";
        }
        if(checkFirstDayOfWork(request.getFirstDayOfWork())){
            return "Ngày bắt đầu vào làm không được để trống";
        }
        if(checkContract(request.getContract())) {
            return "Loại hợp đồng không được bỏ trống";
        }
        if (checkDegree(request.getDegree())) {
            return "Bằng cấp không được để trống";
        }
        return null;
    }

    //lastName
    public boolean checkLastName(String lastName) {
        if ( lastName == null || lastName.isEmpty()) {
            return false;
        }
        return true;
    }

    //firstName
    public boolean checkFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            return false;
        }
        return true;
    }


    //firstDayOfWork
    public boolean checkFirstDayOfWork(Date fristDayOfWork) {
        if (fristDayOfWork == null) {
            return false;
        }
        return true;
    }

    //degree
    public boolean checkDegree(String degree) {
        if (degree == null || degree.isEmpty()) {
            return false;
        }
        return true;
    }

    //contract
    public boolean checkContract(String contract) {
        if (contract == null || contract.isEmpty()) {
            return false;
        }
        return true;
    }

}
