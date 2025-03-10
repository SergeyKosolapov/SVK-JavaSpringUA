package com.cbs.springcourse.rest.controllers;

import com.cbs.springcourse.rest.models.ValCursy;
import com.cbs.springcourse.rest.services.VcursyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // @Controller + @ResponseBody над кожним методом
@RequestMapping("/vcursy")
public class VcursyController {

    private final VcursyService vcursyService;

    @Autowired
    public VcursyController(VcursyService vcursyService) {
        this.vcursyService = vcursyService;
    }

    @GetMapping()
    public List<ValCursy> getAllVcursy() {
        return vcursyService.findAll(); // Jackson конвертує ці об'єкти у JSON
    }

    @GetMapping("/{id}")
    public ValCursy getVcursy(@PathVariable("id") int id) {
        return vcursyService.findOne(id); // Jackson конвертує у JSON
    }
}
