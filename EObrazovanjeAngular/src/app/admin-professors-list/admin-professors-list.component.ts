import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { Professor } from '../types/professor';
import { ProfessorService } from '../services/professor/professor.service';


@Component({
  selector: 'app-admin-professors-list',
  templateUrl: './admin-professors-list.component.html',
  styleUrls: ['./admin-professors-list.component.css']
})
export class AdminProfessorsListComponent implements OnInit, OnDestroy {
  private subscription: Subscription;
  professors: Professor[];
  constructor(private professorService: ProfessorService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.subscription = this.route.params
        .pipe(switchMap((params: Params) =>
          this.professorService.getListOfProfessors()))
          .subscribe(professor => {
            this.professors = professor
        })
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
