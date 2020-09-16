import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { from, Observable } from 'rxjs';
import { AuthenticationService } from './services/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor( private authService : AuthenticationService , private router : Router) {}
  canActivate() : boolean {
    if(this.authService.isAdmin()) {
      return true
    } else {
      alert("you don't have this privelege");
      this.router.navigate(['/login']);
      return false;
    }
  }
    
  


  
}
