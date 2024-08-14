package com.cangngo.creanning_test.dao.impl;

import com.cangngo.creanning_test.dao.IContractDAO;
import com.cangngo.creanning_test.entity.Contract;
import com.cangngo.creanning_test.entity.Teacher;
import com.cangngo.creanning_test.utils.JpaUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ContractDAO implements IContractDAO {
    @Override
    public Contract findContractByName(String contractName) {
        Contract contract = null;
        try {
            EntityManager em = JpaUtils.getEntityManager();
            em.getTransaction().begin();
            TypedQuery<Contract> query = em.createQuery("select c from Contract c where c.contractName like :contractName", Contract.class);
            query.setParameter("contractName", contractName);
            contract = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return contract;
    }

    @Override
    public List<Contract> findAll() {
        try {
            EntityManager em = JpaUtils.getEntityManager();
            em.getTransaction().begin();
            List<Contract> contracts = em.createQuery("select c from Contract c").getResultList();
            em.getTransaction().commit();
            return contracts;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ContractDAO dao = new ContractDAO();
        try {
            Contract contract = dao.findContractByName("Part time");
            System.out.println(contract.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
