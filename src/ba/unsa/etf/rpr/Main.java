package ba.unsa.etf.rpr;

public class Main {

     public static boolean daLiJeIspravnaPozicija(String s) {
         String s1 = new String("ABCDEFGH");
         String s2 = new String("12345678");
         if(s.length() != 2) return false;
         else if(s1.indexOf(s.charAt(0)) >=  0 || s1.indexOf(s.charAt(0) - 32) >=  0) return true;
         else if(s2.indexOf(s.charAt(1)) >= 0 || s2.indexOf(s.charAt(1) - 32) >= 0) return true;
         return false;
     }
     public static void main(String[] args) {
        King kralj = new King("H3", ChessPiece.Color.WHITE);
        Queen kraljica = new Queen("B4", ChessPiece.Color.BLACK);

        System.out.print(kralj.getPosition() + " " + kraljica.getPosition());
    }
}
