import React from 'react';

import  {Container,Button,Form}  from 'react-bootstrap';


class FileUpload extends React.Component{
    
    constructor()
    {
        super();
        this.state={
            selectedFile:null
        }

    }

    onFileChange=(e)=>{
        this.setState(
            {
                selectedFile:e.target.files[0]
            }
        );
    }
       

    onFileUpload=(e)=>{
         console.log('im inside the form');
        e.preventDefault();  

        const formData=new FormData();
        formData.append('file',this.state.selectedFile);
        fetch('http://localhost:8080/filecon/newupload',{
            method:'POST',
            body:formData
        }).then(re=>
            {
                if(re.ok)
                {
                    console.log(re.data);
                    alert('file uploaded successfully')
                }
            })
    }

    
    
    fileData=()=>{
        if(this.state.selectedFile)
        {
        return(
            <div>
            <h1>file is uploaded</h1>
            </div>
        );
        }
        else{
            return(
            <>
            </>
            );
        }
    }

    render()
    {
        return(
            <div className="App">
            <Container>
                <h1>Upload the file</h1>
<Form style={{paddingTop:10}} onSubmit={this.onFileUpload} className="mt-1">
     <Form.Group controlId="formBasicEmail">
       
       <Form.Control type="file" size="lg" name="file" onChange={this.onFileChange}/>
        
     </Form.Group>  
     <Button variant="primary" type="submit">Submit</Button>
     </Form>

            </Container>
            
            </div>
        );   
    }
}


export default FileUpload;


