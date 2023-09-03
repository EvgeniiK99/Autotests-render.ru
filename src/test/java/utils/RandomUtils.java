package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {

    public static Faker faker = new Faker();
    public static Faker ruFaker = new Faker(new Locale("ru-RU"));

    public static int getRandomBlogId() {
        return faker.options().option(
                24647, 24646, 24644, 24641, 24639, 24638, 24635, 24615
        );
    }

    public static String getRandomEnText() {
        return faker.address().streetAddress();
    }

    public static String getRandomRuText() {
        return ruFaker.address().streetAddress();
    }
}