import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpProvider } from './http-provider.service';
import * as moment from 'moment';
@Injectable({
  providedIn: 'root'
})
export class CommonService extends HttpProvider {

//#region URL
private readonly allCompanyEndpoint ="viewCompanyStock/ListAllComapany";
private readonly stockStatsEndpoint ="viewCompanyStock/GetMinMaxAvgPrice";
private readonly companyEndpoint ="viewCompanyStock/getCompany/";
private readonly deleteEndpoint="company/RemoveCompany/";
private readonly updateStockEndpoint="stock/updateStock";
private readonly addCompanyEndpoint="company/addCompany";
private readonly findStockEndpoint="viewCompanyStock/FindStockByCompanyCode/";
private readonly filterStockEndpoint="viewCompanyStock/GetStockByDates?";
//#endregion

  //#region Constructor
  constructor(private httpClient: HttpClient) {
    super(httpClient);
  }
  //#endregion

  //#region
  getAllCompany(){
    return this.get(this.allCompanyEndpoint);
  }

  getStockStats(id: any) {

    return this.get(this.stockStatsEndpoint+"?companyCode="+id.companyCode+"&fromDate="+id.fromDate+"&endDate="+id.toDate);
  }

  getCompanyData(id: any) {
    return this.get(this.companyEndpoint+id);
  }

  deleteCompany(id:any){
    return this.delete(this.deleteEndpoint+id);
  }

  updateStock(data:any){
    return this.put(this.updateStockEndpoint,data)
  }
  addCompany(data:any){
    return this.post(this.addCompanyEndpoint,data)
  }

  findCompanyStock(id){
    return this.get(this.findStockEndpoint+id);
  }

  filterCompanyStock(data){
    return this.get(this.filterStockEndpoint+"companyCode="+data.companyCode+"&fromDate="+data.fromDate+"&endDate="+data.toDate);
  }
  //#endregion
}
