import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.lang.StringBuilder;

public class Day5_2 {
    
    public static void main (String[] args) {
        
        String input = "ugkcyxxp";
        StringBuilder res = new StringBuilder("________");
        
        int j = 0;
        while (res.indexOf("_") != -1) {
            String md5 = getMD5(input + j);
            if (md5.startsWith("00000")) {
                int position = Character.getNumericValue(md5.charAt(5));
                if (position >= 0 && position < 8 && res.charAt(position) == '_') {
                    System.out.println(res.toString()); // For visualization
                    res.setCharAt(position, md5.charAt(6));
                }
            }
            j++;
        }

        System.out.println("The password is: " + res);
    }

    /*  From https://www.mkyong.com/java/java-md5-hashing-example/
    */
    public static String getMD5(String s) {
        
        byte[] hashedBytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            hashedBytes = md.digest(s.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            System.out.println("Exception in function getMD5");
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hashedBytes.length; i++) {
            sb.append(Integer.toString((hashedBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return sb.toString();
    }
}