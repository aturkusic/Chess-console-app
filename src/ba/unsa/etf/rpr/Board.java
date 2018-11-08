package ba.unsa.etf.rpr;


import java.util.ArrayList;

public class Board {
    private ArrayList<ChessPiece> tabla;

    public Board() {
        tabla.add(new Rook("A1", ChessPiece.Color.WHITE));
        tabla.add(new Knight("B1", ChessPiece.Color.WHITE));
        tabla.add(new Bishop("C1", ChessPiece.Color.WHITE));
        tabla.add(new Queen("D1", ChessPiece.Color.WHITE));
        tabla.add(new King("E1", ChessPiece.Color.WHITE));
        tabla.add(new Bishop("F1", ChessPiece.Color.WHITE));
        tabla.add(new Knight("G1", ChessPiece.Color.WHITE));
        tabla.add(new Rook("H1", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("A2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("B2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("C2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("D2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("E2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("F2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("G2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("H2", ChessPiece.Color.WHITE));
        tabla.add(new Rook("A8", ChessPiece.Color.BLACK));
        tabla.add(new Knight("B8", ChessPiece.Color.BLACK));
        tabla.add(new Queen("D8", ChessPiece.Color.BLACK));
        tabla.add(new King("E8", ChessPiece.Color.BLACK));
        tabla.add(new Bishop("F8", ChessPiece.Color.BLACK));
        tabla.add(new Knight("G8", ChessPiece.Color.BLACK));
        tabla.add(new Rook("H8", ChessPiece.Color.BLACK));
        tabla.add(new Pawn("A7", ChessPiece.Color.BLACK));
        tabla.add(new Pawn("B7", ChessPiece.Color.BLACK));
        tabla.add(new Pawn("C7", ChessPiece.Color.BLACK));
        tabla.add(new Pawn("D7", ChessPiece.Color.BLACK));
        tabla.add(new Pawn("E7", ChessPiece.Color.BLACK));
        tabla.add(new Pawn("F7", ChessPiece.Color.BLACK));
        tabla.add(new Pawn("G7", ChessPiece.Color.BLACK));
        tabla.add(new Pawn("H7", ChessPiece.Color.BLACK));
    }

    public void move(ChessPiece type, ChessPiece.Color color, String position) throws IllegalChessMoveException {
        String tmp = position.toUpperCase();
            if(type instanceof King) {
                for(int i = 0; i < tabla.size(); i++) {
                    String tmp1 = tabla.get(i).getPosition().toUpperCase();
                    if(tmp1.equals(tmp) && tabla.get(i).getColor() == color) throw new IllegalChessMoveException("Illegalan potez");
                    else if(tmp1.equals(tmp)){
                        for(int k = 0; k < tabla.size(); k++) {
                            if(tabla.get(k) instanceof King &&  tabla.get(k).getColor() == color) {
                                try {
                                    tabla.get(k).move(tmp);
                                    int brojac = 0;
                                    for(int j = 0; j < tabla.size(); j++) {
                                        if(tmp1.equals(tmp)) brojac = j;
                                    }
                                    tabla.remove(brojac);
                                } catch(IllegalChessMoveException izuz) {
                                    throw izuz;
                                }
                            }
                        }
                    } else {
                        for(int k = 0; k < tabla.size(); k++) {
                            if (tabla.get(k) instanceof King &&  tabla.get(k).getColor() == color)
                                try {
                                    tabla.get(k).move(tmp);
                                } catch(IllegalChessMoveException izuz) {
                                    throw izuz;
                                }

                        }
                    }
                }
            } /*else if(type.isInstance(Pawn)) {

            } else if(type.isInstance(Knight)) {

            } else if(type.isInstance(Bishop)) {

            } else if(type.isInstance(Queen)) {

            } else if(type.isInstance(Rook)) {

            } */else {
            throw new IllegalArgumentException("Prvi parametar nije figura");
        }
    }

}
