package com.cangngo.creanning_test.controller.web;

import com.cangngo.creanning_test.entity.Degree;
import com.cangngo.creanning_test.entity.Teacher;
import com.cangngo.creanning_test.service.IDegreeService;
import com.cangngo.creanning_test.service.ITeacherService;
import com.cangngo.creanning_test.service.impl.DegreeService;
import com.cangngo.creanning_test.service.impl.TeacherService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/listTeacher"})
public class ListTeacher extends HttpServlet {
    private ITeacherService teacherService;
    IDegreeService degreeService;

    public void init() {
        teacherService = new TeacherService();
        degreeService = new DegreeService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Teacher> listTeachers = new ArrayList<>();
        List<Degree> listDegree = degreeService.findAll();
        String action = request.getParameter("action");

        if (listDegree.size() > 0) {
            request.setAttribute("listDegree", listDegree);
            //tìm kiếm
            if (action != null && action.equals("findByDegree")) {
                String findByDegree = request.getParameter("degree");
                int findByDegreeInt = Integer.parseInt(findByDegree);
                listTeachers = teacherService.findByDegree(findByDegreeInt);
            } else if (action != null && action.equals("findByNameOrId")) {
                String findNameOrId = request.getParameter("findTeacher");
                listTeachers = teacherService.findByNameOrId(findNameOrId);
            } else {
                listTeachers = teacherService.findAllTeacher();
            }
            request.setAttribute("listTeachers", listTeachers);
            request.getRequestDispatcher("/views/web/ListTeacher.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        super.doPost(req, resp);
    }
}

