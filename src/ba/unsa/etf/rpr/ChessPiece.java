package ba.unsa.etf.rpr;

public abstract class ChessPiece {
    protected String position;
    protected Color color;
    public static enum Color{BLACK, WHITE}
    public String getPosition() { return position; }
    public Color getColor() { return color; }
    public abstract void move(String position);
}
