import { Component, OnDestroy } from '@angular/core';
import { NbThemeService } from '@nebular/theme';
import { ChartService } from '../../../shared/services/chart.service';
import { AlgorithmInput } from '../../../shared/model/algorithm-input';

@Component({
  selector: 'hackaton-chart',
  styleUrls: ['./hackaton-chart.component.scss'],
  templateUrl: './hackaton-chart.component.html',
  
})
export class HackatonChartComponent implements OnDestroy {
  data: {};
  options: any;
  themeSubscription: any;

  // Inputs
  //imargin = 0;
  //icostu= 0;
  //iastock = 0;

  ainput: AlgorithmInput = new AlgorithmInput;

  // Business Indicators
  btotrev=0;
  bprou=0;
  boptmar=0;

  datapoints = [this.random(), this.random(), this.random(), this.random(), this.random(), this.random()];
  labels = ['January', 'February', 'March', 'April', 'May', 'June'];

  constructor(private theme: NbThemeService, private chartService:ChartService) {
    

    this.ainput.imargin=0.1;
    this.ainput.icostu=200;
    this.ainput.iastock=150;
    this.ainput.iopcos=70000;
    this.ainput.iincos=300000;

    this.btotrev = 0;

    this.reloadChart();
    
    //this.createChart();

  }

  createChart(){

    this.themeSubscription = this.theme.getJsTheme().subscribe(config => {

      const colors: any = config.variables;
      const chartjs: any = config.variables.chartjs;

      this.data = {
        labels: this.labels,
        datasets: [{
          label: 'Optimised Price',
          data: this.datapoints,
          borderColor: colors.primary,
          backgroundColor: colors.primary,
          fill: false,
          borderDash: [5, 5],
          pointRadius: 8,
          pointHoverRadius: 10,
        }/*, {
          label: 'dataset - individual point sizes',
          data: [this.random(), this.random(), this.random(), this.random(), this.random(), this.random()],
          borderColor: colors.dangerLight,
          backgroundColor: colors.dangerLight,
          fill: false,
          borderDash: [5, 5],
          pointRadius: 8,
          pointHoverRadius: 10,
        }, {
          label: 'dataset - large pointHoverRadius',
          data: [this.random(), this.random(), this.random(), this.random(), this.random(), this.random()],
          borderColor: colors.info,
          backgroundColor: colors.info,
          fill: false,
          pointRadius: 8,
          pointHoverRadius: 10,
        }, {
          label: 'dataset - large pointHitRadius',
          data: [this.random(), this.random(), this.random(), this.random(), this.random(), this.random()],
          borderColor: colors.success,
          backgroundColor: colors.success,
          fill: false,
          pointRadius: 8,
          pointHoverRadius: 10,
        }*/],
      };

      this.options = {
        responsive: true,
        maintainAspectRatio: false,
        legend: {
          position: 'bottom',
          labels: {
            fontColor: chartjs.textColor,
          },
        },
        hover: {
          mode: 'index',
        },
        scales: {
          xAxes: [
            {
              display: true,
              scaleLabel: {
                display: true,
                labelString: 'Timestamp',
              },
              gridLines: {
                display: true,
                color: chartjs.axisLineColor,
              },
              ticks: {
                fontColor: chartjs.textColor,
              },
            },
          ],
          yAxes: [
            {
              display: true,
              scaleLabel: {
                display: true,
                labelString: 'Price',
              },
              gridLines: {
                display: true,
                color: chartjs.axisLineColor,
              },
              ticks: {
                fontColor: chartjs.textColor,
              },
            },
          ],
        },
      };
    });

  }

  reloadChart(){

    this.chartService.getData().subscribe(
      (dataload :any)=> {
        this.labels=dataload.labels;
        this.datapoints=dataload.data;
          console.log(dataload);
          this.createChart();
     
      },
      (error) => {
        if (error.status === 200) {
          // return obs that completes;
          console.log("Process ok: " +JSON.stringify(error));
          var labels1 = error.error.text.labels;
          var datapoints1 = error.error.text.data;
          console.log("Datapoints: "+JSON.stringify(labels1));
          console.log("Datapoints: "+JSON.stringify(datapoints1));
          this.createChart();
        
       
      } else {
        console.log("ERROR to get data: " + JSON.stringify(error));
      }
    }
  );


  }

  update(){
    console.log("Updated");
    this.chartService.updateChart(this.ainput);
    this.reloadChart();   

  }

  ngOnDestroy(): void {
    this.themeSubscription.unsubscribe();
  }

  private random() {
    return Math.round(Math.random() * 100);
  }
}
