package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.Program.daLiJeIspravnaPozicija;

public abstract class ChessPiece {
    protected String pozicija;
    protected Color boja;
    public ChessPiece(String poz, Color col) {
        if(!daLiJeIspravnaPozicija(poz)) throw new IllegalArgumentException("Losa pozicija");
        pozicija = poz; boja = col;
    }
    public static enum Color{BLACK, WHITE}
    public String getPosition() { return pozicija; }
    public Color getColor() { return boja; }
    public abstract void move(String position) throws IllegalChessMoveException;
    public abstract Object dajKopiju();
}
