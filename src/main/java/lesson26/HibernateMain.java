package lesson26;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class HibernateMain {

    private final static String HERO_NAME = "Kate Rozhkovska";

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HibernateSession.class);
        var sessionFactory = context.getBean(SessionFactory.class);

        try (var session = sessionFactory.openSession()) {
            var hero = session.find(HibernateHero.class, 45);
            System.out.println("Founded hero by ID: " + hero);

            var id = createHero(session);

            var persistentHero = session.find(HibernateHero.class, id);
            System.out.println("Created hero: " + persistentHero);

            System.out.println("All heroes with name " + HERO_NAME + ": ");

            getAllHeroesByName(session).forEach(System.out::println);

            deleteHeroById(session, id);

            System.out.println("All heroes with name " + HERO_NAME + ": ");

            getAllHeroesByName(session).forEach(System.out::println);
        }
    }

    private static Object createHero(Session session) {
        return session.save(HibernateHero.builder()
                .name(HERO_NAME)
                .gender("female")
                .eyeColor("blue")
                .race("God")
                .hairColor("dark")
                .height(160)
                .skinColor("white")
                .alignment("good")
                .publisherId(5)
                .weight(60)
                .build());
    }

    private static List<HibernateHero> getAllHeroesByName(Session session) {
        var heroes = session.createQuery("SELECT h FROM HibernateHero h", HibernateHero.class).getResultList();
        return heroes.stream().filter(h -> h.name.equals(HERO_NAME)).toList();
    }

    private static void deleteHeroById(Session session, Object id) {
        Transaction transaction = session.beginTransaction();
        session.createQuery("DELETE FROM HibernateHero h WHERE h.id = :heroId")
                .setParameter("heroId", id)
                .executeUpdate();
        transaction.commit();
    }
}
