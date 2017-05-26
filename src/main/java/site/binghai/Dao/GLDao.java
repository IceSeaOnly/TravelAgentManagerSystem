package site.binghai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.binghai.Entity.Business.Line;
import site.binghai.Entity.Character.Guider;
import site.binghai.Entity.RelationShip.GuiderToLine;

import java.util.List;

/**
 * Created by IceSea on 2017/5/26.
 * GitHub: https://github.com/IceSeaOnly
 */
public interface GLDao extends JpaRepository<GuiderToLine,Integer> {

    List<GuiderToLine> findByGuiderAndLine(Guider user,Line line);

    int deleteByGuiderAndLine(Guider user,Line line);

    List<GuiderToLine> findByLine(Line line);
    List<GuiderToLine> findByGuider(Guider guider);
}
