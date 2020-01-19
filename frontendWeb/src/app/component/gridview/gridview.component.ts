import { Component, OnInit } from '@angular/core';
import {QuizService} from '../../services/quiz-service/quiz.service';
import {Quiz} from '../../model/quiz';

@Component({
  selector: 'app-gridview',
  templateUrl: './gridview.component.html',
  styleUrls: ['./gridview.component.css']
})
export class GridviewComponent implements OnInit {
  quizzes: Quiz[];
  spec: number;
  divflag: boolean;
  constructor(private quizservice: QuizService) {
    this.spec=1;
  }

  ngOnInit() {
    this.update();
  }
  onClick(){

    this.spec=2;
    this.update();
  }
  update() {
    this.quizservice.getAllQuizzes().subscribe(quizzes => {
      this.quizzes = quizzes;
      this.divflag=true;
    });
  }
  flag(){
    this.divflag=false;

  }
}
