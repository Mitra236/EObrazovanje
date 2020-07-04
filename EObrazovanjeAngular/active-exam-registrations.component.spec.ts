import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActiveExamRegistrationsComponent } from './active-exam-registrations.component';

describe('ActiveExamRegistrationsComponent', () => {
  let component: ActiveExamRegistrationsComponent;
  let fixture: ComponentFixture<ActiveExamRegistrationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActiveExamRegistrationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActiveExamRegistrationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
