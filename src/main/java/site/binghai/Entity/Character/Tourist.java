package site.binghai.Entity.Character;

import site.binghai.Entity.Base.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IceSea on 2017/5/11.
 * GitHub: https://github.com/IceSeaOnly
 * 游客类
 */
@Entity
public class Tourist extends User {
    @Id //主键
    @GeneratedValue // 自增
    private int id;

    public Tourist(String name, String account, String pass, String phone) {
        super(name, account, pass, phone);
    }

    public Tourist() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
