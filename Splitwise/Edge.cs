
/// <summary>
/// Generic implementation for an edge in a graph.
/// </summary>
/// <typeparam name="T"></typeparam>
public class Edge<T>
{

    public static bool SameEndpoints(Edge<T> edge, Edge<T> compareEdge) 
    {
        return edge.From.Equals(compareEdge.From) && edge.To.Equals(compareEdge.To);
    }

    public Edge(Node<T> start,Node<T> end)
    {
        From= start;
        To = end;
    }

    public Edge(Node<T> start,Node<T> end, int amount)
    {
        From= start;
        To = end;
        Owes = amount;
    }
    public int Owes { get; set; } = 0;
    public Node<T> From { get; set; }
    public Node<T> To { get; set; }

}