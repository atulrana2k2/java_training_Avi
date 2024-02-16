package dfs;

import dfs.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Server   {                                         //class Server containing properties of Server
    int ServerId;
    List<File> files=new ArrayList<>();

    public Server(int serverId) {                       //constructor of Server object
        ServerId = serverId;
    }
        public boolean fileExists(String FileName)                  //function to check weather file exist in the system or not
        {
            for(File file:files)
            {
                if(Objects.equals(file.FileName, FileName))
                    return true;
            }
            return false;
        }
        public void UploadFile(File file)                   //function to upload a file to the files list
        {
            files.add(file);
            System.out.println("File added Successfully");
        }
        public void downloadFile(String FileName)               //function to download a file from a server
        {
            for(File file:files)
            {
                if(Objects.equals(file.FileName,FileName))
                {
                    System.out.println("File is Downloaded");
                    return;
            }}
            System.out.println("File Not Found");
        }
        public void replicateServer(File file , Server Desitnationserver) //function to replicate a file in a different server
        {
            Desitnationserver.UploadFile(file);
            file.isReplicated=true;
        }
}
