import {Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AlgorithmInput } from '../model/algorithm-input';



@Injectable()
export class ChartService  {

    endpoint = 'http://localhost:8080';

    constructor(private http: HttpClient) {

    }

    getData() {
        return this.http.get(this.endpoint + '/chart/data');
    } 

    updateChart(ainput: AlgorithmInput) {
        console.log("Start updating...")
        let url = this.endpoint + '/chart/update';
        console.log(url);

        return this.http.post(url, JSON.stringify(ainput));

    }


}
