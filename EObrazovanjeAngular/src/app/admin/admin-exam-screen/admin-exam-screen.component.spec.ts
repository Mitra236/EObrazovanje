import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminExamScreenComponent } from './admin-exam-screen.component';

describe('AdminExamScreenComponent', () => {
  let component: AdminExamScreenComponent;
  let fixture: ComponentFixture<AdminExamScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminExamScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminExamScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
