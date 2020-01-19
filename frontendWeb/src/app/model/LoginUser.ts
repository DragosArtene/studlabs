export class LoginUser {
  paswword: string;
  username: string;
  constructor(pwd: string, usrname: string) {
    this.paswword = pwd;
    this.username = usrname;
  }
}
