package site.binghai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.binghai.Entity.Character.LineManager;
import site.binghai.Entity.RelationShip.GuiderToLine;
import site.binghai.Entity.RelationShip.TouristLikeLine;
import site.binghai.Service.*;
import site.binghai.Entity.Base.User;
import site.binghai.Entity.Business.Line;
import site.binghai.Entity.Character.Guider;
import site.binghai.Entity.Character.Tourist;
import site.binghai.Entity.RelationShip.TouristLikeGuilder;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IceSea on 2017/5/18.
 * GitHub: https://github.com/IceSeaOnly
 */
@Controller
@RequestMapping("user")
public class user {
    @Autowired
    TGService tgService;
    @Autowired
    GuiderService guiderService;
    @Autowired
    LineService lineService;
    @Autowired
    TLService tlService;
    @Autowired
    GLService glService;

    @RequestMapping("ucenter")
    public String ucenter(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user instanceof Tourist){
            return "redirect:touristCenter";
        }else if(user instanceof Guider)
            return "redirect:/guider/guiderCenter";
        else if(user instanceof LineManager)
            return "redirect:/lm/lmCenter";
        return "error";
    }

    @RequestMapping("touristCenter")
    public String touristCenter(Model model, HttpSession session){
        Tourist tourist = (Tourist) session.getAttribute("user");
        List<Guider> guiders = tgService.getGuidersILike(tourist);
        List<Line> lines = tlService.getLinesILike(tourist);
        model.addAttribute("guiders",guiders);
        model.addAttribute("lines",lines);
        return "touristCenter";
    }

    @RequestMapping("addGLike")
    public String addGLike(@RequestParam int gid,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user instanceof Tourist){
            Tourist tourist = (Tourist) user;
            Guider guider = guiderService.getById(gid);
            if(tgService.likeExist(guider,tourist))
                tgService.deleteByTouristIdAndGuiderId(tourist,guider);
            else
                tgService.save(new TouristLikeGuilder(tourist,guider));
        }
        return "redirect:/guiders";
    }

    @RequestMapping("addLineIlike")
    public String addLineIlike(@RequestParam int id,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user instanceof Tourist){
            Line line = lineService.getLineById(id);
            if(tlService.likeExist(line,(Tourist)user)){
                tlService.deleteByTouristAndLine(line,(Tourist)user);
            }else{
                tlService.save(new TouristLikeLine((Tourist)user,line));
            }
        }else if(user instanceof Guider){
            Line line = lineService.getLineById(id);
            if(glService.likeExist(line,(Guider)user)){
                glService.deleteByLineAndGuider((Guider)user,line);
            }else{
                glService.save(new GuiderToLine((Guider)user,line));
            }
        }
        return "redirect:/lines";
    }
}
