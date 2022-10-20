//#region imports
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
//#endregion imports

//#region internal imports
import { environment } from 'src/environments/environment';
//#endregion internal imports

@Injectable()
export class HttpProvider {
  constructor(private http: HttpClient) {}

  toHttpParams(obj: any) {
    if (obj) {
      return {
        params: Object.getOwnPropertyNames(obj).reduce(
          (p, key) => p.set(key, obj[key]),
          new HttpParams()
        ),
      };
    }else{
      return null
    }
  }


  protected get(uri: string, params?: any): Observable<any> {
    return this.http.get(environment.apiUrl + uri, params);
  }

  protected getById(uri: string, id: string | number): Observable<any> {
    return this.http.get(environment.apiUrl + uri + '/' + id);
  }

  protected post(uri: string, params: any): Observable<any> {
    return this.http.post(environment.apiUrl + uri, params);
  }

  protected put(uri: string, params: any): Observable<any> {
    return this.http.put(environment.apiUrl + uri, params);
  }

  protected delete(uri: any, params?: any): Observable<any> {
    return this.http.delete(
      environment.apiUrl + uri,
      //this.toHttpParams(params)
    );
  }




}
