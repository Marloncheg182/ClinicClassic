package clinicapp.controller;

import clinicapp.entity.Analysis;
import clinicapp.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Oleg Romanenchuk
 */
@Controller
public class AnalysisController {

    private AnalysisService analysisService;

    @Autowired(required = true)
    @Qualifier(value = "analysisService")
    public void setAnalysisService(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @RequestMapping(value = "entity/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("analysis") Analysis a){
      if (a.getId() ==0){
          this.analysisService.create(a);
      } else {
          this.analysisService.update(a);
      }
        return "redirect:/entities";
    }

    @RequestMapping(value = "/entity/{id}")
    public String getById(@PathVariable("id") Long id, Model model){
        model.addAttribute("entity", this.analysisService.getById(id));
        return "entity";


    }

    @RequestMapping(value = "/entity{date}")
    public String getByDate(@PathVariable("date")String date, Model model){
        model.addAttribute("entity", this.analysisService.getByDate(date));
        return "entity";

    }

    @RequestMapping(value = "/entities", method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("entity", new Analysis());
        model.addAttribute("getAll", this.analysisService.getAll());
        return "entity";

    }

    @RequestMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        model.addAttribute("entity", this.analysisService.getById(id));
        model.addAttribute("getAll", this.analysisService.getAll());
        return "entity";

    }

    @RequestMapping("/remove/{id}")
    public String delete(@PathVariable("id") Long id){
        this.analysisService.delete(id);
        return "redirect:/entities";

    }
}
