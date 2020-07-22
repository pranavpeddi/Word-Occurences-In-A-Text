import React from 'react';
import {Container,Table} from 'react-bootstrap'
import axios from 'axios'

class TableView extends React.Component
{
    constructor(props)
    {
        super(props);
        this.state={
            words:[]
        };
    }

    componentDidMount()
    {
        
            axios.get('http://localhost:8080/getData')
              .then(res => {
                this.setState({ words: res.data });
                console.log(res.data)
                console.log(this.state.words);
              });
    }

    render()
    {
     
        
        return(
<Container fluid>
    <Table variant="light" striped bordered hover  size="sm">
    <thead>
        <tr>
            <th>Word</th>
            <th>No of times it occured</th>
        </tr>
            
    </thead>
    <tbody>
                {this.state.words.map(word =>
                  <tr>
                    <td>{word.key}</td>
                    <td>{word.value}</td>
                  </tr>
                )}
              </tbody>
    </Table>
</Container>
        );
 
}
}


export default TableView