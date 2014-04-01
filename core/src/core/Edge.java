/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

/**
 *
 * @author charles.strong
 */
public class Edge {
    
    //constructor
    Edge(Vertex destination, int distance)
    {
        this._desintination = destination;
        this._distance = distance;
    }
    
    //private member variables    
    private Vertex _origin;
    private Vertex _desintination;
    private Integer _distance;
   
    //public instance methods
    public Vertex GetDestination()
    {
        return this._desintination;
    }
    
    public Vertex GetOrigin()
    {
        return this._origin;
    }
    
    public int GetDistance()
    {
        return this._distance;
    }
}
