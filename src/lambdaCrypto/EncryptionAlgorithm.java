package lambdaCrypto;

public interface EncryptionAlgorithm {
	public byte[] encryptBlock(byte[] key, byte[] plaintext);
}
