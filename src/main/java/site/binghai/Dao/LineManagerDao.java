package site.binghai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.binghai.Entity.Base.User;
import site.binghai.Entity.Character.LineManager;

import java.util.List;

/**
 * Created by IceSea on 2017/5/22.
 * GitHub: https://github.com/IceSeaOnly
 */
public interface LineManagerDao extends JpaRepository<LineManager,Integer> {
    List<User> findByPhone(String p);

    List<LineManager> findByPhoneAndPass(String phone,String pass);
}
