package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.Main.daLiJeIspravnaPozicija;
import static java.lang.Math.abs;

public class Knight extends ChessPiece {

    public Knight(String poz, Color col) { super(poz, col); }

    @Override
    public void move(String position) throws IllegalChessMoveException {
        String tmp = position.toUpperCase();
        if(!daLiJeIspravnaPozicija(position)) throw new IllegalArgumentException("Nepostojeca pozicija");
        if((abs(pozicija.charAt(0) - tmp.charAt(0)) + abs(pozicija.charAt(1) - tmp.charAt(1))) != 3) throw new IllegalChessMoveException("Konj ne moye na tu poziciju");
        pozicija = tmp;
    }
}
