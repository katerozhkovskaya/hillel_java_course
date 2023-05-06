package lesson21;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class HeroDaoImpl implements HeroDao {
    private final DataSource dataSource;

    @Override
    public List<Hero> findAll() {
        var sql = "SELECT h.name, h.gender, h.eye_color, h.race, h.hair_color, h.height, h.skin_color, h.alignment, " +
                "h.weight, p.name AS publisher \n" +
                "FROM heroes h\n" +
                "JOIN publishers p ON h.publisher_id = p.id";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Hero> mapHeroes(ResultSet result) throws SQLException {
        var heroes = new ArrayList<Hero>();
        while (result.next()) {
            heroes.add(Hero.builder()
                    .name(result.getString("name"))
                    .gender(result.getString("gender"))
                    .eyeColor(result.getString("eye_color"))
                    .race(result.getString("race"))
                    .hairColor(result.getString("hair_color"))
                    .height(result.getInt("height"))
                    .publisher(result.getString("publisher"))
                    .skinColor(result.getString("skin_color"))
                    .alignment((result.getString("alignment")))
                    .weight(result.getInt("weight"))
                    .build());
        }
        return heroes;
    }

    @Override
    public List<Hero> findByName(String name) {
        var sql = String.format(
                "SELECT h.name, h.gender, h.eye_color, h.race, h.hair_color, h.height, " +
                        "h.skin_color, h.alignment, h.weight, p.name AS publisher \n" +
                        "FROM heroes h\n" +
                        "JOIN publishers p ON h.publisher_id = p.id\n" +
                        "WHERE h.name = '%s'", name);
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Hero> findById(int id) {
        var sql = String.format(
                "SELECT h.name, h.gender, h.eye_color, h.race, h.hair_color, h.height, " +
                        "h.skin_color, h.alignment, h.weight, p.name AS publisher \n" +
                        "FROM heroes h\n" +
                        "JOIN publishers p ON h.publisher_id = p.id\n" +
                        "WHERE h.id = '%s'", id);
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean delete(int id) {
        var sql = String.format("delete from heroes where id = %d", id);
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Hero hero) {
        var sql = String.format("INSERT INTO public.heroes\n" +
                        "(name, gender, eye_color, race, hair_color, height, skin_color, alignment, weight, publisher_id)\n" +
                        "VALUES('%s', '%s', '%s', '%s', '%s', %d, '%s', '%s', %d, \n" +
                        "(SELECT id FROM public.publishers WHERE name = '%s'))",
                hero.name, hero.gender, hero.eyeColor, hero.race, hero.hairColor, hero.height, hero.skinColor,
                hero.alignment, hero.weight, hero.publisher);
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Hero hero, int id) {
        var sql = String.format("UPDATE heroes\n" +
                "SET  weight=%d\n" +
                "WHERE id='%s'", hero.weight, id);
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
