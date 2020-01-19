import {Component, Input, OnInit} from '@angular/core';
import {Quiz} from '../../model/quiz';
import {QuizService} from '../../services/quiz-service/quiz.service';
import {QuizzDifficulty} from '../../model/quizzDifficulty';
import {ActivatedRoute, Router} from '@angular/router';
import {log} from 'util';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {
  @Input() idquiz: number=5
  quiz: Quiz;

  category: string;
  time: string;
  difficulty: string;
  levels: string[]=["EASY","MODERATE","HARD"];
  isPublic: boolean;
  isRandom: boolean=false;
  constructor(private quizservice: QuizService,private route: ActivatedRoute,
              private router: Router,) { }

  ngOnInit() {
    this.update();
  }

  update() {
    this.idquiz= Number(this.route.snapshot.paramMap.get('id'));
    if(this.idquiz!=-1) {
      console.log("intrat in update");
      this.quizservice.getQuizById(this.idquiz).subscribe(quiz => {
        this.quiz = quiz;
        this.time = quiz.timeInMinutes.toString();
        this.isPublic = quiz.public;
        this.isRandom = quiz.random;
        this.difficulty = quiz.difficulty.toString();
        this.category = quiz.category;
      });
    }
    this.time = "Time";
    this.difficulty="Difficulty";
  }
  editQuiz(idquiz: number, category: string, time: string ,difficulty: string, ispublic: boolean, israndom: boolean): void {
    var quizdifficulty: QuizzDifficulty;
    var updatedQuiz: Quiz;
      if (difficulty=="EASY"){
         updatedQuiz = {idQuiz: idquiz, category: category,completionRate: 1,timeInMinutes: Number(time), difficulty: QuizzDifficulty.EASY, public: ispublic, random: israndom };

      }else if(difficulty=="HARD"){
        updatedQuiz = {idQuiz: idquiz, category: category,completionRate: 1,timeInMinutes: Number(time), difficulty: QuizzDifficulty.HARD, public: ispublic, random: israndom };
      }else{
        updatedQuiz= {idQuiz: idquiz, category: category,completionRate: 1,timeInMinutes: Number(time), difficulty: QuizzDifficulty.MODERATE, public: ispublic, random: israndom };
      }


      this.quizservice.updateQuizById(idquiz, updatedQuiz).subscribe(() => {
        this.update();
         console.log("updated quiz!");
      });

  }

  addQuiz(category: string, time: string ,difficulty: string, ispublic: boolean, israndom: boolean){
     //TODO add that if else structure, it adds only "EASY"
    const quiz: Quiz= {idQuiz: -1, category: category,completionRate: 1,timeInMinutes: Number(time), difficulty: QuizzDifficulty.EASY, public: ispublic, random: israndom};
    this.quizservice.addQuiz( quiz).subscribe(() => {
      this.ngOnInit();
      console.log("Added quiz!");
    });


  }
  removeQuiz(idQuiz: number){
    this.quizservice.deleteQuizById(idQuiz).subscribe(() => {

      console.log("Deleted quiz!");
    });
  }
}

