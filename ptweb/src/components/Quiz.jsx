import React from 'react';
import { Grid, Col, Row, Media,Radio } from "react-bootstrap";
import axios from 'axios';
import Popup from './Popup';
import Footer from './Footer';
const API_CALL =  "http://localhost:8180/ptservice/questions";

class Quiz extends React.Component {

 constructor(props) {
    super(props);
    this.state = {
      questions: [],
      loading:true,           score: 0,
      displayPopup: 'flex',

    };
    this.handleStartQuiz = this.handleStartQuiz.bind(this);

  }
  handleStartQuiz() {
    this.setState({
        displayPopup: 'none',
        nr: 1
    });
}
  componentDidMount() {
    const self = this;
    axios
      .get(API_CALL)
      .then(function(response) {
        // handle success
        const questions = response.data;
        console.log(questions);
        self.setState({
          questions: questions,loading:false,            

        });
      })
      .catch(function(error) {
        // handle error
        console.log(error);
      })
     
  }




  render() {
    const { isLoading, questions,displayPopup } = this.state;
    
    return (
      <React.Fragment>
        <h2>Quiz</h2>
        <Popup style={{display: displayPopup}}  startQuiz={this.handleStartQuiz}/>

        <div>
     
          {!isLoading ? (
          
          questions.map((ques,index)=> {
            console.log(ques)
            let   qData=JSON.parse(ques.question);
            console.log(qData.question_type)
              return (<div>{
                qData.question

                }

                {


                }
                      {
qData.question_type.options.map(function(option,index){
                          return (
                            <div className="radio">
                            <label>
                            
      
                                <input type="radio" name={"radio"+ques.id} />{option}
                                </label>
                            </div>
                          )
                      })}
              </div>)
          })
          ) : (
            <p>Loading...</p>
          )}
        </div>
      </React.Fragment>
    );
  }
}
export default Quiz