package lambdaCrypto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import testpack.*;

public class Test {

	public static void main(String[] args) {
		Test tester = new Test();
		// Get Run-Mode
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-help")) {
				tester.printHelp();
				System.exit(0);
			} else if (args[i].equals("-e")) {
				tester.setMode(RunMode.ENCRYPT);
				
				System.exit(0);
			} 
			else if (args[i].equals("-d")) {
				tester.setMode(RunMode.DECRYPT);
			
				System.exit(0);
			}else {
				System.err.println("invalid argument:" + args[i]);
				System.exit(1);
			}
		}
		// RUNDEFAULT

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
	private String infile = "in.txt";
	private String outfile = "outfile.txt";
	
	public Test() {
		runmode = RunMode.DEFAULT;
	}

	private boolean setMode(RunMode mode) {
		runmode = mode;
		return false;
	}

	private void printHelp() {
		String filename = "/testpack/help.txt";
		File file = new File(filename);
		try {
			Scanner in = new Scanner(file);

			while (in.hasNextLine()) {
				int i = in.nextInt();
				System.out.println(i);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Failure to open help.txt");
			e.printStackTrace();
		}
	}

}
