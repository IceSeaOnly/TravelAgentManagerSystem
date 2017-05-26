package site.binghai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.binghai.Entity.Character.Guider;
import site.binghai.Entity.Character.Tourist;
import site.binghai.Entity.RelationShip.TouristLikeGuilder;

import java.util.List;

/**
 * Created by IceSea on 2017/5/22.
 * GitHub: https://github.com/IceSeaOnly
 */
public interface TGDao extends JpaRepository<TouristLikeGuilder,Integer> {

    void deleteByTouristAndGuider(Tourist t, Guider g);
    List<TouristLikeGuilder> findByTourist(Tourist tourist);
    List<TouristLikeGuilder> findByTouristAndGuider(Tourist t,Guider guider);
}
