// You will need to specify the full package when creating functions based on 
// the classes in your library.
package com.webdesignpluscode.www;
// Import all of the Vertica SDK 
import com.vertica.sdk.*;

public class StringConcatenation extends ScalarFunction
{
	@Override
	public void processBlock(ServerInterface srvInterface,
							 BlockReader argReader,
							 BlockWriter resWriter)
				throws UdfException, DestroyInvocation
	{
		do {
			// The input and output objects have already loaded
			// the first row, so you can start reading and writing 
			// values immediately.
			
			// Get the two string arguments from the BlockReader
			String firstParam = argReader.getString(0);
			String secondParam = argReader.getString(1);
			
			// Process the arguments and come up with a result. 
			String result  = firstParam + secondParam;

			// Write the string output value.
			resWriter.setString(result);
			
			// Advance the output BlocKWriter to the next row.
			resWriter.next();
		
			// Continue processing input rows until there are no more.
		} while (argReader.next());
	}
}
