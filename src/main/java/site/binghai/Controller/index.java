package site.binghai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import site.binghai.Entity.Business.Line;
import site.binghai.Service.LineService;

import java.util.List;

/**
 * Created by IceSea on 2017/5/18.
 * GitHub: https://github.com/IceSeaOnly
 */
@Controller
public class index {

    @Autowired
    LineService lineService;

    @RequestMapping(value = {"/","index"})
    public String index(Model model){
        model.addAttribute("lines",lineService.getAll());
        return "index";
    }

    @RequestMapping("search")
    public String search(@RequestParam String content,Model model){
        List<Line> lines = lineService.search(content);
        model.addAttribute("lines",lines);
        return "searchResult";
    }
}
