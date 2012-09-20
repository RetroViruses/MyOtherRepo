
import java.io.*;

public class FileExample
{

    public static void main(String args[]) {


	
	InputFileHandler infile = new InputFileHandler("employees.txt");
	OutputFileHandler outfile = new OutputFileHandler("copy.txt");

	String s = infile.getNextLine();
	while ( s != null) {
	    outfile.writeLine(s);
	    s = infile.getNextLine();
	}
	infile.close();
	outfile.close();
    }
}

