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

import java.util.Set;

public class Path {
	
	//constructor
	Path(int identifier, Set<Integer> vertices, int distance)
	{
		this._identifier = identifier;
		this._vertices = vertices;
		this._distance = distance;
	}
	
	//private instance members
	private int _identifier;
	private Set<Integer> _vertices;
	private int _distance;
	
	//public instance methods
	public int GetDistance()
	{
		return this._distance;
	}
	
	public void AddVertex(int vertex)
	{
		this._vertices.add(vertex);
	}
	
	public int GetIdentifier()
	{
		return this._identifier;
	}

	//Overrides
	@Override
	public int hashCode()
    {    	
        return Integer.toString(this._identifier,2).hashCode();
    }
   
    @Override	    
    public boolean equals(Object o)
    {
        Path obj = (Path)o;
        if (obj == null)
            return false;
            
        return this._identifier == obj.GetIdentifier();
    }

}
