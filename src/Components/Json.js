import React from 'react';
import {Container,Form,Button} from 'react-bootstrap'

class Json extends React.Component{
    constructor()
    {
        super()
        this.state={
            dataText:''
        };
    }
    onChange=(e)=>
    {
      
        const state=this.state;
        state[e.target.name]=e.target.value;
        this.setState(state)

    }

    onSubmit=(e)=>
    {
        e.preventDefault();
        const {dataText}=this.state
        const FinalString=dataText.toString();
        console.log(FinalString)
        
        const url='http://localhost:8080/csvToJson/'+FinalString+'';
        fetch(url,{METHOD:'POST'}).then((res)=>
        {
            if(res.status===200)
            {
                console.log('data is sent');
            }
        });
    }

    render()
    {
        const {dataText}=this.state
        return(
     <div className="App">
             <Container>
   
     <h3 style={{paddingTop:25}}>Enter CSV data</h3>
     <Form style={{paddingTop:10}} onSubmit={this.onSubmit} className="mt-1">
     <Form.Group controlId="formBasicEmail">
       
       <Form.Control type="text" size="lg" placeholder="Enter text" name="dataText" value={dataText} onChange={this.onChange}/>
        
     </Form.Group>  
     <Button variant="primary" type="submit">Submit</Button>
     </Form>

     
     </Container>
       
    </div>
    
    );
    }
}

export default Json;
