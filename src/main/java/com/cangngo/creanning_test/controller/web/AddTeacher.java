package com.cangngo.creanning_test.controller.web;

import com.cangngo.creanning_test.dto.teacherdto.TeacherCreationRequest;
import com.cangngo.creanning_test.dto.teacherdto.TeacherUpdateRequest;
import com.cangngo.creanning_test.entity.Contract;
import com.cangngo.creanning_test.entity.Degree;
import com.cangngo.creanning_test.entity.Teacher;
import com.cangngo.creanning_test.service.IContractService;
import com.cangngo.creanning_test.service.IDegreeService;
import com.cangngo.creanning_test.service.ITeacherService;
import com.cangngo.creanning_test.service.impl.ContractService;
import com.cangngo.creanning_test.service.impl.DegreeService;
import com.cangngo.creanning_test.service.impl.TeacherService;
import com.cangngo.creanning_test.utils.FormUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@WebServlet({"/addTeacher"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10)
public class AddTeacher extends HttpServlet {
    ITeacherService teacherService;
    IDegreeService degreeService;
    IContractService contractService;
    @Override
    public void init() throws ServletException {
        super.init();
        teacherService = new TeacherService();
        degreeService = new DegreeService();
        contractService = new ContractService();
    }

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        List<Degree> listDegree = degreeService.findAll();
        List<Contract> listContract = contractService.findAll();
        request.setAttribute("listDegree", listDegree);
        request.setAttribute("listContract", listContract);
        if (action != null && action.equals("update")) {
            Teacher teacher = teacherService.findTeacherById(Long.parseLong(id));

            if (teacher != null) {
                request.setAttribute("teacher", teacher);
            } else {
                request.setAttribute("message", "Không tìm thấy giảng viên");
                request.setAttribute("alert", "warning");
            }
        }
        request.getRequestDispatcher("/views/web/Addteacher.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("add")) {
            //lấy hình ảnh
            File dir = new File(getServletContext().getRealPath("/template/web/img"));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Part part = request.getPart("choiceImage");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            if (part != null && part.getSize() > 0) {
                File file = new File(dir, fileName);
                part.write(file.getAbsolutePath());

            }
            TeacherCreationRequest teacher = FormUtil.toModel(TeacherCreationRequest.class, request);

            if (teacher != null) {
                teacher.setImage(fileName);
                String messageResult = teacherService.createTeacher(teacher);
                if(messageResult.equals(teacher.getCodeTeacher())) {
                    request.getSession().setAttribute("message", "Thêm mới giảng viên thành công");
                    request.getSession().setAttribute("alert", "primary");
                }else{
                    request.getSession().setAttribute("message", messageResult);
                    request.getSession().setAttribute("alert", "danger");
                }
            }
        } else if (action != null && action.equals("update")) {
            //lấy codeTeach
            String id = request.getParameter("id");
            TeacherUpdateRequest teacher = FormUtil.toModel(TeacherUpdateRequest.class, request);
            if (teacher != null) {
                //lấy tên hình ảnh và lưu
                File dir = new File(getServletContext().getRealPath("/template/web/img"));
                Part part = request.getPart("choiceImage");
                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                if (part != null && part.getSize() > 0) {
                    File file = new File(dir, fileName);
                    part.write(file.getAbsolutePath());

                }
                //set tên hình ảnh cho object
                teacher.setImage(fileName);
                String updateMessage = teacherService.updateTeacher(Long.parseLong(id), teacher);
                if (updateMessage != null) {
                    request.getSession().setAttribute("message", "Cập nhật thông tin " + id  + " thành công");
                    request.getSession().setAttribute("alert", "success");
                }
            }
        }
        response.sendRedirect(request.getContextPath() + "/addTeacher");

    }
}
