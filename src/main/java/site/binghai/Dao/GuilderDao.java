package site.binghai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.binghai.Entity.Base.User;
import site.binghai.Entity.Character.Guider;

import java.util.List;

/**
 * Created by IceSea on 2017/5/22.
 * GitHub: https://github.com/IceSeaOnly
 */
public interface GuilderDao extends JpaRepository<Guider,Integer> {
    List<User> findByPhone(String p);
    List<Guider> findByPhoneAndPass(String phone,String pass);
}
