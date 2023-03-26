package lesson16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CSVReader {
    public static List<Hero> loadListOfHeroes() {
        String csvFile = "heroes.csv";
        String[] nextLine;
        List<Hero> heroes = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(CSVReader.class.getResourceAsStream("/" + csvFile))))) {
            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                nextLine = line.split(";");
                Hero hero = new Hero();
                hero.setName(nextLine[1]);
                hero.setGender(nextLine[2]);
                hero.setEyeColor(nextLine[3]);
                hero.setRace(nextLine[4]);
                hero.setHairColor(nextLine[5]);
                hero.setHeight(Double.parseDouble(nextLine[6]));
                hero.setPublisher(nextLine[7]);
                hero.setSkinColor(nextLine[8]);
                hero.setAlignment(nextLine[9]);
                hero.setWeight(Integer.parseInt(nextLine[10]));
                heroes.add(hero);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return heroes;
    }
}
