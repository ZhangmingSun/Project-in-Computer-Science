package utd.persistentDataStore.datastoreServer.commands;

import java.io.IOException;

import org.apache.log4j.Logger;

import utd.persistentDataStore.utils.FileUtil;
import utd.persistentDataStore.utils.ServerException;
import utd.persistentDataStore.utils.StreamUtil;

public class DeleteCommand extends ServerCommand{
	private static Logger logger = Logger.getLogger(DeleteCommand.class);
	
	@Override
	public void run() throws IOException, ServerException {
		// TODO Auto-generated method stub
		logger.debug("Start to delete ...");
		
		String readName = StreamUtil.readLine(inputStream);
		Boolean result = FileUtil.deleteData(readName);
		
		if(result == true)
		{
			sendOK();
			logger.debug("The deleting has been successfully done.");
		}else
		{
			sendError("There is no such file!");
			//throw new ServerException("The deleting is failed!");
		}
	}
	
}
