package cn.ylj.entity;

/**
 * @author : yanglujian
 * create at:  2021/1/21  3:54 下午
 */
public class UserEntity {

    private String username;

    private String password;

    public UserEntity(){

    }

    public UserEntity(String username,String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}