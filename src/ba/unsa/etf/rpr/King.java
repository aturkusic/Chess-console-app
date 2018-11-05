package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.Main.daLiJeIspravnaPozicija;

public class King extends ChessPiece{

    public ChessPiece(String poz, Color col) {
        if(daLiJeIspravnaPozicija(poz)) throw IllegalArgumentException("Losa pozicija");
        super.position
    }
    @Override
    public void move(String position) {

    }
}
