package com.vti.repository;

import com.vti.entity.Exam;
import com.vti.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ExamRepository {
    private HibernateUtils hibernateUtils;

    public ExamRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public void createExam(Exam exam) {
        Session session = null;
        try {
            //get session
            session = hibernateUtils.openSession();
            //get Exam
            session.save(exam);
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public List<Exam> getAllExam() {
        Session session = null;
        try {
            //get session
            session = hibernateUtils.openSession();
            //get Exam
            Query<Exam> query = session.createQuery("FROM Exam ");
            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public void updateExam(Exam exam) {
        Transaction transaction= null;
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
             transaction = session.beginTransaction();
            //update
            session.update(exam);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }


    }

    public void deleteExam(short id) {
        Session session = null;
        // get session
        session = hibernateUtils.openSession();
        // get Exam
        session.beginTransaction();
        Exam exam = session.load(Exam.class, id);
        session.delete(exam);
        session.getTransaction().commit();
    }

    public Exam getExamById(short id) {
        Session session = null;
        // get session
        session = hibernateUtils.openSession();
        // get Exam
        Exam exam = session.get(Exam.class, id);
        return  exam;
    }


}


