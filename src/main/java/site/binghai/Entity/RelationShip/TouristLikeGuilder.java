package site.binghai.Entity.RelationShip;

import site.binghai.Entity.Character.Guider;
import site.binghai.Entity.Character.Tourist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by IceSea on 2017/5/11.
 * GitHub: https://github.com/IceSeaOnly
 * 关系类
 * 游客喜欢的导游
 * @Param touristId 游客id
 * @Param guiderId 导游id
 */
@Entity
public class TouristLikeGuilder {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Tourist tourist;
    @OneToOne
    private Guider guider;

    public TouristLikeGuilder(Tourist tourist, Guider guider) {
        this.tourist = tourist;
        this.guider = guider;
    }

    public TouristLikeGuilder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public Guider getGuider() {
        return guider;
    }

    public void setGuider(Guider guider) {
        this.guider = guider;
    }
}
