import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorCourseDetailsComponent } from './professor-course-details.component';

describe('ProfessorCourseDetailsComponent', () => {
  let component: ProfessorCourseDetailsComponent;
  let fixture: ComponentFixture<ProfessorCourseDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfessorCourseDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorCourseDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
