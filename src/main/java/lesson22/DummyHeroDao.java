package lesson22;

import lesson21.Hero;
import lesson21.HeroDao;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DummyHeroDao implements HeroDao {

    private final List<Hero> db;

    @Override
    public List<Hero> findAll() {
        return db;
    }

    @Override
    public List<Hero> findByName(String name) {
        return db.stream()
                .filter(hero -> hero.getName().equals(name))
                .toList();
    }

    @Override
    public List<Hero> findById(int id) {
        return null;
    }

    @Override
    public void create(Hero hero) {
        db.add(hero);
    }

    @Override
    public void update(Hero hero, int id) {

    }

    @Override
    public void update(Hero hero) {
        db.set(hero.getId(), hero);
    }

    @Override
    public boolean delete(int id) {
        return db.remove(db.get(id));
    }
}
