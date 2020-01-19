import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QestionDialogComponent } from './question-dialog.component';

describe('QestionDialogComponent', () => {
  let component: QestionDialogComponent;
  let fixture: ComponentFixture<QestionDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QestionDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QestionDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
