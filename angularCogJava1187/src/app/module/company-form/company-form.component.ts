import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Company } from 'src/app/model/company.model';
import { CommonService } from 'src/app/shared/common.service';

@Component({
  selector: 'app-company-form',
  templateUrl: './company-form.component.html',
  styleUrls: ['./company-form.component.css'],
})
export class CompanyFormComponent implements OnInit {
  data: Company = new Company();
  constructor(private commonService: CommonService, private router: Router) {}

  ngOnInit(): void {}

  saveCompany() {
    if (
      this.data.company.turnover != null &&
      this.data.company.turnover > 100000000
    ) {
      this.commonService.addCompany(this.data).subscribe(
        (result) => {
          // Handle result
          console.log(result);
          debugger;
          this.data = new Company();
          alert(result.message);
        },
        (error) => {
          debugger;
          alert(error.error.text);
          //#region some issue here
          if (error.error.text == 'Company added successfully') {
            this.router.navigateByUrl('/company');
          }
          () => {
            // 'onCompleted' callback.
            // No errors, route to new page here
            debugger
          };

          //#endregion
        }
      );
    }
  }
}
