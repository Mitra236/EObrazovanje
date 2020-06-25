import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

const mockData = [
  {
    username: 'markic',
    password: 'marko',
    firstName: 'marko',
    lastName: 'markovic',
    email: 'marko@email.com',
    phoneNumber: '0483294',
    JMBG: '43895482375849',
    academicTitle: 'professor',
    biography: 'tra la la',
    position: 'professor',
    employeeFunction: 'professor',
    courseRole: 'assistant',
    positionFrom: '2005-08-08',
    employeeFunctionFrom: '2008-09-23'
  },
];

@Component({
  selector: 'app-admin-professors-list',
  templateUrl: './admin-professors-list.component.html',
  styleUrls: ['./admin-professors-list.component.css']
})
export class AdminProfessorsListComponent implements OnInit {
  professors;
  constructor(private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.professors = mockData;
  }

}
