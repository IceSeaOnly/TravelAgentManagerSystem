package site.binghai.Entity.Character;

import site.binghai.Entity.Base.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by IceSea on 2017/5/11.
 * GitHub: https://github.com/IceSeaOnly
 * 导游
 * @Param describe 导游描述信息
 */
@Entity
public class Guider extends User {
    @Id
    @GeneratedValue
    private int id;
    private String img;
    private String pdescribe;

    public Guider(String name, String account, String pass, String phone, String img, String pdescribe) {
        super(name, account, pass, phone);
        this.img = img;
        this.pdescribe = pdescribe;
    }

    public Guider() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPdescribe() {
        return pdescribe;
    }

    public void setPdescribe(String pdescribe) {
        this.pdescribe = pdescribe;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
