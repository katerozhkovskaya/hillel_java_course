package lesson27.rest;

import lesson21.Hero;
import lesson21.HeroDto;
import lesson21.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestController {
    private final HeroService heroService;

    @GetMapping("/heroes")
    public List<HeroDto> getHeroes() {
        return heroService.findAll();
    }

    @GetMapping("/heroes/{id}")
    public HeroDto getHero(@PathVariable("id") int id) {
        return heroService.findById(id);
    }

    @PostMapping("/heroes")
    public ResponseEntity createHero(@RequestBody Hero request) {
        heroService.create(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/heroes/{id}")
    public ResponseEntity updateHero(@PathVariable("id") int id, @RequestBody Hero request) {
        heroService.update(request, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/heroes/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id) {
        if (heroService.delete(id))
            return ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();
    }
}
