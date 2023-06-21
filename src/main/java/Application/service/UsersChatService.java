package Application.service;

import Application.dao.UsersChatDAO;
import Application.model.UsersChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersChatService {
    @Autowired
    private UsersChatDAO usersChatDAO;

    public boolean saveService(UsersChat usersChat) {
        try {
            return usersChatDAO.save(usersChat);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateService(UsersChat usersChat) {
        try {
            return usersChatDAO.update(usersChat);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteService(UsersChat usersChat) {
        try {
            return usersChatDAO.delete(usersChat);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public UsersChat findId(long id) {
        try {
            return usersChatDAO.findId(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<UsersChat> findAll() {
        try {
            return usersChatDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean findChatIdService(String chatId){
        try {
            return usersChatDAO.findChatId(chatId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
