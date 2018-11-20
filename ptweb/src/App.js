import React, { Component } from 'react';
import quizQuestions from './api/quizQuestions';
import Quiz from './components/Quiz';
import Result from './components/Result';
import logo from './svg/logo.svg';
import axios from 'axios';
import './App.css';

const API_CALL =  "http://localhost:8180/ptservice/questions";
class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      counter: 0,
      questionId: 1,
      questions:[],
      question: '',
      answerOptions: [],
      answer: '',
      answersCount: {
        Nintendo: 0,
        Microsoft: 0,
        Sony: 0 
      },
      result: ''
    };

    this.handleAnswerSelected = this.handleAnswerSelected.bind(this);
  }
  componentWillMount() {
    const self = this;
    axios
      .get(API_CALL)
      .then(function(response) {
        // handle success
        const questions = response.data;
        console.log(questions);
        let   qData=JSON.parse(questions[0].question);
        console.log("qData"+qData);

        self.setState({
          questions: questions,loading:false,            
          question:qData.question,answerOptions:qData.question_type.options,questionId:questions[0].id
        });
      })
      .catch(function(error) {
        // handle error
        console.log(error);
      })
     
  }
  //componentWillMount() {


  //  const shuffledAnswerOptions = quizQuestions.map(question =>
  //    this.shuffleArray(question.answers)
  //  );
  //  this.setState({
   //   question: quizQuestions[0].question,
    //  answerOptions: shuffledAnswerOptions[0]
  //  });
 // }

  shuffleArray(array) {
    var currentIndex = array.length,
      temporaryValue,
      randomIndex;

    // While there remain elements to shuffle...
    while (0 !== currentIndex) {
      // Pick a remaining element...
      randomIndex = Math.floor(Math.random() * currentIndex);
      currentIndex -= 1;

      // And swap it with the current element.
      temporaryValue = array[currentIndex];
      array[currentIndex] = array[randomIndex];
      array[randomIndex] = temporaryValue;
    }

    return array;
  }

  handleAnswerSelected(event) {
    this.setUserAnswer(event.currentTarget.value);

    if (this.state.questionId < quizQuestions.length) {
      setTimeout(() => this.setNextQuestion(), 300);
    } else {
      setTimeout(() => this.setResults(this.getResults()), 300);
    }
  }

  setUserAnswer(answer) {
    this.setState((state, props) => ({
      answersCount: {
        ...state.answersCount,
        [answer]: state.answersCount[answer] + 1
      },
      answer: answer
    }));
  }

  setNextQuestion() {
    const counter = this.state.counter + 1;
    const questionId = this.state.questionId + 1;
    let  q =this.state.questions[counter];
    let   qData=JSON.parse(q.question);

    this.setState({
      counter: counter,
      questionId: q.id,
      question: qData.question,
      answerOptions: qData.question_type.options,
      answer: ''
    });
  }

  getResults() {
    const answersCount = this.state.answersCount;
    const answersCountKeys = Object.keys(answersCount);
    const answersCountValues = answersCountKeys.map(key => answersCount[key]);
    const maxAnswerCount = Math.max.apply(null, answersCountValues);

    return answersCountKeys.filter(key => answersCount[key] === maxAnswerCount);
  }

  setResults(result) {
    if (result.length === 1) {
      this.setState({ result: result[0] });
    } else {
      this.setState({ result: 'Undetermined' });
    }
  }

  renderQuiz() {
    return (
      <Quiz
        answer={this.state.answer}
        answerOptions={this.state.answerOptions}
        questionId={this.state.questionId} 
        question={this.state.question}
        questionTotal={this.state.questions.length}
        onAnswerSelected={this.handleAnswerSelected}
      />
    );
  }

  renderResult() {
    return <Result quizResult={this.state.result} />;
  }

  render() {
    return (
      <div className="App">
        <div className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h2>Personality  Quiz</h2>
        </div>
        {this.state.result ? this.renderResult() : this.renderQuiz()}
      </div>
    );
  }
}

export default App;
