import {Component, Input, OnInit} from '@angular/core';
import {Question} from '../../model/question';
import {QuestionService} from '../../services/question-service/question.service';
import {QuestionDifficulty} from '../../model/questionDifficulty';
import {QuestionsComponent} from '../questions/questions.component';
import {QuizComponent} from '../quiz/quiz.component';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {
  @Input() idQuestion: number=5
   //questions: Question[];
   levels: string[]=["EASY","MODERATE","HARD"];
   description: string;
   category : string;
   difficulty: string;
   deprecated: boolean=false;
   quest: Question;

  constructor(private questionService: QuestionService, private questionsComponent: QuestionsComponent, private quizComponent: QuizComponent) { }

  ngOnInit() {
    this.update();
  }

  update() {
      this.questionService.getQuestionById(this.idQuestion).subscribe(
        question=> {
          this.quest=question;

           this.description=question.description;
           this.category=question.category;
           this.difficulty=question.difficulty.toString();
           this.deprecated=question.deprecated;
        }
      );
  }

  editQuestion(idQuestion: number, category: string, description: string, difficulty: string , deprecated: boolean): void{
    var question: Question;
    if (difficulty=="EASY"){
      question={idQuestion: idQuestion, description: description, category: category, difficulty: QuestionDifficulty.EASY, deprecated: deprecated};
    }else if(difficulty=="HARD"){
      question={idQuestion: idQuestion, description: description, category: category, difficulty: QuestionDifficulty.HARD, deprecated: deprecated};

    }else{
      question ={idQuestion: idQuestion, description: description, category: category, difficulty: QuestionDifficulty.MODERATE, deprecated: deprecated};
    }
   //question = {idQuestion: idQuestion, description: description, category: category, difficulty: QuestionDifficulty.HARD, deprecated: deprecated}
    this.questionService.updateQuestion(idQuestion, question).subscribe(()=>{
      this.update();
      this.questionsComponent.update();
    });
  }
  removeQuestion(idQuestion: number){
    this.questionService.deleteQuestion(idQuestion ).subscribe(()=>{
      this.update();
      this.questionsComponent.update();
    });

  }
}
