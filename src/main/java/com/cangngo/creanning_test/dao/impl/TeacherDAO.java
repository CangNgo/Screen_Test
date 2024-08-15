package com.cangngo.creanning_test.dao.impl;


import com.cangngo.creanning_test.dao.IContractDAO;
import com.cangngo.creanning_test.dao.IDegreeDAO;
import com.cangngo.creanning_test.dao.ITeacherDAO;
import com.cangngo.creanning_test.dto.teacherdto.TeacherCreationRequest;
import com.cangngo.creanning_test.dto.teacherdto.TeacherUpdateRequest;
import com.cangngo.creanning_test.entity.Contract;
import com.cangngo.creanning_test.entity.Degree;
import com.cangngo.creanning_test.entity.Teacher;
import com.cangngo.creanning_test.utils.JpaUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TeacherDAO implements ITeacherDAO {
    IDegreeDAO degreeDAO;
    IContractDAO contractDAO;
    public TeacherDAO() {
        degreeDAO = new DegreeDAO();
        contractDAO = new ContractDAO();
    }

    @Override
    public String createTeacher(TeacherCreationRequest request) {
        EntityManager em = JpaUtils.getEntityManager();
        Degree degree = em.find(Degree.class, request.getDegree());
        Contract contract = em.find(Contract.class, request.getContract());

        Teacher teacher = new Teacher();
        teacher.setCodeTeacher(request.getCodeTeacher());
        teacher.setLastName(request.getLastName());
        teacher.setFirstName(request.getFirstName());
        teacher.setImage(request.getImage());
        teacher.setSalary(request.getSalary());
        teacher.setFirstDayOfWork(request.getFirstDayOfWork());
        teacher.setDegreeId(degree);
        teacher.setContractId(contract);
        try {
            em.getTransaction().begin();
            em.persist(teacher);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return teacher.getCodeTeacher();
    }

    @Override
    public List<Teacher> findAllTeachers() {
        EntityManager em = JpaUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            List<Teacher> teachers = em.createQuery("select t from Teacher t").getResultList();
            em.getTransaction().commit();
            return teachers;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Teacher findTeacherById(Long id) {
        Teacher teacher = null;
        try {
            EntityManager em = JpaUtils.getEntityManager();
            em.getTransaction().begin();
            teacher = em.find(Teacher.class, id);
            em.getTransaction().commit();
            if (teacher != null) {
                return teacher;
            }
        } catch (Exception e) {
        }
        return teacher;
    }

    @Override
    public List<Teacher> findByNameOrId(String findNameOrId) {
        List<Teacher> teachers = null;
        EntityManager em = JpaUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Teacher> query = em.createQuery("select t from Teacher t where t.lastName like :findNameOrId or t.firstName like :findNameOrId or t.codeTeacher like :findNameOrId", Teacher.class);
            query.setParameter("findNameOrId", "%" + findNameOrId + "%");
            teachers = query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return teachers;
    }

    @Override
    public List<Teacher> findByDegree(int degree) {
        List<Teacher> teachers = null;
        if(degree !=0){
            try {
                EntityManager em = JpaUtils.getEntityManager();
                Degree dg = em.find(Degree.class, degree);
                em.getTransaction().begin();
                TypedQuery<Teacher> query = em.createQuery("select t from Teacher t where t.degreeId = :degree", Teacher.class);
                query.setParameter("degree", dg);
                teachers = query.getResultList();
                em.getTransaction().commit();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else {
            teachers = findAllTeachers();
        }

        return teachers;
    }

    @Override
    public String updateTeacher(Long id, TeacherUpdateRequest request) {
        EntityManager em = JpaUtils.getEntityManager();
        Degree degree = em.find(Degree.class, request.getDegree());
        Contract contract = em.find(Contract.class, request.getContract());
        Teacher teacher = em.find(Teacher.class, id);
        teacher.setLastName(request.getLastName());
        teacher.setFirstName(request.getFirstName());
        teacher.setImage(request.getImage());
        teacher.setSalary(request.getSalary());
        teacher.setFirstDayOfWork(request.getFirstDayOfWork());
        teacher.setDegreeId(degree);
        teacher.setContractId(contract);
        try {
            em.getTransaction().begin();
            em.merge(teacher);
            em.getTransaction().commit();
            return teacher.getCodeTeacher();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Teacher findTeacherByCodeName(String codeName) {
        try {
            EntityManager em = JpaUtils.getEntityManager();
            em.getTransaction().begin();
            TypedQuery<Teacher> query = em.createQuery("select t from Teacher t where t.codeTeacher = :codeName", Teacher.class);
            query.setParameter("codeName", codeName);
            List<Teacher> teachers = query.getResultList();
            if(!teachers.isEmpty()){
                return teachers.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public static void main(String[] args) {
        TeacherDAO dao = new TeacherDAO();
        Teacher teacher = new Teacher();
        teacher = dao.findTeacherByCodeName("lienntb");
        System.out.println(teacher.getCodeTeacher());
    }
}
