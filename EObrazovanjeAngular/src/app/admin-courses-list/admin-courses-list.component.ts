import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { StudyProgramme } from '../types/study.programme';
import { StudyProgrammeService } from '../services/study.programme.service'


@Component({
  selector: 'app-admin-courses-list',
  templateUrl: './admin-courses-list.component.html',
  styleUrls: ['./admin-courses-list.component.css']
})


export class AdminCoursesListComponent implements OnInit, OnDestroy {
  private subscription: Subscription;
  studyProgrammes: StudyProgramme[];
  constructor(private studyProgrammeService: StudyProgrammeService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.subscription = this.route.params
    .pipe(switchMap((params: Params) =>
      this.studyProgrammeService.getListOfStudyProgrammes()))
      .subscribe(studyProgramme => {
        this.studyProgrammes = studyProgramme
    })
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
