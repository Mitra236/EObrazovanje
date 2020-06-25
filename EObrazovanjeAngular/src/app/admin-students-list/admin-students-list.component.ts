import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

const mockData = [
  {
    username: 'Tina',
    index: 'SF25/2017',
    firstName: 'Valentina',
    lastName: 'Mackovic',
    email: 'mail@gmail.com',
    phoneNumber: '086172829',
    JMBG: '07119972828',
    yearOfEnrollment: '2017',
    methodOfFinancing: 'budget',
    yearOfStudy: '2',
    timeEnrolled: '1',
  },
  {
    username: 'Pero',
    index: 'SF39/2024',
    firstName: 'Pero',
    lastName: 'Peric',
    email: 'peroperic@gmail.com',
    phoneNumber: '3213213',
    JMBG: '0101001123456',
    yearOfEnrollment: '2024',
    methodOfFinancing: 'budget',
    yearOfStudy: '3',
    timeEnrolled: '14',
  },
];

@Component({
  selector: 'app-admin-students-list',
  templateUrl: './admin-students-list.component.html',
  styleUrls: ['./admin-students-list.component.css']
})
export class AdminStudentsListComponent implements OnInit {
  students;
  constructor(private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.students = mockData;
  }

}
