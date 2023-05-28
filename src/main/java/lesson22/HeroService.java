package lesson22;

import lesson21.HeroDao;

import java.util.List;

public class HeroService {
    private HeroDao heroDao;
    private HeroMovieService heroMovieService;

    public HeroService(HeroDao heroDao, HeroMovieService heroMovieService) {
        this.heroDao = heroDao;
        this.heroMovieService = heroMovieService;

    }

    public List<HeroDto> getHeroes() {
        return heroDao.findAll()
                .stream()
                .map(hero -> new HeroDto(hero.getName(), heroMovieService.getPlayedIn(hero.getName())))
                .toList();
    }
}
