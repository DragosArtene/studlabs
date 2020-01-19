import { Component, OnInit } from '@angular/core';
import {QuizService} from '../../services/quiz-service/quiz.service';
import {Quiz} from '../../model/quiz';
import {PlayquizComponent} from '../playquiz/playquiz.component';

@Component({
  selector: 'app-quizzes',
  templateUrl: './quizzes.component.html',
  styleUrls: ['./quizzes.component.css']
})
export class QuizzesComponent implements OnInit {
  quizzes: Quiz[];
  spec: number;
  condition: boolean;
  constructor(private quizService: QuizService, ) { }

  ngOnInit() {
    this.update();
    this.spec=1;
  }
  update() {

    this.quizService.getAllAvailableQuizzes().subscribe(quizzes => {
      this.quizzes = quizzes;
    });
  }
  open(){


  }
}
