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
    Edge(int origin, int destination, int distance)
    {
        this._origin = origin;
        this._desintination = destination;
        this._distance = distance;
    }
    
    //private member variables    
    private int _origin;
    private int _desintination;
    private int _distance;
   
    //public instance methods
    public int GetDestination()
    {
        return this._desintination;
    }
    
    public int GetOrigin()
    {
        return this._origin;
    }
    
    public int GetDistance()
    {
        return this._distance;
    }
    
    //now that I am using hashset for vertices I also whant to use it for this
    //"complex" HAHA object
    //this means I need to override GetHashCode and Equals
    public int GetHashCode()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(Integer.toString(this.GetOrigin(),2));
        builder.append(Integer.toString(this.GetDestination(),2));
        builder.append(Integer.toString(this.GetDistance(),2));
                        
        return builder.toString().hashCode();
    }
    
    public boolean equals(Object o)
    {
        Edge obj = (Edge)o;
        if (obj == null)
        {
            return false;
        }
    
        return this.GetOrigin() == obj.GetOrigin() &&
                this.GetDestination() == obj.GetDestination() &&
                this.GetDistance() == obj.GetDistance();
    }
}
