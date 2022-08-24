package data;

import java.time.LocalDateTime;

public class Member {

    private int id;

    private String loginId;
    private String password;
    private String name;


    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    public Member(int id, String loginId, String password, String name){
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
