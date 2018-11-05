package ba.unsa.etf.rpr;

import static ba.unsa.etf.rpr.Main.daLiJeIspravnaPozicija;

public abstract class ChessPiece {
    protected String position;
    protected Color color;
    public ChessPiece(String poz, Color col) {
        if(daLiJeIspravnaPozicija(poz)) throw new IllegalArgumentException("Losa pozicija");
        position = poz; color = col;
    }
    public static enum Color{BLACK, WHITE}
    public String getPosition() { return position; }
    public Color getColor() { return color; }
    public abstract void move(String position);
}
