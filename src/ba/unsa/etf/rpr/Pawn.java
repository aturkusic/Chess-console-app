package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.Main.daLiJeIspravnaPozicija;
import static java.lang.Math.abs;

public class Pawn extends ChessPiece{

    public Pawn(String poz, Color col) { super(poz, col); }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        String tmp = position.toUpperCase();
        if(!daLiJeIspravnaPozicija(position)) throw new IllegalArgumentException("Nepostojeca pozicija");
        else if(pozicija.charAt(1) == '2') {
            if(pozicija.charAt(0) != tmp.charAt(0))throw new IllegalChessMoveException("Pijun se ne moze tu pomjeriti");
            else if(!(position.charAt(1) - pozicija.charAt(1) == 2 || tmp.charAt(1) - pozicija.charAt(1) == 1)) throw new IllegalChessMoveException("Pijun se ne moze tu pomjeriti");
        } else {
            if(!(tmp.charAt(1) - pozicija.charAt(1) == 1) || pozicija.charAt(0) != tmp.charAt(0)) throw new IllegalChessMoveException("Pijun se ne moze tu pomjeriti");
        }
        pozicija = tmp;
    }
}
