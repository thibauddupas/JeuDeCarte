package com.jeudecarte;

import com.jeudecarte.model.JeuDe32;
import com.jeudecarte.model.JeuDe54;
import com.jeudecarte.model.JeuDeTarot;
import com.jeudecarte.model.Pile;

public class ConstructeurDePile {
    public enum TypeDeJeu{JeuDe32, JeuDe54, JeuDeTarot};

    public static Pile construirePile(TypeDeJeu type){
        switch (type) {
            case JeuDe32: return new JeuDe32();
            case JeuDe54: return new JeuDe54();
            case JeuDeTarot: return new JeuDeTarot();
        }
        return new JeuDe54();
    }
}
