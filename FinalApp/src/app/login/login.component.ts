import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { AuthenticateService } from '../authenticate.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName: FormControl;
  userPassword:FormControl;
  token : string;
  constructor(private myauth:AuthenticateService) {
    this.userName=new FormControl('',Validators.required);
 this.userPassword=new FormControl('',Validators.required);
   }

  ngOnInit() {
  }
myValidate()
{
 let dt=({userName:this.userName.value,userPassword:this.userPassword.value});

 this.myauth.validateUser(dt)
 .subscribe
 (
   (res)=>
   {
    this.token = res['token'];
    this.myauth.setBearerToken(this.token);
    console.log(this.token);
    // check isUserAuthenticated() returns true in canactivateguard. Then route  to dashboard page
   }
 )

}
}
