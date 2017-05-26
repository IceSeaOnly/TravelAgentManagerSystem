package site.binghai.Entity.Base;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IceSea on ${DATE}.
 * GitHub: https://github.com/IceSeaOnly
 * 用户服务接口
 */

public interface IUserService {
    User loginValidate(String username,String password);
    User regUser(User entity);
    User findById(int id);
    boolean deleteUserById(int id);
    List<User> findByPhone(String phone);
}
