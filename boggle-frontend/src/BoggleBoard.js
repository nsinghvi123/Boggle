import React from 'react';
import BoggleLetter from './BoggleLetter';
import { Button } from 'antd';
import { Configuration } from './swagger';
import { DefaultApi } from './swagger';
import ParticlesBg from 'particles-bg';

const boggleApi = new DefaultApi(new Configuration({
    basePath: "http://localhost:9000"
}));

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
            ],
            answerKey : [] 
        }
        
    }


    render() {
        return( 
            <div id="board">
             {
                this.state.board.map((row, i) => 
                    <div className={i}>
                        {row.map((letter, j) =>
                            <BoggleLetter 
                                letter={letter}
                                row={i}
                                col={j}
                                updateLetter={(letter, row, col) => this.updateLetter(letter, row, col)}/>)}
                    </div>
                )}
            <div>
               <input type="file" onChange={(event) => this.fileUpload(event)}  /> 
               <Button type='primary' style = {{color:'white', background: '#ffa940', borderColor: "#ffa940"}}onClick={(event) => this.solve(event)}>Solve me!</Button>
            </div>          
            {this.state.answerKey.map((answer, i) => <h4>{answer}</h4>)}
            <ParticlesBg type="square" num={4} bg={true} />
            
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
        boggleApi.solveBoggle({
            requestBody: this.state.board
        })
        .then((result) => {
            console.log(result);
            this.setState( {
                answerKey : result
            })
        })
    }

    fileUpload(event) {
        console.log("get boggle board is called")
        const file = event.target.files[0];
        boggleApi.getBoggleBoard({
            fileName: file
        })
        .then((result) => {
            console.log(result);
            this.setState({
                board : result
            })
        })
    }
}

export default BoggleBoard;



              
