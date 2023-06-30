// See https://aka.ms/new-console-template for more information
Console.WriteLine("Hello, to S%L game");
Game game = new Game();

// Adding snakes
Console.WriteLine($"Enter the number of snakes");
var noOfSnakes = Console.ReadLine();
Console.WriteLine($"There are {noOfSnakes} snakes");
for (int i = 0; i < int.Parse(noOfSnakes); i++)
{
    var positions = Console.ReadLine().Split().Select(s => int.Parse(s)).ToList();
    game.AddSnake(new Snake(positions[0], positions[1]));
}
// Adding Ladders
Console.WriteLine($"Enter the number of ladders");
var noOfLadders = Console.ReadLine();
Console.WriteLine($"There are {noOfLadders} ladders");
for (int i = 0; i < int.Parse(noOfLadders); i++)
{
    var positions = Console.ReadLine().Split().Select(s => int.Parse(s)).ToList();
    game.AddLadder(new Ladder(positions[0], positions[1]));
}

// Adding Players
Console.WriteLine($"Enter the number of players");
var noOfPlayers = Console.ReadLine();
Console.WriteLine($"There are {noOfPlayers} players");
for (int i = 0; i < int.Parse(noOfPlayers); i++)
{
    var name = Console.ReadLine();
    game.AddPlayer(new Player(name));
}

game.StartGame();

