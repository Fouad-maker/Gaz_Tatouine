import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

  user:any={};
  id:number;

  constructor(private authService : AuthenticationService,private router:Router ,private activatedRoute:ActivatedRoute)
   { 
    this.id=activatedRoute.snapshot.params['id'];

   }


   


  ngOnInit(): void {
    this.authService.getWorker(this.id)
    .subscribe(data=>{
      this.user=data;
      console.log(data);
  },err=>{
    console.log(err);
  })

  }
  

  updateUser() {
    this.authService.updateUser(this.user)
        .subscribe(data=>{
          console.log(data);
          alert("success update")
          this.router.navigate(['admin'])
        },err=>{
          console.log(err);
          alert("fail update")
        });

        
  

}

}
