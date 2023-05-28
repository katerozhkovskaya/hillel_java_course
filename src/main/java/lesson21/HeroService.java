package lesson21;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class HeroService {
    private final HeroDao dao;

    public List<HeroDto> findAll() {
        return dao.findAll().stream()
                .map(HeroDto::from)
                .toList();
    }

    public List<HeroDto> findByName(String name) {
        return dao.findByName(name).stream()
                .map(HeroDto::from)
                .toList();
    }

    public Boolean delete(int id) {
        return dao.delete(id);
    }

    public void create(Hero hero) {
        dao.create(hero);
    }

    public void update(Hero hero, int id) {
        dao.update(hero, id);
    }

    public HeroDto findById(int id) {
        return dao.findById(id).stream()
                .map(HeroDto::from)
                .findFirst()
                .orElse(null);
    }
}
