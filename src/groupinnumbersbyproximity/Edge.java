 // A class to represent a graph edge
package groupinnumbersbyproximity;

/**
 *
 * @author Daniel Dias
 */
public class Edge implements Comparable<Edge>{
   
        int src, dest, weight; // src-> source vertice & dest-> destiny vertice
        
    
        // Comparator function used for sorting edges based on
        // their weight
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }

    @Override
    public String toString() {
        return ("Edge: (" + src + " ; " + dest + ") - Weight:  " + weight );
    }
        
        
  
}
