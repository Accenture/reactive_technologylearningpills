import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Report} from "./model/report.interface";

@Injectable({
  providedIn: 'root',
})
export class AppService {

  urlbase = 'http://localhost:3000';

  constructor(private httpClient: HttpClient) {

  }

  getReport(): Observable<Report[]> {

    return this.httpClient.get<Report[]>(this.urlbase + '/bar')
  }


}
