import { Bottom, Left, Right, Top, direaction } from "move";

export class Board{
    board : (number | null)[][] = [];
    size : number;
    winNumber : number = 2048;
    baseNumber : number = 2;
    constructor(size : number , winNumber : number){
        this.size = size;
        for(let i = 0 ; i < size; i++){
            let temp = new Array(size).fill(null);
            this.board.push(temp);
        }

        this.winNumber = winNumber
      
        this.inilizeBoard();


    }

    isWinner() : boolean{
        for(let i = 0 ; i < this.size ; i++){
            for(let j = 0 ; j < this.size ; j++){
                if(this.board[i][j] == this.winNumber){
                    return true;
                }
            }
        }
        return false;
    }

    checkDirection(r : number , c : number):boolean{
        // check for four direction

        let top = false;
        let bottom = false;
        let left = false;
        let right = false;
        if (r-1 >= 0 && this.board[r][c] == this.board[r-1][c]){
            top = true;
        }
        if (r+1 < this.size && this.board[r][c] == this.board[r+1][c]){
            bottom = true;
        }
        if (c-1 >= 0 && this.board[r][c] == this.board[r][c-1]){
            left = true;
        }
        if (c+1 < this.size && this.board[r][c] == this.board[r][c+1]){
            right = true;
        }
        return top || bottom || left || right;
    }

    isEmptySpot(){
        for(let i = 0 ; i < this.size ; i++){
            for(let j = 0 ; j < this.size ; j++){
                if(this.board[i][j] == null){
                    return false;
                }
            }
        }
        return true;
    }

    isLost() : boolean{
        for(let i = 0 ; i < this.size ; i++){
            for(let j = 0 ; j < this.size ; j++){
                if(this.checkDirection(i , j)){
                    return false;
                }
            }
        }
        return true;
    }

    printBoard(){
        for(let i = 0 ; i < this.size ; i++){
            let row = '';
            for(let j = 0 ; j < this.size ; j++){
                if (this.board[i][j] != null){
                    row += ' ' + this.board[i][j] + ' '
                }else{
                    row += ' - '
                }
            }
            console.log(row);
        }
    }

    randomTileSpot(){
        let spots = [];
        for(let i = 0 ; i < this.size ; i ++){
            for(let j = 0 ; j < this.size ; j++){
                if (this.board[i][j] == null){
                    spots.push([i , j]);
                }
            }
        }

        let randomSpot = Math.floor(Math.random() * spots.length);

        return spots[randomSpot];
    }

    addTile(){
        let [r , c] = this.randomTileSpot();
        this.board[r][c] = this.baseNumber;
    }

    inilizeBoard(){
        for(let i = 0 ; i < 2 ; i ++){
            let [r , c] = this.randomTileSpot();
            this.board[r][c] = this.baseNumber;
        }
    }

    directionMove(dir : string){
        if (dir == direaction.left){
            let left = new Left();
            left.move(this.board); 
        } else if(dir == direaction.right){
            let right = new Right();
            right.move(this.board);
        }else if(dir == direaction.top){
            let top = new Top();
            top.move(this.board);
        }else if(dir == direaction.bottom){
            let bottom = new Bottom();
            bottom.move(this.board);
        }
        
    }
    

}