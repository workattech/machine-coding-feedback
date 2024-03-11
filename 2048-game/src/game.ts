import { Board } from "board";
import { Player } from "player";
import PromptSync from "prompt-sync";

const prompt = PromptSync();

class Game{
    player : Player;
    board : Board;
    constructor(){
        let size = parseInt(prompt('you can change grid size default is 4 * 4 '));
        let winNumber = parseInt(prompt('you can change the wining number default is 2048 '));
        this.board = new Board( size , winNumber);
    }

    startGame(){
        console.log('if want to quit the game press c ')
        let p = prompt('enter your name ');

        while (true){
            this.board.printBoard();
            let direction = prompt('Enter direction to slide ');

            if (direction == 'c'){
                this.restart();
                break;
            }

            this.board.directionMove(direction);

            let isEmptySpot = this.board.isEmptySpot();

            if(!isEmptySpot){
                this.board.addTile();
            }
            let isLost : boolean = this.board.isLost();

            if (isLost && isEmptySpot){
                this.board.printBoard();
                console.log('Game Over !!!')
                this.restart();
                return
            }


            let isWinner : boolean = this.board.isWinner();

            if(isWinner){
                this.board.printBoard();
                console.log('Congratulations !!!');
                this.restart()
                return;
            }
            
            
            
        }
    }

    restart(){
        let q = prompt('do want to restart game type yes or no ');
        if (q == 'yes'){
            this.startGame();
        }

    }
}

const game = new Game();
game.startGame();