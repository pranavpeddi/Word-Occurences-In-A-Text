import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

import * as serviceWorker from './serviceWorker';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter , Route } from 'react-router-dom';
import DataForm from './Components/DataForm'
import TableView from './Components/TableView'

ReactDOM.render(
  <BrowserRouter>
    <Route exact path="/" component={DataForm}></Route>
    <Route path="/table" component={TableView}></Route>
  </BrowserRouter>
  ,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
