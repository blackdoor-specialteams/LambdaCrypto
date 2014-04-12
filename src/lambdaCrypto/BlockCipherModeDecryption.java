package lambdaCrypto;

public interface BlockCipherModeDecryption extends BlockCipherMode {
	
	/**
	 * Decrypt a block using this block cipher mode.
	 * @param key
	 * @param ciphertext
	 * @param IV
	 * @return a 2-tuple in the form (plaintext, next) where next is the IV for the next block.
	 */
	public TwoTuple<byte[], byte[]> cryptBlock(DecryptionAlgorithm algo, byte[] key, byte[] plaintext, byte[] IV);

}
