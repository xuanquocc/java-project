package Controller;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class EnCryption {
	public static String enCryption(String msg) {
		String s1 = " ";
		try {
			// Ä�á»�c file chá»©a public key
			FileInputStream fis = new FileInputStream("D:\\publicKey.rsa");
			byte[] b = new byte[fis.available()];
			fis.read(b);
			fis.close();

			// Táº¡o public key
			X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
			KeyFactory factory = KeyFactory.getInstance("RSA");
			PublicKey pubKey = factory.generatePublic(spec);

			// MÃ£ hoÃ¡ dá»¯ liá»‡u
			Cipher c = Cipher.getInstance("RSA");
			c.init(Cipher.ENCRYPT_MODE, pubKey);
			byte encryptOut[] = c.doFinal(msg.getBytes());
			s1 = Base64.getEncoder().encodeToString(encryptOut);
			return s1;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return s1;
	}

	public static String EnCryption1(String s1) {
		// TODO Auto-generated method stub
		return null;
	}

}
