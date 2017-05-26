package site.binghai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.binghai.Entity.Business.Line;
import site.binghai.Entity.Character.Guider;
import site.binghai.Entity.Character.Tourist;
import site.binghai.Service.GLService;
import site.binghai.Service.LineService;
import site.binghai.Service.TLService;

import javax.servlet.http.HttpSession;

/**
 * Created by IceSea on 2017/5/24.
 * GitHub: https://github.com/IceSeaOnly
 */
@Controller
public class lines {

    @Autowired
    LineService lineService;
    @Autowired
    TLService tlService;
    @Autowired
    GLService glService;

    @RequestMapping("/lines")
    public String index(Model model){
        model.addAttribute("lines",lineService.getAll());
        return "lines";
    }

    @RequestMapping("seeLine")
    public String seeLine(@RequestParam int lid, Model model, HttpSession session){
        Object obj = session.getAttribute("user");
        if(obj != null && obj instanceof Tourist){
            Tourist t = (Tourist) obj;
            Line line = lineService.getLineById(lid);
            if(tlService.likeExist(line,t)){
                model.addAttribute("select_stat",true);
            }else
                model.addAttribute("select_stat",false);
        }else if(obj != null && obj instanceof Guider){
            Line line = lineService.getLineById(lid);
            if(glService.likeExist(line,(Guider)obj)){
                model.addAttribute("guiders",glService.findByLine(line));
                model.addAttribute("select_stat",true);
            }else
                model.addAttribute("select_stat",false);
        }else
            model.addAttribute("select_stat",false);
        model.addAttribute("line",lineService.getLineById(lid));
        return "seeLine";
    }
}
