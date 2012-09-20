import java.io.*;

/**
 * OutStringFile makes file writing simpler. It allows
 * information to be written one line at a time to a
 * data file, as a String.
 * @author CS1027
 */
public class OutStringFile {
   
    /**
     * the handle to write to the file
     */
    private BufferedWriter out;
    
	 /**
     * Constructs the object that controls file writing
     * Exits gracefully if unable to write to file
     * @param filename the name of the file to be written to
     */
    public OutStringFile(String filename) {   
        try {   	
          out = new BufferedWriter(new FileWriter(filename));
        }
        catch (IOException e){
           System.out.println("File " + filename + " cannot be written.");
           System.exit(0);
	  }
    }

    /**
     * Writes a line of output as a String
     * Exits gracefully if an error occurs while writing the file
     * @param the line to be written
     */ 
    public void write(String line) {
      try {
    	  out.write(line);
      }
      catch (IOException e){
         System.out.println("File cannot be written.");
         System.exit(0);
      }
	}

    /**
     * Closes the file (making it inaccessible though this OutStringFile)
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

