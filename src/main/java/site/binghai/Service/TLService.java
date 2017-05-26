package site.binghai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.binghai.Dao.TLDao;
import site.binghai.Entity.Business.Line;
import site.binghai.Entity.Character.Tourist;
import site.binghai.Entity.RelationShip.TouristLikeLine;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IceSea on 2017/5/24.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class TLService {
    @Autowired
    TLDao tlDao;

    public boolean likeExist(Line line, Tourist tourist) {
        return tlDao.findByTouristAndLine(tourist,line).size() > 0;
    }

    @Transactional
    public void deleteByTouristAndLine(Line line, Tourist tourist) {
        tlDao.deleteByTouristAndLine(tourist,line);
    }

    public void save(TouristLikeLine touristLikeLine) {
        tlDao.save(touristLikeLine);
    }

    public List<Line> getLinesILike(Tourist tourist) {
        List<TouristLikeLine> ls = tlDao.findByTourist(tourist);
        ArrayList<Line> lines = new ArrayList<>();
        ls.forEach(v->lines.add(v.getLine()));
        return lines;
    }
}
