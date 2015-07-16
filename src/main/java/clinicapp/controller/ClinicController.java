package clinicapp.controller;

import clinicapp.entity.Clinic;
import clinicapp.service.ClinicService;
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
public class ClinicController {

    private ClinicService clinicService;

    @Autowired(required = true)
    @Qualifier(value = "clinicService")
    public void setClinicService(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @RequestMapping(value = "clinicService", method = RequestMethod.GET)
    public String create(@ModelAttribute("clinic")Clinic c){
        if (c.getId() == 0){
            this.clinicService.create(c);
        } else {
            this.clinicService.update(c);
        }
        return "redirect:/entities";
    }

    @RequestMapping(value = "/entity/{name}")
    public String getByName(@PathVariable("name")String name, Model model){
       model.addAttribute("entity", this.clinicService.getByName(name));
        return "entity";

    }

    @RequestMapping(value = "/entity/{id}")
    public String getById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("entity", this.clinicService.getById(id));
        return "entity";
    }

    @RequestMapping(value = "/entities", method = RequestMethod.GET)
    public String getAll(Model model){
        model.addAttribute("entity", new Clinic());
        model.addAttribute("getAll", this.clinicService.getAll());
        return "entity";

    }

    @RequestMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        model.addAttribute("entity", this.clinicService.getById(id));
        model.addAttribute("getAll", this.clinicService.getAll());
        return "entity";

    }

    @RequestMapping("/remove/{id}")
    public String delete(@PathVariable("id") Long id){
        this.clinicService.delete(id);
        return "redirect:/entities";

    }
}