import {Component, Input, OnInit} from '@angular/core';
import {ForumItem} from '../../../model/ForumItem';


@Component({
  selector: 'app-forum-item',
  templateUrl: './forum-item.component.html',
  styleUrls: ['./forum-item.component.css']
})
export class ForumItemComponent implements OnInit {
  @Input() item: ForumItem;
  comm = false;
   constructor(/*private forumService:forumService)*/) { }

  ngOnInit() {
  }

  onClick() {
    this.comm=!this.comm;
  }
}
