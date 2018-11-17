import React from 'react';
import { render } from 'react-dom';
import { Route, Router, IndexRoute, hashHistory } from 'react-router';
import Main from './components/Main';
import './App.css';
// eslint-disable-next-line import/no-webpack-loader-syntax
// App css

export default class App extends React.Component {
  render(){
     return(
         <div>
             <Main/> 
         </div>   
      )
   }
}