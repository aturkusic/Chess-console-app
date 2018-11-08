package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.Main.daLiJeIspravnaPozicija;
import static java.lang.Math.abs;

public class Queen extends ChessPiece {


    public Queen(String poz, Color col) { super(poz, col); }

    @Override
    public boolean move(String position) throws IllegalChessMoveException {
        String tmp = position.toUpperCase();
        String pozTmp = pozicija.toUpperCase();
        if(!daLiJeIspravnaPozicija(position)) throw new IllegalArgumentException("Nepostojeca pozicija");
        else if(!(abs(pozTmp.charAt(0) - tmp.charAt(0)) == 0 || abs(pozTmp.charAt(1) - tmp.charAt(1)) == 0) &&
                (abs(pozTmp.charAt(0) - tmp.charAt(0)) != abs(pozTmp.charAt(1) - tmp.charAt(1)))) throw new IllegalChessMoveException("Kraljica ne moze ovamo");
        pozicija = position;
        return true;
    }
}
