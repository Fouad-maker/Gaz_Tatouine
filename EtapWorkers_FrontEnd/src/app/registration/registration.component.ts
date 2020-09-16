import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

   mode = 'ajout';
	 userAdded: any;
	 errorMessage: string;

  constructor(private authenticationService:AuthenticationService , private router:Router) { }

  ngOnInit(): void {
  }


  onSaveUser(user) {
		this.authenticationService.saveUser(user)
			.subscribe(data => {
				this.mode = 'confirmation';
				this.userAdded = data;
				this.router.navigateByUrl('/login');
			}, error => {
				console.log(error);
				this.errorMessage = error.error.message;
			});
	}

}
