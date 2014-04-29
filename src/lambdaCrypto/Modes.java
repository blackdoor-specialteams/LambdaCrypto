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
	 ////////////////////////////////////////////////////////////////////////
	 ///		OUTPUT FEEDBACK			/////////////////////////
	 ////////////////////////////////////////////////////////////////////////
	public static TwoTuple<byte[], byte[]> OFBEncrypt(CipherAlgorithm algo, byte[] key, byte[] inputText, byte[] IV){
		byte[] next;
		byte[] outputText;
		next = algo.cryptBlock(key, IV);
		outputText = Misc.XOR(next, inputText);
		return new TwoTuple<byte[], byte[]>(outputText, next);
	}
	
	public static TwoTuple<byte[], byte[]> OFBDecrypt(CipherAlgorithm algo, byte[] key, byte[] inputText, byte[] IV){
		byte[] next;
		byte[] outputText;
		
		next = algo.cryptBlock(key, IV);
		outputText = Misc.XOR(next, inputText);
		return new TwoTuple<byte[], byte[]>(outputText, next);
	}	
	public static BlockCipherMode getOFB(){
		return (CipherAlgorithm algo, byte[] key, byte[] inputText, byte[] IV) -> OFB(algo, key, inputText, IV);
	}
	
	 ////////////////////////////////////////////////////////////////////////
	 ///		ELECTRONIC CODEBOOK		/////////////////////////
	 ////////////////////////////////////////////////////////////////////////	
	public static TwoTuple<byte[], byte[]> ECBEncrypt(CipherAlgoritm algo, byte[] key, byte[] inputText, byte[] IV){
		byte[] cipherText;
		cipherText = algo.cryptBlock(key, inputText);
		return new TwoTuple<byte[], Void>(outputText, null);
	}
	public static TwoTuple<byte[], byte[]> ECBDecrypt(CipherAlgoritm algo, byte[] key, byte[] inputText, byte[] IV){
		byte[] plainText;
		plainText = algo.cryptBlock(key, inputText);
		return new TwoTuple<byte[], Void>(outputText, null);
	}	
	
	public static BlockCipherMode getECB(){
		return (CipherAlgorithm algo, byte[] key, byte[] inputText, byte[] IV) -> EBC(algo, key, inputText, IV);	

	 ////////////////////////////////////////////////////////////////////////
	 ///		CIPHER BLOCK CHAINING		/////////////////////////
	 ////////////////////////////////////////////////////////////////////////

	public static TwoTuple<byte[], byte[]> CBCEncrypt(CipherAlgoritm algo, byte[] key, byte[] inputText, byte[] IV){
		byte[] next;
		byte[] outputText;
		byte[] bceText;
		bceText = Misc.XOR(inputText, IV);
		
		next = algo.cryptBlock(key, bceText);
		
		outputText = next;
		return new TwoTuple<byte[], byte[]>(outputText, next)
	}
	public static TwoTuple<byte[], byte[]> CBCDecrypt(CipherAlgoritm algo, byte[] key, byte[] inputText, byte[] IV){
		byte[] next;
		byte[] outputText;
		byte[] bceText;
		next = inputText;
		
		bceText = algo.cryptBlock(key, inputText)
		outputText = Misc.XOR(bceText, IV)
		
		return new TwoTuple<byte[], byte[]>(outputText, next)
	}
		
	public static BlockCipherMode getCBC(){
		return (CipherAlgorithm algo, byte[] key, byte[] inputText, byte[] IV) -> CBC(algo, key, inputText, IV);	
/*	 
	 ////////////////////////////////////////////////////////////////////////
	 ///		CIPHER FEEDBACK			/////////////////////////
	 ////////////////////////////////////////////////////////////////////////
	 
	public static TwoTuple<byte[], byte[]> CFB(CipherAlgoritm algo, byte[] key, byte[] inputText, byte[] IV){	 
		byte[] next;
		byte[] outputText;
		byte[] bceText;
		
		bceText = algo.cryptBlock
	}*/
}
