import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Quiz} from '../../model/quiz';
import {PlayQuestion} from '../../model/playQuestion';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {PlayAnswer} from '../../model/playAnswer';
import {Answer} from '../../model/answer';
import {PlayQuiz} from '../../model/playQuiz';

@Injectable({
  providedIn: 'root'
})
export class PlayService {
  httpOptions = {
    headers: new HttpHeaders({
      //'Content-Type': 'text/plain',
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      // tslint:disable-next-line:max-line-length
      Authorization: 'Bearer ' + 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoiQWRtaW5pc3RyYXRvciIsInVuaXF1ZV9uYW1lIjoiRWNhdGVyaW5hIEFuZHJvbmVzY3UiLCJuYW1laWQiOiJhZG1pbiIsIm5iZiI6MTU2NTE3ODAxOSwiZXhwIjoxNTk1MTgxNjE5LCJpYXQiOjE1NjUxNzgwMTl9.zmZFPVL9VT2mFwmq0FoEeENBzSNsDnVNXiHwzI5xQYc'
    })
  };
  constructor(private http: HttpClient) { }

  addPlayQuiz(idQuiz:number): Observable<any> {
    const params = new HttpParams()
      .set('idQuiz', idQuiz.toString())

    const url = 'http://localhost:8080/quiz_war_exploded/playQuiz/'+idQuiz;

    return this.http.post(url, params, this.httpOptions);
  }

  getAllPQuestionsForPlayQuiz(idPlayQuiz: number): Observable<PlayQuestion[]> {
    console.log('Esteeee in servie-getAllPQplayQuiz');
    const url = 'http://localhost:8080/quiz_war_exploded/playQuestions/findall/'+idPlayQuiz;
    console.log(url);
    return this.http.get<PlayQuestion[]>(url, this.httpOptions);
  }

  getAnswersForPlayQuestion(idQuestion: number):Observable<Answer[]>{
    console.log('Esteeee in servie-getAllPQplayAnswres');
    const url = 'http://localhost:8080/quiz_war_exploded/answers/byQuestion/'+idQuestion;
    console.log(url);
    return this.http.get<Answer[]>(url, this.httpOptions);

  }

  postAnswerToPlayQuestion(playQuestionId:number, answerIds: number[], textAnswer:string){
    const url = 'http://localhost:8080/quiz_war_exploded/playAnswer/'+playQuestionId;
    console.log('in service de assign'+ url);
    return this.http.post(url,answerIds,this.httpOptions);

  }
  finishQuiz(id: number){
    const url = 'http://localhost:8080/quiz_war_exploded/playQuiz/finish/'+id;
    const params = new HttpParams()
      .set('id', id.toString())
    console.log('in service de finish quiz'+ url);
    return this.http.put(url,params,this.httpOptions);
  }
  getPlayedQuizById(playQuizId:number):Observable<PlayQuiz>{
    const url = 'http://localhost:8080/quiz_war_exploded/playQuiz/played/'+playQuizId;
    console.log('in service de finish quiz'+ url);
    return this.http.get<PlayQuiz>(url,this.httpOptions);
  }


}
