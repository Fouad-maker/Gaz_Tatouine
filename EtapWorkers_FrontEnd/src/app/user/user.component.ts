import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
 currentUser:any={};
 username:any;
  constructor(private authService:AuthenticationService) {
    
   }


  ngOnInit(): void {
    this.authService.getWorkerByUsername(this.username)
    .subscribe(data=>{
      this.currentUser=data;
      console.log(data);
  },err=>{
    console.log(err);
  })
  }



}
