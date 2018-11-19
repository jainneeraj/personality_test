import React from 'react';
import { Grid, Col, Row, Media,Radio } from "react-bootstrap";
import axios from 'axios';
const API_CALL =  "http://localhost:8180/ptservice/questions";

class Exam extends React.Component {

 constructor(props) {
    super(props);
    this.state = {
      questions: [],
      loading:true
    };
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
          questions: questions,loading:false
        });
      })
      .catch(function(error) {
        // handle error
        console.log(error);
      })
     
  }




  render() {
    const { isLoading, questions } = this.state;
    
    return (
      <React.Fragment>
        <h2>Quiz</h2>
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
export default Exam