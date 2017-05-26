package site.binghai.Entity.RelationShip;

import site.binghai.Entity.Business.Line;
import site.binghai.Entity.Character.Tourist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by IceSea on 2017/5/24.
 * GitHub: https://github.com/IceSeaOnly
 */
@Entity
public class TouristLikeLine {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Tourist tourist;
    @OneToOne
    private Line line;

    public TouristLikeLine(Tourist tourist, Line line) {
        this.tourist = tourist;
        this.line = line;
    }

    public TouristLikeLine() {
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

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}
