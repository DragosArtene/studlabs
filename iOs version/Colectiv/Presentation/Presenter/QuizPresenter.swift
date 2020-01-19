//
//  QuizPresenter.swift
//  Colectiv
//
//  Created by Andrei Lobont on 13/01/2020.
//  Copyright © 2020 Andrei Lobont. All rights reserved.
//

import Foundation

class QuizPresenter {
    private weak var view: QuizView?
    private weak var navigation: QuizNavigation?
    var quizes: [Quiz] = []
    
    init(view: QuizView, navigation: QuizNavigation) {
        self.view = view
        self.navigation = navigation
    }
    
    func viewDidLoad() {
        populateQuizes()
        
    }
    
    func numberOfQuizes() -> Int {
        return quizes.count
    }
    
    func getQuiz(at index: Int) -> Quiz {
        return quizes[index]
    }
    
    func selected(quiz index: Int) {
        navigation?.navigateToQuestions(with: getQuiz(at: index))
    }
    
    private func populateQuizes() {
        let a1: Answer = Answer(answer: "A redefinii o metoda din clasa parinte", isCorrect: true)
        let a2: Answer = Answer(answer: "A schimba definitia unei metoda din aceasi clasa.", isCorrect: false)
        let a3: Answer = Answer(answer: "A scrie o metoda noua care face aproape acelasi lucru cu o alta metoda deja implementata.", isCorrect: false)
        let answers1: [Answer] = [a1, a2, a3]
        let a4: Answer = Answer(answer: "Face metoda in care este scris sa fie super.", isCorrect: false)
        let a5: Answer = Answer(answer: "Apeleaza metoda din clasa parinte.", isCorrect: true)
        let answers2: [Answer] = [a4, a5]
        let q1: Question = Question(definition: "Ce inseamna override?", answers: answers1)
        let q2: Question = Question(definition: "Ce face keyword-ul super?", answers: answers2)
        let questions: [Question] = [q1, q2]
        let qu1: Quiz = Quiz(title: "Algoritmica 101", imageName: "books", questions: questions)
        let qu2: Quiz = Quiz(title: "Intrebari utile pentru admitere", imageName: "hat", questions: questions)
        let qu3: Quiz = Quiz(title: "Bazele algoritmicii", imageName: "labels", questions: questions)
        let qu4: Quiz = Quiz(title: "OOP", imageName: "laptop", questions: questions)
        let qu5: Quiz = Quiz(title: "Intrebari de logica", imageName: "labels", questions: questions)
        quizes = [qu1, qu2, qu3, qu4, qu5]
    }
}
