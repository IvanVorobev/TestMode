package ru.netology.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import ru.netology.data.Registration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataGenerator.*;

public class RegistrationTest {


    @Test
    void activeValidDataCustomer() {
        Registration customer = generateActiveCustomer();
        open("http://localhost:7777");
        $("[data-test-id=login] input").setValue(customer.getLogin());
        $("[data-test-id=password] input").setValue(customer.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Личный кабинет")).waitUntil(Condition.visible, 15000);
    }

    @Test
    void blockedValidDataCustomer() {
        Registration customer = generateBlockedCustomer();
        open("http://localhost:7777");
        $("[data-test-id=login] input").setValue(customer.getLogin());
        $("[data-test-id=password] input").setValue(customer.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Пользователь заблокирован")).waitUntil(Condition.visible, 15000);
    }

    @Test
    void invalidCustomerPassword() {
        Registration customer = generateInvalidCustomerPassword();
        open("http://localhost:7777");
        $("[data-test-id=login] input").setValue(customer.getLogin());
        $("[data-test-id=password] input").setValue(customer.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 15000);
    }

    @Test
    void invalidCustomerLogin() {
        Registration customer = generateInvalidCustomerLogin();
        open("http://localhost:7777");
        $("[data-test-id=login] input").setValue(customer.getLogin());
        $("[data-test-id=password] input").setValue(customer.getPassword());
        $(byText("Продолжить")).click();
        $(withText("Неверно указан логин или пароль")).waitUntil(Condition.visible, 15000);
    }
}
