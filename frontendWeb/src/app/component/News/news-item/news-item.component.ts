import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import {NewsItem} from '../../../model/News';


@Component({
  selector: 'app-news-item',
  templateUrl: './news-item.component.html',
  styleUrls: ['./news-item.component.css']
})
export class NewsItemComponent implements OnInit {
  @Input() newsItem: NewsItem;
  @Output() deleteNewsItem: EventEmitter<NewsItem> = new EventEmitter();
  readMore = true;
  constructor() { }

  ngOnInit() {
  }

  setClasses() {
    const classes = {
      newsItem: true
    };
    return classes;
  }

  onClick() {
    console.log('click');
    this.readMore = false;
  }

  onDelete(newsItem) {
    this.deleteNewsItem.emit(newsItem);
  }

}
