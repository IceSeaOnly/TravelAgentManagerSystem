package site.binghai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.binghai.Dao.LineDao;
import site.binghai.Entity.Business.Line;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by IceSea on 2017/5/15.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class LineService {

    @Autowired
    LineDao lineDao;
    public Line getLineById(int id){
        return lineDao.findOne(id);
    }

    public Line addLine(Line line){
        return null;
    }


    public List<Line> getAll(){
        List<Line> ls = lineDao.findAll();
        for (int i = 0; i < ls.size(); i++) {
            if(ls.get(i).getPdescribe().length() > 60)
                ls.get(i).setPdescribe(ls.get(i).getPdescribe().substring(0,60)+"...");
        }
        return ls;
    }

    public List<Line> search(String content) {
        List<Line> ls = lineDao.findByNameContainingOrCityContainingOrPdescribeContaining(content,content,content);
        for (int i = 0; i < ls.size(); i++) {
            if(ls.get(i).getPdescribe().length() > 60)
                ls.get(i).setPdescribe(ls.get(i).getPdescribe().substring(0,60)+"...");
        }
        return ls;
    }

    public void save(Line line) {
        lineDao.save(line);
    }

    @Transactional
    public void delete(int lid) {
        lineDao.delete(lid);
    }
}
