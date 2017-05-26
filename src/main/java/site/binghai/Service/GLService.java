package site.binghai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import site.binghai.Dao.GLDao;
import site.binghai.Entity.Base.User;
import site.binghai.Entity.Business.Line;
import site.binghai.Entity.Character.Guider;
import site.binghai.Entity.RelationShip.GuiderToLine;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IceSea on 2017/5/26.
 * GitHub: https://github.com/IceSeaOnly
 */
@Controller
public class GLService {
    @Autowired
    GLDao glDao;

    public boolean likeExist(Line line, Guider user) {
        return findByGuiderAndLine(line,user).size()>0;
    }

    public List<GuiderToLine> findByGuiderAndLine(Line line, Guider user){
        return glDao.findByGuiderAndLine(user,line);
    }

    @Transactional
    public void deleteByLineAndGuider(Guider user,Line line) {
        glDao.deleteByGuiderAndLine(user,line);
    }

    @Transactional
    public void save(GuiderToLine guiderToLine) {
        glDao.save(guiderToLine);
    }

    public List<Guider> findByLine(Line line) {
        List<GuiderToLine> ls = glDao.findByLine(line);
        ArrayList<Guider> res = new ArrayList<>();
        ls.forEach(v->res.add(v.getGuider()));
        return res;
    }

    public List<Line> findByGuider(Guider guider){
        List<GuiderToLine> ls = glDao.findByGuider(guider);
        ArrayList<Line> res = new ArrayList<>();
        ls.forEach(v->res.add(v.getLine()));
        return res;
    }
}
