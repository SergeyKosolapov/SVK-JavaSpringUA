package taskPack.controllers;

import taskPack.dao.WorkerDAO;
import taskPack.models.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerDAO workerDAO;

    @Autowired
    public WorkerController(WorkerDAO workerDAO) {
        this.workerDAO = workerDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("worker", workerDAO.index());
        return "worker/index";
    }

    @GetMapping("/older30")
    public String older30(Model model) {
        model.addAttribute("worker", workerDAO.older30());
        return "worker/older30";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("worker", workerDAO.show(id));
        return "worker/show";
    }

    @GetMapping("/new")
    public String newWorker(@ModelAttribute("worker") Worker worker) {
        return "worker/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("worker") @Valid Worker worker,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "worker/new";

        workerDAO.save(worker);
        return "redirect:/worker";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("worker", workerDAO.show(id));
        return "worker/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("worker") @Valid Worker worker, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "worker/edit";

        workerDAO.update(id, worker);
        return "redirect:/worker";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        workerDAO.delete(id);
        return "redirect:/worker";
    }
}
