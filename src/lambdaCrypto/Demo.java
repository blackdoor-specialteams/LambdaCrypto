package lambdaCrypto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import lambdaCrypto.Crypto.OpMode;
import testpack.*;
import util.Misc;

public class Demo {

	public static void main(String[] args) {
		Demo tester = new Demo();
		// Get Run-Mode
		if (args.length > 0) {
			// HELP CMD
			if (args[0].equals("-help")) {
				tester.printOut("./src/testpack/help.txt");
				System.exit(0);
			} else if (args[0].equals("-about")) {
				tester.printOut("./src/testpack/about.txt");
				System.exit(0);
			} else if (args[0].equals("-d")) { // DECRYPT CMD
				tester.setMode(RunMode.DECRYPT);
				tester.Run(args);
				System.exit(0);
			} else if (args[0].equals("-e")) { // ENCRYPT CMD
				tester.setMode(RunMode.ENCRYPT);
				tester.Run(args);
				System.exit(0);
			} else {
				System.err.println("invalid argument:" + args[0]);
				System.exit(1);
			}
		}
		// RUNDEFAULT
		tester.Run(null);
	}

	public enum RunMode {
		DEFAULT(), ENCRYPT(), DECRYPT();

		private final String description;

		private RunMode() {
			this.description = "";
		}

		private RunMode(String a) {
			this.description = a;
		}

		@Override
		public String toString() {
			return description;
		}
	}

	private RunMode runmode;
	private String infile = "src/testpack/in.txt";
	private String firstoutfile = "src/testpack/first_out.txt";
	private String finaloutfile = "src/testpack/final_out.txt";
	private String cipher = "default cipher";
	// TODO
	private String blockmode = "default blockmode";
	private final int BLOCKSIZE = 32;
	private byte[] IV = new byte[BLOCKSIZE];
	private byte[] key = new byte[BLOCKSIZE];
	private byte[] plaintext = new byte[100];

	// TODO

	public Demo() {
		runmode = RunMode.DEFAULT;
	}

	private boolean setMode(RunMode mode) {
		runmode = mode;
		return false;
	}

	private void Run(String[] args) {
		if (args != null) {
			setFiles(args);
			Crypto crypto = new Crypto();
			if (runmode == RunMode.ENCRYPT) {
				crypto.setOpMode(OpMode.ENCRYPT);
				EncryptionAlgorithm eAlgo = (EncryptionAlgorithm) Algorithms.SHEcrypt; 
				BlockCipherModeEncryption eMode = (CipherAlgorithm algo,
						byte[] keyyy, byte[] plainText, byte[] iV) -> Modes
						.OFB(algo, keyyy, plainText, iV);
				crypto.init(eAlgo, eMode, IV, key);
			} else if (runmode == RunMode.DECRYPT) {
				crypto.setOpMode(OpMode.DECRYPT);
				EncryptionAlgorithm eAlgo = (EncryptionAlgorithm) Algorithms.SHEcrypt;
				BlockCipherModeEncryption eMode = (CipherAlgorithm algo,
						byte[] keyyy, byte[] plainText, byte[] iV) -> Modes
						.OFB(algo, keyyy, plainText, iV);
				crypto.init(eAlgo, eMode, IV, key);
			}
			byte[] ciphertext = crypto.update(plaintext);
			byte[] pad = crypto.doFinal();
			System.out.println(Misc.bytesToHex(plaintext));
			System.out.println(Misc.bytesToHex(ciphertext) + Misc.bytesToHex(pad));
		} else {

		}
	}

	private void setFiles(String[] args) {
		if (args[1] != "-x") {
			if (args.length == 5) {
				cipher = args[1];
				blockmode = args[2];
				infile = args[3];
				firstoutfile = args[4];
				finaloutfile = args[4] + "_final";
			} else if (args.length == 4) {
				cipher = args[1];
				blockmode = args[2];
				infile = args[3];
			} else if (args.length == 3) {
				cipher = args[1];
				blockmode = args[2];
			} else if (args.length == 2) {
				cipher = args[1];
			}
		} else {
			if (args.length == 4) {
				infile = args[2];
				firstoutfile = args[3] + ".txt";
				finaloutfile = args[3] + "_final.txt";
			} else if (args.length == 3) {
				infile = args[2];
			}
		}
	}

	private void printOut(String filename) {
		File file = new File(filename);
		try {
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Failure to open file to be displayed");
			e.printStackTrace();
		}
	}
}
