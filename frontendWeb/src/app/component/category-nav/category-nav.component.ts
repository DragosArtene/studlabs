import {Component, OnInit} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {QuizService} from '../../services/quiz-service/quiz.service';
import {Quiz} from '../../model/quiz';

@Component({
  selector: 'app-category-nav',
  templateUrl: './category-nav.component.html',
  styleUrls: ['./category-nav.component.css']
})
export class CategoryNavComponent implements OnInit{

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private breakpointObserver: BreakpointObserver, private quizservice: QuizService) {
    this.title="Category";

  }
  quizzes: Quiz[];
  title: string;

  ngOnInit() {
    this.update();
  }
  onClick(){

       this.update();
  }
  update() {
    this.quizservice.getAllQuizzes().subscribe(quizzes => {
      this.quizzes = quizzes;
    });
  }
}
