import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  mode:number=0;

  constructor( private authService:AuthenticationService , private router:Router) { }

  ngOnInit(): void {
  }


  onLogin(datForm:any) {
    this.authService.login(datForm)
    .subscribe(resp=>{
      let jwt=resp.headers.get("Authorization");
      this.authService.saveToken(jwt);
      if(this.authService.isAdmin() )
      this.router.navigateByUrl('/admin');
      else {
        this.router.navigateByUrl('profile');
      }
      console.log(resp.headers.get("Authorization"));

    }, _err=>{
      this.mode=1;

      
    }
    
    );
    console.log(datForm);

  }

  onRegister() {
		this.authService.logout();
		this.router.navigateByUrl('/register');
	}
    

  

}
