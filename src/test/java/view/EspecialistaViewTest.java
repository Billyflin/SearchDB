package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspecialistaViewTest {

    @BeforeEach
    void setUp() {


    }
    @Test
    void uuw(){
        new LoginView().runEspecialista("QFO87YNX");
    }
}