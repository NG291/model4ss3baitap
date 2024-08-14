package com.module4.controller;

import com.module4.model.Product;
import com.module4.service.IProductService;
import com.module4.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private static final IProductService productService = new ProductService();
    @GetMapping("")
    public String index(Model model) {
       List<Product> products = productService.getProducts();
        System.out.println(products.size());
       model.addAttribute("products", products);
       return "/index";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 10000));
        productService.createProduct(product);
        return "redirect:/products";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.FindByID(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update(Product product){
       productService.updateProduct(product.getId(), product);
        return "redirect:/products";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.FindByID(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
       productService.deleteProduct(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/products";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product",productService.FindByID(id));
        return "/view";
    }
}
