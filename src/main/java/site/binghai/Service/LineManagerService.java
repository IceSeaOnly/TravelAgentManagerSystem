package site.binghai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.binghai.Dao.LineManagerDao;
import site.binghai.Entity.Base.IUserService;
import site.binghai.Entity.Base.User;
import site.binghai.Entity.Character.LineManager;

import java.util.List;

/**
 * Created by IceSea on 2017/5/15.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class LineManagerService implements IUserService {
    @Autowired
    LineManagerDao lineManagerDao;
    @Override
    public User loginValidate(String username, String password) {
        List<LineManager> ls = lineManagerDao.findByPhoneAndPass(username,password);
        if(ls != null && ls.size() > 0)
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

    @Override
    public List<User> findByPhone(String phone) {
        return lineManagerDao.findByPhone(phone);
    }
}
