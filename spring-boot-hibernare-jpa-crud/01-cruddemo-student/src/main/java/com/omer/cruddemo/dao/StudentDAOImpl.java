package com.omer.cruddemo.dao;

import com.omer.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository //This annotation translates JDBC exceptions
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;


    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // Use this annotation from spring framework
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {

        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:data", Student.class);
        query.setParameter("data", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public int updateAll() {
        return entityManager.createQuery("UPDATE Student SET lastName='Tester'").executeUpdate();
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        Student student = entityManager.find(Student.class, id);

        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }
}
