package lambdaCrypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import struct.TwoTuple;
import util.Misc;

public  class Crypto {
	
	public enum OpMode{
		ENCRYPT, DECRYPT}
	public static final int BLOCKSIZE = 32;
	private CipherAlgorithm algo;
	private BlockCipherMode mode;
	private OpMode opMode;
	
	
	public static void main(String[] args){
		/**
		 * |example of how crypto might be used
		 */
		byte[] IV = new byte[32];
		byte[] key = new byte [32];
		byte[] plaintext = new byte[100];
		
		Crypto crypto = new Crypto(OpMode.ENCRYPT);
		EncryptionAlgorithm eAlgo = (EncryptionAlgorithm) Ciphers.SHEcrypt; // one way: use an already existing object of interface.
		BlockCipherModeEncryption eMode = (CipherAlgorithm algo, byte[] keyyy, byte[] plainText, byte[] iV) -> Modes.OFB(algo, keyyy, plainText, iV);// another way: define functional interface with static method in object declaration.
		crypto.init(eAlgo, eMode, IV, key);
		byte[] ciphertext = crypto.update(plaintext);
		byte[] pad = crypto.doFinal();
	}
	
	
	public Crypto(OpMode opMode){
		this.opMode = opMode;
	}
	
	/**
	 * Encrypts or decrypts data in a single-part operation, or finishes a multiple-part operation.
	 * The bytes in the input buffer, and any input bytes that may have been buffered during a previous update operation, are processed, with padding (if requested) being applied. 
	 *
	 * Upon finishing, this method resets this cipher object to the state it was in before initialized via a call to init. That is, the object is reset and needs to be re-initialized before it is available to encrypt or decrypt more data.
	 * @param input the input buffer
	 * @return the new buffer with the result
	 */
	public byte[] doFinal(){
		
	}
	
	/**
	 * Encrypts or decrypts data in a single-part operation, or finishes a multiple-part operation.
	 * The bytes in the input buffer, and any input bytes that may have been buffered during a previous update operation, are processed, with padding (if requested) being applied. 
	 *
	 * Upon finishing, this method resets this cipher object to the state it was in before initialized via a call to init. That is, the object is reset and needs to be re-initialized before it is available to encrypt or decrypt more data.
	 * @param input the input buffer
	 * @return the new buffer with the result
	 */
	public byte[] doFinal(byte[] input){
		
	}
	
	/**
	 * Initializes the cipher with key, creates a random IV to use with the cipher.
	 * @param opMode the mode of operation, encryption or decryption
	 * @param key A key to encrypt with.
	 * @return An IV that has been created for this cipher to use.
	 */
	public byte[] init(CipherAlgorithm algo, BlockCipherMode mode, byte[] key){
		byte[] iv = new byte[BLOCKSIZE];
		new SecureRandom().nextBytes(iv);
		init(algo, mode, iv, key);
		return iv;
	}
	
	/**
	 * Initializes the cipher with key and IV
	 * @param opMode the mode of operation, encryption or decryption
	 * @param IV An initialization vector to use for the cipher.
	 * @param key A key to encrypt with.
	 */
	public void init(CipherAlgorithm algo, BlockCipherMode mode, byte[] IV, byte[] key){
		if(opMode == OpMode.ENCRYPT){
			if(!(algo instanceof EncryptionAlgorithm && mode instanceof BlockCipherModeEncryption ))
				throw new RuntimeException("CipherAlgorithm and/or BlockCipher Modes are not Encryption Algorithms and/or Modes");
		}else{
			if(!(algo instanceof DecryptionAlgorithm && mode instanceof BlockCipherModeDecryption ))
			throw new RuntimeException("CipherAlgorithm and/or BlockCipher Modes are not Decryption Algorithms and/or Modes");
		}
		this.algo = algo;
		this.mode = mode;
	}
	
	
	/**
	 * Continues a multiple-part encryption or decryption operation (depending on how this cipher was initialized), processing another data part.
	 * The bytes in the input buffer are processed, and the result is stored in a new buffer.
	 *
	 * If input has a length of zero, this method returns null.
	 * @param input
	 * @return
	 */
	public byte[] update(byte[] input){
		
	}

	/**
	 * @return the cipher algorithm
	 */
	public CipherAlgorithm getAlgorithm() {
		return algo;
	}

	/**
	 * @return the block cipher mode
	 */
	public BlockCipherMode getMode() {
		return mode;
	}
}

