package Application.model;

import javax.persistence.*;

@Entity
@Table(name = "t_userChat")
public class UsersChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "chatID", unique = true)
    private String chatID;

    @Column(name = "nameUser")
    private String nameUser;

    public UsersChat() {

    }

    public UsersChat(String chatID, String nameUser) {
        this.chatID = chatID;
        this.nameUser = nameUser;
    }

    public long getId() {
        return id;
    }

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

}
