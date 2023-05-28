package lesson22;

import java.util.*;

public class HeroMovieService {
    public List<String> getPlayedIn(String heroName) {
        List<String> movies = new ArrayList<>();
        movies.add(heroName + "film 1");
        movies.add(heroName + "film 2");
        return movies;
    }
}
