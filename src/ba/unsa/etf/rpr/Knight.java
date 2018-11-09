package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.Main.daLiJeIspravnaPozicija;
import static java.lang.Math.abs;

public class Knight extends ChessPiece {

    public Knight(String poz, Color col) { super(poz, col); }

    @Override
    public boolean move(String position) throws IllegalChessMoveException {
        String tmp = position.toUpperCase();
        String pozTmp = pozicija.toUpperCase();
        if(!daLiJeIspravnaPozicija(position)) throw new IllegalArgumentException("Nepostojeca pozicija");
        if((abs(pozTmp.charAt(0) - tmp.charAt(0)) + abs(pozTmp.charAt(1) - tmp.charAt(1))) != 3) throw new IllegalChessMoveException("Konj ne moye na tu poziciju");
        else if(tmp.equals(pozTmp)) throw new IllegalChessMoveException("Niste nista pomjerili");
        pozicija = position;
        return true;
    }
    public Object dajKopiju(){
        return new Knight(pozicija,boja);
    }
}
