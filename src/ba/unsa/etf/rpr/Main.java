package ba.unsa.etf.rpr;



public class Main {

     public static boolean daLiJeIspravnaPozicija(String s) {
         String s1 = ("ABCDEFGH");
         String s2 = ("12345678");
         if(s.length() != 2) return false;
         else if(!(s1.indexOf(s.charAt(0)) >=  0 || s1.indexOf(s.charAt(0) - 32) >=  0)) return false;
         else if(!(s2.indexOf(s.charAt(1)) >= 0 || s2.indexOf(s.charAt(1) - 32) >= 0)) return false;
         return true;
     }
     public static void main(String[] args) {
        King kralj = new King("E1", ChessPiece.Color.WHITE);
      //  Queen kraljica = new Queen("D4", ChessPiece.Color.BLACK);
        //Knight konj = new Knight("D4", ChessPiece.Color.BLACK);
        //Bishop lovac = new Bishop("E5", ChessPiece.Color.WHITE);
        //ChessPiece pijun = new Pawn("e7", ChessPiece.Color.BLACK);
         Board tabla = new Board();
        try {
            /*kraljica.move("d5");
            kralj.move("h4");
            konj.move("e6");
            lovac.move("C3");
            pijun.move("E6");*/
           tabla.move(King.class, ChessPiece.Color.WHITE,"E2");
        } catch (IllegalChessMoveException izuzetak) {
            System.out.print("Bacen je izuzetak");
        }
        //System.out.print(kralj.getPosition() + " " + kraljica.getPosition() + " " + konj.getPosition()+ " " + lovac.getPosition()+ " " + pijun.getPosition());

     }
}
