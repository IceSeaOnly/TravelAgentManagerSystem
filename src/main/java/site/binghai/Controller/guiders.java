package site.binghai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.binghai.Entity.Character.Guider;
import site.binghai.Entity.Character.Tourist;
import site.binghai.Entity.RelationShip.TouristLikeGuilder;
import site.binghai.Service.GLService;
import site.binghai.Service.GuiderService;
import site.binghai.Service.TGService;

import javax.servlet.http.HttpSession;

/**
 * Created by IceSea on 2017/5/22.
 * GitHub: https://github.com/IceSeaOnly
 */
@Controller
public class guiders {
    @Autowired
    GuiderService guiderService;
    @Autowired
    TGService tgService;
    @Autowired
    GLService glService;

    @RequestMapping("guiders")
    public String guiders(Model map){
        map.addAttribute("guiders",guiderService.list());
        return "guiders";
    }

    @RequestMapping("seeGuider")
    public String seeGuider(@RequestParam int gid, Model model, HttpSession session){
        Object obj = session.getAttribute("user");
        Guider guider = guiderService.findById(gid);

        if(obj != null && obj instanceof Tourist){
            if(tgService.likeExist(guider, (Tourist) obj))
                model.addAttribute("like_stat",true);
            else model.addAttribute("like_stat",false);
        }else{
            model.addAttribute("like_stat",false);
        }
        model.addAttribute("lines",glService.findByGuider(guider));
        model.addAttribute("guider",guiderService.findById(gid));
        return "seeGuider";
    }
}
