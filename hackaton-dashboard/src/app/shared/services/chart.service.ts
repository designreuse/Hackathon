import {Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Injectable()
export class ChartService  {

    endpoint = 'http://localhost:8080';

    constructor(private http: HttpClient) {

    }

    getData() {
        return this.http.get(this.endpoint + '/test');
    } 


}
