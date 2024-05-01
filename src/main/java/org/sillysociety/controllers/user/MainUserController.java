package org.sillysociety.controllers.user;

import org.sillysociety.config.MyUserDetails;
import org.sillysociety.models.chemistry.Brigade;
import org.sillysociety.models.chemistry.Experiment;
import org.sillysociety.models.chemistry.ExperimentBrigade;
import org.sillysociety.models.swa.MyUser;
import org.sillysociety.service.ExperimentBrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/protected/profile/user")
@PreAuthorize("hasAuthority('user') || hasAuthority('admin')")
public class MainUserController {
    @Autowired
    private ExperimentBrigadeService experimentBrigadeService;

    @GetMapping("")
    public String user(Model model, Authentication authentication) {
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        model.addAttribute("username", username);
        return "userPages/userPage";
    }

    @GetMapping("/chemistry")
    public String getUsers(Model model) {
        model.addAttribute("exp_br", experimentBrigadeService.getAllExperimentBrigades());
        return "userPages/chemistryList";
    }

    @GetMapping("/chemistry/add")
    public String addPage(Model model) {
        model.addAttribute("exp_br", new ExperimentBrigade());
        return "userPages/editAddPage";
    }

    @PostMapping("/chemistry/add")
    public String addUser(@ModelAttribute Brigade brigade, @ModelAttribute Experiment experiment, Model model) {
        if (brigade.getMember_first().isEmpty() ||
                brigade.getMember_second().isEmpty() ||
                experiment.getExperiment_name().isEmpty() ||
                experiment.getExperiment_status().isEmpty()) {
            return "redirect:/protected/profile/user/chemistry/add?error";
        }

        experimentBrigadeService.addBrigade(brigade);
        experimentBrigadeService.addExperiment(experiment);
        ExperimentBrigade exp_br = new ExperimentBrigade();
        exp_br.setBrigade_id(brigade);
        exp_br.setExperiment_id(experiment);
        experimentBrigadeService.addExperimentBrigade(exp_br);

        model.addAttribute("exp_br", experimentBrigadeService.getAllExperimentBrigades());
        return "redirect:/protected/profile/user/chemistry";
    }

//    @PostMapping("/chemistry/add")
//    public String addUser(@ModelAttribute ExperimentBrigade experimentBrigade, Model model) {
//        if (experimentBrigade.getBrigade_id().getMember_first().isEmpty() ||
//                experimentBrigade.getBrigade_id().getMember_second().isEmpty() ||
//                experimentBrigade.getExperiment_id().getExperiment_name().isEmpty() ||
//                experimentBrigade.getExperiment_id().getExperiment_status().isEmpty()) {
//            return "redirect:/protected/profile/user/chemistry/add?error";
//        }
//
//        experimentBrigadeService.addBrigade(experimentBrigade.getBrigade_id());
//        experimentBrigadeService.addExperiment(experimentBrigade.getExperiment_id());
////        ExperimentBrigade exp_br = new ExperimentBrigade();
////        exp_br.setBrigade_id(brigade);
////        exp_br.setExperiment_id(experiment);
//        experimentBrigadeService.addExperimentBrigade(experimentBrigade);
//
//        model.addAttribute("exp_br", experimentBrigadeService.getAllExperimentBrigades());
//        return "redirect:/protected/profile/user/chemistry";
//    }

    @GetMapping("/chemistry/edit")
    public String editUser(@RequestParam Integer id, Model model) {
        model.addAttribute("exp_br", experimentBrigadeService.getById(id));
        return "userPages/editAddPage";
    }

    @PostMapping("/chemistry/edit")
    public String confirmEditUser(@ModelAttribute Brigade brigade,
                                  @ModelAttribute Experiment experiment,
                                  @RequestParam Integer experiment_brigade_id) {
        ExperimentBrigade tmpExBr = experimentBrigadeService.getById(experiment_brigade_id);
        Brigade tmpBrigade = tmpExBr.getBrigade_id();;
        Experiment tmpExperiment = tmpExBr.getExperiment_id();

        if (!brigade.getMember_first().isEmpty()) tmpBrigade.setMember_first(brigade.getMember_first());
        if (!brigade.getMember_second().isEmpty()) tmpBrigade.setMember_second(brigade.getMember_second());
        if (!experiment.getExperiment_name().isEmpty()) tmpExperiment.setExperiment_name(experiment.getExperiment_name());
        if (!experiment.getExperiment_status().isEmpty()) tmpExperiment.setExperiment_status(experiment.getExperiment_status());

        tmpExBr.setBrigade_id(tmpBrigade);
        tmpExBr.setExperiment_id(tmpExperiment);

        experimentBrigadeService.addBrigade(tmpBrigade);
        experimentBrigadeService.addExperiment(tmpExperiment);
        experimentBrigadeService.updateExperimentBrigade(tmpExBr);

        return "redirect:/protected/profile/user/chemistry";
    }
}
