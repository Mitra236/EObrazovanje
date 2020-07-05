import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { ProfessorService } from '../../services/professor/professor.service';
import { Professor } from '../../types/professor';

@Component({
  selector: 'app-admin-professors-list',
  templateUrl: './admin-professors-list.component.html',
  styleUrls: ['./admin-professors-list.component.css'],
})
export class AdminProfessorsListComponent implements OnInit, OnDestroy {
  private subscription: Subscription;
  professors: Professor[];
  constructor(
    private professorService: ProfessorService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.subscription = this.route.params
      .pipe(
        switchMap((params: Params) =>
          this.professorService.getListOfProfessors()
        )
      )
      .subscribe((professor) => {
        this.professors = professor;
      });
  }

  goToEdit(id: number) {
    this.router.navigate(['admin/users/edit/professor/', id])
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
