package com.cangngo.creanning_test.dao.impl;

import com.cangngo.creanning_test.dao.IDegreeDAO;
import com.cangngo.creanning_test.entity.Contract;
import com.cangngo.creanning_test.entity.Degree;
import com.cangngo.creanning_test.utils.JpaUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DegreeDAO implements IDegreeDAO {
    @Override
    public Degree findDegreeByName(String degreeName) {
        Degree degree = null;
        try {
            EntityManager em = JpaUtils.getEntityManager();
            em.getTransaction().begin();
            TypedQuery<Degree> query = em.createQuery("select d from Degree d where d.degreeName like :degreeName", Degree.class);
            query.setParameter("degreeName",  degreeName );
            degree = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return degree;
    }

    @Override
    public List<Degree> findAll() {
        try {
            EntityManager em = JpaUtils.getEntityManager();
            em.getTransaction().begin();
            List<Degree> degrees = em.createQuery("select d from Degree d").getResultList();
            em.getTransaction().commit();
            return degrees;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        DegreeDAO dao = new DegreeDAO();
        try {
            EntityManager em = JpaUtils.getEntityManager();
            em.getTransaction().begin();
            Degree degree = dao.findDegreeByName("Cử nhân cao đẳng");
            System.out.println(degree.getId());
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
