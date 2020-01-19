import {QuizzDifficulty} from './quizzDifficulty';

export class Quiz {
  idQuiz: number
  category: string
  difficulty: QuizzDifficulty
  timeInMinutes: number
  completionRate: number
  public: boolean
  random: boolean;
}
