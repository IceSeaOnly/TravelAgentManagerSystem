package site.binghai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.binghai.Entity.Base.User;
import site.binghai.Entity.Character.Guider;
import site.binghai.Entity.Character.LineManager;
import site.binghai.Entity.Character.Tourist;
import site.binghai.Service.TouristService;
import site.binghai.Service.UserService;
import site.binghai.Utils.MD5;

import javax.servlet.http.HttpSession;

import static site.binghai.Utils.FormatValidate.noEmptyOrNull;

/**
 * Created by IceSea on 2017/5/18.
 * GitHub: https://github.com/IceSeaOnly
 */
@Controller
public class loginAndout {

    @Autowired
    UserService userService;
    @Autowired
    TouristService touristService;

    @RequestMapping("adminLogin")
    public String adminLogin(){
        return "redirect:/login";
    }

    @RequestMapping("login")
    public String login(HttpSession session){
        session.setAttribute("_validate", MD5.encryption(System.currentTimeMillis()+""));
        return "login";
    }
    @RequestMapping("reg")
    public String reg(HttpSession session){
        session.setAttribute("_validate", MD5.encryption(System.currentTimeMillis()+""));
        return "reg";
    }

    @RequestMapping("vreg")
    public String vreg(@RequestParam String _validate,
                       @RequestParam String username,
                       @RequestParam String phone,
                       @RequestParam String password,
                       @RequestParam String repassword,
                       HttpSession session
    ){
        String sV = (String) session.getAttribute("_validate");
        session.setAttribute("_validate",MD5.encryption(System.currentTimeMillis()+""));

        if(!noEmptyOrNull(sV,_validate,username,phone,password,repassword))
            return "redirect:/reg?errInfo=1";

        if(!password.equals(repassword))
            return "redirect:/reg?errInfo=2";

        if(phone.length() != 11)
            return "redirect:/reg?errInfo=3";

        if(userService.userExist(phone))
            return "redirect:/reg?errInfo=4";

        touristService.addUser(username,phone,password);

        return "redirect:/login?regSuccess";
    }
    @RequestMapping("vlogin")
    public String vlogin(@RequestParam String _validate,
                         @RequestParam String phone,
                         @RequestParam String password,
                         HttpSession session
    ){
        String sV = (String) session.getAttribute("_validate");
        session.setAttribute("_validate",MD5.encryption(System.currentTimeMillis()+""));

        if(!noEmptyOrNull(sV,_validate,password,phone))
            return "redirect:/login?errInfo=1";

        if(sV == null || !sV.equals(_validate))
            return "redirect:/login?errInfo=2";

        User user = userService.validate(phone,password);
        if(user == null)
            return "redirect:/login?errInfo=3";
        session.setAttribute("user",user);
        // 判断用户类型
        if(user instanceof Tourist){
            session.setAttribute("usertype","(游客)");
            return "redirect:/";
        }else if(user instanceof Guider){
            session.setAttribute("usertype","(导游)");
            return "redirect:/guider/guiderCenter";
        }else if(user instanceof LineManager){
            session.setAttribute("usertype","(管理)");
            return "redirect:/lm/lmCenter";
        }
        return "error";
    }
}
