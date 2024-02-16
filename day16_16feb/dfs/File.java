package dfs;

public class File                           //File class having properties of file
{
    String FileName;
    double FileSize;
    boolean isReplicated;

    public File(String fileName, double fileSize) {
        FileName = fileName;
        FileSize = fileSize;
        this.isReplicated = false;
    }
    public File(String fileName)
    {
        this.FileName=fileName;
    }
}
