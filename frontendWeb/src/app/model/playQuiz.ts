import DateTimeFormat = Intl.DateTimeFormat;
import {PlayQuizStatus} from './playQuizStatus';

export class PlayQuiz {
  idPlayQuiz: number;
  idQuiz: number;
  idUser: string;
  startTime: Date;
  endTime: Date;
  rate: number;
  status: PlayQuizStatus;
}
