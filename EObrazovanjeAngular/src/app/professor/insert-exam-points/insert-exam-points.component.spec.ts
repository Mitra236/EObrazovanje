import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertExamPointsComponent } from './insert-exam-points.component';

describe('InsertExamPointsComponent', () => {
  let component: InsertExamPointsComponent;
  let fixture: ComponentFixture<InsertExamPointsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertExamPointsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertExamPointsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
