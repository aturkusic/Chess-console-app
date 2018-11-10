package ba.unsa.etf.rpr;


import java.util.ArrayList;

import static ba.unsa.etf.rpr.Main.daLiJeIspravnaPozicija;
import static java.lang.Math.abs;

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
                int index = 0;
                try {
                    index = petljaZaTrazenjeFigure(King.class, poz, color);
                } catch (IllegalChessMoveException izuz) {
                    throw izuz;
                }
                for(int i = 0; i < tabla.size(); i++) {
                    String tmp = tabla.get(i).getPosition().toUpperCase();
                    if(poz.equals(tmp) && tabla.get(i).getColor() == color) throw new IllegalChessMoveException("Nelegalan potez");
                    else if (poz.equals(tmp)) {
                        break;
                    }
                }
               /* boolean pronadjen = false;
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
                }*/
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
                int prvi, drugi;
                if(stara_poz.charAt(0) > poz.charAt(0) && stara_poz.charAt(1) < poz.charAt(1)) { prvi = -1; drugi = 1;}
                else if(stara_poz.charAt(0) > poz.charAt(0) && stara_poz.charAt(1) > poz.charAt(1)) { prvi = -1; drugi = -1; }
                else if(stara_poz.charAt(0) < poz.charAt(0) && stara_poz.charAt(1) < poz.charAt(1)) { prvi = 1; drugi = 1;}
                else { prvi = 1; drugi = -1; }
                // uslovi za provjeru preskakanja, provjeravanje moze biti u 4 smjera pa po tome ova 4 ifa iznad
            vanjska : while(true) {
                        for (int i = 0; i < tabla.size(); i++) {
                            String tmp = tabla.get(i).getPosition().toUpperCase();
                            if (tmp.charAt(0) == stara_poz.charAt(0) + prvi && tmp.charAt(1) == (stara_poz.charAt(1) + drugi)) {
                                if (poz.equals(tmp) && tabla.get(i).getColor() != color) {
                                    tabla.get(index).move(position);
                                    tabla.remove(i);
                                    break vanjska;
                                } else {
                                    throw new IllegalChessMoveException("Lovac ne moze preskakati");
                                }
                            }
                        }
                            if(stara_poz.charAt(0) > poz.charAt(0) && stara_poz.charAt(1) < poz.charAt(1)) { prvi--; drugi++;}
                            else if(stara_poz.charAt(0) > poz.charAt(0) && stara_poz.charAt(1) > poz.charAt(1)) { prvi--; drugi--; }
                            else if(stara_poz.charAt(0) < poz.charAt(0) && stara_poz.charAt(1) < poz.charAt(1)) { prvi++; drugi++;}
                            else { prvi++; drugi--; }
                            limit++;
                            if(limit == abs(poz.charAt(0) - stara_poz.charAt(0))) break;

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
                // ako je slovo pozicije jednako trazimo figure po brojevima
                 vanjska :   for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < tabla.size(); j++) {
                            String tmp = tabla.get(j).getPosition().toUpperCase();
                            if (tmp.charAt(0) == stara_poz.charAt(0)+ drugi && tmp.charAt(1) == stara_poz.charAt(1) + prvi) {
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
                     else if(stara_poz.charAt(0) < poz.charAt(0)) drugi++;
                     else drugi--;
                     if(i + 1 == abs(poz.charAt(0) - stara_poz.charAt(0)) || i + 1 == abs(poz.charAt(1) - stara_poz.charAt(1))) break;
                }
                try {
                    tabla.get(index).move(position);
                } catch (IllegalChessMoveException izuz) {
                    int doNothing;
                }

            } else if(type == Queen.class) {
                int index = 0;
                try {
                    index = petljaZaTrazenjeFigure(Queen.class, poz, color);
                } catch (IllegalChessMoveException izuz) {
                    throw izuz;
                }
                String stara_poz = tabla.get(index).getPosition().toUpperCase();
                //kraljica je spoj topa i lovca, uslovi od ta dva isombinirani
                int prvi = 0, drugi =  0;
                if(stara_poz.charAt(0) > poz.charAt(0) && stara_poz.charAt(1) < poz.charAt(1)) { prvi = -1; drugi = 1;}
                else if(stara_poz.charAt(0) > poz.charAt(0) && stara_poz.charAt(1) > poz.charAt(1)) { prvi = -1; drugi = -1; }
                else if(stara_poz.charAt(0) < poz.charAt(0) && stara_poz.charAt(1) < poz.charAt(1)) { prvi = 1; drugi = 1;}
                else if(stara_poz.charAt(0) < poz.charAt(0) && stara_poz.charAt(1) > poz.charAt(1)){ prvi = 1; drugi = -1; }
                else if(stara_poz.charAt(1) < poz.charAt(1)) { drugi = 1; }
                else if(stara_poz.charAt(1) > poz.charAt(1)) { drugi = -1; }
                else if(stara_poz.charAt(0) < poz.charAt(0)) { prvi = 1; }
                else if(stara_poz.charAt(0) > poz.charAt(0)){ prvi = -1; }
                vanjska :   for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < tabla.size(); j++) {
                        String tmp = tabla.get(j).getPosition().toUpperCase();
                        if (tmp.charAt(0) == stara_poz.charAt(0)+ prvi && tmp.charAt(1) == stara_poz.charAt(1) + drugi) {
                            if (poz.equals(tmp) && tabla.get(j).getColor() != color) {
                                tabla.remove(j);
                                tabla.get(index).move(position);
                                break vanjska;
                            } else {
                                throw new IllegalChessMoveException("Kraljica ne moze preskakati");
                            }
                        }
                    }
                    if(stara_poz.charAt(0) > poz.charAt(0) && stara_poz.charAt(1) < poz.charAt(1)) { prvi--; drugi++;}
                    else if(stara_poz.charAt(0) > poz.charAt(0) && stara_poz.charAt(1) > poz.charAt(1)) { prvi--; drugi--; }
                    else if(stara_poz.charAt(0) < poz.charAt(0) && stara_poz.charAt(1) < poz.charAt(1)) { prvi++; drugi++;}
                    else if(stara_poz.charAt(0) < poz.charAt(0) && stara_poz.charAt(1) > poz.charAt(1)) { prvi++; drugi--; }
                    else if(stara_poz.charAt(1) < poz.charAt(1))  drugi++;
                    else if(stara_poz.charAt(1) > poz.charAt(1)) drugi--;
                    else if(stara_poz.charAt(0) < poz.charAt(0)) prvi++;
                    else if (stara_poz.charAt(0) > poz.charAt(0))prvi--;
                    if(i + 1 == abs(poz.charAt(0) - stara_poz.charAt(0)) || i + 1 == abs(poz.charAt(1) - stara_poz.charAt(1))) break;
                }
                try {
                    tabla.get(index).move(position);
                } catch (IllegalChessMoveException izuz) {
                    int doNothing;
                }

            } else if(type == Pawn.class) {
                int index = 0;
                try {
                    index = petljaZaTrazenjeFigure(Pawn.class, poz, color);
                } catch (IllegalChessMoveException izuz) {
                    throw izuz;
                }
                // nasli smo da postoji pijun za ovaj potez sada ide postupak da li ga jest ili samo pomjeriti
                int indx_za_izbacit = 0;
                for(int i = 0; i < tabla.size(); i++) {
                    String tmp = tabla.get(i).getPosition().toUpperCase();
                    if(poz.equals(tmp) && tabla.get(i).getColor() == color) throw new IllegalChessMoveException("Nelegalan potez");
                    else if (poz.equals(tmp)) {
                        indx_za_izbacit = i;
                        break;
                    }
                }
                boolean da_li_jede = false;
                try {
                    Pawn tmpPijun = (Pawn) tabla.get(index).dajKopiju();
                    tmpPijun.jedi(tabla.get(indx_za_izbacit).getPosition());
                    da_li_jede = true;
                } catch(IllegalChessMoveException iz) {
                    int doNothing;
                }
                if(da_li_jede) {
                    Pawn tmp = (Pawn)tabla.get(index);
                    tmp.jedi(position);
                    tabla.remove(indx_za_izbacit);
                }
                else {
                    tabla.get(index).move(position);
                }
            } else {
            throw new IllegalArgumentException("Prvi parametar nije figura");
        }
    }

    public boolean isCheck(ChessPiece.Color color) {
        String pozicija_kralja = "abc";
        Board tabla1 = this.dajKopiju();
        int index = 0;
        for(int i = 0; i < tabla1.tabla.size(); i++) {
            if(tabla1.tabla.get(i).getClass() == King.class && tabla1.tabla.get(i).getColor() == color) {
                tabla1.tabla.add(i, new King(tabla1.tabla.get(i).getPosition(), color));
                pozicija_kralja = tabla1.tabla.get(i).getPosition().toUpperCase();
                index = i;
                break;
            }
        }

        boolean pojeo = false;
        for(int i = 0; i < tabla1.tabla.size(); i++) {
            try {
                ChessPiece tmp = (ChessPiece) tabla1.tabla.get(i).dajKopiju();
                if(tmp.getClass() == Pawn.class) {
                    Pawn pijun = (Pawn)tmp.dajKopiju();
                    try {
                        pijun.jedi(pozicija_kralja);
                        tabla1.tabla.remove(index);
                        pojeo = true;
                        break;
                    } catch(IllegalChessMoveException iz) {
                        int doNothing;
                    }
                }
                if(!pojeo)
                    tabla1.move(tmp.getPosition(), pozicija_kralja);
                tabla1.tabla.remove(index);
                break;
            } catch(IllegalChessMoveException iz) {
                int doNothing;
            }

        }
        int brojac = 0;
        for(int i = 0; i < tabla1.tabla.size(); i++) {
            if(tabla1.tabla.get(i).getClass() == King.class && tabla1.tabla.get(i).getColor() == color) brojac++;
        }
        if(brojac == 1) return true;
        return false;
    }

    public void move(String oldPosition, String newPosition) throws IllegalChessMoveException {
        String stara = oldPosition.toUpperCase();
        boolean ima_stara = false;
        for(int i = 0; i < tabla.size(); i++) {
            String tmp = tabla.get(i).getPosition().toUpperCase();
            if(stara.equals(tmp)) {
                try {
                    this.move(tabla.get(i).getClass(), tabla.get(i).getColor(), newPosition);
                    ima_stara = true;
                    break;
                } catch (IllegalChessMoveException iz) {
                    throw iz;
                }
            }
        }
        if(!ima_stara) throw new IllegalChessMoveException("Illegal move");
    }

    public Board dajKopiju() {
        Board tablaVratit = new Board();
        tablaVratit.tabla.clear();
        for(int i = 0; i < tabla.size(); i++) {
            tablaVratit.tabla.add((ChessPiece) tabla.get(i).dajKopiju());
        }
        return tablaVratit;
    }

    private int petljaZaTrazenjeFigure(Class<?> figura, String position, ChessPiece.Color color) throws IllegalChessMoveException {
        if(figura == Pawn.class) {
            boolean pronadjen = false, pronadjen_za_jelo = false;
            int index_zajelo = 0, index_pronadjenog = 0;
            String novi = position.toUpperCase();
            for(int i = 0; i < tabla.size(); i++) {
                String tmp = tabla.get(i).getPosition().toUpperCase();
                if(tmp.equals(novi)) {
                    index_zajelo = i;
                    pronadjen_za_jelo = true;
                }
            }
            if(pronadjen_za_jelo) {
                String tmp = tabla.get(index_zajelo).getPosition().toUpperCase();
                for (int i = 0; i < tabla.size(); i++) {
                    if (tabla.get(i).getClass() == Pawn.class){
                        Pawn tmpPijun = (Pawn) tabla.get(i).dajKopiju();
                        try {
                            tmpPijun.jedi(tmp);
                            pronadjen = true;
                            index_pronadjenog = i;
                            break;
                        } catch (IllegalChessMoveException iz) {
                            int doNothing;
                        }
                    }
                }
            }
            if(!pronadjen) {
                for(int i = 0; i < tabla.size(); i++) {
                    if (tabla.get(i).getClass() == Pawn.class) {
                        Pawn tmpPijun = (Pawn) tabla.get(i).dajKopiju();
                        try {
                            tmpPijun.move(position);
                            pronadjen = true;
                            index_pronadjenog = i;
                            break;
                        } catch (IllegalChessMoveException iz) {
                            int doNothing;
                        }
                    }
                }
            }
            if(pronadjen) return index_pronadjenog;
            else throw new IllegalChessMoveException("Ne moze se povuci taj potez ni za jednu figuru");
        } else {
            boolean pronadjen = false;
            int index_pronadjenog = 0;
            vanjska:
            for (int i = 0; i < tabla.size(); i++) {
                if (figura.isInstance(tabla.get(i)) && tabla.get(i).getColor() == color) {
                    try {
                        String restore = tabla.get(i).getPosition();
                        tabla.get(i).move(position);
                        tabla.get(i).move(restore);
                        pronadjen = true;
                        index_pronadjenog = i;
                        break vanjska;
                    } catch (IllegalChessMoveException izuz) {
                        pronadjen = false;
                    }
                }
            }
            if (pronadjen) return index_pronadjenog;
            else throw new IllegalChessMoveException("Ne moze se povuci taj potez ni za jednu figuru");
        }
    }

}
