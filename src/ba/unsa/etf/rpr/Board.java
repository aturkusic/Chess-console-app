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

    public void move(String oldPosition, String position) throws IllegalChessMoveException {
        String poz = position.toUpperCase();
        String oP = oldPosition.toUpperCase();
        ChessPiece.Color color = ChessPiece.Color.WHITE;
        int ix = 0;
        boolean pronadjen1 = false;
        for(int i =  0; i < tabla.size(); i++) {
            if(oP.equals(tabla.get(i).getPosition().toUpperCase())) {
                ix = i;
                color = tabla.get(i).getColor();
                pronadjen1 = true;
            }
        }
        if(!pronadjen1) throw new IllegalChessMoveException("Illegal move");
        int index = 0;
        try {
            index = daLiJeLegalno(oP, poz);
        } catch (IllegalChessMoveException izuz) {
            throw izuz;
        }

        if(tabla.get(ix).getClass() == King.class) {
                for(int i = 0; i < tabla.size(); i++) {
                    String tmp = tabla.get(i).getPosition().toUpperCase();
                    if (poz.equals(tmp) && tabla.get(i).getColor() != color) {
                        tabla.get(index).move(position);
                        tabla.remove(i);
                        break;
                    } else if(poz.equals(tmp)){
                        throw new IllegalChessMoveException("Kralj ne moze na tu poziciju");
                    }

                }
            try {
                tabla.get(index).move(position);
            } catch (IllegalChessMoveException izuz) {
                int doNothing;
            }
        } else if(tabla.get(ix).getClass() == Knight.class) {
            for(int i = 0; i < tabla.size(); i++) {
                String tmp = tabla.get(i).getPosition().toUpperCase();
                if (poz.equals(tmp) && tabla.get(i).getColor() != color) {
                    tabla.get(index).move(position);
                    tabla.remove(i);
                    break;
                } else if(poz.equals(tmp)){
                    throw new IllegalChessMoveException("Konj ne moze na tu poziciju");
                }

            }
            try {
                tabla.get(index).move(position);
            } catch (IllegalChessMoveException izuz) {
                int doNothing;
            }
        } else if(tabla.get(ix).getClass() == Bishop.class) {
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

        } else if(tabla.get(ix).getClass() == Rook.class) {
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

        } else if(tabla.get(ix).getClass() == Queen.class) {
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

        } else if(tabla.get(ix).getClass() == Pawn.class) {
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
            throw new IllegalChessMoveException("Prvi parametar nije figura");
        }
    }

    public void move(Class type, ChessPiece.Color color, String position) throws IllegalChessMoveException {
        boolean pronadjen = false;
        for(int i = 0; i < tabla.size(); i++) {
            if(tabla.get(i).getClass() == type && tabla.get(i).getColor() == color) {
                try {
                    this.move(tabla.get(i).getPosition(), position);
                    pronadjen = true;
                    break;
                } catch (IllegalChessMoveException iz) {
                    //nista
                }
            }
        }
        if(!pronadjen) throw new IllegalChessMoveException("Illegal move");
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




    public Board dajKopiju() {
        Board tablaVratit = new Board();
        tablaVratit.tabla.clear();
        for(int i = 0; i < tabla.size(); i++) {
            tablaVratit.tabla.add((ChessPiece) tabla.get(i).dajKopiju());
        }
        return tablaVratit;
    }

    private int daLiJeLegalno(String stara, String nova) throws IllegalChessMoveException {
            boolean pronadjen = false;
            int index_pronadjenog = 0;
            String stara_1 = stara.toUpperCase();
            vanjska:
            for (int i = 0; i < tabla.size(); i++) {
                String tmp = tabla.get(i).getPosition().toUpperCase();
                if (tmp.equals(stara_1)) {
                    if (tabla.get(i).getClass() == Pawn.class) {
                        boolean pronadjen_za_jelo = false;
                        String novi = nova.toUpperCase();
                        for (int j = 0; j < tabla.size(); j++) {
                            String tmp1 = tabla.get(j).getPosition().toUpperCase();
                            if (tmp1.equals(novi)) {
                                pronadjen_za_jelo = true;
                            }
                        }
                        if (pronadjen_za_jelo) {
                            try {
                                Pawn tmpPijun = (Pawn) tabla.get(i).dajKopiju();
                                tmpPijun.jedi(novi);
                                pronadjen = true;
                                index_pronadjenog = i;
                                break;
                            } catch (IllegalChessMoveException iz) {
                                //nista
                            }
                        }
                        if (!pronadjen) {
                            Pawn tmpPijun = (Pawn) tabla.get(i).dajKopiju();
                            try {
                                tmpPijun.move(nova);
                                pronadjen = true;
                                index_pronadjenog = i;
                                break;
                            } catch (IllegalChessMoveException iz) {
                                int doNothing;
                            }
                        }

                    }
                    try {
                        String restore = tabla.get(i).getPosition();
                        tabla.get(i).move(nova);
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
    //}

}
