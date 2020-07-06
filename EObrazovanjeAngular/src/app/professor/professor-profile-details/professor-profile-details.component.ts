import { Component, OnInit, OnDestroy } from '@angular/core';
import { Professor } from 'src/app/types/professor';
import { ProfessorService } from 'src/app/services/professor/professor.service';
import { ActivatedRoute, Params } from '@angular/router';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';

// const professorMockData = {
//     username: 'markic',
//     password: 'marko',
//     firstName: 'marko',
//     lastName: 'markovic',
//     email: 'marko@email.com',
//     phoneNumber: '0483294',
//     JMBG: '43895482375849',
//     academicTitle: 'professor',
//     biography: 'tra la la',
//     position: 'professor',
//     employeeFunction: 'professor',
//     courseRole: 'assistant',
//     positionFrom: '2005-08-08',
//     employeeFunctionFrom: '2008-09-23'
// }

@Component({
  selector: 'app-professor-profile-details',
  templateUrl: './professor-profile-details.component.html',
  styleUrls: ['./professor-profile-details.component.css']
})
export class ProfessorProfileDetailsComponent implements OnInit, OnDestroy {
  subscription: Subscription;
  professor: Professor;

  constructor(private professorService: ProfessorService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.snapshot.params["id"] ?
      this.getData()
    : null
  }

  getData() {
    this.subscription = this.route.params
    .pipe(switchMap((params: Params) =>
      this.professorService.getProfessor(+params["id"])))
      .subscribe(prof => {
        this.professor = prof
    })
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe()
  }
}
