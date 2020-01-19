//
//  QuestionPresenter.swift
//  Colectiv
//
//  Created by Andrei Lobont on 17/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

class QuestionPresenter {
    private weak var view: QuestionView?
    private weak var navigation: QuestionNavigation?
    private var quiz: Quiz
    private var currentQuestion: Int = 0
    private var correctAnswers: Int = 0
    
    init(view: QuestionView, navigation: QuestionNavigation, quiz: Quiz) {
        self.view = view
        self.navigation = navigation
        self.quiz = quiz
    }
    
    func viewDidLoad() {
        view?.displayQuestion(question: quiz.questions[currentQuestion].definition)
    }
    
    func getNumberOfAnswers() -> Int {
        return quiz.questions[currentQuestion].answers.count
    }
    
    func getCurrentAnswer(at index: Int) -> Answer {
        return quiz.questions[currentQuestion].answers[index]
    }
    
    func continueButtonPressed(with answerIndex: Int) {
        checkAnswer(at: answerIndex)
        if currentQuestion < quiz.questions.count - 1 {
            currentQuestion += 1
            view?.displayQuestion(question: quiz.questions[currentQuestion].definition)
            view?.reloadData()
        } else {
            navigation?.navigateToEndOfQuiz(with: correctAnswers, and: quiz)
        }
    }
    
    private func checkAnswer(at index: Int) {
        if quiz.questions[currentQuestion].answers[index].isCorrect {
            correctAnswers += 1
        }
    }
}
