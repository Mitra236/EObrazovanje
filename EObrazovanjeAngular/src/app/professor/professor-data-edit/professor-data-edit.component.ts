import { Component, OnInit, OnDestroy } from '@angular/core';
import { ProfessorDataEdit } from 'src/app/types/professor-data-edit';
import { ProfessorService } from 'src/app/services/professor/professor.service';
import { ActivatedRoute } from '@angular/router';
import { Professor } from 'src/app/types/professor';
import { Subscription } from 'rxjs';

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
export class ProfessorDataEditComponent implements OnInit, OnDestroy {
  private subscription: Subscription;
  professor: ProfessorDataEdit;

  constructor(private professorService: ProfessorService, private route: ActivatedRoute) { }

  ngOnInit(): void {
     this.getProfessor(+this.route.snapshot.paramMap.get("id"));
  }

  getProfessor(id: number) {
    this.subscription = this.professorService.getProfessorEdit(id)
      .subscribe(data => {
        this.professor = data
      })
  }

  public edit(): void {
    this.professorService.editProfessorData(this.professor).subscribe()
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }
}
