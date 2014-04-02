/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.util.Set;
/**
 *
 * @author charles.strong
 */
public class DirectedGraph {
    
    //constructor
    DirectedGraph(Set<Integer> vertices, Set<Edge> edges)
    {
        this._isAcyclic = NullableBoolean.NOTSET;
        this._vertices = vertices;
        this._edges = edges;
        
        //determine if is acyclic
        this.IsAcyclic();
       
    }
    
    //private member variables
    private NullableBoolean _isAcyclic;
    
    private Set<Integer> _vertices;
    private Set<Edge> _edges;
      
    //public methods
    public boolean IsAcyclic()
    {
        //A digraph can be Acyclic only if there are no Directed loops
        //Meaning you cannot start and return to any given vertex
        //(following path direction)
        
        if(this._isAcyclic == NullableBoolean.NOTSET)
        {
            //add logic to determine if this DirectedGraph is acyclic
        }
        
        return (this._isAcyclic == NullableBoolean.TRUE);
    }
      
    public Set<Integer> GetVertices()
    {
        return this._vertices;
    }
    
    public Set<Edge> GetEdges()
    {
        return this._edges;
    }
    
    public int GetNumberOfEdges()
    {
        return this._edges.size();
    }
    
    public void FindShortestPath(int origin, int destination)
    {
        if(!this.IsAcyclic())
            return;//Add error: Wee only want Acyclic Graphs
       
    }
    
}
