package pl.edu.agh.xp.files;

public interface FileManagerInterface {

    void openFile(String filePath);
    void closeFile();

    String readLine();
    String readLine(int lineNumber);

    void writeLine(String line);
    void updateLine(int lineNumber, String line);
}
