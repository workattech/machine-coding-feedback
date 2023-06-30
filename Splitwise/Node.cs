using System.Runtime;

public class Node<T>
{
    public bool HasNoEdge => Edges == null;
    public Node(T value)
    {
        Value = value;
    }
    public T Value { get; }
    public List<Edge<T>>? Edges { get; set; }

    public void AddEdge(Edge<T> edge)
    {
        if(Edges == null)
        {
            Edges = new()
            {
                edge
            };
            return;
        }

        var sameEdge = Edges.SingleOrDefault(e => Edge<T>.SameEndpoints(e,edge));
        if(sameEdge != null)
        {
            if(sameEdge.To != this)
            {
                sameEdge.Owes += edge.Owes;
            }
        }
        else
        {
            Edges.Add(edge);
        }

        //TODO: 
    }

}