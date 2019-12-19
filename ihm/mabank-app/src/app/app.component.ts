import {Component, OnInit} from '@angular/core';
import {AccountDto, AccountService} from "../../projects/mabank-services-api";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'mabank-app';

  accounts: Array<AccountDto>;

  constructor(private accountService: AccountService) {}

  ngOnInit() {
    this.accountService.getAllAccountsUsingGET()
      .subscribe(accounts => {
        console.log(accounts);
        this.accounts = accounts;
      }, err => {
        console.log(err);
      });
  }

}
