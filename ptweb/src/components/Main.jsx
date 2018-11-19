import React from 'react';
import axios from 'axios';
import Answers from './Answers';
import Popup from './Popup';
import Footer from './Footer';
const API_CALL =  "http://localhost:8180/ptservice/questions";
class Main extends React.Component {
    //            total: data.length,

    constructor(props) {
        super(props);
        this.state = {
            nr: 0,
             loading:true,
            showButton: false,
            questionAnswered: false,
            score: 0,
            displayPopup: 'flex',
            data:[]
        }
        this.nextQuestion = this.nextQuestion.bind(this);
        this.handleShowButton = this.handleShowButton.bind(this);
        this.handleStartQuiz = this.handleStartQuiz.bind(this);
        this.handleIncreaseScore = this.handleIncreaseScore.bind(this);
    }

    pushData(nr) {
        alert("d"+nr+ this.state)
        this.setState({
            questions: this.state.data[nr],
            answers: [this.state.data[nr].category, this.state.data[nr].category],
             correct :'b',
            //correct: data[nr].correct,
            nr: this.state.nr + 1
        });
    }
   
    componentWillMount() {
        //let { nr } = this.state;
        //this.pushData(nr);
        
        axios.get(`http://localhost:8180/ptservice/questions`)
      .then(res => {
          alert(res.data);
          console.log(res.data);
        const data = res.data;
        this.setState({ data,loading:false });
      }).then(this.pushData(this.state.nr))
    }

    nextQuestion() {
        let { nr, total, score } = this.state;

        if(nr === total){
            this.setState({
                displayPopup: 'flex'
            });
        } else {
            this.pushData(nr);
            this.setState({
                showButton: false,
                questionAnswered: false
            });
        }

    }

    handleShowButton() {
        this.setState({
            showButton: true,
            questionAnswered: true
        })
    }

    handleStartQuiz() {
        this.setState({
            displayPopup: 'none',
            nr: 1
        });
    }

    handleIncreaseScore() {
        this.setState({
            score: this.state.score + 1
        });
    }

    render() {
        let { nr, total, question, answers, correct, showButton, questionAnswered, displayPopup, score} = this.state;

        return (

            !this.state.loading &&
            <div className="container">

                <Popup style={{display: displayPopup}} score={score} total={total} startQuiz={this.handleStartQuiz}/>

                <div className="row">
                    <div className="col-lg-10 col-lg-offset-1">
                        <div id="question">
                            <h4>Question {nr}/{total}</h4>
                            <p>{question}</p>
                        </div>
                        <Answers answers={answers} correct={correct} showButton={this.handleShowButton} isAnswered={questionAnswered} increaseScore={this.handleIncreaseScore}/>
                        <div id="submit">
                            {showButton ? <button className="fancy-btn" onClick={this.nextQuestion} >{nr===total ? 'Finish quiz' : 'Next question'}</button> : null}
                        </div>
                    </div>
                </div>
                <Footer />
            </div>
        );
    }
};

export default Main
