import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {JwtHelperService} from '@auth0/angular-jwt';
import { catchError, tap, map } from 'rxjs/operators';



import { Key } from 'protractor';
import { observable } from 'rxjs';
import { User } from '../model/User';
import { worker } from 'cluster';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private host:string="http://localhost:9494";
  private jwtToken=null;
  private roles:Array<any> = [];
  private id:string='';
  private username :string='';

  constructor( private http:HttpClient) { }

  login(user) {
    return this.http.post(this.host+"/login", user, { observe:"response"} );

  }

  logout() {
    this.jwtToken=null;
    localStorage.removeItem('token');
  }

  isAdmin() {
    /**
		 * roles dans le jwt de la forme
		 * {
		 *   "sub": "admin",
		 *   "exp": 1568027984,
		 *   "roles": [
		 *     {
		 *       "authority": "ADMIN"
		 *     },
		 *     {
		 *       "authority": "USER"
		 *     }
		 *   ]
		 * }
		 */
    for(let r of this.roles) {
      if(r.authority=='ADMIN') return true;
    }
    return false;
  }

  saveToken(jwt:string) {
    this.jwtToken=jwt;
    localStorage.setItem('token',jwt);
    let jwtHelper = new JwtHelperService();
    this.roles = jwtHelper.decodeToken(this.jwtToken).roles; 
    this.username=jwtHelper.decodeToken(this.jwtToken).sub;
 }

 loadToken() {
   
   this.jwtToken=localStorage.getItem('token');
   
 }

 saveTask(task) {
  if(this.jwtToken === null) this.loadToken();

  return this.http.post(this.host + '/tasks', task,
    {headers : new HttpHeaders({'Authorization' : this.jwtToken})});
}

  getTasks() {
    if(this.jwtToken === null) this.loadToken();
    return this.http.get(this.host+'/tasks' , 
    {headers : new HttpHeaders({'Authorization':this.jwtToken}) } );
  }


  getUsers() {
    if(this.jwtToken === null) this.loadToken();
    return this.http.get(this.host+'/users',
      {headers: new HttpHeaders({'Authorization':this.jwtToken})}    
    );
  }

  getWorker( id:any) {
    if(this.jwtToken === null) this.loadToken();
    

    return this.http.get(this.host+"/user/"+id ,{headers: new HttpHeaders({'Authorization':this.jwtToken})})
    .pipe(map(resp=>resp));
}

getWorkerByUsername(username:string) {
  username=this.username;
    return this.http.get(this.host+"/use/"+username, {headers: new HttpHeaders({'Authorization':this.jwtToken})})
    .pipe(map(resp=>resp)); 
  
  
    }

  updateUser(user:User){
    console.log(user);
    if(this.jwtToken === null) this.loadToken();

      return this.http.put(this.host+"/users/"+user.id,user ,{headers: new HttpHeaders({'Authorization':this.jwtToken})})
      .pipe(map(resp=>resp));
  

  }

  saveUser(user) {
    if(this.jwtToken === null) this.loadToken();

    return this.http.post(this.host + '/register', user ,{headers: new HttpHeaders({'Authorization':this.jwtToken})});

  }

  
  
}
