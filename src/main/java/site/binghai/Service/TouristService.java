package site.binghai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.binghai.Dao.TouristDao;
import site.binghai.Entity.Base.IUserService;
import site.binghai.Entity.Base.User;
import site.binghai.Entity.Business.Line;
import site.binghai.Entity.Character.Guider;
import site.binghai.Entity.Character.Tourist;

import java.util.List;

/**
 * Created by IceSea on 2017/5/15.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class TouristService implements IUserService {
    @Autowired
    TouristDao touristDao;

    @Override
    public User loginValidate(String phone, String password) {
        List<Tourist> ls = touristDao.findByPhoneAndPass(phone,password);
        if(ls!=null && ls.size()>0)
            return ls.get(0);
        return null;
    }

    @Override
    public User regUser(User entity) {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public boolean deleteUserById(int id) {
        return false;
    }

    /**
     * 查看线路信息，直接获取线路实体
     * */
    public Line getLineById(int id){
        return null;
    }

    @Override
    public List<User> findByPhone(String phone){
        return touristDao.findByPhone(phone);
    }

    public void addUser(String username, String phone, String password) {
        Tourist tourist = new Tourist(username,phone,password,phone);
        touristDao.save(tourist);
    }
}
