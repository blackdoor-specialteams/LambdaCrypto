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
			// HELP CMD
			if (args[i].equals("-help")) {
				tester.printHelp();
				System.exit(0);
			} else if (args[i].equals("-e")) { // ENCRYPT CMD
				tester.setMode(RunMode.ENCRYPT);
				tester.Run(args);
				System.exit(0);
			} else if (args[i].equals("-d")) { // DECRYPT CMD
				tester.setMode(RunMode.DECRYPT);
				tester.Run(args);
				System.exit(0);
			} else {
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
	private String infile = "src/testpack/in.txt";
	private String firstoutfile = "src/testpack/first_out.txt";
	private String finaloutfile = "src/testpack/final_out.txt";
	private String cipher = "default cipher"; //TODO

	public Test() {
		runmode = RunMode.DEFAULT;
	}

	private boolean setMode(RunMode mode) {
		runmode = mode;
		return false;
	}
	
	private void Run(String[] args) {
		setFiles(args);
		if(runmode == RunMode.DEFAULT){

		}else if (runmode == RunMode.ENCRYPT){

		}else if (runmode == RunMode.ENCRYPT){

		}
	}
	
	private void setFiles(String[] args){
		if(args.length == 4){
			cipher = args[1];
			infile = args[2];
			firstoutfile = args[3]; 
			finaloutfile = args[3] + "_final";
		}else if (args.length == 3){
			cipher = args[1];
			infile = args[2];
		}else if (args.length == 2){
			cipher = args[1];
		}
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
