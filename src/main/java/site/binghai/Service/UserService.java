package site.binghai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.binghai.Entity.Base.User;
import site.binghai.Entity.Character.Tourist;

/**
 * Created by IceSea on 2017/5/18.
 * GitHub: https://github.com/IceSeaOnly
 */
@Service
public class UserService {
    @Autowired
    TouristService touristService;
    @Autowired
    LineManagerService lineManagerService;
    @Autowired
    GuiderService guiderService;

    public User validate(String phone, String password) {
        User user = touristService.loginValidate(phone, password);
        if (user != null) return user;
        user = guiderService.loginValidate(phone, password);
        if (user != null) return user;
        user = lineManagerService.loginValidate(phone, password);
        return user;
    }

    /**
     * 判断用户是否存在，需要判断3类用户
     */
    public boolean userExist(String phone) {
        if (touristService.findByPhone(phone).size() > 0 ||
                lineManagerService.findByPhone(phone).size() > 0 ||
                guiderService.findByPhone(phone).size() > 0)
            return true;
        return false;
    }
}
