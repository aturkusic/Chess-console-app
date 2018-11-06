package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.Main.daLiJeIspravnaPozicija;
import static java.lang.Math.abs;

public class Pawn extends ChessPiece{

    public Pawn(String poz, Color col) { super(poz, col); }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        if(!daLiJeIspravnaPozicija(position)) throw new IllegalArgumentException("Nepostojeca pozicija");
        else if(pozicija.charAt(1) == '2') {
            if(pozicija.charAt(0) != position.charAt(0) /*(abs(pozicija.charAt(0) - position.charAt(0)) != 32 ||
                    abs(pozicija.charAt(0) - position.charAt(0)) != 0)*/)throw new IllegalChessMoveException("Pijun se ne moze tu pomjeriti");
            else if(!(position.charAt(1) - pozicija.charAt(1) == 2 || position.charAt(1) - pozicija.charAt(1) == 1)) throw new IllegalChessMoveException("Pijun se ne moze tu pomjeriti");
        }
        pozicija = position;
    }
}
