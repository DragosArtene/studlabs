import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders,HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Quiz} from '../../model/quiz';
import {Question} from '../../model/question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  httpOptions = {
    headers: new HttpHeaders({
      'Acces-Control-Allow-Origin':'*',
      'Accept': 'application/json',
      'Content-Type': 'application/json',

      Authorization: 'Bearer ' + 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoiQWRtaW5pc3RyYXRvciIsInVuaXF1ZV9uYW1lIjoiRWNhdGVyaW5hIEFuZHJvbmVzY3UiLCJuYW1laWQiOiJhZG1pbiIsIm5iZiI6MTU2NTE3ODAxOSwiZXhwIjoxNTk1MTgxNjE5LCJpYXQiOjE1NjUxNzgwMTl9.zmZFPVL9VT2mFwmq0FoEeENBzSNsDnVNXiHwzI5xQYc'
    })
  };
  constructor(private http: HttpClient) { }
  getAllQuestionsOfQuiz(idQuiz: number): Observable<Question[]> {
    console.log('Este in servie-getAllQuestionsOfQuiz');
    const url = 'http://localhost:8080/quiz_war_exploded/quizQuestion/'+idQuiz ;
    console.log(url);
    return this.http.get<Question[]>(url, this.httpOptions);
  }
  getQuestionById(idQuestion: number): Observable<Question>{
    const url = 'http://localhost:8080/quiz_war_exploded/questions/'+idQuestion ;
    console.log(url);
    return this.http.get<Question>(url, this.httpOptions);
  }
  getAllQuestions(): Observable<Question[]> {
    console.log('Este in service-getAllQuestions');
    const url = 'http://localhost:8080/quiz_war_exploded/questions/' ;
    console.log(url);
    return this.http.get<Question[]>(url, this.httpOptions);
  }
  addQuestion(question: Question): Observable<any>{
    const url = 'http://localhost:8080/quiz_war_exploded/questions/' ;
    return this.http.post(url,question, this.httpOptions);
  }
  updateQuestion(idQuestion: number,question: Question): Observable<any>{
    const url = 'http://localhost:8080/quiz_war_exploded/questions/'+idQuestion ;
    console.log('in service de update'+ url);
    console.log(  question.idQuestion.toString()+" "+question.description.toString()+" "+question.category.toString()+" "+question.difficulty.toString()+" "+ question.deprecated.toString());
    return this.http.put(url,question, this.httpOptions);
  }
  deleteQuestion(idQuestion: number): Observable<any>{
    const url = 'http://localhost:8080/quiz_war_exploded/questions/'+idQuestion ;
    return this.http.delete(url,this.httpOptions);
  }
  assignQuestion(idQuestion: number, idQuiz: number){
    const params = new HttpParams()
      .set('idQuiz', idQuiz.toString())
      .set('idQuestion', idQuestion.toString());

    const url = 'http://localhost:8080/quiz_war_exploded/quizQuestion/'+idQuiz+'/'+idQuestion ;
    console.log('in service de assign'+ url);
    return this.http.post(url,params,this.httpOptions);
  }
}
