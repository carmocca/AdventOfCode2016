import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day05 {

    public static void main(String[] args) {

        String input = "ugkcyxxp";
        String res = "";

        int j = 0;
        while (res.length() < 8) {
            String md5 = getMD5(input + j);
            if (md5.startsWith("00000")) {
                res += md5.charAt(5);
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

        StringBuilder sb = new StringBuilder();
        for (byte hashedByte : hashedBytes) {
            sb.append(Integer.toString((hashedByte & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return sb.toString();
    }
}