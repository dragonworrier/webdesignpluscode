// You will need to specify the full package when creating functions based on 
// the classes in your library.
package com.webdesignpluscode.www;
// Import all of the Vertica SDK 
import com.vertica.sdk.*;

public class StringConcatenationFactory extends ScalarFunctionFactory
{
    @Override
    public void getPrototype(ServerInterface srvInterface,
                             ColumnTypes argTypes,
                             ColumnTypes returnType)
    {
        argTypes.addVarchar();
        argTypes.addVarchar();
        returnType.addVarchar();
    }

    @Override
    public void getReturnType(ServerInterface srvInterface,
            SizedColumnTypes argTypes,
            SizedColumnTypes returnType){
        returnType.addVarchar(
        // Output will be no larger than the input.
        argTypes.getColumnType(0).getStringLength() + argTypes.getColumnType(1).getStringLength(), "StringConcatenationFactory");
    }

    @Override
    public ScalarFunction createScalarFunction(ServerInterface srvInterface)
    {
        return new StringConcatenation();
    }
              
}
