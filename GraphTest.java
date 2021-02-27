import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * File Name: GraphTest.java
 * 
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2021
 */

 /*********************************************************************
					Nothing can be changed in this file
**********************************************************************/

class GraphTest{
	private IntUtil u = new IntUtil();
	GraphTest() throws FileNotFoundException {
		testBed() ;
	}
	
	private void build(String name, GraphType.Type graphType, int enodes, int eedges) throws FileNotFoundException {
		GraphIO io = new GraphIO();
		Graph g = new Graph(graphType,io);
		String f = GraphInputOutputDir.inputFileBase + name + ".txt" ;
		
		g.buildGraph(f) ;
		g.dumpGraph(name);
		f = GraphInputOutputDir.outputFileBase + name + ".dot" ;
		int v = g.numV() ;
		g.writeGraphAsDotFile(f);
		if (v < 25) {
			GraphInputOutputDir.dot2pdf(GraphInputOutputDir.outputFileBase + name);
		}
		if (v != enodes) {
			System.out.println("The graph has " + enodes + " Nodes. But you are telling " + v + " Nodes") ;
			u.myassert(v == enodes);
		}
		int e = g.numE();
		if (e != eedges) {
			System.out.println("The graph has " + eedges + " Edges. But you are telling " + e + " Edges") ;	
			u.myassert(e == eedges);
		}
	}
	
	
	private void test_build_graph() throws FileNotFoundException {
		build("13",GraphType.Type.UNDIRECTED,7,24);
		build("14",GraphType.Type.WEIGHTED_UNDIRECTED,6,20);
		build("15",GraphType.Type.DIRECTED,6,6);
		build("16",GraphType.Type.WEIGHTED_DIRECTED,5,6);
		build("loopparallel",GraphType.Type.WEIGHTED_DIRECTED,4,3);
		build("cat",GraphType.Type.DIRECTED,6,7);
		build("hd2",GraphType.Type.WEIGHTED_DIRECTED,78,1095);
	}
	
	private void testBed() throws FileNotFoundException {
		test_build_graph() ;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		//String s = outputFileBase + "output.txt";
		String s = "output.txt";
		if (false) { //Make it to true to write to a file
			System.out.println("Writing to " + s) ;
			try {
				System.setOut(new PrintStream(new FileOutputStream(s)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String version = System.getProperty("java.version");
		System.out.println("Java version used for this program is " + version);
    System.out.println("GraphTest.java starts");
    GraphTest g = new GraphTest() ;
    System.out.println("GraphTest.java Ends");
  }
}
	