package com.vti.repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentRepository {
    private HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }
    @SuppressWarnings("unchecked")
    public void createDepartment(Department department) {
        Session session = null;
        try {
            //get session
            session = hibernateUtils.openSession();
            //create department
            session.save(department);


        } finally{
        if (session != null) {
            session.close();
        }
    }


}

    public List<Department> getAllDepartment() {
        Session session = null;
        try {

            //get Session
            session = hibernateUtils.openSession();
            // get Department
            Query<Department> query = session.createQuery("FROM Department ");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateDepartment(Department department) {
        Transaction transaction = null;
        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
           transaction = session.beginTransaction();
            // update
            session.update(department);

            transaction.commit();

        } catch (Exception e){
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteDepartment(short id) {
        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get department
            Department department = (Department) session.load(Department.class, id);

            // delete
            session.delete(department);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Department getDepartmentById(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get Department by id
            Department department = session.get(Department.class, id);
            return department;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
