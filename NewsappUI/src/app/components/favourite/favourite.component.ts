import { Component, OnInit } from '@angular/core';
import { ArticleModel } from 'src/app/models/ArticleModel';
import { DashboardService } from 'src/app/services/dashboard.service';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit {
  favArticles: Array<ArticleModel> = [];
  constructor(private dashboardService: DashboardService) { }

  ngOnInit() {
    this.getFavArticles();
  }

  onClick(article: ArticleModel) {
    console.log(article.id);
  }

  getFavArticles(): void {
    this.dashboardService.getFavouriteArticles().subscribe((response: any) => {

      this.favArticles = response;
      console.log(response);
    });
  }

  deleteFavArticle(article: ArticleModel): void {
    this.dashboardService.deleteFavourite(article.id).subscribe((response: any) => {
      console.log(response);
      location.reload();
    });
  }

}
