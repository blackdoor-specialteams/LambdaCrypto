package lambdaCrypto;

public interface BlockCipherModeEncryption extends BlockCipherMode {
	/**
	 * Encrypt a block using this block cipher mode.
	 * @param key
	 * @param plaintext
	 * @param IV
	 * @return a 2-tuple in the form (ciphertext, next) where next is the IV for the next block.
	 */
	public TwoTuple<byte[], byte[]> cryptBlock(byte[] key, byte[] plaintext, byte[] IV);
}
