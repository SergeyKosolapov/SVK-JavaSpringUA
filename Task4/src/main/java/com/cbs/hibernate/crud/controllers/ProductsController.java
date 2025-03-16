package com.cbs.hibernate.crud.controllers;

import com.cbs.hibernate.crud.dao.ProductsDAO;
import com.cbs.hibernate.crud.models.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductsDAO productsDAO;

    @Autowired
    public ProductsController(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("products", productsDAO.index());
        return "products/index";
    }

    @GetMapping("/qualmax")
    public String qualMax(Model model) {
        model.addAttribute("products", productsDAO.qualMax());
        return "products/qualmax";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("products", productsDAO.show(id));
        return "products/show";
    }

    @GetMapping("/new")
    public String newProducts(@ModelAttribute("products") Products products) {
        return "products/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("products") @Valid Products products,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "products/new";

        productsDAO.save(products);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("products", productsDAO.show(id));
        return "products/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("products") @Valid Products products, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "products/edit";

        productsDAO.update(id, products);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        productsDAO.delete(id);
        return "redirect:/products";
    }
}
