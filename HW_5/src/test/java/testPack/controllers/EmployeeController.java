package testPack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import testPack.dao.WorkerDAO;
import testPack.models.Worker;

import javax.validation.Valid;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final WorkerDAO workerDAO;

    @Autowired
    public EmployeeController(WorkerDAO workerDAO) {
        this.workerDAO = workerDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("worker", workerDAO.index());
        return "employee/index";
    }

    @GetMapping("/older30")
    public String older30(Model model) {
        model.addAttribute("worker", workerDAO.older30());
        return "employee/older30";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("worker", workerDAO.show(id));
        return "employee/show";
    }

    @GetMapping("/new")
    public String newWorker(@ModelAttribute("worker") Worker worker) {
        return "employee/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("worker") @Valid Worker worker,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "employee/new";

        workerDAO.save(worker);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("worker", workerDAO.show(id));
        return "employee/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("worker") @Valid Worker worker, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "employee/edit";

        workerDAO.update(id, worker);
        return "redirect:/employee";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        workerDAO.delete(id);
        return "redirect:/employee";
    }
}
