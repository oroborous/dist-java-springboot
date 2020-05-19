package edu.wctc.tacocloud.controller;

import edu.wctc.tacocloud.entity.Ingredient;
import edu.wctc.tacocloud.entity.Order;
import edu.wctc.tacocloud.entity.Taco;
import edu.wctc.tacocloud.repository.IngredientRepository;
import edu.wctc.tacocloud.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j // Simple Logging Facade for Java
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
    private IngredientRepository ingredientRepo;

    private TacoRepository tacoRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository,
                                TacoRepository tacoRepository) {
        this.ingredientRepo = ingredientRepository;
        this.tacoRepo = tacoRepository;
    }

    private void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(ingredients::add);

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @ModelAttribute("order")
    public Order order() {
        return new Order();
    }

    @PostMapping
    public String processDesign(@Valid Taco taco,
                                Errors errors,
                                Model model,
                                @SessionAttribute Order order) {
        if (errors.hasErrors()) {
            addIngredientsToModel(model);

            return "design";
        }

        log.info("Processing taco: " + taco);

        Taco saved = tacoRepo.save(taco);
        order.addTaco(saved);

        return "redirect:/orders/current";
    }

    @GetMapping
    public String showDesignForm(Model model) {
        addIngredientsToModel(model);

        model.addAttribute("taco", new Taco());
        return "design";
    }

    @ModelAttribute("taco")
    public Taco taco() {
        return new Taco();
    }
}
