export class Company
{
  company: CompanyData = new CompanyData
  stock: StockData = new StockData
}

export class CompanyData{
  companyCode:number=null
  companyName:string=""
  companyCEO:string=""
  website:string=""
  stockExchange:string=""
  turnover:number=null

}

export class StockData{
  price: number =null
}

export class SearchEngine{
  companyCode:number=null
  fromDate!: Date
  toDate!:Date;
}
