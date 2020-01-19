import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-add-news-item',
  templateUrl: './add-news-item.component.html',
  styleUrls: ['./add-news-item.component.css']
})
export class AddNewsItemComponent implements OnInit {
  @Output() addNewsItem: EventEmitter<any> = new EventEmitter();
  @Output() cancelForm: EventEmitter<any> = new EventEmitter();

  title: string;
  text: string;
  multimedia: string;
  show = true;

  constructor() { }

  ngOnInit() {
  }

  onSubmit() {
    const newsItem = {
      title: this.title,
      text: this.text,
      multimedia: this.multimedia,
      createdOn: new Date()
    };

    this.addNewsItem.emit(newsItem);
  }

  onCancel() {
    this.show = false;
  }
}
