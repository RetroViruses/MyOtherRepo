import java.util.Iterator;
public class FrequencyTreeTester
{
    public static void main(String[] args)
    {
        InputFileHandler treeFile = new InputFileHandler("tree1.txt");
        
        int arraySize = treeFile.getInt();
        String shapeDescriptor = treeFile.getNextLine();
        
        String[] wordList = new String[arraySize];
        int[] wordFrequencies = new int[arraySize];
        for (int k = 0; k < arraySize; k++)
        {
            wordList[k] = treeFile.getNextLine();
            wordFrequencies[k] = treeFile.getInt();
        }
        
        FrequencyTree<String> wordTree = new FrequencyTree<String>();
        wordTree.buildTree(shapeDescriptor);
        wordTree.fillTree(wordList, wordFrequencies);
        
        System.out.println("After building initial tree from tree1.txt:\n");
        System.out.println("  Tree size: " + wordTree.size());
        System.out.println("  Tree shape: " + wordTree.getShape());
        System.out.println("\nInOrder list of words and frequencies:\n\n"
                + wordTree.toStringInOrder());
        System.out.println("\nPreOrder list of words and frequencies:\n\n"
                + wordTree.toStringPreOrder());
        
        System.out.println("\nLevelOrder list of words only:\n");
        Iterator<String> scan = wordTree.iteratorLevelOrder();
        while (scan.hasNext())
            System.out.println(scan.next());
        
        System.out.println("\nPostOrder list of words only:\n");
        scan = wordTree.iteratorPostOrder();
        while (scan.hasNext())
            System.out.println(scan.next());    
        
        InputFileHandler wordFile = new InputFileHandler("words1.txt");
        String nextWord = wordFile.getNextLine();
        while (nextWord != null)
        {
            wordTree.addElement(nextWord);
            nextWord = wordFile.getNextLine();
        }
        wordFile.close();
        treeFile.close();
        
        System.out.println("\nAfter adding words from words1.txt:\n");
        System.out.println("  Tree size: " + wordTree.size());
        System.out.println("  Tree shape: " + wordTree.getShape());
        System.out.println("\nInOrder list of words and frequencies:\n\n"
                + wordTree.toStringInOrder());
        
        OutputFileHandler treeOutputFile = new OutputFileHandler("tree2.txt");
        wordTree.writeTreeToFile(treeOutputFile);
        treeOutputFile.close();
    

        
        treeFile = new InputFileHandler("tree2.txt");
        arraySize = treeFile.getInt();
        shapeDescriptor = treeFile.getNextLine();
        
        wordList = new String[arraySize];
        wordFrequencies = new int[arraySize];
        for (int k = 0; k < arraySize; k++)
        {
            wordList[k] = treeFile.getNextLine();
            wordFrequencies[k] = treeFile.getInt();
        }
        
        wordTree = new FrequencyTree<String>();
        wordTree.buildTree(shapeDescriptor);
        wordTree.fillTree(wordList, wordFrequencies);
        
        System.out.println("After building initial tree from tree2.txt:\n");
        System.out.println("  Tree size: " + wordTree.size());
        System.out.println("  Tree shape: " + wordTree.getShape());
        System.out.println("\nInOrder list of words and frequencies:\n\n"
                + wordTree.toStringInOrder());
        
        wordFile = new InputFileHandler("words2.txt");
        nextWord = wordFile.getNextLine();
        while (nextWord != null)
        {
            wordTree.addElement(nextWord);
            nextWord = wordFile.getNextLine();
        }
        wordFile.close();
        treeFile.close();
        
        System.out.println("\nAfter adding words from words2.txt:\n");
        System.out.println("  Tree size: " + wordTree.size());
        System.out.println("  Tree shape: " + wordTree.getShape());
        System.out.println("\nInOrder list of words and frequencies:\n\n"
                + wordTree.toStringInOrder());
        
        treeOutputFile = new OutputFileHandler("tree3.txt");
        wordTree.writeTreeToFile(treeOutputFile);
        treeOutputFile.close();

        wordTree = new FrequencyTree<String>();
        wordFile = new InputFileHandler("words3.txt");
        nextWord = wordFile.getNextLine();
        while (nextWord != null)
        {
            wordTree.addElement(nextWord);
            nextWord = wordFile.getNextLine();
        }
        wordFile.close();
        System.out.println("\nAfter building new tree from words3.txt:\n");
        System.out.println("  Tree size: " + wordTree.size());
        System.out.println("  Tree shape: " + wordTree.getShape());
        System.out.println("\nInOrder list of words and frequencies:\n\n"
                + wordTree.toStringInOrder());
        
        treeOutputFile = new OutputFileHandler("tree4.txt");
        wordTree.writeTreeToFile(treeOutputFile);
        treeOutputFile.close();

    }
}

