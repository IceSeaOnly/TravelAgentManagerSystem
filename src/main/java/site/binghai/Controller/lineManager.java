package site.binghai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import site.binghai.Entity.Business.Line;
import site.binghai.Service.LineService;

/**
 * Created by IceSea on 2017/5/25.
 * GitHub: https://github.com/IceSeaOnly
 */
@RequestMapping("lm")
@Controller
public class lineManager {

    @Autowired
    LineService lineService;

    @RequestMapping("lmCenter")
    public String lmCenter(Model model){
        model.addAttribute("lines",lineService.getAll());
        return "lmCenter";
    }

    @RequestMapping("addLine")
    public String addLine(String city,String name,double price,String desc,String img,String sugg){
        lineService.save(new Line(city,name,desc,img,price,sugg));
        return "redirect:lmCenter";
    }

    @RequestMapping("delete")
    public String delete(int lid){
        lineService.delete(lid);
        return "redirect:lmCenter";
    }
}
