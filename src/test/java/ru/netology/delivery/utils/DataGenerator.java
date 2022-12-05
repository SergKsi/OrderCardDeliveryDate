package ru.netology.delivery.utils;

import com.github.javafaker.Faker;
import ru.netology.delivery.entities.RegistrationInfo;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

@UtilityClass
public class DataGenerator {

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        String[] adminCityRF = {"Абакан", "Анадырь", "Архангельск", "Астрахань", "Барнаул", "Белгород", "Биробиджан", "Благовещенск", "Брянск", "Великий Новгород", "Владивосток", "Владикавказ", "Владимир", "Волгоград", "Вологда", "Воронеж", "Грозный", "Екатеринбург", "Иваново", "Ижевск", "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово", "Киров", "Кострома", "Красногорск", "Краснодар", "Красноярск", "Курган", "Курск", "Кызыл", "Липецк", "Магадан", "Магас", "Майкоп", "Махачкала", "Москва", "Нальчик", "Нарьян-Мар", "Нижний Новгород", "Новосибирск", "Омск", "Орёл", "Оренбург", "Пенза", "Пермь", "Петрозаводск", "Петропавловск-Камчатский", "Псков", "Ростов-на-Дону", "Рязань", "Салехард", "Самара", "Санкт-Петербург", "Саранск", "Саратов", "Севастополь", "Симферополь", "Смоленск", "Ставрополь", "Сыктывкар", "Тамбов", "Тверь", "Томск", "Тула", "Тюмень", "Улан-Удэ", "Ульяновск", "Уфа", "Хабаровск", "Ханты-Мансийск", "Чебоксары", "Челябинск", "Чита", "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль", "Гатчина", "Горно-Алтайск", "Мурманск", "Черкесск"};
        Random generator = new Random();
        return adminCityRF[generator.nextInt(adminCityRF.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        String phoneForm = faker.phoneNumber().phoneNumber().replaceAll("[()-]", "");
        phoneForm = phoneForm.substring(0, 2) + " " +
                phoneForm.substring(2, 5) + " " +
                phoneForm.substring(5, 8) + " " +
                phoneForm.substring(8, 10) + " " +
                phoneForm.substring(10, 12);
        return phoneForm;
    }

    @UtilityClass
    public static class Registration {
        public static RegistrationInfo generateUser(String locale) {
            return new RegistrationInfo(generateCity("ru"), generateName("ru"), generatePhone("ru"));
        }
    }

}