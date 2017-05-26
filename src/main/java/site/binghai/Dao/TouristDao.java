package site.binghai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.binghai.Entity.Base.User;
import site.binghai.Entity.Character.Tourist;

import java.util.List;

/**
 * Created by IceSea on 2017/5/22.
 * GitHub: https://github.com/IceSeaOnly
 */
public interface TouristDao extends JpaRepository<Tourist,Integer> {

    List<User> findByPhone(String phone);
    List<Tourist> findByPhoneAndPass(String phone,String pass);
}
