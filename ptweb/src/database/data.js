import React from 'react';

import axios from 'axios';

export default class data extends React.Component {
  state = {
    questions: []
  }
  
  componentDidMount() {
    axios.get(`http://localhost:8180/ptservice/questions`)
      .then(res => {
          alert(res.data);
          console.log(res.data);
        const questions = res.data;
        this.setState({ questions });
      })
  }
  render() {
    return (
     this.state.questions

    )
  }

}