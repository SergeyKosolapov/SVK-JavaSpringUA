package taskPack.controllers;

import taskPack.dao.RowDAO;
import taskPack.models.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/SVKDirect")
public class RowController {

    private final RowDAO rowDAO;

    @Autowired
    public RowController(RowDAO rowDAO) {
        this.rowDAO = rowDAO;
    }

        //ссылка для браузера
        //http://localhost:8080/SVKDirect/index

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("row", rowDAO.index());
        return "SVKDirect/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("row", rowDAO.show(id));
        return "SVKDirect/show";
    }

    @GetMapping("/new")
    public String newRow(@ModelAttribute("row") Row row) {
        return "SVKDirect/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("row") @Valid Row row,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "SVKDirect/new";

        rowDAO.save(row);
        return "redirect:/SVKDirect";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("row", rowDAO.show(id));
        return "SVKDirect/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("row") @Valid Row row, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "SVKDirect/edit";

        rowDAO.update(id, row);
        return "redirect:/SVKDirect";
    }


}