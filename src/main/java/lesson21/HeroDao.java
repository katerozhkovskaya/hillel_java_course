package lesson21;

import java.util.List;

public interface HeroDao {
    List<Hero> findAll();

    List<Hero> findByName(String name);
    List<Hero> findById(int id);

    void create(Hero hero);

    void update(Hero hero, int id);

    boolean delete(int id);
}
