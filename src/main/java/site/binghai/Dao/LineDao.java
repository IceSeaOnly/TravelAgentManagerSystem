package site.binghai.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import site.binghai.Entity.Business.Line;

import java.util.List;

/**
 * Created by IceSea on 2017/5/18.
 * GitHub: https://github.com/IceSeaOnly
 */
public interface LineDao  extends JpaRepository<Line,Integer>{
    List<Line> findByCityContains(String s);
    List<Line> findByNameContains(String s);
    List<Line> findByNameContainingOrCityContainingOrPdescribeContaining(String a,String b,String c);
}
