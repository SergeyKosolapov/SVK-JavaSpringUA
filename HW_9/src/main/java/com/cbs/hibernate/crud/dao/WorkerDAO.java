package com.cbs.hibernate.crud.dao;

import com.cbs.hibernate.crud.models.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class WorkerDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public WorkerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Worker> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select w from Worker w", Worker.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Worker show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Worker.class, id);
    }

    @Transactional
    public void save(Worker worker) {
        Session session = sessionFactory.getCurrentSession();
        session.save(worker);
    }

    @Transactional
    public void update(int id, Worker updatedWorker) {
        Session session = sessionFactory.getCurrentSession();
        Worker workerToBeUpdated = session.get(Worker.class, id);

        workerToBeUpdated.setName(updatedWorker.getName());
        workerToBeUpdated.setAge(updatedWorker.getAge());
        workerToBeUpdated.setEducation(updatedWorker.getEducation());
        workerToBeUpdated.setPosition(updatedWorker.getPosition());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Worker.class, id));
    }

    @Transactional(readOnly = true)
    public List<Worker> older30() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select w from Worker w where w.age>30 and w.education <> 'Vyshee'", Worker.class)
                .getResultList();
    }


}
