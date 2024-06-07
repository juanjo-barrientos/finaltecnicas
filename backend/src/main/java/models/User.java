
package models;


public class User {
    
    private String idUser;
    private String userName;
    private String password;

    public User(String idUser, String username, String password) {
        this.idUser = idUser;
        this.userName = username;
        this.password = password;
    }

    public User() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
