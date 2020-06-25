import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-add-user',
  templateUrl: './admin-add-user.component.html',
  styleUrls: ['./admin-add-user.component.css'],
})
export class AdminAddUserComponent implements OnInit {
  student;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.student = this.router.url.toString().includes('student');
    console.log(this.student);
  }
}
