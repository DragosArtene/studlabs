import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StartquizwarningComponent } from './startquizwarning.component';

describe('StartquizwarningComponent', () => {
  let component: StartquizwarningComponent;
  let fixture: ComponentFixture<StartquizwarningComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StartquizwarningComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StartquizwarningComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
