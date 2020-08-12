import React from 'react';
import BoggleLetter from './BoggleLetter';
import { Button } from 'antd';
import { Upload, message } from 'antd';
import { UploadOutlined } from '@ant-design/icons';
import { Configuration } from './swagger';
import { DefaultApi } from './swagger';

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
            answerKey : [], 
            selectedFiles : null
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
                )
                }
            <div>
                {/* <Upload accept = 'jpeg/png' onChange={({file, fileList}) => this.fileUpload(file, fileList)}>
                    <Button>
                        <UploadOutlined /> Click to Upload
                    </Button>
               </Upload> */}
               <input type="file" onChange={(event) => this.fileUpload(event)} /> 
               <Button type='primary' onClick={(event) => this.solve(event)}>Solve me!</Button>
            </div>          
            {
                this.state.answerKey.map((answer, i) => <h4>{answer}</h4>)
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



              
