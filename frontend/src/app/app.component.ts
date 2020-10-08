import {Component, OnInit} from '@angular/core';
import {AppService} from "./app.service";
import {Report} from "./model/report.interface";
import {Client} from "./model/client.interface";
import {tap} from "rxjs/operators";
import {Coffee} from "./model/coffee.interface";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  reports: Report[];
  clients: Client[];
  selectedClient: number;

  constructor(private appService: AppService) {
    this.clients = [];
  }

  ngOnInit(): void {
    this.appService.getReport()
      .pipe(
        // Concatenación de operadores
        tap((reports: Report[]) => this.clients = reports.map(report => report.client))
        // ... otros operadores
      )
      .subscribe(
        // Función on next
        value => {
          console.log('Observable next value')
          this.reports = value
        },
        // Función on error
        error => {
          console.error(error);
          this.clients.push({id: -1, name: "No se pudieron recuperar los clientes", purchasedCoffees: 0})
        },
        // Función on complete
        () => console.log('Observable completed!'))
  }

  filterReports(): Coffee[] {
    if (this.selectedClient) {
      return this.reports.find(report => report.client.id == this.selectedClient).coffees;
    }
  }
}
