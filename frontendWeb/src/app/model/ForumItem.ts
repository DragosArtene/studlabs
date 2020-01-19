import {Comment} from './Comment';
import {User} from './User';

export class ForumItem{
  rating: number;
  tags: string[];
  text: string;
  title: string;
  type: string;
  comments: Comment[];
  username: string;
}
