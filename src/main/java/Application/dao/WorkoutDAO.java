package Application.dao;

import Application.model.Workout;
import Application.util.HibernateSessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class WorkoutDAO {
    private Session session = HibernateSessionUtil.getSession();

    public boolean save(Workout workout) {
        try {
            Transaction transaction = session.beginTransaction();
            session.save(workout);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Workout workout) {
        try {
            Transaction transaction = session.beginTransaction();
            session.update(workout);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Workout workout) {
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(workout);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Workout findId(long id) {
        try {
            return session.get(Workout.class, id); //Проверить какая загрузка
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Workout> findAll() {
        try {
            return session.createQuery("select w from Workout w", Workout.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Workout> findMuscleName(String muscleName) {
        try {
            Query queue = session.createQuery("select w from Workout w where w.muscleName = :muscleName");
            queue.setParameter("muscleName", muscleName);
            return queue.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
