package site.binghai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.binghai.Entity.Character.Guider;
import site.binghai.Service.GuiderService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IceSea on 2017/5/24.
 * GitHub: https://github.com/IceSeaOnly
 */
@Controller
@RequestMapping("guider")
public class guider {
    @Autowired
    GuiderService guiderService;

    @RequestMapping("guiderCenter")
    public String guiderCenter(HttpSession session, Model model){
        Guider guider = (Guider) session.getAttribute("user");
        List<Guider> others = guiderService.findAllButOne(guider);
        model.addAttribute("guiders",others);
        return "guiderCenter";
    }

    @RequestMapping("modifyGuider")
    public String modifyGuider(@RequestParam int gid,Model model){
        Guider guider = guiderService.findById(gid);
        model.addAttribute("guider",guider);
        return "modifyGuider";
    }

    @RequestMapping("guiderModify")
    public String guiderModify(int gid,String name,String desc,String account,String img,HttpSession session){
        Guider guider = guiderService.getById(gid);
        guider.setImg(img);
        guider.setName(name);
        guider.setPdescribe(desc);
        guider.setAccount(account);
        guiderService.update(guider);
        Guider me = (Guider)session.getAttribute("user");
        session.setAttribute("user",guiderService.findById(me.getId()));
        return "redirect:/guider/guiderCenter";
    }

    @RequestMapping("addGuider")
    public String addGuider(String name,String phone,String pass,String desc,String img){
        guiderService.regUser(new Guider(name,phone,pass,phone,img,desc));
        return "redirect:guiderCenter";
    }

    @RequestMapping("deleteGuider")
    public String deleteGuider(int gid){
        guiderService.deleteUserById(gid);
        return "redirect:guiderCenter";
    }
}
