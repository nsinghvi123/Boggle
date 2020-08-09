import React from 'react';
import BoggleLetter from './BoggleLetter';
import { Button } from 'antd';
import { DefaultApiFactory } from './generated/api/api'

const boggleApi = DefaultApiFactory(undefined, fetch, "http://localhost:8080");

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
            <Button type='primary' onClick={(event) => this.solve(event)}>Solve me!</Button>
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

    solve(event) {
        console.log("solve me is called")
        const configuration = {
            basePath : "https://localhost:8080"
        }
        console.log(boggleApi.solveBoggle(this.state.board))
    }

}
export default BoggleBoard;



              
