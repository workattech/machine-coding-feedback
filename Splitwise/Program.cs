// See https://aka.ms/new-console-template for more information
using System.Runtime.InteropServices.Marshalling;

Console.WriteLine("Hello, welcome to Splitwise!");
Manager manager = new();
manager.ShowBalances();
manager.ShowBalanceForUser("u1");
manager.SplitAmountEqually("u1",4,new string[] {"u1","u2","u3","u4"},1000);
manager.ShowBalanceForUser("u4");
manager.ShowBalanceForUser("u1");
manager.SplitAmountExactly("u1",2,new string[] {"u2","u3"},new int[] {370,880},1250);
manager.ShowBalances();