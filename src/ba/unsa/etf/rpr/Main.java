package ba.unsa.etf.rpr;

public class Main {

     public static boolean daLiJeIspravnaPozicija(String s) {
         String s1 = new String("ABCDEFGH");
         String s2 = new String("12345678");
         if(s.length() != 2) return false;
         else if(s1.indexOf(s.charAt(0)) !=  0) return false;
         else if(s2.indexOf(s.charAt(1)) !=  1) return false;
         return true;
     }
     public static void main(String[] args) {

    }
}
