import React,{Component} from 'react'
import {Form,Button,Container,Row,Col} from 'react-bootstrap'
import TableView from './TableView'
class DataForm extends Component{
    constructor()
    {
        super();
        this.state={
            data:'',
            isInserted:''
        }
        
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
  const{data}=this.state;
  const url='http://localhost:8080/stringOp/'+data+'';
  fetch(url,{method:'POST'}).then(res=>{
  if(res.status===200)

  {
      //console.log(res.)
      console.log('data is inserted');
      this.props.history.push('/table')

  }
  else
  {
      console.log(res.status)
      console.log("data is not inserted");
  }
  });

}


    render()
    {
        const {data}=this.state
        return(
     <div className="App">
             <Container>
   
     <h3 style={{paddingTop:25}}>Word Counter </h3>
     <Form style={{paddingTop:10}} onSubmit={this.onSubmit} className="mt-1">
     <Form.Group controlId="formBasicEmail">
       
       <Form.Control type="text" placeholder="Enter text" name="data" value={data} onChange={this.onChange}/>
        
     </Form.Group>  
     <Button variant="primary" type="submit">Submit</Button>
     </Form>


     </Container>

    </div>
        );
    }
}


export default DataForm;