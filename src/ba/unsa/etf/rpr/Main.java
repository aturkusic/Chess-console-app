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
         Board b = new Board();
        try {
            b.move("E2", "E4");
            b.move("E4", "E5");
            b.move("E5", "E6");
            b.move("E6", "D7");
            System.out.print(b.isCheck(ChessPiece.Color.BLACK));
        } catch (IllegalChessMoveException izuzetak) {
            System.out.print(izuzetak.getMessage());
        }
       // System.out.print(kralj.getPosition() + " " + kraljica.getPosition() + " " + konj.getPosition()+ " " + lovac.getPosition()+ " " + pijun.getPosition());

     }
}
