import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { StudyProgrammeService } from '../../services/study.programme.service';
import { StudyProgramme } from '../../types/study.programme';

@Component({
  selector: 'app-admin-courses-list',
  templateUrl: './admin-courses-list.component.html',
  styleUrls: ['./admin-courses-list.component.css'],
})
export class AdminCoursesListComponent implements OnInit, OnDestroy {
  private subscription: Subscription;
  studyProgrammes: StudyProgramme[];
  constructor(
    private studyProgrammeService: StudyProgrammeService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.subscription = this.route.params
      .pipe(
        switchMap((params: Params) =>
          this.studyProgrammeService.getListOfStudyProgrammes()
        )
      )
      .subscribe((studyProgramme) => {
        this.studyProgrammes = studyProgramme;
      });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
