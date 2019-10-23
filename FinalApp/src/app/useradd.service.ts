import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class UseraddService {

  url:string;
  constructor(private httpserve : HttpClient) { 
    this.url="http://localhost:8089//myboot/add";
  }

  addrec(data)

  {
    return this.httpserve.post(this.url,data);
  }

}
