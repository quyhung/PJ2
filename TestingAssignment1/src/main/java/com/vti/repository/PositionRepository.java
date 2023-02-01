package com.vti.repository;


import com.vti.entity.Answer;
import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PositionRepository {
    private HibernateUtils hibernateUtils;

    public PositionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public void createPosition(Position position) {
        Session session = null;
        try {
            //get session
            session = hibernateUtils.openSession();
            session.beginTransaction();
            //create position
            session.save(position);
            session.getTransaction().commit();


        } finally {
            if (session != null) {
                session.close();
            }
        }


    }

    public List<Position> getAllPosition() {
        Session session = null;
        try {

            //get Session
            session = hibernateUtils.openSession();
            // get Position
            Query<Position> query = session.createQuery("FROM Position ");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updatePosition(Position position) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(position);
            session.getTransaction().commit();


        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deletePosition(short id) {
        Transaction transaction = null;
        Session session = null;
        try {

            // get session
            session = hibernateUtils.openSession();
            transaction = session.beginTransaction();

            // get Position
            Position position = (Position) session.load(Position.class, id);

            // delete
            session.delete(position);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Position getPositionById(short id) {
        Session session = null;
        try {
            // get session
            session = hibernateUtils.openSession();
            // get Position
            Position position = session.get(Position.class, id);
            return position;
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
