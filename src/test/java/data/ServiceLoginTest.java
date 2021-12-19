package data;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import service.LoginService;

import static org.junit.jupiter.api.Assertions.*;

class ServiceLoginTest {
    LoginService service;

    @Test
    void insertarDato() {
        service= new LoginService();
        service.register("20331763-8","0208",2,"CG14O7MV");
    }
    @Test
    void buscarID() {
        service= new LoginService();
        assertEquals("CG14O7MV",service.sessionID("20331763-8","0208"));
    }
    @Test
    void accessLevel() {
        service= new LoginService();
        assertEquals(2,service.accessLevel("CG14O7MV"));
    }
    @Test
    void access() {
        service= new LoginService();
        assertTrue(service.access("20331763-8", "0208"));
    }
    @Test
    void access2() {
        service= new LoginService();
        assertFalse(service.access("2033176", "08"));
    }


    @Test
    void deleteData(){
        service= new LoginService();
        service.deleteUser("CG14O7MV");
    }
}