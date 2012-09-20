
import java.io.*;
/**
 * InputFileHandler objects simplify the reading of Strings and ints
 * from a text file.
 */
public class InputFileHandler
{

    private BufferedReader in;
    private String nextLine;


    /**
     * Construct an object that allows transactions to be read from a 
     * given file
     * @param inputFile The name of the file containing the transactions
     */

    public InputFileHandler(String inputFile)
    {
        /* open the file, and store its first line in nextLine */
        try {   
            in = new BufferedReader(new FileReader(inputFile));
            nextLine = in.readLine();
        }catch (FileNotFoundException ee){
        }catch (IOException e){
        }
    }



    /**
     * Private method to read in the next line from the transaction file
     */
    private void fetchNextLine()
    {
        try {
            nextLine = in.readLine();
        }catch (IOException e){}
    }



    /**
     * Retrieve the next line of text from the input file
     * @return The next line from the input file; if
     * the end of file has been reached, return null instead.
     */

    public String getNextLine()
    {

        /* if end of file has been reached, return null to indicate the fact */
        if (nextLine == null)
            return null;
	/* otherwise, return a copy of the next line from the file, and
	   step to the next line of the file */

	String result = new String(nextLine);
	fetchNextLine();
	return result;
    }



    /** 
     * Get an integer from the input file.
     * Precondition: The integer has to be on a line by itself
     * @return The integer just read in
     */
    public int getInt()
    {
        int value = Integer.parseInt(nextLine);
        fetchNextLine();
        return value;
    }


    /**
     * Closes the file (making it inaccessible though this InputFileHandler)
     */
    public void close(){
       try {
          in.close();
          in = null;
       }
       catch (IOException e){
           System.out.println("Problem closing file.");
           System.exit(0);
       }
    }


}
