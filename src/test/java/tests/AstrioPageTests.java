package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import helpers.DriverUtils;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.AstrioPage;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
@Owner("KirillKatkov")
@Feature("Задачи в репозитории")
@Story("Просмотр созданных задач в репозитории")
//@DisplayName("Мой любимый тест")
@Link(value = "Тестинг", url = "https://github.com")
public class AstrioPageTests extends TestBase{
    AstrioPage astrioPage = new AstrioPage();


//    @BeforeAll
//    static void setUp() {
//        Configuration.holdBrowserOpen = true;
//        Configuration.browserSize = "1920x1080";
//    }


//    @AfterEach
//    void close() {
//        Selenide.closeWebDriver();
//    }

//    @Test
//    void openPageTest() {
//        astrioPage.openPage();
//
//        astrioPage.checkCopyright();
//
//        astrioPage.checkResultMain("Вакансии")
//                .checkResultMain("О нас")
//                .checkResultMain("Клиенты")
//                .checkResultMain("Услуги")
//                .checkResultMain("Блог")
//                .checkResultMain("Контакты");
//
//        astrioPage.openNavLinkVacancies();
//
//        astrioPage.checkResultVacancies("О нас")
//                .checkResultVacancies("Что мы делаем")
//                .checkResultVacancies("Обучение в ASTRIO")
//                .checkResultVacancies("Ваша карьера")
//                .checkResultVacancies("Стажировка и практика")
//                .checkResultVacancies("Наши вакансии");
//
//
//        astrioPage.openScrollNavAboutUS()
//                .aboutUCheckTitle("Работа в одной из лучших IT компаний Ульяновска")
//                .aboutUCheckText("Высокий уровень проектов,");
//
//
//        //astrioPage.openMenuLinkAboutUs();
//        astrioPage.openMenuLinkDoing()
//                .DoingCheckTitle("Наши проекты")
//                .DoingUCheckText("Наша основная платформа - Magento");
//
//        astrioPage.openMenuLinkEducation()
//                .EducationCheckTitle("Отлаженный процесс обучения")
//                .EducationUCheckText("Наш процесс постоянно шлифуется последние 6 лет.");
//
//        astrioPage.openMenuLinkCareer();
//        astrioPage.setContactName("Ruslan")
//                .setContactEmail("1ya-ruslan@gmail.com")
//                .setContactPhone("790429445322");
//        //.careerButton()
//        //.careerCheckForm("Ваше сообщение получено и мы ответим на него в ближайшее время. Спасибо за сообщение.");
//
//        astrioPage
//                .setVacanciesEmail("1ya-ruslan@gmail.com")
//                .setVacanciesPhone("790429445322")
//                .setVacanciesComment("Ruslan");
////                .vacanciesButton()
////                .vacanciesCheckForm("Ваше сообщение получено и мы ответим на него в ближайшее время. Спасибо за сообщение.");
//
//
//        //$x("(//div[@role='tablist']/div)[2]").click();
//
//
//        //$$("//div[@class='careerBlock']//p)").shouldHave(itemWithText("Разработка ведется на современных платформах, с использованием самых современных инструментов разработки. В работе активно используются следующие технологии и инструменты: паттерны проектирования / MVC, PWA, phpStorm, Git, Gitlab CI, Newrelic, Elasticsearch, GraphQL, Docker."));
//
//    }

    @Test
    @Tag("astrio")
    @DisplayName("Проверка открытия страницы и поиск копирайта на главной странице")
    void checkCopyrightTest() {
        step("Открытие страницы - https://astrio.ru/", () -> {
            astrioPage.openPage();
        });
        step("Проверка копирайта - astrio", () -> {
            astrioPage.checkCopyright();
        });

    }

    @Test
    @Tag("astrio")
    @DisplayName("Проверка меню на главной страницы")
    void checkMainMenu() {
        step("Открытие страницы - https://astrio.ru/", () -> {
            astrioPage.openPage();
        });

        step("Проверка присутствия на странице пунктов меню - Вакансия, О нас, Клиенты, Услуги, Блог, Контакты", () -> {
            astrioPage.checkResultMain("Вакансии")
                    .checkResultMain("О нас")
                    .checkResultMain("Клиенты")
                    .checkResultMain("Услуги")
                    .checkResultMain("Блог")
                    .checkResultMain("Контакты");
        });
    }

