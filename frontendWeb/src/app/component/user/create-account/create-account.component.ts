import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {
  @Output() doCReateAccout: EventEmitter<any> = new EventEmitter<any>();
  fname: string;
  lname: string;
  email: string;
  username: string;
  pswd: string;
  pswd2: string;


  constructor(private router: Router) {
  }
  ngOnInit() {
  }

  onSubmit() {
    if (this.pswd !== this.pswd2) {
      console.log('not the same');
      this.pswd = '';
      this.pswd2 = '';
      return 0;
    }
    const newUser = {
      email: this.email,
      firstName: this.fname,
      lastName: this.lname,
        password: this.pswd,
        username: this.username
      };
    // this.userService.createNewAccount(newUser).subscribe(data => {
    //   console.log('Registration successful');
    //   this.router.navigate(['/login']);
    // });
    this.fname = '';
    this.lname = '';
    this.email = '';
    this.username = '';
    this.pswd2 = '';
    this.pswd = '';
  }
}
