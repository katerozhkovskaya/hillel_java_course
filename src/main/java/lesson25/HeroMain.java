package lesson25;

import lesson21.HeroDao;
import lesson21.HeroDaoImpl;
import lesson22.HeroService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HeroMain {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HeroConfiguration.class);
        HeroService heroService = context.getBean(HeroService.class);
        HeroDao heroDao = context.getBean(HeroDaoImpl.class);

        System.out.println(heroDao.findByName("Batman"));
        System.out.println(heroDao.findById(69));
        System.out.println(heroService.getHeroes()
                .stream()
                .filter(heroDto -> heroDto.getName().equals("Batman"))
                .toList());

    }
}
