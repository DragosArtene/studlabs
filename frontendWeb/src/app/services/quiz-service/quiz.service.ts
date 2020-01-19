import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {log} from 'util';
import {catchError} from 'rxjs/operators';
import {Observable, of} from 'rxjs';
import {Quiz} from '../../model/quiz';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  httpOptions = {
    headers: new HttpHeaders({
      //'Content-Type': 'text/plain',
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      // tslint:disable-next-line:max-line-length
      Authorization: 'Bearer ' + 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoiQWRtaW5pc3RyYXRvciIsInVuaXF1ZV9uYW1lIjoiRWNhdGVyaW5hIEFuZHJvbmVzY3UiLCJuYW1laWQiOiJhZG1pbiIsIm5iZiI6MTU2NTE3ODAxOSwiZXhwIjoxNTk1MTgxNjE5LCJpYXQiOjE1NjUxNzgwMTl9.zmZFPVL9VT2mFwmq0FoEeENBzSNsDnVNXiHwzI5xQYc'
    })
  };

  constructor(private http: HttpClient) {
  }

  getAllQuizzes(): Observable<Quiz[]> {
    console.log('Esteeee in servie-getAllQuizzesssssssssssssss');
    const url = 'http://localhost:8080/quiz_war_exploded/quiz/all?difficulties=&categories=';
    console.log(url);
    return this.http.get<Quiz[]>(url, this.httpOptions);
  }

  getQuizById(idquiz: number): Observable<Quiz> {
    console.log('Esteeee in servie-get  quiz by id ');
    const url = 'http://localhost:8080/quiz_war_exploded/quiz/' + idquiz;
    console.log(url);
    return this.http.get<Quiz>(url, this.httpOptions);
  }
  updateQuizById(idquiz: number, upquiz: Quiz): Observable<any> {
    const url = 'http://localhost:8080/quiz_war_exploded/quiz/' + idquiz;
    console.log(url + " quizz to be updated: " + JSON.stringify(upquiz));
    return this.http.put(url, upquiz, this.httpOptions);
  }

  deleteQuizById(idquiz: number): Observable<any> {
    const url = 'http://localhost:8080/quiz_war_exploded/quiz/' + idquiz;
    return this.http.delete(url, this.httpOptions);
  }

  addQuiz(quiz: Quiz): Observable<any> {
    const url = 'http://localhost:8080/quiz_war_exploded/quiz/';
    return this.http.post(url, quiz, this.httpOptions);
  }
  //----------------------------for user

  getAllAvailableQuizzes(): Observable<Quiz[]> {
    console.log('Este in service de getAllAvailableQuizzes');
    const url = 'http://localhost:8080/quiz_war_exploded/quiz/available';
    //console.log(url);
    return this.http.get<Quiz[]>(url, this.httpOptions);
  }


}










