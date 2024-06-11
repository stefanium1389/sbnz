import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {

  constructor(private http: HttpClient) { }

  status: BloodStatus | undefined;

  ngOnInit(): void {
    this.http.get<BloodStatus>("http://localhost:8080/bloodStatus").subscribe(
      {
        next: (result)=> {
          console.log(result);
          this.status = result;
        }
      }
    )
  }

}
export interface BloodStatus{
  amount:number,
  status:string
}
