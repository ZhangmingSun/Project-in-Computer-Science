package utd.persistentDataStore.datastoreServer.commands;

import java.io.IOException;

import org.apache.log4j.Logger;

import utd.persistentDataStore.utils.FileUtil;
import utd.persistentDataStore.utils.ServerException;
import utd.persistentDataStore.utils.StreamUtil;

public class ReadCommand extends ServerCommand{
	private static Logger logger = Logger.getLogger(WriteCommand.class);
	
	@Override
	public void run() throws IOException, ServerException {
		logger.debug("Start to read ...");
		
		try {
			// Because we have read the first line(CommandType) from inputStream, 
			// so we directly read the second line
			String name = StreamUtil.readLine(inputStream);
			//We need to read data from local data warehouse, 
			byte[] AllData = FileUtil.readData(name);		
			if(AllData.length > 0)	//if there exists data
			{
				sendOK();
				//Because it only contains data, so we need to calculate the length of data
				String DataSize = AllData.length + "\n";
				StreamUtil.writeLine(DataSize, outputStream);
				StreamUtil.writeData(AllData, outputStream);
				logger.debug("The reading has been successfully done.");
			}	
		} catch (Exception e) {
			sendError(e.getMessage());
			new ServerException("It fails for us to read!");
			logger.debug("The reading occurs Exception!");
		}
	}
}
