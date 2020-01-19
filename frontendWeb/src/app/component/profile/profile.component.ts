import { Component, OnInit } from '@angular/core';
import {QuizService} from '../../services/quiz-service/quiz.service';
import {PlayQuiz} from '../../model/playQuiz';
import {PlayService} from '../../services/play-service/play.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  playQuizes: PlayQuiz[]
  constructor(private quizService: QuizService,private playservice: PlayService) { }

  ngOnInit() {
  }

  update(){



  }
  getPlayedQ(){

  }
}
