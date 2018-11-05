package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.Main.daLiJeIspravnaPozicija;
import static java.lang.Math.abs;

public class King extends ChessPiece{

    public King(String poz, Color col) { super(poz, col); }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        if(!daLiJeIspravnaPozicija(position)) throw new IllegalArgumentException("Nepostojeca pozicija");
        else if(abs(pozicija.charAt(0) - position.charAt(0)) > 1 || abs(pozicija.charAt(1) - position.charAt(1)) > 1) throw new IllegalChessMoveException("Kralj se ne moze tu pomjeriti");
        pozicija = position;
    }
}
