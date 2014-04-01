/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author charles.strong
 */
public class Vertex {
    
    //constructor
    Vertex(int Identifier)
    {
        this._edges = new ArrayList<Edge>();
        this._identifier = Identifier;
    }
    
    //private member variables
    private List<Edge> _edges;
    private Integer _identifier;
        
    //private internal methods
    
    //public instance methods
    public int GetIdentifier()
    {
        return this._identifier;
    }
    
    public void AddEdge(Edge edge)
    {
        this._edges.add(edge);
    }
    
    public void AddEdge(Vertex destination, int distance)
    {
        this._edges.add(new Edge(destination, distance));
    }
    
}
