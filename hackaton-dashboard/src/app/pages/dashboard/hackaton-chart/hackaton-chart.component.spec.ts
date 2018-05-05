import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HackatonChartComponent } from './hackaton-chart.component';

describe('HackatonChartComponent', () => {
  let component: HackatonChartComponent;
  let fixture: ComponentFixture<HackatonChartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HackatonChartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HackatonChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
