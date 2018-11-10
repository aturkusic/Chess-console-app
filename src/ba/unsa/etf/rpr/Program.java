package ba.unsa.etf.rpr;


import java.util.Scanner;

public class Program {

     public static boolean daLiJeIspravnaPozicija(String s) {
         String s1 = ("ABCDEFGH");
         String s2 = ("12345678");
         if(s.length() != 2) return false;
         else if(!(s1.indexOf(s.charAt(0)) >=  0 || s1.indexOf(s.charAt(0) - 32) >=  0)) return false;
         else if(!(s2.indexOf(s.charAt(1)) >= 0 || s2.indexOf(s.charAt(1) - 32) >= 0)) return false;
         return true;
     }
     public static void main(String[] args) {
         Board b = new Board();
         Scanner ulaz = new Scanner(System.in);
         String unos = "heh";
         ChessPiece.Color boja;
         int brojac = 0;
         while(!unos.equals("X")) {
             if(brojac%2 == 1) System.out.print("Black move: ");
             else System.out.print("White move: ");
             if(brojac%2 == 1) boja = ChessPiece.Color.BLACK;
             else boja = ChessPiece.Color.WHITE;
             unos = ulaz.nextLine();
             if(unos.charAt(0) == 'K') {
                 try {
                     b.move(King.class, boja, unos.substring(1));
                 } catch (IllegalChessMoveException iz) {
                     System.out.print("Unesite ispravnu poziciju");
                 }
             } else if(unos.charAt(0) == 'Q') {
                 try {
                     b.move(Queen.class, boja, unos.substring(1));
                 } catch (IllegalChessMoveException iz) {
                     System.out.print("Unesite ispravnu poziciju");
                 }
             } else if(unos.charAt(0) == 'R') {
                 try {
                     b.move(Rook.class, boja, unos.substring(1));
                 } catch (IllegalChessMoveException iz) {
                     System.out.print("Unesite ispravnu poziciju");
                 }
             } else if(unos.charAt(0) == 'B') {
                 try {
                     b.move(Bishop.class, boja, unos.substring(1));
                 } catch (IllegalChessMoveException iz) {
                     System.out.print("Unesite ispravnu poziciju");
                 }
             } else if(unos.charAt(0) == 'N') {
                 try {
                     b.move(Knight.class, boja, unos.substring(1));
                 } catch (IllegalChessMoveException iz) {
                     System.out.print("Unesite ispravnu poziciju");
                 }
             } else if(unos.length() == 2) {
                 try {
                     b.move(Pawn.class, boja, unos);
                 } catch (IllegalChessMoveException iz) {
                     System.out.print("Unesite ispravnu poziciju");
                 }
             } else {
                 System.out.print("Molimo unesite ponovo: \n");
                 brojac--;
             }
             if(brojac%2 == 1) {
                 if (b.isCheck(ChessPiece.Color.WHITE)) System.out.print("CHECK!!!");
             } else {
                 if(b.isCheck(ChessPiece.Color.BLACK)) System.out.print("CHECK!!!");
             }

             brojac++;
         }

     }
}
