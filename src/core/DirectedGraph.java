/*
 * This file is part of Shortest-Path-Server.
 * 
 * Copyright (c) 2014 Charles Strong
 * 
 * Shortest-Path-Server is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * Shortest-Path-Server is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Shortest-Path-Server.
 * If not, see http://www.gnu.org/licenses/.
 */

package core;

import java.util.Map;
import java.util.Set;

/*
 * @author charles.strong
 */
public class DirectedGraph {
    
    //constructor
    public DirectedGraph(Map<Integer,Vertex> vertices, Set<Edge> edges)
    {
        this._isAcyclic = NullableBoolean.NOTSET;
        this._vertices = vertices;
        this._edges = edges;
        
        //determine if is acyclic
        this.IsAcyclic();
       
    }
    
    //private member variables
    private NullableBoolean _isAcyclic;
    
    private Map<Integer,Vertex> _vertices;
    private Set<Edge> _edges;
      
    //public methods
    public boolean IsAcyclic()
    {
        //A directed graph can be Acyclic only if there are no Directed loops
        //Meaning you cannot start and return to any given vertex
        //(following path direction)
        
        if(this._isAcyclic == NullableBoolean.NOTSET)
        	this._isAcyclic = NullableBoolean.TRUE;
        	//add logic to determine if this DirectedGraph is acyclic
        	//currently unneeded because we are told that all input graphs are acyclic
        	//but if you would like to expand the program this makes it possible.
        	//for now just set to true
        
        return (this._isAcyclic == NullableBoolean.TRUE);
    }
    
    public int GetGraphSize()//Graph size is defined as the number of edges in a directed graph
    {
    	return this._edges.size();
    }
    
    public int GetGraphOrder()//graph order is defined as the number of vertices in a graph
    {
    	return this._vertices.size();
    }
      
    public Map<Integer,Vertex> GetVertices()
    {
        return this._vertices;
    }
    
    public Set<Edge> GetEdges()
    {
        return this._edges;
    }    
    
    public String FindShortestPath(int origin, int destination)
    {
        if(!this.IsAcyclic())
            return "Error: Graph is not acyclic" ;//Add error: We only want Acyclic Graphs ** possible future use
        
        Vertex startVertex = this.GetVertexWithIdentifier(origin);
        
        startVertex.SetDistanceToOrigin(0);
        startVertex.SetAsUnChecked();
                
        int totalDistance = Integer.MAX_VALUE;
        
        String decision = "";
        
        //quick answers
    	//is the start also the end?
        if(origin == destination)
        {
    		totalDistance = 0;
    		decision = String.format(ResultStrings.START_END_EQUAL, origin, destination);
        }
    	else//is the end directly connected to the start via a single edge?
    	{
    		//we can assume this is correct because the distances are all unsigned integers 
    		//All paths will be positive
    		for(Edge edge : startVertex.GetEdges())
    		{
    			if(edge.GetDestination() == destination)
    			{
    				totalDistance = edge.GetDistance();
    				decision = String.format(ResultStrings.START_CONNECTED_TO_END, origin, destination, totalDistance);
    			}
    		}
    	}

        if(totalDistance == Integer.MAX_VALUE)
        {
        	//Soooooo.. Started with Dijkstra's solution. Studied a MIT lecture and materials on shortest k algorithms
        	//Decided to start over implement Bellman-Ford's algorithm. After rewriting 2/3 of all of the solution items
        	//I started another lecture
        	//and I changed my mind and went back to Dijkstra's...
        	//Given the input this is the most straight forward approach to solving the problem 
        	//if we were to have negative edge distances or the possibility of negative cycles
        	//Bellman-Ford would be a better solution
            for (Vertex vertex : this._vertices.values()) {
            	if(!vertex.HasBeenChecked())
            	{
	              Vertex nextVertex = this.GetNextVertex();
	              nextVertex.SetAsChecked();
	              this.CheckDestinations(nextVertex);
            	}
            }
        	
            //read the results
        	Vertex vertex = this.GetVertexWithIdentifier(destination);
        	totalDistance = vertex.GetDistanceToOrigin();
    		String result = Integer.toString(destination);
    		while( vertex.GetPreviousVertexIdentifier() != Integer.MIN_VALUE && vertex.GetPreviousVertexIdentifier() != origin )
    		{
    			vertex = this.GetVertexWithIdentifier(vertex.GetPreviousVertexIdentifier());
    			result = String.format(ResultStrings.PATH_FOUND, vertex.GetIdentifier(), result);
    		}
    		if( vertex.GetPreviousVertexIdentifier() == Integer.MIN_VALUE )
    			decision = String.format(ResultStrings.PATH_NOT_FOUND, origin, destination);
    		
    		else
    			decision = String.format("%d->%s (%d)",origin, result, totalDistance);
        	
        }
        
        //return the results
        return decision;
    }

    //private methods
    
    private Vertex GetVertexWithIdentifier(int identifier)
    {
    	return this._vertices.get(identifier);
    }
    
    private Vertex GetNextVertex()
    {
        Vertex nextVertex = null;
        for (Vertex vertex : this._vertices.values()) {
        	if(!vertex.HasBeenChecked())
        	{
	          if (nextVertex == null)
	        	  nextVertex = vertex;
	          
	          else
	          {
	            if (vertex.GetDistanceToOrigin() < nextVertex.GetDistanceToOrigin()) 
	            	nextVertex = vertex;
	            
	          }
        	}
        }
        return this.GetVertexWithIdentifier(nextVertex.GetIdentifier());
    }
    
    public void CheckDestinations(Vertex origin)
    {
    	for(Edge edge : origin.GetEdges())
    	{
    		 Vertex workingVertex = this.GetVertexWithIdentifier(edge.GetDestination());
			 if (workingVertex.GetDistanceToOrigin() > origin.GetDistanceToOrigin() + edge.GetDistance())
			 {
				 	workingVertex.SetDistanceToOrigin(origin.GetDistanceToOrigin() + edge.GetDistance());
		            workingVertex.SetPreviousVertexIdentifier(origin.GetIdentifier());
		            workingVertex.SetAsUnChecked();
		     }
    	}    	
    }
    
}
