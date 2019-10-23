import { Component } from '@angular/core';
import { UseraddService } from './useradd.service';
import { FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FinalApp';
  userName: FormControl;
  userPassword:FormControl;
constructor(private myserve : UseraddService)
{
 this.userName=new FormControl('',Validators.required);
 this.userPassword=new FormControl('',Validators.required);
}

  loginSubmit()
  {
  let record=({userName:this.userName.value,
          userPassword:this.userPassword.value});
          this.myserve.addrec(record)
          .subscribe(
            (data)=>
            {
              console.log("user added");
              console.log(data);
            }
          ),
          (err)=>
          {
            console.log(err);
          }

          
  }
}
