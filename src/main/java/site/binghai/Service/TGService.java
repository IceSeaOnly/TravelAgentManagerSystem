package site.binghai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.binghai.Dao.TGDao;
import site.binghai.Entity.Character.Guider;
import site.binghai.Entity.Character.Tourist;
import site.binghai.Entity.RelationShip.TouristLikeGuilder;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IceSea on 2017/5/23.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class TGService {
    @Autowired
    TGDao tgDao;

    @Transactional
    public void deleteByTouristIdAndGuiderId(Tourist uid,Guider gid) {
        tgDao.deleteByTouristAndGuider(uid,gid);
    }

    public void save(TouristLikeGuilder touristLikeGuilder) {
        tgDao.save(touristLikeGuilder);
    }

    public List<Guider> getGuidersILike(Tourist tourist) {
        ArrayList<Guider> arr = new ArrayList<>();
        tgDao.findByTourist(tourist).stream()
                .forEach(v->arr.add(v.getGuider()));
        return arr;
    }

    /**
     * 判断收藏关系是否存在
     * */
    public boolean likeExist(Guider guider, Tourist tourist) {
        return tgDao.findByTouristAndGuider(tourist,guider).size() > 0;
    }
}
