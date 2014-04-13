package lambdaCrypto;

import struct.TwoTuple;
import util.Misc;

public class Modes {

	/**
	 * output feedback mode
	 * symmetric mode, can be used for both encryption and decryption.
	 * @param algo
	 * @param key
	 * @param inputtext
	 * @param IV
	 * @return a 2-tuple in the form (outputText, next) where next is the IV for the next block.
	 */
	public static TwoTuple<byte[], byte[]> OFB(CipherAlgorithm algo, byte[] key, byte[] inputText, byte[] IV){
		byte[] next;
		byte[] outputText;
		next = algo.cryptBlock(key, IV);
		outputText = Misc.XOR(next, inputText);
		return new TwoTuple<byte[], byte[]>(outputText, next);
	}

	
}
