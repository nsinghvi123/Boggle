import React from 'react';
import { Typography } from 'antd';
import {Popover, Button } from 'antd';

const { Text, Link } = Typography;

const changeLetterMessage = (
    <div>
        <p>"Change letter to:"</p>
    </div>
)

class BoggleLetter extends React.Component {
 
    render() {
        return(  
        <span>
            <Popover title="Please change letter:" 
                content={
                    <form>
                        <input
                        name = "newletter"
                        type = "string"
                        onChange={(event) => this.onChange(event)}
                        />
                    </form>
                }>
                <Button type = "primary" className="big-btn" style={{ background: "white", borderColor: "#ffa940", color: "#ffa940", fontSize: '20px'}}>{this.props.letter}             
                </Button>
            </Popover>       
        </span>    
        )           
    }

    onChange(event) {
        let letter = event.target.value;
        if (this.isLetter(letter)) {
            this.props.updateLetter(event.target.value, this.props.row, this.props.col)
        } else {
            alert('Please input one alphabet characters only');
        }
    }

    isLetter(str) {
          return str.length === 1 && str.match(/[a-z]/i);
    }
     
}
export default BoggleLetter;