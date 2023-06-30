using System.Dynamic;
using System.Security.Cryptography;

public class Manager
{
    public Dictionary<string,Node<User>> Users = new();

    public Manager()
    {
        InitializeUsers();
    }

    private void InitializeUsers()
    {
        Users.Add("u1",new Node<User>(new User("u1","User1")));
        Users.Add("u2",new Node<User>(new User("u2","User2")));
        Users.Add("u3",new Node<User>(new User("u3","User3")));
        Users.Add("u4",new Node<User>(new User("u4","User4")));
    }


    public void ShowBalanceForUser(string userId)
    {
        var node = Users[userId];

        if(node == null)
        {
            throw new Exception();
        }

        if(node.HasNoEdge)
        {
            Console.WriteLine("No balances");
            return;
        }

        foreach(Edge<User> edge in node.Edges!)
        {
            var payer = edge.From.Value;
            var payee = edge.To.Value;
            Console.WriteLine($"The {payee.Name} owes {payer.Name}:{edge.Owes}");
        }

    }

    public void ShowBalances()
    {
        var visitedEdges = new HashSet<Edge<User>>();
        foreach(var(k,v) in  Users)
        {
            var edges = v.Edges;

            if(edges == null)
            {
                Console.WriteLine($"No balances for user {v.Value.Name}");
                continue;
            }

            var newEdges = edges!.Where(e => !visitedEdges.Contains(e));

            foreach(Edge<User> newEdge in newEdges)
            {
                var payer = newEdge.From.Value;
                var payee = newEdge.To.Value;
                Console.WriteLine($"The {payee.Name} owes {payer.Name}:{newEdge.Owes}");
                visitedEdges.Add(newEdge);
            }

        }

    }

    private void AddExpense(string fromId, string toId, int amount)
    {
        if(fromId.Equals(toId))
        {
            return;
        }

        var from = Users[fromId];
        var to = Users[toId];

        var newEdge = new Edge<User>(from,to,amount);

        from.AddEdge(newEdge);
        to.AddEdge(newEdge);
    }

    public void SplitAmountEqually(string payerId,int noOfPayees,string[] payeeIds,int amount)
    {
        if(noOfPayees != payeeIds.Count())
        {
            throw new Exception();
        }

        var splitamt  = amount/noOfPayees;

        foreach(string payeeId in payeeIds)
        {
            AddExpense(payerId,payeeId,splitamt);
        }
    }

    public void SplitAmountExactly(string payerId,int noOfPayees,string[] payeeIds,int[] splitamts,int totalamt)
    {
        if(noOfPayees != payeeIds.Length)
        {
            throw new Exception();
        }

        if(noOfPayees != splitamts.Length)
        {
            throw new Exception();
        }

        if(totalamt != splitamts.Sum())
        {
            throw new Exception();
        }

        for(int i=0;i<splitamts.Length;i++)
        {
            AddExpense(payerId,payeeIds[i],splitamts[i]);
        }

    }

    public void SplitAmountByPercent(string payerId,int noOfPayees,string[] payeeIds,int[] percentamts,int amount)
    {
        if(percentamts.Sum() != 100)
        {
            throw new Exception();
        }

        if(noOfPayees != percentamts.Length)
        {
            throw new Exception();
        }

        for(int i=0;i<payeeIds.Length;i++)
        {
            int splitamt = amount * (percentamts[i]/100);
            AddExpense(payerId,payeeIds[i],splitamt);
        }

    }







    
}