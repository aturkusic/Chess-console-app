package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.Program.daLiJeIspravnaPozicija;
import static java.lang.Math.abs;

public class Pawn extends ChessPiece{

    public Pawn(String poz, Color col) { super(poz, col); }

    @Override
    public boolean move(String position) throws IllegalChessMoveException {
        String tmp = position.toUpperCase();
        String pozTmp = pozicija.toUpperCase();
        int dvica, kec;
        if (boja == Color.WHITE) {
            dvica = 2;
            kec = 1;
        } else {
            dvica = -2;
            kec = -1;
        }
        if (!daLiJeIspravnaPozicija(position)) throw new IllegalArgumentException("Nepostojeca pozicija");
        else if (pozTmp.charAt(1) == '2' || pozTmp.charAt(1) == '7') {

            if (pozTmp.charAt(0) != tmp.charAt(0)) throw new IllegalChessMoveException("Pijun se ne moze tu pomjeriti");
            else if (!(tmp.charAt(1) - pozTmp.charAt(1) == dvica || tmp.charAt(1) - pozTmp.charAt(1) == kec))
                throw new IllegalChessMoveException("Pijun se ne moze tu pomjeriti");
        } else if (tmp.equals(pozTmp)) throw new IllegalChessMoveException("Niste nista pomjerili");
          else {
            if(!(tmp.charAt(1) - pozTmp.charAt(1) == kec) || pozTmp.charAt(0) != tmp.charAt(0)) throw new IllegalChessMoveException("Pijun se ne moze tu pomjeriti");
        }
        pozicija = position;
        return true;
    }

    public void jedi(String position) throws IllegalChessMoveException {
        String tmp = position.toUpperCase();
        String pozTmp = pozicija.toUpperCase();
        if (!daLiJeIspravnaPozicija(position)) throw new IllegalArgumentException("Nepostojeca pozicija");
        if (tmp.equals(pozTmp)) throw new IllegalChessMoveException("Niste nista pomjerili");
        else {
            if(boja == Color.BLACK) {
                if (!(pozTmp.charAt(0) + 1 == tmp.charAt(0) && pozTmp.charAt(1) - 1 == tmp.charAt(1)) &&
                        !(pozTmp.charAt(0) - 1 == tmp.charAt(0) && pozTmp.charAt(1) - 1 == tmp.charAt(1))) throw new IllegalChessMoveException("Pijun ne moze tu jesti");
            } else {
                if (!(pozTmp.charAt(0) + 1 == tmp.charAt(0) && pozTmp.charAt(1) + 1 == tmp.charAt(1)) &&
                        !(pozTmp.charAt(0) - 1 == tmp.charAt(0) && pozTmp.charAt(1) + 1 == tmp.charAt(1))) throw new IllegalChessMoveException("Pijun ne moze tu jesti");
            }
        }
        pozicija = position;
    }

    public Object dajKopiju(){
        return new Pawn(pozicija,boja);
    }
}
