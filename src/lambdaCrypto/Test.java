package lambdaCrypto;

import java.security.CryptoPrimitive;
import java.util.Arrays;

import util.Misc;

public class Test {

	public static void main(String[] args) {
		byte[] IV = new byte[32];
		byte[] plainText = new byte[100];
		byte[] key = new byte[32];
		for(int i = 0; i < plainText.length; i++){
			plainText[i] = (byte) ((i/32) +1);
		}
		Crypto crypto = new Crypto(Crypto.OpMode.ENCRYPT);
		/*######################################################################
		#### Null Cipher #######################################################
		######################################################################*/
		
		crypto.init(Algorithms.getNullCipher(), Modes.getOFB(), key);
		
		byte[] _0_40 = crypto.update(Arrays.copyOf(plainText, 40));
		System.out.println(Misc.bytesToHex(_0_40));
		
		byte[] full = crypto.update(plainText);
		System.out.println(Misc.bytesToHex(full));
		
		//######################################################################
		
		
		/*######################################################################
		#### SHE Cipher ########################################################
		######################################################################*/
		
		

		//######################################################################

	}

}
