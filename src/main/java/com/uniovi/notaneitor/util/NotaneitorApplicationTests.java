package com.uniovi.notaneitor.util;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NotaneitorApplicationTests {
    static String PathFirefox = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";

    static String Geckodriver = "C:\\Users\\34658\\Documents\\Clase\\SDI\\geckodriver-v0.30.0-win64.exe";



    static WebDriver driver = getDriver(PathFirefox, Geckodriver);
    static String URL = "http://localhost:8090";

    public static WebDriver getDriver(String PathFirefox, String Geckodriver) {
        System.setProperty("webdriver.firefox.bin", PathFirefox);
        System.setProperty("webdriver.gecko.driver", Geckodriver);
        driver = new FirefoxDriver();
        return driver;
    }

    @BeforeEach
    public void setUp(){
        driver.navigate().to(URL);
    }
    //Después de cada prueba se borran las cookies del navegador
    @AfterEach
    public void tearDown(){
        driver.manage().deleteAllCookies();
    }
    //Antes de la primera prueba
    @BeforeAll
    static public void begin() {}
    //Al finalizar la última prueba
    @AfterAll
    static public void end() {
        //Cerramos el navegador al finalizar las pruebas
        driver.quit();
    }

    @Test
    @Order(1)
    void PRO1(){}

    @Test
    @Order(2)
    void PRO2(){}

    @Test
    @Order(3)
    void PRO3(){}

    @Test
    @Order(4)
    void PRO4(){}

    @Test
    @Order(5)
    void PRO5(){}

    @Test
    @Order(6)
    void PRO6(){}

    @Test
    @Order(7)
    void PRO7(){}

    @Test
    @Order(8)
    void PRO8(){}

    @Test
    @Order(9)
    void PRO9(){}

    @Test
    @Order(10)
    void PRO10(){}


}
