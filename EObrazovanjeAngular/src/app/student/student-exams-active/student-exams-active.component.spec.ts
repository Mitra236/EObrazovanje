import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentExamsActiveComponent } from './student-exams-active.component';

describe('StudentExamsActiveComponent', () => {
  let component: StudentExamsActiveComponent;
  let fixture: ComponentFixture<StudentExamsActiveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentExamsActiveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentExamsActiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
