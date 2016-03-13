package utd.persistentDataStore.datastoreServer.commands;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import utd.persistentDataStore.utils.FileUtil;
import utd.persistentDataStore.utils.ServerException;
import utd.persistentDataStore.utils.StreamUtil;

public class DirectoryCommand extends ServerCommand
{
	private static Logger logger = Logger.getLogger(DirectoryCommand.class);
	
	@Override
	public void run() throws IOException, ServerException 
	{
		logger.debug("Start to directory ...");
		try {
			List<String> ListDirectory = FileUtil.directory();
			sendOK();
			// First we need to send the size of the list
			StreamUtil.writeLine(ListDirectory.size() + "\n", outputStream);
			
			for(int i=0; i<ListDirectory.size(); i++)
			{
				StreamUtil.writeLine(ListDirectory.get(i) + "\n", outputStream);
				//The following is used for debug and test
				//System.out.println(i+": "+ListDirectory.get(i));
			}
			logger.debug("The directorying has been successfully done.");
		} catch (Exception e) {
			// TODO: handle exception
			sendError(e.getMessage());
			logger.debug("The directorying occurs Exception!");
		}
	}
}
