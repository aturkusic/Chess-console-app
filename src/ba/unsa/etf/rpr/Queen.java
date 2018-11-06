package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.Main.daLiJeIspravnaPozicija;
import static java.lang.Math.abs;

public class Queen extends ChessPiece {


    public Queen(String poz, Color col) { super(poz, col); }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        if(!daLiJeIspravnaPozicija(position)) throw new IllegalArgumentException("Nepostojeca pozicija");
        else if(!(abs(pozicija.charAt(0) - position.charAt(0)) == 0|| abs(pozicija.charAt(1) - position.charAt(1)) == 0) &&
                (abs(pozicija.charAt(0) - position.charAt(0)) != abs(pozicija.charAt(1) - position.charAt(1)))) throw new IllegalChessMoveException("Kraljica ne moze ovamo");
        pozicija = position;
    }
}
