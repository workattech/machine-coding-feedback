import { Board } from "board";
import { nextTick } from "process";

export enum direaction {
  left = "0",
  right = "1",
  top = "2",
  bottom = "3",
}

export interface MoveStrategy {
  move(board: any): any;
}

export class Left implements MoveStrategy {
  move(board: any): any {
    let n = board.length;
    let m = board[0].length;
    for (let i = 0; i < n; i++) {


      // find the first number which is not null
      let first = 0;
      for (let j = 0; j < m; j++) {
        if (board[i][j] != null) {
          first = j;
          break;
        }
      }

      // itrate from that first to end 
      for (let j = first; j < m; j++) {
        let second = j + 1;

        // check its next number , it can be next of 2 
        while (second < m) {
          let nextVal = board[i][second];
          if (nextVal != null) {
            break;
          }
          second += 1;
        }

        

        // once found position of first and second element marge into direction which user given 
        let currVal = board[i][j];
        if (
            j != second &&
          second < m &&
          currVal != null &&
          board[i][second] != null &&
          currVal == board[i][second]
        ) {
          board[i][j] += board[i][second];
          board[i][second] = null;
        }
      }

      //move all elements to left side
      let start = 0;
      for (let k = 0; k < n; k++) {
        if (board[i][k] != null) {
          [board[i][k], board[i][start]] = [board[i][start], board[i][k]];
          start += 1;
        }
      }
    }
    return board;
  }
}

export class Right implements MoveStrategy {
  move(board: any): any {
    let n = board.length;
    let m = board[0].length;
    for (let i = 0; i < n; i++) {

      // from end find the first number which is not null
      let first = m - 1;
      for (let j = m - 1; j >= 0; j--) {
        if (board[i][j] != null) {
          first = j;
          break;
        }
      }

      // itrate from that that number to 0 
      for (let j = first; j >= 0; j--) {
        let second = j - 1;

        // check its next number , it can be next of 2 
        while (second >= 0) {
          let prevVal = board[i][second];
          if (prevVal != null) {
            break;
          }
          second -= 1;
        }


        // once found position of first and second element marge into direction which user given 

        let currVal = board[i][j];
        if (
            j != second &&
          second >= 0 &&
          currVal != null &&
          board[i][second] != null &&
          currVal == board[i][second]
        ) {
          board[i][j] += board[i][second];
          board[i][second] = null;
        }
      }

      //move all element to right side
      let last = m - 1;
      for (let k = m - 1; k >= 0; k--) {
        if (board[i][k] != null) {
          [board[i][k], board[i][last]] = [board[i][last], board[i][k]];
          last -= 1;
        }
      }
    }
    return board;
  }
}

export class Top implements MoveStrategy {
  move(board: any): any {
    let n = board.length;
    let m = board[0].length;
    for (let i = 0; i < m; i++) {
        
    // find the first number which is not null
      let first = 0;
      for (let j = 0; j < n; j++) {
        if (board[j][i] != null) {
          first = j;
          break;
        }
      }

    // itrate from that that first to n
      for (let j = first; j < n; j++) {
        let second = first + 1;

        // check its next number , it can be next of 2 
        while (second < n) {
          let nextVal = board[second][i];
          if(nextVal != null){
            break;
          }
          
          second += 1;
        }

        // once found position of first and second element marge into direction which user given 
        let currVal = board[j][i];
          if (j != second && second < n && currVal != null && board[second][i] != null && currVal == board[second][i]) {
            board[j][i] += board[second][i];
            board[second][i] = null;
          }
      }

    //move all element to top side
      let start = 0;
      for (let k = 0; k < n; k++) {
        if (board[k][i] != null) {
          [board[k][i], board[start][i]] = [board[start][i], board[k][i]];
          start += 1;
        }
      }
    }

    return board;
  }
}

export class Bottom implements MoveStrategy {
  move(board: any): any {
    let n = board.length;
    let m = board[0].length;
    for (let i = 0; i < m; i++) {

      // find the first number which is not null
      let first = n - 1;
      for (let j = n - 1; j >= 0; j--) {
        if (board[j][i] != null) {
          first = j;
          break;
        }
      }

    // itrate from that that first to 0
      for (let j = first; j >= 0; j--) {
        let second = j - 1;

        // check its next number , it can be next of 2 
        while (second >= 0) {
          let prevVal = board[second][i];
          if (prevVal != null) {
            break;
          }

          second -= 1;
        }

        // once found position of first and second element marge into direction which user given 
        let currVal = board[j][i];
        if (
            j != second &&
          second >= 0 &&
          currVal != null &&
          board[second][i] != null &&
          currVal == board[second][i]
        ) {
          board[j][i] += board[second][i];
          board[second][i] = null;
        }
      }

      //move all element to bottom side

      let last = n - 1;
      for (let k = n - 1; k >= 0; k--) {
        if (board[k][i] != null) {
          [board[k][i], board[last][i]] = [board[last][i], board[k][i]];
          last -= 1;
        }
      }
    }

    return board;
  }
}
