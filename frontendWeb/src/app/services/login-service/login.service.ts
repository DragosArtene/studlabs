import { Injectable } from '@angular/core';
import {HttpHeaders, HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {LoginUser} from '../../model/LoginUser';
import {Quiz} from '../../model/quiz';
import {User} from '../../model/User';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  httpOptions = {
    headers: new HttpHeaders({
      Accept: 'application/json',
      'Content-Type': 'application/json',
      // tslint:disable-next-line:max-line-length
    })
  };
  constructor(private http: HttpClient) { }

  loginUser(usr: LoginUser) {
    console.log('Is in service');
    // tslint:disable-next-line:max-line-length
   // const url = 'https://studlabs.herokuapp.com/studlabs/api/auth' ;
   // return this.http.post<any>(url, usr);
  }

  getUserInfo():Observable<User>{
       const url="http cebaaaaaaaaaaaaa"
       return this.http.get<User>(url, this.httpOptions);
  }
}
