package com.vti.repository;

import com.vti.entity.Answer;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.RollbackException;
import java.sql.SQLException;
import java.util.List;

public class AnswerRepository {
    private HibernateUtils hibernateUtils;

    public AnswerRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public void createAnswer(Answer answer) {
        Session session = null;
        try {
            //get session
            session = hibernateUtils.openSession();
            // create answer
            session.save(answer);
        } finally {
            if (session != null) {
                session.close();
            }

        }


    }

    public List<Answer> getAllAnswer() {
        Session session = null;
        try {

            //get Session
            session = hibernateUtils.openSession();
            // get Department
            Query<Answer> query = session.createQuery("FROM Answer ");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateAnswer(Answer answer) {
        Transaction transaction = null;
        Session session = null;
        try {

            // get session
            session = hibernateUtils.openSession();
            transaction = session.beginTransaction();

            // update
            session.update(answer);
            transaction.commit();

        } catch (Exception e){
            transaction.rollback();
        } finally{
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteAnswer(short id) {
        Session session = null;
        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get department
            Answer answer = (Answer) session.load(Answer.class, id);

            // delete
            session.delete(answer);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Answer getAnswerById(short id) {
        Session session = null;
        // get session
        session = hibernateUtils.openSession();
        // get Answer
        Answer answer = session.get(Answer.class, id);
        return answer;
    }
}
