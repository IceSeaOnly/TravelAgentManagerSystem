package site.binghai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.binghai.Entity.Business.Line;
import site.binghai.Entity.Character.Tourist;
import site.binghai.Entity.RelationShip.TouristLikeLine;

import java.util.List;

/**
 * Created by IceSea on 2017/5/24.
 * GitHub: https://github.com/IceSeaOnly
 */
public interface TLDao extends JpaRepository<TouristLikeLine,Integer> {
    List<TouristLikeLine> findByTouristAndLine(Tourist t, Line l);
    int deleteByTouristAndLine(Tourist t, Line l);
    List<TouristLikeLine> findByTourist(Tourist t);
}
