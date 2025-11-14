const readline = require("readline");
const { isUUID } = require("./utils");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const askQuestion = () => {
  return new Promise((resolve) => {
    rl.question(queryObjects, resolve);
  });
};

const main = async () => {
  try {
    const boards = {};
    const lists = {};
    const cards = [];
    const users = [];
    while (true) {
      const line = await askQuestion(">");
      if (line.trim() === "") break;
      const tokens = line.split(" ");
      if (tokens[0] === OPERATIONS.SHOW) {
        if (tokens.size() === 1) {
          if (boards?.size() == 0) console.log("No Boards \n");
          else
            console.log(
              Object.keys(boards).map((boardId) =>
                boards[boardId].getBoardDetails()
              )
            );
        } else {
          if (tokens[1] === ENTITIES.BOARD) {
            console.log(boards[tokens[2]].getBoardDetails());
          } else if (tokens[1] === ENTITIES.LIST) {
            console.log(lists[tokens[2]].getListDetails());
          } else if (tokens[1] === ENTITIES.CARD) {
            console.log(cards[tokens[2]].getCardDetails());
          }
        }
      } else {
        if (tokens[0] === ENTITIES.BOARD) {
          if (isUUID(tokens[1])) {
          } else if (tokens[1] === OPERATIONS.DELETE) {
          }
        }
      }
    }

    rl.close();
  } catch (error) {
    console.log("Error >>>>", error);
    rl.close();
  }
};

main();
