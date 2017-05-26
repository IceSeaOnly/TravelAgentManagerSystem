package site.binghai.Entity.Character;

import site.binghai.Entity.Base.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by IceSea on 2017/5/11.
 * GitHub: https://github.com/IceSeaOnly
 * 线路管理员
 */
@Entity
public class LineManager extends User{
    @Id
    @GeneratedValue
    private int id;

    public LineManager(String name, String account, String pass, String phone) {
        super(name, account, pass, phone);
    }

    public LineManager() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
