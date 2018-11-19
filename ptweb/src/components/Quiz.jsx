import React, { Component } from "react";
import axios from "axios";
import { Grid, Col, Row, Media } from "react-bootstrap";

const API_CALL =  "http://localhost:8180/ptservice/questions";

class Quiz extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      questions: []
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
            questions
        });
      })
      .catch(function(error) {
        // handle error
        console.log(error);
      })
      .then(function() {
        // always executed
        //console.log("Movies" + data);
      });
  }

  render() {
    return (
      <div className="popularRoot">
        <Grid>
          <Row>
            {this.state.questions.map(question => (
                             console.log("col"+JSON.parse(question.question).question)

            ))}
          </Row>
        </Grid>
      </div>
    );
  }
}

export default Quiz;