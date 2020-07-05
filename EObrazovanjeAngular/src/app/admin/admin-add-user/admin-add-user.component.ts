import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { EventEmitter } from '@angular/core';
import { ProfessorService } from '../../services/professor/professor.service';
import { Professor } from '../../types/professor';
import { StudentServiceService } from '../../services/student/student.service';
import { Student } from '../../types/student';

@Component({
  selector: 'app-admin-add-user',
  templateUrl: './admin-add-user.component.html',
  styleUrls: ['./admin-add-user.component.css'],
})
export class AdminAddUserComponent implements OnInit {
  student;

  constructor(private router: Router) {}

  ngOnInit(): void {
  }
}