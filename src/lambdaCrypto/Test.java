package lambdaCrypto;

public class Test {

	public static void main(String[] args) {
		byte[] out = Ciphers.SHECrypt(new byte[32], new byte[32]);
		byte[] in = Ciphers.SHECrypt(new byte[32], out);
		System.out.println();
	}

}
