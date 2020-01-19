import {Component, EventEmitter, OnInit, Output} from '@angular/core';


import {Router} from '@angular/router';
import {first} from 'rxjs/operators';
import {LoginService} from '../../../services/login-service/login.service';
import {LoginUser} from '../../../model/LoginUser';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Output() doLogin: EventEmitter<any> = new EventEmitter<any>();

  usrname: string;
  pswd: string;
  logged: boolean=false;
  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
    this.logged=false;
  }

  onSubmit() {
    const usr = new LoginUser(this.pswd, this.usrname);
    //this.loginService.loginUser(usr).subscribe();
    // this.doLogin.emit(user);
    this.usrname = '';
    this.pswd = '';
  }
  loginapp(){
  this.logged=true;

  }
}
