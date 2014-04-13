package lambdaCrypto;

public  class Crypto {
	
	public enum OpMode{
		ENCRYPT, DECRYPT
	}
	
	private CipherAlgorithm algo;
	private BlockCipherMode mode;
	
	public Crypto(CipherAlgorithm algo, BlockCipherMode mode){
		this.algo = algo;
		this.mode = mode;
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
	public byte[] init(OpMode opMode, byte[] key){
		
	}
	
	/**
	 * Initializes the cipher with key and IV
	 * @param opMode the mode of operation, encryption or decryption
	 * @param IV An initialization vector to use for the cipher.
	 * @param key A key to encrypt with.
	 */
	public void init(OpMode opMode, byte[] IV, byte[] key){
		
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

