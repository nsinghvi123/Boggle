giimport React from 'react';
import BoggleLetter from './BoggleLetter';

class BoggleBoard extends React.Component {

    constructor(props) {
       super(props);
        this.state = {
            board : [
                ["a", "b", "c", "d", "e"], 
                ["a", "b", "c", "d", "e"],
                ["a", "b", "c", "d", "e"],
                ["a", "b", "c", "d", "e"], 
                ["a", "b", "c", "d", "e"]
            ]
        }
    }

   render() {
        return(
            <div id="board">{
                this.state.board.map((row, i) => 
                    <div className={i}>
                        {row.map((letter, j) =>
                            <BoggleLetter 
                                letter={letter}
                                row={i}
                                col={j}
                                updateLetter={(letter, row, col) => this.updateLetter(letter, row, col)}/>)}
                    </div>
                )
            }
            </div>  
        )
   }
        updateLetter(letter, row, col) {
            let newBoard = [...this.state.board]
            newBoard[row][col] = letter;
            this.setState( {
                board: newBoard
            });
        }
   }
export default BoggleBoard;



              
