import java.io.IOException;

/**
 * File Name: GraphInputOutputDir.java
 * 
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2021
 */

class GraphInputOutputDir {
	//You can change these 3 lines
	public static final String inputFileBase = "C:\\Users\\xdeng\\Downloads\\graphdata\\graphdata\\";
	public static final String outputFileBase = "/Users/jialiu/Desktop/graphdataoutput";
	private static final String dot2pdfExec = "C:/Program Files (x86)/Graphviz2.38/bin/dot.exe";
	//make it null if you don't want to use dot2pdfExec
	//private static final String dot2pdfExec = "" ;
	
	//NOTHING CAN BE CHANGED BELOW
	static public void dot2pdf(String s) {
		if (!(dot2pdfExec.isEmpty())) {
			String dotFile = s +".dot";
	    String pdfFile = s +".pdf";
	    String c = dot2pdfExec + " -Tpdf " + dotFile + " -o " + pdfFile;
	    System.out.println("Executing " + c) ;
	    try {
	    	Runtime run  = Runtime.getRuntime(); 
	      Process proc = run.exec(c);
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	    }
		}
	}
}

