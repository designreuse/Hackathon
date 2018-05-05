import { NgModule } from '@angular/core';

import { NgxEchartsModule } from 'ngx-echarts';
import { ChartModule } from 'angular2-chartjs';

import { ThemeModule } from '../../@theme/theme.module';
import { DashboardComponent } from './dashboard.component';
import { HackatonChartComponent } from './hackaton-chart/hackaton-chart.component';



@NgModule({
  imports: [
    ThemeModule,
    NgxEchartsModule,
    ChartModule
  ],
  declarations: [
    DashboardComponent,
    HackatonChartComponent
  ],
})
export class DashboardModule { }
