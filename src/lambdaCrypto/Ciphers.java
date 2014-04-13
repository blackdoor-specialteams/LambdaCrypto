package lambdaCrypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Ciphers {
	
	public static byte[] SHECrypt(byte[] key, byte[] inputtext){
		MessageDigest mD = null;
		try {
			mD = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		key = mD.digest(key);
		
		if(key.length != inputtext.length)
			throw new RuntimeException("Parameters are not same length for xor.");
		
		for(int i = 0; i < key.length; i++)
			key[i] = (byte) (key[i]^inputtext[i]);
		
		return key;
	}
	
}
