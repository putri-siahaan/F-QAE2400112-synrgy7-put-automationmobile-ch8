package SwagLabs_Mobile;

import SwagLabs_Mobile.testing.ValidLoginTest;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class CucumberHooks{

    @BeforeAll
    public static void setUp(){
        ValidLoginTest.setUp();
    }

    @AfterAll
    public static void tearDown(){
        ValidLoginTest.tearDown();
    }
}
