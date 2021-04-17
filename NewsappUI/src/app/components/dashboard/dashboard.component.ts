import { Component, OnInit } from '@angular/core';
import { DashboardService } from 'src/app/services/dashboard.service';
import { ArticleModel } from 'src/app/models/ArticleModel';
import 'rxjs/add/operator/map';
import { map } from 'rxjs-compat/operator/map';
import { concat } from 'rxjs';
import { Router } from '@angular/router';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  articles: Array<ArticleModel> = [];
  id: any = '';
  constructor(private dashboardService: DashboardService, private router: Router) { }

  ngOnInit() {
    this.getArticles();
  }

  getArticles(): void {
    this.dashboardService.getRecommendedArticles().subscribe((response: any) => {
      this.articles = response;
      console.log(response);
    });
  }

  onClick(article: ArticleModel) {
    this.dashboardService.setFavourite(article.id).subscribe((response: any) => {
      this.router.navigate(['/favourite']);
      console.log(response);
    });
  }

  setArticle(): void {
    console.log("click");
  }

  


}
