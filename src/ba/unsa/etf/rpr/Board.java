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
        //tabla.add(new Pawn("A2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("B2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("C2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("D2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("E2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("F2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("G2", ChessPiece.Color.WHITE));
        tabla.add(new Pawn("H2", ChessPiece.Color.WHITE));
        tabla.add(new Rook("A8", ChessPiece.Color.BLACK));
        tabla.add(new Knight("B8", ChessPiece.Color.BLACK));
        tabla.add(new Bishop("C8", ChessPiece.Color.BLACK));
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
                                for(int j = 0; j < tabla.size(); j++) {
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
                } // ako nije pronadjen nijedan element na position onda je slobodno i pomjeramo kralja
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
            } else if(type == Knight.class) {
            boolean pronadjen = false;
            for(int i = 0; i < tabla.size(); i++) { // trazimo da li ima figura na novoj poziciji, zatim da li je potez leglan i konacno da li izbacujemo figuru sa tog mjesta ili izuzetak
                String stara_poz = tabla.get(i).getPosition().toUpperCase();
                if (stara_poz.equals(poz)) {
                    if (tabla.get(i).getColor() == color) throw new IllegalChessMoveException("illegalan potez");
                    else {
                        try {
                            for (int j = 0; j < tabla.size(); j++) {
                                if (tabla.get(j) instanceof Knight && tabla.get(j).getColor() == color) {
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
            } // ako nije pronadjen nijedan element na position onda je slobodno i pomjeramo konja
                if(!pronadjen) {
                    try {
                        for (int j = 0; j < tabla.size(); j++) {
                            if (tabla.get(j) instanceof Knight && tabla.get(j).getColor() == color) {
                                tabla.get(j).move(position);
                                break;
                            }
                        }
                    } catch (IllegalChessMoveException izuz) {
                        throw izuz;
                    }
                }

            } else if(type == Bishop.class) {
                int index = 0;
                try {
                    index = petljaZaTrazenjeFigure(Bishop.class, poz, color);
                } catch (IllegalChessMoveException izuz) {
                    throw izuz;
                }
                int limit = 0;
                String stara_poz = tabla.get(index).getPosition().toUpperCase();
                boolean postavljen = false;
                if(stara_poz.charAt(0) > poz.charAt(0) && stara_poz.charAt(1) < poz.charAt(1)) { // uslovi za provjeru preskakanja
                    int prvi = 1, drugi = 1;
            vanjska :  while(true) {
                        for (int i = 0; i < tabla.size(); i++) {
                            String tmp = tabla.get(i).getPosition().toUpperCase();
                            if (tmp.charAt(0) == (stara_poz.charAt(0) - prvi) && tmp.charAt(1) == (stara_poz.charAt(1) + drugi)) {
                                if (poz.equals(tmp) && tabla.get(i).getColor() != color) {
                                    tabla.get(index).move(position);
                                    tabla.remove(i);
                                    break vanjska;
                                } else {
                                    throw new IllegalChessMoveException("Lovac ne moze preskakati");
                                }
                            }
                        }
                        prvi++; drugi++; limit++;
                        if(limit > 8) break;
                    }
                } else if(stara_poz.charAt(0) > poz.charAt(0) && stara_poz.charAt(1) > poz.charAt(1)) {
                    int prvi = 1, drugi = 1;
                    vanjska :  while(true) {
                        for (int i = 0; i < tabla.size(); i++) {
                            String tmp = tabla.get(i).getPosition().toUpperCase();
                            if (tmp.charAt(0) == stara_poz.charAt(0) - prvi && tmp.charAt(1) == stara_poz.charAt(1) - drugi) {
                                if (poz.equals(tmp) && tabla.get(i).getColor() != color) {
                                    tabla.get(index).move(position);
                                    tabla.remove(i);
                                    break vanjska;
                                } else {
                                    throw new IllegalChessMoveException("Lovac ne moze preskakati");
                                }
                            }
                        }
                        prvi++; drugi++; limit++;
                        if(limit > 8) break;
                    }
                } else if(stara_poz.charAt(0) < poz.charAt(0) && stara_poz.charAt(1) < poz.charAt(1)) {
                    int prvi = 1, drugi = 1;
                    vanjska :  while(true) {
                        for (int i = 0; i < tabla.size(); i++) {
                            String tmp = tabla.get(i).getPosition().toUpperCase();
                            if (tmp.charAt(0) == stara_poz.charAt(0) + prvi && tmp.charAt(1) == stara_poz.charAt(1) + drugi) {
                                if (poz.equals(tmp) && tabla.get(i).getColor() != color) {
                                    tabla.get(index).move(position);
                                    tabla.remove(i);
                                    break vanjska;
                                } else {
                                    throw new IllegalChessMoveException("Lovac ne moze preskakati");
                                }
                            }
                        }
                        prvi++; drugi++; limit++;
                        if(limit > 8) break;
                    }
                } else if(stara_poz.charAt(0) < poz.charAt(0) && stara_poz.charAt(1) > poz.charAt(1)) {
                    int prvi = 1, drugi = 1;
                    vanjska :  while(true) {
                        for (int i = 0; i < tabla.size(); i++) {
                            String tmp = tabla.get(i).getPosition().toUpperCase();
                            if (tmp.charAt(0) == stara_poz.charAt(0) + prvi && tmp.charAt(1) == stara_poz.charAt(1) - drugi) {
                                if (poz.equals(tmp) && tabla.get(i).getColor() != color) {
                                    tabla.get(index).move(position);
                                    tabla.remove(i);
                                    break vanjska;
                                } else {
                                    throw new IllegalChessMoveException("Lovac ne moze preskakati");
                                }
                            }
                        }
                        prvi++; drugi++; limit++;
                        if(limit > 8) break;
                    }
                }
                try {
                    tabla.get(index).move(position);
                } catch (IllegalChessMoveException izuz) {
                    int doNothing;
                }

            } else if(type == Rook.class) {
                int index = 0;
                try {
                    index = petljaZaTrazenjeFigure(Rook.class, poz, color);
                } catch (IllegalChessMoveException izuz) {
                    throw izuz;
                }
                String stara_poz = tabla.get(index).getPosition().toUpperCase();
                int prvi , drugi;
                if(stara_poz.charAt(1) < poz.charAt(1)) { prvi = 1; drugi = 0;}
                else if(stara_poz.charAt(1) > poz.charAt(1)) { prvi = -1; drugi = 0; }
                else if(stara_poz.charAt(0) < poz.charAt(0)) { prvi = 0; drugi = 1;}
                else { prvi = 0; drugi = -1; }
                if(stara_poz.charAt(0) == poz.charAt(0)) { // ako je slovo pozicije jednako trazimo figure po brojevima
                 vanjska :   for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < tabla.size(); j++) {
                            String tmp = tabla.get(j).getPosition().toUpperCase();
                            if (tmp.charAt(0) == stara_poz.charAt(0) && tmp.charAt(1) == stara_poz.charAt(1) + prvi) {
                                if (poz.equals(tmp) && tabla.get(j).getColor() != color) {
                                    tabla.get(index).move(position);
                                    tabla.remove(j);
                                    break vanjska;
                                } else {
                                    throw new IllegalChessMoveException("Top ne moze preskakati");
                                }
                            }
                        }
                     if(stara_poz.charAt(1) < poz.charAt(1))  prvi++;
                     else if(stara_poz.charAt(1) > poz.charAt(1)) prvi--;

                    }
                } else {
                    vanjska :   for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < tabla.size(); j++) {
                            String tmp = tabla.get(j).getPosition().toUpperCase();
                            if (tmp.charAt(0) == stara_poz.charAt(0) + drugi && tmp.charAt(1) == stara_poz.charAt(1)) {
                                if (poz.equals(tmp) && tabla.get(j).getColor() != color) {
                                    tabla.get(index).move(position);
                                    tabla.remove(j);
                                    break vanjska;
                                } else {
                                    throw new IllegalChessMoveException("Top ne moze preskakati");
                                }
                            }
                        }
                        if(stara_poz.charAt(0) < poz.charAt(0)) drugi++;
                        else drugi--;
                    }
                }
                try {
                    tabla.get(index).move(position);
                } catch (IllegalChessMoveException izuz) {
                    int doNothing;
                }

            } /*else if(type.isInstance(Queen)) {

            } else if(type.isInstance(Pawn)) {

            } */else {
            throw new IllegalArgumentException("Prvi parametar nije figura");
        }
    }

    int petljaZaTrazenjeFigure(Class<?> figura, String position, ChessPiece.Color color) throws IllegalChessMoveException {
        boolean pronadjen = false; int index_pronadjenog = 0;
     vanjska :   for(int i = 0; i < tabla.size(); i++) {
            if (figura.isInstance(tabla.get(i))&& tabla.get(i).getColor() == color) {
                try {
                    String restore = tabla.get(i).getPosition();
                    tabla.get(i).move(position);
                    tabla.get(i).move(restore);
                    pronadjen = true; index_pronadjenog = i;
                    break vanjska;
                } catch(IllegalChessMoveException izuz) {
                    pronadjen = false;
                }
            }
        }
        if(pronadjen) return index_pronadjenog;
        else throw new IllegalChessMoveException("Ne moze se povuci taj potez ni za jednu figuru");
    }

}
