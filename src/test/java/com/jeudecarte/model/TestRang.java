package com.jeudecarte.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestRang {

    @Test
    void asPlusFortQueRoi(){
        Rang as = Rang.As;
        Rang roi = Rang.Roi;
        assertTrue(as.getIndex() > roi.getIndex(), "L'as devrait être plus fort que le roi");
        //fail("L'as devrait être plus fort que le roi");
    }

    @Test
    void huitPlusFortQueSept(){
        Rang huit = Rang.Huit;
        Rang sept = Rang.Sept;
        assertTrue(huit.getIndex() > sept.getIndex(), "Le huit devrait être plus fort que le sept");
    }
}
