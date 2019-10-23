import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import 'rxjs/Rx';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  url :string;
  constructor(private httpserve: HttpClient) {
    this.url="http://localhost:8089/myboot/login";
   }

  validateUser(data)
  {
return this.httpserve.post(this.url,data);
    

  }


   setBearerToken(token) {
    localStorage.setItem('Bearertoken', token);
  }

  getBearerToken() {
    return(localStorage.getItem('Bearertoken'));
  }

  
  isUserAuthenticated(token): Promise<boolean> {
    return this.httpserve.post(`${this.url}isAuthenticated` , {}, 
    {headers: new HttpHeaders().set('Authorization', `Bearer ${token}`)})
    .map(
      (res) => { return(res['isAuthenticated']);}).toPromise();
  }
  
}
