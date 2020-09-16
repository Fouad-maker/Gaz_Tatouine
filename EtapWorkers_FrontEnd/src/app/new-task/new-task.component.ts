import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { error } from 'protractor';

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {
   mode = 'ajout';
   taskAdded: any;
  
  constructor(private authService :AuthenticationService) { }

  ngOnInit(): void {
  }
 
 
 
  onSaveTask(task) {
		this.authService.saveTask(task)
			.subscribe(data => {
				this.mode = 'confirmation';
				this.taskAdded = data;
			}, error => {
				console.log(error);
		});
	}
}
