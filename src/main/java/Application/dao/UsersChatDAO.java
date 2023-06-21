package Application.dao;

import Application.model.UsersChat;
import Application.util.HibernateSessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UsersChatDAO {
    private Session session = HibernateSessionUtil.getSession();

    public boolean save(UsersChat usersChat) {
        try {
            Transaction transaction = session.beginTransaction();
            session.save(usersChat);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(UsersChat usersChat) {
        try {
            Transaction transaction = session.beginTransaction();
            session.update(usersChat);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(UsersChat usersChat) {
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(usersChat);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public UsersChat findId(long id) {
        try {
            return session.get(UsersChat.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UsersChat> findAll() {
        try {
            return session.createQuery("select u from UsersChat u", UsersChat.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean findChatId(String chatId){
        try {
            Query query = session.createQuery("select u from UsersChat u where u.chatID = :chatId");
            query.setParameter("chatId", chatId);
            if (query.getSingleResult() == null){
                return true;
            }
            else {
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }
    }
}
