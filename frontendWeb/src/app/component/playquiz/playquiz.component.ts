import {Component, Input, OnInit} from '@angular/core';
import {PlayService} from '../../services/play-service/play.service';
import {QuizService} from '../../services/quiz-service/quiz.service';
import {ActivatedRoute, Router} from '@angular/router';
import {PlayQuestion} from '../../model/playQuestion';
import {QuestionService} from '../../services/question-service/question.service';
import {MatDialog, MatDialogConfig} from '@angular/material';
import {QuestionDialogComponent} from '../qestion-dialog/question-dialog.component';
import {Quiz} from '../../model/quiz';
import {StartquizwarningComponent} from '../startquizwarning/startquizwarning.component';
import {Question} from '../../model/question';
import {Answer} from '../../model/answer';
import {FormArray, FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-playquiz',
  templateUrl: './playquiz.component.html',
  styleUrls: ['./playquiz.component.css']
})
export class PlayquizComponent implements OnInit {
  @Input() idquiz: number=5
  idCurrentPlayQuestion: number;
  counter: number=0;
  currentQuestion: Question;
  playquestions :PlayQuestion[];
  answersForCurrentQuestion: Answer[];
  answerIdsToBeSent: number[];
  playQuestionslength:number;

  idPlayQuiz: number
  quiz: Quiz;
  result: boolean
  score: number;
  endflag: boolean=false;
  endquestionsflag: boolean=false;
  favAnswers: FormArray;



  constructor(private playService: PlayService,
              private quizservice: QuizService,
              private questionservice: QuestionService,
              public dialog: MatDialog,
              private route: ActivatedRoute,
              private router: Router,
              private _fb:FormBuilder) { }

  ngOnInit() {
    this.idquiz= Number(this.route.snapshot.paramMap.get('id'));
    this.quizservice.getQuizById(this.idquiz).subscribe(quiz=>{
      this.quiz=quiz;
      this.openDialog();
    });
  }

  update() {
    let idQuestion:number =this.playquestions[this.counter].idQuestion;
    this.idCurrentPlayQuestion=this.playquestions[this.counter].idPlayQuestion;
    console.log("ID QUESTION IS : "+idQuestion);

    if(this.counter<this.playQuestionslength){
    this.counter=this.counter+1;}
    if(this.counter==this.playQuestionslength){
      this.endquestionsflag=true;
    }

    this.questionservice.getQuestionById(idQuestion).subscribe(q=>{
      this.currentQuestion=q;
      console.log("QUESTION DESCRIPTION IS :"+ this.currentQuestion.description);
      this.playService.getAnswersForPlayQuestion(idQuestion).subscribe(answers=>{
        this.answersForCurrentQuestion=answers;
        this.favAnswers=this.addAnswersControls();

      });
    });


  }

  addAnswersControls(){
    let arr =this.answersForCurrentQuestion.map(element=>{this._fb.control(false);})
    return this._fb.array(arr);

  }
  getSelectedValues(){
    this.answerIdsToBeSent=[];
    this.favAnswers.controls.forEach((control,i)=>{
      if(control.value==true){
        this.answerIdsToBeSent.push(this.answersForCurrentQuestion[i].idAnswer);
      }
    });
    console.log("RASPUNSURIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIILWEEEEEE: "+this.answerIdsToBeSent);
    return this.answerIdsToBeSent;
  }
  getanswersArray(){
    return <FormArray>this.favAnswers;

  }
  next(){
       this.playService.postAnswerToPlayQuestion(this.idCurrentPlayQuestion, this.getSelectedValues(),"empty").subscribe();
       this.getSelectedValues();
       this.update();

  }
  openDialog(){
    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    let warnDialog=this.dialog.open(StartquizwarningComponent, {data: {quizname: this.quiz.category} });

    warnDialog.afterClosed().subscribe(result=>{

     if (result){this.result=result;
     this.initiateQuiz()
     }

    });
  }
  initiateQuiz(){
    this.playService.addPlayQuiz(this.idquiz).subscribe(idplayquiz => {
      this.idPlayQuiz=idplayquiz;
      this.getPlayQuestions();
      console.log('idplayquiz created is:'+idplayquiz)

    });
  }
  getPlayQuestions(){
    this.playService.getAllPQuestionsForPlayQuiz(this.idPlayQuiz).subscribe(pquestions=> {
      this.playquestions=pquestions;
      this.playQuestionslength=this.playquestions.length;
      this.update();

    });

  }

  finishQuiz(){
    this.playService.getPlayedQuizById(this.idPlayQuiz).subscribe(pq=>{
      this.score=pq.rate
    })
   this.playService.finishQuiz(this.idPlayQuiz).subscribe( ()=>{
     this.endflag=true;
     this.playService.getPlayedQuizById(this.idPlayQuiz).subscribe(pq=>{
       this.score=pq.rate
     })

   } );

  }

}
