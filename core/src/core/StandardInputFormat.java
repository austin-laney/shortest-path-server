/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/**
 *
 * @author charles.strong
 */
public class StandardInputFormat {
    //constructor
    StandardInputFormat(InputStream stream) throws IOException{
        int index = 1;
            byte[] data = new byte[2]; //two byte (16 bit) increments
            while( stream.read( data )  != -1 )  { //read input to end
                ByteBuffer buffer = ByteBuffer.wrap( data )
                                              .order(ByteOrder.BIG_ENDIAN);

                short value = buffer.getShort();
                //Cycle threw data and assign vertices and edges
                if(index > 3){//edge data                
                    int sub = (index % 3);
                    switch(sub){
                        case 1:
                            //edge origin  = value
                            break;
                        case 2:
                            //edge destination = value
                            break;
                        default:
                            //edge distance = value
                            break;
                    }
                } else {//sudo header data
                    switch(index){
                        case 1:
                            //start vertex = value
                            break;
                        case 2:
                            //end vertex = value
                            break;
                        default:
                            //edge count = value
                            break;
                    }
                }
            }
            index++;
    }
    
    private int _startingVertexIdentifier;
    private int _endingVertexIdentifier;
    private int _numberOfGraphEdges;
    private List<Edge> _graphEdges;
    
    //public instance methods
    public int GetStartingVertexIdentifier()
    {
        return this._startingVertexIdentifier;
    }
    
    public int GetEndingVertexIdentifier()
    {
        return this._endingVertexIdentifier;
    }
    
    public int GetNumberOfGraphEdges()
    {
        return this._numberOfGraphEdges;
    }
    
    public List<Edge> GetGraphEdges()
    {
        return this._graphEdges;
    }
    
}
