package ru.netology.delivery.test;

import ru.netology.delivery.entities.RegistrationInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.delivery.utils.DataGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DeviveryTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldSuccessfulPlanAndReplanOneMeeting() {
        RegistrationInfo info = DataGenerator.Registration.generateUser("ru");
        var daysToAddForFirstMeeting = 4;
        var firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);

        $("[data-test-id=\"city\"] input").setValue(info.getCity());
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").setValue(" ");
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").sendKeys(firstMeetingDate);
        $("[data-test-id=\"name\"] input").setValue(info.getName());
        $("[data-test-id=\"phone\"] input").setValue(info.getPhone());
        $("[data-test-id=\"agreement\"] span").click();
        $$(".form-field .button").find(text("Запланировать")).click();
        $(".notification__content")
                .shouldHave(text("Встреча успешно запланирована на " + firstMeetingDate), Duration.ofMillis(13000))
                .shouldBe(visible);
    }

    @Test
    void shouldSuccessfulPlanAndReplanTwoMeeting() {
        RegistrationInfo info = DataGenerator.Registration.generateUser("ru");

        var daysToAddForFirstMeeting = 4;
        var firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
        var daysToAddForSecondMeeting = 7;
        var secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);
        var validUser = info.getName();
        var validPhone = info.getPhone();
        var validCity = info.getCity();

        $("[data-test-id=\"city\"] input").setValue(validCity);
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").setValue(" ");
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").sendKeys(firstMeetingDate);
        $("[data-test-id=\"name\"] input").setValue(validUser);
        $("[data-test-id=\"phone\"] input").setValue(validPhone);
        $("[data-test-id=\"agreement\"] span").click();
        $$(".form-field .button").find(text("Запланировать")).click();
        $(".notification__content")
                .shouldHave(text("Встреча успешно запланирована на " + firstMeetingDate), Duration.ofMillis(13000))
                .shouldBe(visible);

        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").setValue(" ");
        $("[data-test-id=\"date\"] input").doubleClick();
        $("[data-test-id=\"date\"] input").sendKeys(secondMeetingDate);

        $$(".form-field .button").find(text("Запланировать")).click();
        $("[data-test-id=\"replan-notification\"]")
                .shouldHave(text("Необходимо подтверждение"), Duration.ofMillis(13000))
                .shouldBe(visible);
        $$(".notification__content .button").find(text("Перепланировать")).click();
        $("[data-test-id=\"success-notification\"]")
                .shouldHave(text("Встреча успешно запланирована на " + secondMeetingDate), Duration.ofMillis(13000))
                .shouldBe(visible);
    }
}
