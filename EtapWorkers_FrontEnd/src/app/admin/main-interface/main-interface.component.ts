import { Component, OnInit, HostListener } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-main-interface',
  templateUrl: './main-interface.component.html',
  styleUrls: ['./main-interface.component.css']
})
export class MainInterfaceComponent implements OnInit {

  users:any={};

  constructor( private authService : AuthenticationService , private router:Router) { }

  ngOnInit(): void {

    this.authService.getUsers()
			.subscribe(data => {
				this.users = data;
			}, error => {
        console.log("error");
				// logout pour supprimer le token au cas ou il est expire
			});

    }


    onEditUser(id:string) {
      this.router.navigate(['editUser', id]);

    }

    
}
