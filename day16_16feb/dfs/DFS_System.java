package dfs;

import java.util.ArrayList;
import java.util.List;

public class DFS_System {                                               //Dfs class having functionalities
    List<Server>serverList;

    public DFS_System() {                       //constructor to DFS_System class
        serverList = new ArrayList<>();
    }

    public void addServer(Server serverN)                                   //function to add server
    {
        for(Server server:serverList) {
            try {
                if (serverN.ServerId == server.ServerId) {
                   throw new dfsException("Server with this id Already exist");
                }
            }
            catch (dfsException e)
            {
                System.out.println(e.getMessage());
                return;
            }
        }
        serverList.add(serverN);
        System.out.println("   Server Added Successfully    ");
    }
    public void uploadFile(File file,int serverID)                                      //function to upload file in a server
    {
        try{
            for(Server server1:serverList)
            {
                if(server1.ServerId==serverID)
                {
                    server1.UploadFile(file);
                    return;
                }
            }
            throw new dfsException("This Server does not exist");

        }
        catch (dfsException e)
        {
            System.out.println(e.getMessage());
            return;
        }
    }
    public void downloadFile(String File_Name,int serverId)         //function to download a file from the server
    {
        try{
            for(Server server1:serverList)
            {
                if(server1.ServerId==serverId)
                {
                    server1.downloadFile(File_Name);
                    return;
                }
            }
            throw new dfsException("This Server does not exist");

        }
        catch (dfsException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void replicateFile(File file ,int ServerIds,int ServerIdd)           //function to replicate one file from a server to another server
    {
        Server s=null;
        int flag=0;
        boolean check=false;
        boolean flag2=false;
        boolean check2=false;
            for(Server server1:serverList)
            {
                if(server1.ServerId==ServerIds) {
                    check=true;
                    if (server1.fileExists(file.FileName)) {
                        flag+=1;
                        flag2=true;
                    }
                }
                if(server1.ServerId==ServerIdd)
                {
                    check2=true;
                    flag+=1;
                     s=server1;
                }
            }
            if(!check)
            {
                System.out.println("Source Server does not exist");
                return;
            } else if (!check2) {
                System.out.println("Desitination Server does not exist");
                return;

            }

              else  if(flag==2)
            {
                s.replicateServer(file,s);
                return;
            }
            else {
                    System.out.println("File not exist in the source server");
            }




    }
}
