package site.binghai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.binghai.Dao.GuilderDao;
import site.binghai.Entity.Base.IUserService;
import site.binghai.Entity.Base.User;
import site.binghai.Entity.Character.Guider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IceSea on 2017/5/15.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class GuiderService implements IUserService {
    @Autowired
    GuilderDao guilderDao;

    @Override
    public User loginValidate(String username, String password) {
        List<Guider> ls = guilderDao.findByPhoneAndPass(username,password);
        if(ls != null && ls.size() > 0)
            return ls.get(0);
        return null;
    }

    @Override
    public User regUser(User entity) {
        return guilderDao.save((Guider) entity);
    }

    @Override
    public Guider findById(int id) {
        return guilderDao.findOne(id);
    }

    @Override
    public boolean deleteUserById(int id) {
        guilderDao.delete(id);
        return true;
    }

    @Override
    public List<User> findByPhone(String phone) {
        return guilderDao.findByPhone(phone);
    }

    /**
     * 查看导游信息，要求只含有基本信息，无敏感信息
     * 通过视图查看
     * */
    public Guider seeGuilderBaseInfoById(int id){
        return null;
    }

    public Guider modifyGuilder(Guider guider){
        return null;
    }

    public List<Guider> list() {
        return guilderDao.findAll();
    }

    public Guider getById(int gid) {
        return guilderDao.findOne(gid);
    }

    public List<Guider> findAllButOne(Guider guider) {
        List<Guider> ls = guilderDao.findAll();
        ArrayList<Guider> res = new ArrayList<>();
        for (int i = 0; i < ls.size(); i++) {
            if(ls.get(i).getId() != guider.getId())
                res.add(ls.get(i));
        }
        return res;
    }

    public void update(Guider guider) {
        guilderDao.flush();
    }
}
