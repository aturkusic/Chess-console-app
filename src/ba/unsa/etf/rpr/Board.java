package ba.unsa.etf.rpr;


import java.util.ArrayList;

import static ba.unsa.etf.rpr.Main.daLiJeIspravnaPozicija;

public class Board {
    private ArrayList<ChessPiece> tabla;

    public Board() {
        tabla = new ArrayList<>();
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

    public void move(Class type, ChessPiece.Color color, String position) throws IllegalChessMoveException {
        String poz = position.toUpperCase();
            if(type == King.class) {
                boolean pronadjen = false;
                for(int i = 0; i < tabla.size(); i++) { // trazimo da li ima figura na novoj poziciji, zatim da li je potez leglan i konacno da li izbacujemo figuru sa tog mjesta ili izuzetak
                    String stara_poz = tabla.get(i).getPosition().toUpperCase();
                    if (stara_poz.equals(poz)) {
                        if (tabla.get(i).getColor() == color) throw new IllegalChessMoveException("illegalan potez");
                        else {
                            try {
                                for (int j = 0; j < tabla.size(); j++) {
                                    if (tabla.get(j) instanceof King && tabla.get(j).getColor() == color) {
                                        tabla.get(j).move(position);
                                        break;
                                    }
                                }
                                tabla.remove(i);
                                pronadjen = true;
                                break;
                            } catch (IllegalChessMoveException izuz) {
                                throw izuz;
                            }

                        }
                    }
                }
                if(!pronadjen) {
                    try {
                        for (int j = 0; j < tabla.size(); j++) {
                            if (tabla.get(j) instanceof King && tabla.get(j).getColor() == color) {
                                tabla.get(j).move(position);
                                break;
                            }
                        }
                    } catch (IllegalChessMoveException izuz) {
                        throw izuz;
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
