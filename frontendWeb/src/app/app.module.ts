import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { QuizComponent } from './component/quiz/quiz.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { QuestionComponent } from './component/question/question.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CategoryNavComponent } from './component/category-nav/category-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { GridviewComponent } from './component/gridview/gridview.component';
import {
  MatCardModule, MatCheckboxModule, MatChip, MatChipsModule, MatDialogModule, MatExpansionModule,
  MatFormFieldModule,
  MatGridListModule,
  MatInputModule,
  MatOptionModule,
  MatSelectModule,
  MatSlideToggleModule,

} from '@angular/material';
import { RouterModule, Routes } from '@angular/router';
import {CdkTreeModule} from '@angular/cdk/tree';
import { QuestionsComponent } from './component/questions/questions.component';
import { QuestionDialogComponent } from './component/qestion-dialog/question-dialog.component';
import { QuizzesComponent } from './component/quizzes/quizzes.component';
import { PlayquizComponent } from './component/playquiz/playquiz.component';
import { StartquizwarningComponent } from './component/startquizwarning/startquizwarning.component';
import {ForumItemComponent} from './component/Forum/forum-item/forum-item.component';
import {ForumComponent} from './component/Forum/forum/forum.component';
import {CommentItemComponent} from './component/Forum/comment-item/comment-item.component';
import {AddNewsItemComponent} from './component/News/add-news-item/add-news-item.component';
import {NewsComponent} from './component/News/news/news.component';
import {NewsItemComponent} from './component/News/news-item/news-item.component';
import {LoginComponent} from './component/user/login/login.component';
import {ForgotPasswordComponent} from './component/user/forgot-password/forgot-password.component';
import {CreateAccountComponent} from './component/user/create-account/create-account.component';
import {ResetPasswordComponent} from './component/user/reset-password/reset-password.component';
import {HeaderComponent} from './component/layout/header/header.component';
import { ProfileComponent } from './component/profile/profile.component';


const APP_ROUTES: Routes = [
  { path: 'quiz/:id', component: QuizComponent },
  { path: '', component: GridviewComponent },
  { path: 'dash', component: CategoryNavComponent },
  { path: 'quizzes', component: QuizzesComponent },
  {path: 'quizzes/playQuiz/:id', component: PlayquizComponent },
  {path: 'news', component: NewsComponent},
  {path: 'forum', component: ForumComponent},
  {path: 'login', component: LoginComponent},

  //{path: 'profile', component:}
];
@NgModule({
  declarations: [
    AppComponent,
    QuizComponent,
    QuestionComponent,
    CategoryNavComponent,
    GridviewComponent,
    QuestionsComponent,
    QuestionDialogComponent,
    QuizzesComponent,
    PlayquizComponent,
    StartquizwarningComponent,
    ForumItemComponent,
    ForumComponent,
    CommentItemComponent,
    AddNewsItemComponent,
    NewsComponent,
    NewsItemComponent,
    LoginComponent,
    ForgotPasswordComponent,
    CreateAccountComponent,
    ResetPasswordComponent,
    HeaderComponent,
    ProfileComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatGridListModule,
    RouterModule.forRoot(APP_ROUTES),
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatOptionModule,
    MatSelectModule,
    MatSlideToggleModule,
    CdkTreeModule,
    MatExpansionModule,
    MatDialogModule,
    MatCheckboxModule,
    ReactiveFormsModule,
    MatChipsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [
    QuestionDialogComponent,
    StartquizwarningComponent
  ]
})
export class AppModule { }
