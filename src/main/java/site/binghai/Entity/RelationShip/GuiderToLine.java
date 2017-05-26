package site.binghai.Entity.RelationShip;

import site.binghai.Entity.Business.Line;
import site.binghai.Entity.Character.Guider;

import javax.persistence.*;

/**
 * Created by IceSea on 2017/5/11.
 * GitHub: https://github.com/IceSeaOnly
 * 关系类
 * 线路的推荐导游
 * @Param guiderId 外键，导游id
 * @Param lineId 外键，线路id
 */
@Entity
public class GuiderToLine {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Guider guider;
    @OneToOne
    private Line line;

    public GuiderToLine(Guider guider, Line line) {
        this.guider = guider;
        this.line = line;
    }

    public GuiderToLine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Guider getGuider() {
        return guider;
    }

    public void setGuider(Guider guider) {
        this.guider = guider;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}
