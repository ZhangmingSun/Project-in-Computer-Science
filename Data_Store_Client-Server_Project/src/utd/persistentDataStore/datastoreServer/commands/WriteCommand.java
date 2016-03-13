package utd.persistentDataStore.datastoreServer.commands;

import java.io.IOException;

import org.apache.log4j.Logger;

import utd.persistentDataStore.utils.FileUtil;
import utd.persistentDataStore.utils.ServerException;
import utd.persistentDataStore.utils.StreamUtil;

public class WriteCommand extends ServerCommand
{
	private static Logger logger = Logger.getLogger(WriteCommand.class);
	
	@Override
	public void run() throws IOException, ServerException
	{		
		logger.debug("Start to write ...");
		
		try {
			// Because we have read the first line(CommandType) from inputStream, we directly read the second line
			String name = StreamUtil.readLine(inputStream);
			//logger.debug("name is " + name);		//It is just used for us to debug
			
			String length = StreamUtil.readLine(inputStream); // length need to be translated to "int" type	
			//logger.debug("length is " + length);	//It is just used for us to debug
			
			byte[] buffer = StreamUtil.readData(Integer.parseInt(length), inputStream);
			//for(int i=0; i<buffer.length; i++)	//It is just used for us to debug
				//logger.debug(buffer[i] + " ");
			
			FileUtil.writeData(name, buffer);
			sendOK();
			logger.debug("The writing has been successfully done.");
			
		} catch (Exception e) {
			sendError(e.getMessage());
			logger.debug("The writing process occur Exception!");
		}
	}
}