    @Test
    @Tag("astrio")
    @DisplayName("Открытие страницы вакансий и проверка меню")
    void vacanciesOpenAndCheck() {
        step("Открытие страницы - https://astrio.ru/", () -> {
            astrioPage.openPage();
        });
        step("Открытие страницы Вакансий", () -> {
            astrioPage.openNavLinkVacancies();
        });

        step("Проверка присутствия на странице пунктов меню - О нас, Что мы делаем, Обучение в Astrio, Ваша курьера, Стажировка и практика, Наши вакансии", () -> {
            astrioPage.checkResultVacancies("О нас")
                    .checkResultVacancies("Что мы делаем")
                    .checkResultVacancies("Обучение в ASTRIO")
                    .checkResultVacancies("Ваша карьера")
                    .checkResultVacancies("Стажировка и практика")
                    .checkResultVacancies("Наши вакансии");
        });

    }

    @Test
    @Tag("astrio")
    @DisplayName("Переход к пунту меню - О нас и проверка контента")
    void aboutUSOpenAndCheck() {
        step("Открытие страницы - https://astrio.ru/", () -> {
            astrioPage.openPage();
        });
        step("Открытие страницы Вакансий", () -> {
            astrioPage.openNavLinkVacancies();
        });

        step("Переход к пункту меню о Нас", () -> {
            astrioPage.openScrollNavAboutUS();
        });

        step("Проверка текста заголовка", () -> {
            astrioPage.aboutUCheckTitle("Работа в одной из лучших IT компаний Ульяновска");
        });

        step("Проверка текста параграфа", () -> {
            astrioPage.aboutUCheckText("Высокий уровень проектов,");
        });
    }

    @Test
    @Tag("astrio")
    @DisplayName("Переход к пунту меню - Что мы делаем и проверка контакета")
    void linkDoingOpenAndCheck() {
        step("Открытие страницы - https://astrio.ru/", () -> {
            astrioPage.openPage();
        });
        step("Открытие страницы Вакансий", () -> {
            astrioPage.openNavLinkVacancies();
        });
        step("Переход к пункту меню - Что мы делаем", () -> {
            astrioPage.openMenuLinkDoing();
        });

        step("Проверка текста заголовка", () -> {
            astrioPage.DoingCheckTitle("Наши проекты");
        });

        step("Проверка текста параграфа", () -> {
            astrioPage.DoingUCheckText("Наша основная платформа - Magento");
        });
    }


    @Test
    @Tag("astrio")
    @DisplayName("Переход к пунту меню - Обучение и карьера и проверка контекста")
    void linkEducationOpenAndCheck() {
        step("Открытие страницы - https://astrio.ru/", () -> {
            astrioPage.openPage();
        });
        step("Открытие страницы Вакансий", () -> {
            astrioPage.openNavLinkVacancies();
        });
        step("Переход к пункту меню - Обучение и карьера", () -> {
            astrioPage.openMenuLinkEducation();
        });

        step("Проверка текста заголовка", () -> {
            astrioPage.EducationCheckTitle("Отлаженный процесс обучения");
        });

        step("Проверка текста параграфа", () -> {
            astrioPage.EducationUCheckText("Наш процесс постоянно шлифуется последние 6 лет.");
        });
    }

    @Test
    @Tag("astrio")
    @DisplayName("Заполнение формы для Старта в IT проверка отправки")
    void setAndCheckLinkCareer() {
        step("Открытие страницы - https://astrio.ru/", () -> {
            astrioPage.openPage();
        });
        step("Открытие страницы Вакансий", () -> {
            astrioPage.openNavLinkVacancies();
        });
        step("Переход к пункту меню - Ваша карьера", () -> {
            astrioPage.openMenuLinkCareer();
        });

        step("Заполнение имени в форме", () -> {
            astrioPage.setContactName("Ruslan");
        });
        step("Заполнение емайла  в форме", () -> {
            astrioPage.setContactEmail("1ya-ruslan@gmail.com");
        });
        step("Заполнение телефона  в форме", () -> {
            astrioPage.setContactPhone("790429445322");
        });

        step("Клик по кнопке - отправка формы", () -> {
            astrioPage.careerButton();
        });

        step("Проверка заполнения формы", () -> {
            astrioPage.careerCheckForm("Ваше сообщение получено и мы ответим на него в ближайшее время. Спасибо за сообщение.");
        });
    }


    @Test
    @Tag("astrio")
    @Description("Autogenerated test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://astrio.ru/'", () ->
                open("https://astrio.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
//    @Test
//    void setAndCheckLinkVacancies() {
//        astrioPage.openPage();
//        astrioPage.openNavLinkVacancies();
//        astrioPage.openMenuLinkVacancies();
//        astrioPage.setVacanciesEmail("1ya-ruslan@gmail.com");
//        astrioPage.setVacanciesPhone("790429445322");
//        astrioPage.setVacanciesComment("Ruslan");
//              astrioPage.vacanciesButton();
//               astrioPage.vacanciesCheckForm("Ваше сообщение получено и мы ответим на него в ближайшее время. Спасибо за сообщение.");
//    }




}
