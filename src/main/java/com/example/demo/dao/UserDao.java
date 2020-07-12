package com.example.demo.dao;

import com.example.demo.bean.UserBean;
import com.example.demo.entities.ParkingSpotsEntity;
import com.example.demo.entities.UserEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class UserDao implements UserDaoInterface {
    public static final Logger logger = LoggerFactory.getLogger(UserDao.class);




    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    @Override
    public String registerUser(UserEntity user) {

        String result = "false";
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Serializable id = session.save(user);


            if (id != null) {
                logger.info("not null saved id=" + id);
                result = "true";
            }


            session.getTransaction().commit();
        } catch (Exception exception) {
            //need to implement logic for duplicate registration
            System.out.println(exception);
            result = exception.getMessage();
        }

        HibernateUtil.closeSessionFactory();

        return result;

    }
    @Override
    public List<UserEntity> getUserEmails() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        List<UserEntity> resultList = null;
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            Query query = em.createQuery("Select email from  UserEntity e  ");
            //query.setParameter("IDone", ID1);
            resultList = query.getResultList();

            em.close();
        } finally {
            entityManagerFactory.close();
            return resultList;
        }


        //return resultList;
    }

@Override
    public UserBean loginUser(UserEntity loginDetails) {

        UserBean user = new UserBean();
        String email = loginDetails.getEmail();
        String password = loginDetails.getPassword();
        List<UserEntity> resultList = getUserEmails();
//        for (UserEntity emailInstance : resultList) {
//            if (emailInstance.toString().equalsIgnoreCase(email)) {
//                user.setRegistered(true);
//
//            }
//        }
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        UserEntity userRow = null;
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            Query query = em.createQuery("Select e from  UserEntity e where email=?1 and password=?2 ");
            query.setParameter("1", loginDetails.getEmail());
            query.setParameter("2", loginDetails.getPassword());
            userRow = (UserEntity) query;
            if (userRow.getPassword().equals(password)) {
                user.setLoginValid(true);
            } else
                user.setLoginValid(false);

            em.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            user.setException(ex);
        } finally {
            entityManagerFactory.close();
            return user;
        }

    }
    @Override
    public UserEntity getApprovedAdmin(ParkingSpotsEntity parkingSpotsEntity) {


        UserEntity userRow = null;

        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            Query query = em.createQuery("Select e from  UserEntity e where userId=?1  ");
            query.setParameter("1", parkingSpotsEntity.getParking_user_id());

            userRow = (UserEntity) query;

            em.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            entityManagerFactory.close();
            return userRow;
        }

    }










@Override
    public UserBean insertCoordinates(ParkingSpotsEntity parkingSpotsEntity)
    {
        UserBean user = new UserBean();
        BigDecimal Lat = parkingSpotsEntity.getLatitude();



        UserEntity userRow = null;
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
//
            em.getTransaction().begin();
            em.persist(parkingSpotsEntity);
            em.getTransaction().commit();
            em.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            user.setException(ex);
        } finally {
            entityManagerFactory.close();
            return user;
        }

    }


}