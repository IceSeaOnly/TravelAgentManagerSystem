package site.binghai.Entity.Base;

import javax.persistence.MappedSuperclass;

/**
 * Created by IceSea on 2017/5/11.
 * GitHub: https://github.com/IceSeaOnly
 * 用户类，所有人物角色的基类
 * @Param name 用户名，字符串，中英文均可，长度不大于10，非空;
 * @Param account 账户名，字符串，纯英文，长度不大于10，非空;
 * @Param pass 密码，字符串，纯英文，长度32位，非空;
 * @Param phone 手机号，字符串，纯数字，11位，可为空
 */
@MappedSuperclass
public class User {
    private String name;
    private String account;
    private String pass;
    private String phone;

    public User(String name, String account, String pass, String phone) {
        this.name = name;
        this.account = account;
        this.pass = pass;
        this.phone = phone;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
