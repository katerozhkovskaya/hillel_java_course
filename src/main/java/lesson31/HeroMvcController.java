package lesson31;

import lesson21.HeroDaoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/heroes")
@RequiredArgsConstructor
public class HeroMvcController {
    private final HeroDaoImpl heroDaoImpl;

    @GetMapping()
    public String hero(Model model) {
        model.addAttribute("name", "Find all heroes");
        model.addAttribute("heroes", heroDaoImpl.findAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String hero(Model model, @PathVariable("id") int id) {
        try {
            var hero = heroDaoImpl.findById(id);
            model.addAttribute("name", "Find hero by id");
            model.addAttribute("heroes", hero);
            if (hero.isEmpty()){
                throw new HeroMvcNotFound("Hero not found");
            }
        } catch (RuntimeException e) {
            throw new HeroMvcNotFound("Hero not found");
        }
        return "index";
    }
}