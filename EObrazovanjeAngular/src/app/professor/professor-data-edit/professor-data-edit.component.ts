import { Component, OnInit } from '@angular/core';

const professorMockData = {
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
}

@Component({
  selector: 'app-professor-data-edit',
  templateUrl: './professor-data-edit.component.html',
  styleUrls: ['./professor-data-edit.component.css']
})
export class ProfessorDataEditComponent implements OnInit {
  professor: any;

  constructor() { }

  ngOnInit(): void {
    this.professor = professorMockData;
  }

}
