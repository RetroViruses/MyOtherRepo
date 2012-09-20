
import java.io.*;
/**
 * OutputFileHandler objects simplify the writing of Strings 
 * to a text file.
 */
public class OutputFileHandler
{

    private BufferedWriter out;


    /**
     * Construct an object that allows Strings to be written to a 
     * given file
     * @param outputFile The name of the file to be written to
     */

    public OutputFileHandler(String outputFile)
    {
        /* open the file */
        try {   
            out = new BufferedWriter(new FileWriter(outputFile));
        }catch (IOException e){
            System.out.println("Problem opening output file.");
            System.exit(0);
        }
    }




    /**
     * Print a line of text to the output file
     */

    public void writeLine(String s)
    {
	try {
	    out.write(s, 0, s.length());
	    out.newLine();
	} catch (IOException e) { }

    }




    /**
     * Closes the file (making it inaccessible though this OutputFileHandler)
     */
    public void close(){
       try {
          out.close();
          out = null;
       }
       catch (IOException e){
           System.out.println("Problem closing file.");
           System.exit(0);
       }
    }


}
