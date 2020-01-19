import { Component } from '@angular/core';
import {LoginService} from './services/login-service/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Front-End-Quiz';
  logedin: boolean=false;
  constructor(loginservice: LoginService) {}

  logfunction(){
    this.logedin=true;

    //call service
  }


}
